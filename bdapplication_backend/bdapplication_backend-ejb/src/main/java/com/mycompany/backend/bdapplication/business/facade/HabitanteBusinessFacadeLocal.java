/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.backend.bdapplication.business.facade;

import com.mycompany.backend.bdapplication.business.dto.HabitanteDTO;
import com.mycompany.backend.bdapplication.model.Habitante;
import javax.ejb.Local;

/**
 *
 * @author CarlosDaniel
 */
@Local
public interface HabitanteBusinessFacadeLocal extends HabitanteBusinessFacadeRemote {
    
       
    public HabitanteDTO prepareHabitante(Habitante habitante);
    
    public HabitanteDTO create(HabitanteDTO habitante);
    
    public HabitanteDTO edit(HabitanteDTO habitante);
    
    public void remove(HabitanteDTO habitante);

}
