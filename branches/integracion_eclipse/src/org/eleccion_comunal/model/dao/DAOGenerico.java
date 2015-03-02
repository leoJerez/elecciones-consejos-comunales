package org.eleccion_comunal.model.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;

import javax.persistence.EntityManager;
import javax.persistence.EntityNotFoundException;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.eleccion_comunal.model.dto.EntidadGenerica;



/**
 * Esta clase se encarga de ejecutar la persistencia a través de JPA, esta hecha de manera que toda clase que herede de ella pueda
 * realizar su persistencia
 * 
 * @author Jose Leonardo Jerez
 *
 */
public abstract class DAOGenerico {

	private Class claseDTO;

	public DAOGenerico(Class claseDTO) {
		this.claseDTO = claseDTO;
	}

	/**
	 * Este metodo genera una instancia del EntityManager, el cual es quien realiza la conexion la unidad de persistencia
	 * 
	 * @return EntityManager
	 */
	private EntityManager getEntityManager() {
		return EntityManagerHelper.getEntityManager();
	}

	/**
	 * Este metodo se encarga de insertar un elemento en la BD
	 * 
	 * @param entidadGenerica. Entidad que se desea persistir
	 */
	public void insertar(EntidadGenerica entidadGenerica) {
		EntityManagerHelper.log("insertando objeto "+this.claseDTO.getCanonicalName(), Level.INFO, null);
		EntityManagerHelper.beginTransaction();
		try {	    
			getEntityManager().persist(entidadGenerica);
			EntityManagerHelper.commit();
			EntityManagerHelper.log("insercion exitosa ", Level.INFO, null);
		}
		catch (RuntimeException re) {
			EntityManagerHelper.rollback();
			EntityManagerHelper.log("insercion fallida", Level.SEVERE, re);
			throw re;
		}
		finally {
			EntityManagerHelper.closeEntityManager();
		}
	}

	/**
	 * Con este metodo se puede actualizar un registro en la BD
	 * 
	 * @param entidadGenerica. Entidad que identifica al registro que se desea actualizar
	 * @return EntidadGenerica. La entidad actualizada
	 */
	public EntidadGenerica actualizar(EntidadGenerica entidadGenerica) {
		EntityManagerHelper.log("actualizando objeto "+this.claseDTO.getCanonicalName()+" con clave: " + entidadGenerica.getPrimaryKey(), Level.INFO, null);
		EntityManagerHelper.beginTransaction();
		try {
			EntidadGenerica result = getEntityManager().merge(entidadGenerica);
			EntityManagerHelper.commit();
			EntityManagerHelper.log("actualizacion exitosa", Level.INFO, null);
			return result;
		}
		catch(EntityNotFoundException enfe) {
			EntityManagerHelper.rollback();
			EntityManagerHelper.log("el objeto "+this.claseDTO.getCanonicalName()+" con clave: " + entidadGenerica.getPrimaryKey()+" no existe", Level.SEVERE, enfe);
			throw enfe;
		}
		catch (RuntimeException re) {
			EntityManagerHelper.rollback();
			EntityManagerHelper.log("actualizacion fallida", Level.SEVERE, re);
			throw re;
		}
		finally {
			EntityManagerHelper.closeEntityManager();
		}
	}

	/**
	 * Este metodo se encarga de verificar si la entidad existe o no en la BD, en caso negativo aplica el metodo Insertar()
	 * y en caso de que exista aplica el metodo Actualziar()
	 * 
	 * @param entidadGenerica. Entidad que se desea persistir, si esta entidad tiene su ID en null es porque aun no ha estado en la BD
	 */
	public void insertarOActualizar(EntidadGenerica entidadGenerica) {
		try {
			if (entidadGenerica.getPrimaryKey() == null)
				throw new EntityNotFoundException();
			getEntityManager().getReference(this.claseDTO, entidadGenerica.getPrimaryKey());
			this.actualizar(entidadGenerica);
		}
		catch(EntityNotFoundException enfe) {
			this.insertar(entidadGenerica);
		}
	}
	

	/**
	 * Este metodo se encarga de eliminar definitivamente un registro de la BD, es decir, aplica eliminación fisica
	 * 
	 * @param entidadGenerica. Entidad a eliminar
	 */
	private void eliminar(EntidadGenerica entidadGenerica) {
		EntityManagerHelper.log("eliminando objeto "+this.claseDTO.getCanonicalName()+" con clave: " + entidadGenerica.getPrimaryKey(), Level.INFO, null);
		EntityManagerHelper.beginTransaction();
		try {
			entidadGenerica = getEntityManager().getReference(this.claseDTO, entidadGenerica.getPrimaryKey());
			getEntityManager().remove(entidadGenerica);
			EntityManagerHelper.commit();
			EntityManagerHelper.log("eliminacion exitosa", Level.INFO, null);
		}
		catch(EntityNotFoundException enfe) {
			EntityManagerHelper.rollback();
			EntityManagerHelper.log("el objeto "+this.claseDTO.getCanonicalName()+" con clave: " + entidadGenerica.getPrimaryKey()+" no existe", Level.SEVERE, enfe);
			throw enfe;
		}
		catch (RuntimeException re) {
			EntityManagerHelper.rollback();
			EntityManagerHelper.log("eliminacion fallida", Level.SEVERE, re);
			throw re;
		}
		finally {
			EntityManagerHelper.closeEntityManager();
		}
	}

	/**
	 * Este metodo hace referencia al metodo eliminar()
	 * 
	 * @param entidadGenerica
	 */
	public void eliminarFisicamente(EntidadGenerica entidadGenerica) {
		this.eliminar(entidadGenerica);
	}

	/**
	 * Este metodo no elimina fisicamente sino que aplica elimnacion logica haciendo un UPDATE del status del registro,
	 * es decir, llama al metodo desactivar() de la entidad generica para cambiar el estatus de la entidad y luego aplica el metodo actualizar() para
	 * guardar los cambios en la BD
	 * 
	 * @param entidadGenerica
	 */
	public void eliminarLogicamente(EntidadGenerica entidadGenerica) {
		entidadGenerica.desactivar();
		this.actualizar(entidadGenerica);
	}

	/**
	 * Este metodo hace la operacion inversa a la eliminacion logica, es decir, cambia el status de la entidad a un valor A
	 * a traves del metodo activar() de la entidad generica y luego aplica actualizar()
	 * 
	 * @param entidadGenerica
	 * @return EntidadGenerica. Entidad con su nuevo status
	 */
	public EntidadGenerica restaurar(EntidadGenerica entidadGenerica) {
		entidadGenerica.activar();
		return this.actualizar(entidadGenerica);
	}

	/**
	 * Este metodo se usa para realizar consultas SQL a traves de tiras SQL personalizadas
	 * 
	 * @param queryString. Tira SQL que se desea ejecutar
	 */
	public void ejecutarQuery(String queryString) {
		Query query = getEntityManager().createQuery(queryString);
		this.executeUpdate(query);
	}

	/**
	 * Este metodo ejecuta tiras SQL personalinadas pero a su vez permite ingresar parametros que fortaleceran los criterios
	 * de busqueda
	 * 
	 * @param queryString. Tira SQL que se desea ejecutar
	 * @param parametros. Mapa de parametros a ingresar  en los criterios de busqueda
	 */
	public void ejecutarQueryConParametros(String queryString, Map<String, Object> parametros) {
		Query query = getEntityManager().createQuery(queryString);
		for (String nombreParametro : parametros.keySet()) {
			query.setParameter(nombreParametro, parametros.get(nombreParametro));
		}
		this.executeUpdate(query);
	}

	/**
	 * Este metodo se encarga de ejecutar un query personalizado, a diferecia de otros metodos, este se vale de JPA
	 * para ejeccutar las consultas, ya que el parametro que recibe  es de tipo QUERY
	 * 
	 * @param query. Objeto tipo Query, el cual contiene las tiras SQL con los parametros de busqueda
	 */
	private void executeUpdate(Query query) {
		EntityManagerHelper.log("ejecutando query de la clase "+this.claseDTO.getCanonicalName(), Level.INFO, null);
		EntityManagerHelper.beginTransaction();
		try {
			query.executeUpdate();
			EntityManagerHelper.commit();
			EntityManagerHelper.log("ejecucion exitosa", Level.INFO, null);
		}
		catch (RuntimeException re) {
			EntityManagerHelper.rollback();
			EntityManagerHelper.log("ejecucion fallida", Level.SEVERE, re);
			throw re;
		}
		finally {
			EntityManagerHelper.closeEntityManager();
		}
	}

	/**
	 * Este metodo genera una busqueda de una entidad en la BD segun una clave ingresada, esta clave es el ID del registro
	 * 
	 * @param clave. ID del registro a buscar
	 * @return EntidadGenerica. Objeto encontrado
	 */
	public EntidadGenerica buscarEntidadPorClave(Object clave) {
		EntityManagerHelper.log("buscando objeto "+this.claseDTO.getCanonicalName()+" con clave: " + clave, Level.INFO, null);
		try {
			EntidadGenerica entidadGenerica = getEntityManager().find(this.claseDTO, clave);
			return entidadGenerica;
		}
		catch (RuntimeException re) {
			EntityManagerHelper.log("busqueda por clave fallida", Level.SEVERE, re);
			throw re;
		}
		finally {
			EntityManagerHelper.closeEntityManager();
		}
	}

	/**
	 * Ese metodo se encarga de buscar todos los registros asociados a la entidad en la BD
	 * 
	 * @param filaInicioYCantidadFilas. Parametro opcional utilizado para indicar la cantidad de rregistros que desea obtener en 
	 * la busqueda
	 * 
	 * @return Lista cargada con los resultados obtenidos
	 */
	@SuppressWarnings("unchecked")
	public List buscarTodasEntidades(final int... filaInicioYCantidadFilas) {
		EntityManagerHelper.log("buscando todos los objetos "+this.claseDTO.getCanonicalName(), Level.INFO, null);
		try {
			final String queryString = 
					"SELECT entity FROM "+this.claseDTO.getSimpleName()+" entity WHERE "+
							"entity.status = '"+EntidadGenerica.DATA_ACTIVA+"'";   //en esta linea cambie estado por status 
			return this.buscarEntidadesPorQuery(queryString);
		} 
		catch (RuntimeException re) {
			EntityManagerHelper.log("busqueda total fallida", Level.SEVERE, re);
			throw re;
		}
		finally {
			EntityManagerHelper.closeEntityManager();
		}
	}

	/**
	 * Este metodo se encarga de buscar UNA entidad que coincida en la BD con la propiedad indicada
	 * 
	 * @param nombrePropiedad. Propiedad deseada, este nombre debe ser igual al que se le declaro al objeto en la clase JAVA
	 * @param valorPropiedad. Valor a buscar, debe tener el mismo tipo de dato que el indicado en la BD
	 * @param filaInicioYCantidadFilas. Parametro opcional que indica la cantidad de registros que se desea obtener en la busqueda
	 * @return Objeto obtenido en la busqueda
	 */
	public EntidadGenerica buscarEntidadPorPropiedad(String nombrePropiedad, final Object valorPropiedad, final int... filaInicioYCantidadFilas) {
		return this.buscarPrimeraEntidadEnListado(this.buscarEntidadesPorPropiedad(nombrePropiedad, valorPropiedad, filaInicioYCantidadFilas));
	}

	/**
	 * Este metodo se encarga de buscar LAS coincidencias de la entidad en la BD segun una propiedad en particular
	 * 
	 * @param nombrePropiedad. Propiedad deseada, este nombre debe ser igual al que se le declaro al objeto en la clase JAVA
	 * @param valorPropiedad. Valor a buscar, debe tener el mismo tipo de dato que el indicado en la BD
	 * @param filaInicioYCantidadFilas. Parametro opcional que indica la cantidad de registros que se desea obtener en la busqueda
	 * @return Lista de objetos cargada con los resultados de la busqueda
	 */
	public List buscarEntidadesPorPropiedad(String nombrePropiedad, final Object valorPropiedad, final int... filaInicioYCantidadFilas) {
		EntityManagerHelper.log("buscando objeto "+this.claseDTO.getCanonicalName()+" con propiedad: "+ nombrePropiedad + " = " + valorPropiedad, Level.INFO, null);
		String queryString =
				"SELECT entity FROM "+this.claseDTO.getSimpleName()+" entity WHERE "+
						"entity."+ nombrePropiedad + "= :valorPropiedad AND " +
						"entity.status = '"+EntidadGenerica.DATA_ACTIVA+"'";
		Map<String, Object> parametros = new HashMap<String, Object>();
		parametros.put("valorPropiedad", valorPropiedad);
		return this.buscarEntidadesPorQueryConParametros(queryString, parametros, filaInicioYCantidadFilas);
	}

	/**
	 * Este metodo se encarga de buscar UN registro que coincida en la BD segun un mapa propiedades indicadas
	 * 
	 * @param propiedades. Mapa de propiedades para la busqueda
	 * @return Objeto resultante de la busqueda
	 */
	public EntidadGenerica buscarEntidadPorPropiedades(Map<String, Object> propiedades) {
		return this.buscarPrimeraEntidadEnListado(this.buscarEntidadesPorPropiedades(propiedades));
	}

	/**
	 * Este metodo se encarga de buscar LAS coincidencias de la entidad en la BD segun un mapa propiedades indicadas
	 * 
	 * @param propiedades. Mapa de propiedades para la busqueda
	 * @return Lista cargada con los registros de obtenidos de la consulta
	 */
	public List buscarEntidadesPorPropiedades(Map<String, Object> propiedades) {
		EntityManagerHelper.log("buscando objeto "+this.claseDTO.getCanonicalName()+" con propiedades: ", Level.INFO, null);
		EntityManager entityManager = this.getEntityManager();
		CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
		CriteriaQuery criteriaQuery = criteriaBuilder.createQuery(this.claseDTO);	
		Root root = criteriaQuery.from(this.claseDTO);	
		for (String nombrePropiedad : propiedades.keySet()) {
			Predicate predicate = criteriaBuilder.equal(root.get(nombrePropiedad), propiedades.get(nombrePropiedad));
			criteriaQuery.where(criteriaBuilder.and(predicate));
		}
		List lista = entityManager.createQuery(criteriaQuery).getResultList();	
		return new LinkedList(lista);
	}

	/**
	 * Este metodo se encarga de buscar un registro en la BD que coincida con los parametros indicados en la tira SQL personalizada
	 * 
	 * @param queryString. Tira SQL a ejecutar
	 * @param filaInicioYCantidadFilas. parametro opcional que indica la cantidad de registros a buscar
	 * @return Registro encontrado
	 */
	public EntidadGenerica buscarEntidadPorQuery(String queryString, final int... filaInicioYCantidadFilas) {
		return this.buscarPrimeraEntidadEnListado(this.buscarEntidadesPorQuery(queryString, filaInicioYCantidadFilas));
	}

	/**
	 * Este metodo realiza una busqueda en la BD para obtener una lista de registros que cumplan con lo indicado en la tira SQL
	 * 
	 * @param queryString. Tira SQL a buscar
	 * @param filaInicioYCantidadFilas. Cantidad de registros a buscar (opcional)
	 * @return Lista cargada con los resultados de la busqueda
	 */
	public List buscarEntidadesPorQuery(String queryString, final int... filaInicioYCantidadFilas) {
		//queryString += " AND "+this.claseDTO.getSimpleName().substring(0,1).toLowerCase()+this.claseDTO.getSimpleName().substring(1)+".estado = '"+EntidadGenerica.DATA_ACTIVA+"'";
		Query query = getEntityManager().createQuery(queryString);
		return this.consultarPorQuery(query, filaInicioYCantidadFilas);
	}

	/**
	 * Este metodo se encarga de buscar un registro en la BD que cumpla con un mapa de parametros a coincidir, pero haciendo uso de una tira SQL personalizada
	 * 
	 * @param queryString. Tira SQL a ejecutar
	 * @param parametros. Mapa de parametros a coincidir
	 * @param filaInicioYCantidadFilas. Parametro opcional que indica la cantidad de registros a buscar en la BD
	 * @return Objeto resultante de la busqueda
	 */
	public EntidadGenerica buscarEntidadPorQueryConParametros(String queryString, Map<String, Object> parametros, final int... filaInicioYCantidadFilas) {
		return this.buscarPrimeraEntidadEnListado(buscarEntidadesPorQueryConParametros(queryString, parametros, filaInicioYCantidadFilas));
	}

	/**
	 * Este metodo se encarga de buscar una serie de registros que coincidan con un mapa de parametros, todo esto haciendo uso
	 * de una tira SQL personalizada
	 * 
	 * @param queryString. Tira SQL personalizada
	 * @param parametros. Mapa de parametros a coincidir
	 * @param filaInicioYCantidadFilas. Parametro opcional que indica la cantidad de registros a buscar en la BD
	 * @return Lista cargada con los resultados de la busqueda
	 */
	public List buscarEntidadesPorQueryConParametros(String queryString, Map<String, Object> parametros, final int... filaInicioYCantidadFilas) {
		//queryString += " AND "+this.claseDTO.getSimpleName().substring(0,1).toLowerCase()+this.claseDTO.getSimpleName().substring(1)+".estado = '"+EntidadGenerica.DATA_ACTIVA+"'";
		Query query = getEntityManager().createQuery(queryString);
		for (String nombreParametro : parametros.keySet()) {
			query.setParameter(nombreParametro, parametros.get(nombreParametro));
		}
		return this.consultarPorQuery(query, filaInicioYCantidadFilas);
	}

	/**
	 * Realiza una consulta en la BD segun un objeto tipo Query
	 * 
	 * @param query. Objeto Query que se desea consultar
	 * @param filaInicioYCantidadFilas. Parametro opcional que indica a cantidad de registros a buscar 
	 * @return
	 */
	private List consultarPorQuery(Query query, final int... filaInicioYCantidadFilas) {
		try {
			if (filaInicioYCantidadFilas != null && filaInicioYCantidadFilas.length > 0) {
				int rowStartIdx = Math.max(0, filaInicioYCantidadFilas[0]);
				if (rowStartIdx > 0) {
					query.setFirstResult(rowStartIdx);
				}

				if (filaInicioYCantidadFilas.length > 1) {
					int rowCount = Math.max(0, filaInicioYCantidadFilas[1]);
					if (rowCount > 0) {
						query.setMaxResults(rowCount);
					}
				}
			}
			return query.getResultList();
		}
		catch (RuntimeException re) {
			EntityManagerHelper.log("busqueda fallida", Level.SEVERE, re);
			throw re;
		}
		finally {
			EntityManagerHelper.closeEntityManager();
		}
	}

	/**
	 * Este metodo obtiene el primer elemento en una lista de objetos
	 * 
	 * @param listado. Lista de la cual se desea obtener el primer objeto
	 * @return Objeto resultante, es decir, primer objeto en la lista
	 */
	private EntidadGenerica buscarPrimeraEntidadEnListado(List listado) {
		if (listado != null && listado.size() > 0) {
			return (EntidadGenerica)listado.get(0);
		}
		return null;
	}
}
