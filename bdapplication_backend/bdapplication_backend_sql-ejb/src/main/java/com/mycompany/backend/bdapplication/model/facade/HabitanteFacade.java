/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.mycompany.backend.bdapplication.model.facade;

import com.mycompany.backend.bdapplication.business.dto.HabitanteDTO;
import com.mycompany.backend.bdapplication.model.Habitante;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Roberth
 */
@Stateless
public class HabitanteFacade extends AbstractFacade<Habitante> implements HabitanteFacadeLocal {
    @PersistenceContext(unitName = "BDAplication_PU")
    private EntityManager em;

    public HabitanteFacade() {
        super(Habitante.class);
    }

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

}
