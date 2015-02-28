/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.backend.bdapplication.service;

import com.mycompany.backend.bdapplication.business.delegate.EstadoDelegate;
import com.mycompany.backend.bdapplication.business.dto.EstadoDTO;
import java.util.List;
import javax.ejb.Stateless;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

/**
 *
 * @author Roberth
 */
@Stateless
@Path("estado")
public class EstadoFacadeRest {
//    @GET
//    @Path("count")
//    @Produces("text/plain")
//    public String count() {
//        return Integer.toString(new EstadoDelegate().count());
//    }

//    @POST
//    @Consumes({"application/xml", "application/json; charset=UTF-8"})
//    public void create(EstadoDTO entity) {
//        new EstadoDelegate().create(entity);
//    }

//    @GET
//    @Path("createBase/{nombre}/{clave}")
//    public void createBase(@PathParam("nombre") String login, @PathParam("clave") String password) {
//        EstadoDTO estadoDTO = new EstadoDTO();
////        estadoDTO.setLogin(login);
////        estadoDTO.setPassword(password);
//        new EstadoDelegate().create(estadoDTO);
//    }

//    @GET
//    @Path("init")
//    public String init() {
//        return new EstadoDelegate().init();   
//    }
    @GET
    @Produces({"application/xml", "application/json; charset=UTF-8"})
    public List<EstadoDTO> findAll() {
        return new EstadoDelegate().findAllEstado();
    }

//    @GET
//    @Path("{id}")
//    @Produces({"application/xml", "application/json; charset=UTF-8"})
//    public EstadoDTO find(@PathParam("id") Long id) {
//        return new EstadoDelegate().find(id);
//    }
//    @GET
//    @Path("login/{nombre}/{clave}")
//    @Produces({"application/xml", "application/json"})
//    public boolean findByLoginAndPassword(@PathParam("nombre") String nombren, @PathParam("clave") String clave) {
//        return new EstadoDelegate().findByLoginAndPassword(nombren, clave);
//    }
}
