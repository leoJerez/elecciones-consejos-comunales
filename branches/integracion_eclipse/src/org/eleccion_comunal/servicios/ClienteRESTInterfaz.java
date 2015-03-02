package org.eleccion_comunal.servicios;

import java.util.List;

public interface ClienteRESTInterfaz {
    
    /**
     * Con este metodo se puede obtener la lista completa de elementos guardados en la base de datos
     * @param servicio - Aqui se recomienda colocar el enum que identifica el servicio web solicitado
     * @param recursoSolicitado - Esta cadena representa el sufijo del recuso solicitado
     * @return Lista con los objetos contenidos en la BD, en caso de no poder ejecutar
     *  el servicio se genera una lista vacia
     */
    public <T> List<T> cargarListaCompleta(ServiciosDisponibles servicio, String recursoSolicitado);
    
    /**
     * Este metodos permite obtener un elemento de la BD segun su ID
     * @param servicio - Aqui se recomienda colocar el enum que identifica el servicio web solicitado
     * @param recursoSolicitado - Esta cadena representa el sufijo del recuso solicitado
     * @param idBuscado - Id del item que se desea
     * @return Objeto deseado en caso de encontrarlo, si no se consigue se retorna un objeto en blanco
     */
    public <T> Object buscarPorId(ServiciosDisponibles servicio, String recursoSolicitado, int idBuscado);
    
    /**
     * Metodo utilizado para crear un nuevo elemento en la base de datos
     * @param objetoACrear
     * @param servicio - Aqui se recomienda colocar el enum que identifica el servicio web solicitado
     * @param recursoSolicitado - Esta cadena representa el sufijo del recuso solicitado
     * @return true si se ejecutó el servicio con exito, false en caso contrario
     */
    public boolean crearNuevo(Object objetoACrear, ServiciosDisponibles servicio, String recursoSolicitado);
    
    /**
     * Este metodo es capaz de eliminar un objeto de la base de datos
     * @param objetoAEliminar - Objeto que se desea eliminar
     * @param servicio - Aqui se recomienda colocar el enum que identifica el servicio web solicitado
     * @param recursoSolicitado - Esta cadena representa el sufijo del recuso solicitado
     * @return true si se logró ejecutar el servicio, false en caso contrario 
     */
    public boolean eliminarElemento(Object objetoAEliminar, ServiciosDisponibles servicio, String recursoSolicitado);
    
    /**
     * Con este metodo se pueden actualizar los datos de un registro en la BD
     * @param servicio - Aqui se recomienda colocar el enum que identifica el servicio web solicitado
     * @param recursoSolicitado - Esta cadena representa el sufijo del recuso solicitado
     * @param objetoModificado - Objeto que se quiere actualizar
     * @return true si se ejecutó el servicio exitosamente, false en caso contrario
     */
    public boolean modificarVoluntario(ServiciosDisponibles servicio, String recursoSolicitado, Object objetoModificado);

}
