/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.mycompany.backend.bdapplication.business.facade;

import com.mycompany.backend.bdapplication.business.dto.CiudadDTO;
import com.mycompany.backend.bdapplication.model.Ciudad;
import com.mycompany.backend.bdapplication.model.facade.CiudadFacadeLocal;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Remote;
import javax.ejb.Stateless;

/**
 *
 * @author Roberth
 */
@Stateless(name = "CiudadBusinessFacade", mappedName = CiudadBusinessFacadeRemote.JNDI_REMOTE_NAME)
@Remote(CiudadBusinessFacadeRemote.class)
public class CiudadBusinessFacade implements CiudadBusinessFacadeRemote ,CiudadBusinessFacadeLocal {
    @EJB CiudadFacadeLocal ciudadFacadeLocal;
   @Override
    public CiudadDTO prepareCiudad(Ciudad ciudad) {
        CiudadDTO ciudadConverter = new CiudadDTO();
        if (ciudad != null) {
            ciudadConverter.setCodigo(ciudad.getCodigo());
            ciudadConverter.setNombre(ciudad.getNombre());
            ciudadConverter.setCodigoPais(ciudad.getCodigoPais());
//            ciudadConverter.setFechaRegistro(ciudad.getFechaRegistro());
//            ciudadConverter.setFechaModificacion(ciudad.getFechaModificacion());
//            ciudadConverter.setVersion(ciudad.getVersion());
            ciudadConverter.setCodigoEstado(ciudad.getCodigoEstado());
        }
        return ciudadConverter;
    }
    
      public List<CiudadDTO> obtenerListaCiudadsDTO(List<Ciudad> listaCiudadsJPA) {
        if (listaCiudadsJPA == null) {
            return new ArrayList<>();
        }
        List<CiudadDTO> listaCiudadsDTO = new ArrayList<>();
        for (Ciudad estado : listaCiudadsJPA) {
            listaCiudadsDTO.add(this.prepareCiudad(estado));
        }
        return listaCiudadsDTO;
    }
    
   
    public CiudadDTO create(CiudadDTO ciudadDTO) {
        Ciudad ciudad = new Ciudad(ciudadDTO);
        ciudadFacadeLocal.create(ciudad);
        return prepareCiudad(ciudad);
    }
    
    public CiudadDTO edit(CiudadDTO ciudadDTO) {
        Ciudad ciudad = new Ciudad(ciudadDTO);
        ciudadFacadeLocal.edit(ciudad);
        return prepareCiudad(ciudad);
    }
    
    public void remove(CiudadDTO estadoDTO){
        ciudadFacadeLocal.remove(ciudadFacadeLocal.find(estadoDTO.getId()));
    }
    
    public List<CiudadDTO> findAll(){
        return obtenerListaCiudadsDTO(ciudadFacadeLocal.findAll());
    }
    
    
     @Override
    public boolean isAlive() {
         return true;
    }

    @Override
    public List<CiudadDTO> findAllCiudad() {
        return findAll(); //To change body of generated methods, choose Tools | Templates.
    }

   
}
