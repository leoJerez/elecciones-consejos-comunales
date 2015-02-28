/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.backend.bdapplication.model.facade;

import com.mycompany.backend.bdapplication.business.dto.HabitanteDTO;
import com.mycompany.backend.bdapplication.model.Habitante;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Roberth
 */
@Local
public interface HabitanteFacadeLocal {

    void create(Habitante habitante);

    void edit(Habitante habitante);

    void remove(Habitante habitante);

    Habitante find(Object id);

    List<Habitante> findAll();
}
