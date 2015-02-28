/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.backend.bdapplication.service;
 
import com.mycompany.backend.bdapplication.business.delegate.HabitanteDelegate;
import com.mycompany.backend.bdapplication.business.dto.HabitanteDTO;
import java.util.List;
import javax.ejb.Stateless;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

/**
 *
 * @author Roberth
 */
@Stateless
@Path("habitante")
public class HabitanteFacadeRest {

    @GET
    @Produces({"application/xml", "application/json; charset=UTF-8"})
    public List<HabitanteDTO> findAll() {
        return new HabitanteDelegate().findAllHabitante();
    }
    
    
  }
