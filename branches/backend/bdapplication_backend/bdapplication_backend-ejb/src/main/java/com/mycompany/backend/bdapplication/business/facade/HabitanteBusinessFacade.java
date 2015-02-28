/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.backend.bdapplication.business.facade;


import com.mycompany.backend.bdapplication.business.dto.HabitanteDTO;
import com.mycompany.backend.bdapplication.model.Habitante;
import com.mycompany.backend.bdapplication.model.facade.HabitanteFacadeLocal;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Remote;
import javax.ejb.Stateless;

/**
 *
 * @author Roberth
 */
@Stateless(name = "HabitanteBusinessFacade", mappedName = HabitanteBusinessFacadeRemote.JNDI_REMOTE_NAME)
@Remote(HabitanteBusinessFacadeRemote.class)
public class HabitanteBusinessFacade implements HabitanteBusinessFacadeRemote, HabitanteBusinessFacadeLocal {

    @EJB
    HabitanteFacadeLocal habitanteFacadeLocal;
    

    @Override
    public HabitanteDTO prepareHabitante(Habitante habitante) {
        HabitanteDTO habitanteConverter = new HabitanteDTO();
        if (habitante != null) {
            habitanteConverter.setId(habitante.getId());
            habitanteConverter.setCedula(habitante.getCedula());
            habitanteConverter.setNombre(habitante.getNombre());
            habitanteConverter.setApellido(habitante.getApellido());
            habitanteConverter.setFechaNacimiento(habitante.getFechaNacimiento());
            habitanteConverter.setNumeroCasa(habitante.getNumeroCasa());
            habitanteConverter.setSexo(habitante.getSexo());
            habitanteConverter.setTelefonoFijo(habitante.getTelefonoFijo());
            habitanteConverter.setTelefonoMovil(habitante.getTelefonoMovil());
            habitanteConverter.setCorreo(habitante.getCorreo());
            habitanteConverter.setVersion(habitante.getVersion());
            habitanteConverter.setEstatus(habitante.getEstatus());
        }
        return habitanteConverter;
    }
    
      public List<HabitanteDTO> obtenerListaHabitantesDTO(List<Habitante> listaHabitantesJPA) {
        if (listaHabitantesJPA == null) {
            return new ArrayList<>();
        }
        List<HabitanteDTO> listaHabitantesDTO = new ArrayList<>();
        for (Habitante habitante : listaHabitantesJPA) {
            listaHabitantesDTO.add(this.prepareHabitante(habitante));
        }
        return listaHabitantesDTO;
    }
    
   
    @Override
    public HabitanteDTO create(HabitanteDTO habitanteDTO) {
        Habitante habitante = new Habitante(habitanteDTO);
        habitanteFacadeLocal.create(habitante);
        return prepareHabitante(habitante);
    }
    
    @Override
    public HabitanteDTO edit(HabitanteDTO habitanteDTO) {
        Habitante habitante = new Habitante(habitanteDTO);
        habitanteFacadeLocal.edit(habitante);
        return prepareHabitante(habitante);
    }
    
    @Override
    public void remove(HabitanteDTO habitanteDTO){
        habitanteFacadeLocal.remove(habitanteFacadeLocal.find(habitanteDTO.getId()));
    }
    
    public List<HabitanteDTO> findAll(){
        return obtenerListaHabitantesDTO(habitanteFacadeLocal.findAll());
    }
    
    
     @Override
    public boolean isAlive() {
         return true;
    }

    @Override
    public List<HabitanteDTO> findAllHabitante() {
        return findAll(); //To change body of generated methods, choose Tools | Templates.
    }

}
