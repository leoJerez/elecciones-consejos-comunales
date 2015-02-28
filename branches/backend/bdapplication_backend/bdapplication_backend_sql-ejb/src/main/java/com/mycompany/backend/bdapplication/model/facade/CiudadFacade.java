/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.mycompany.backend.bdapplication.model.facade;

import com.mycompany.backend.bdapplication.model.Ciudad;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Roberth
 */
@Stateless
public class CiudadFacade extends AbstractFacade<Ciudad> implements CiudadFacadeLocal {
    @PersistenceContext(unitName = "BDAplication_PU")
    private EntityManager em;

    public CiudadFacade() {
        super(Ciudad.class);
    }
    
    @Override
    protected EntityManager getEntityManager() {
        return em;
    }
}
