/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.mycompany.backend.bdapplication.service;

import com.mycompany.backend.bdapplication.business.delegate.CiudadDelegate;
import com.mycompany.backend.bdapplication.business.dto.CiudadDTO;
import java.util.List;
import javax.ejb.Stateless;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

/**
 *
 * @author Roberth
 */
@Stateless
@Path("ciudad")
public class CiudadFacadeRest {
    @GET
    @Produces({"application/xml", "application/json; charset=UTF-8"})
    public List<CiudadDTO> findAll() {
        return new CiudadDelegate().findAllCiudad();
    }
    
    
   
}
