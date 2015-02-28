/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.mycompany.backend.bdapplication.model.facade;

import com.mycompany.backend.bdapplication.model.Estado;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Roberth
 */
@Stateless
public class EstadoFacade extends AbstractFacade<Estado> implements EstadoFacadeLocal {
    @PersistenceContext(unitName = "BDAplication_PU")
    private EntityManager em;

    public EstadoFacade() {
        super(Estado.class);
    }
    
    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

}