/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.mycompany.backend.bdapplication.business.delegate;

import com.bdaplication.backend.locator.AbstractDelegate;
import com.mycompany.backend.bdapplication.business.dto.ClienteDTO;
import com.mycompany.backend.bdapplication.business.dto.HabitanteDTO;
import com.mycompany.backend.bdapplication.business.facade.HabitanteBusinessFacadeRemote;
import java.util.List;

/**
 *
 * @author Roberth
 */
public class HabitanteDelegate extends AbstractDelegate<HabitanteBusinessFacadeRemote> implements HabitanteBusinessFacadeRemote {
    public HabitanteDelegate() {
        this.getDelegado(JNDI_REMOTE_NAME);
    }

    @Override
    public List<HabitanteDTO> findAllHabitante() {
        return this.getDelegado(JNDI_REMOTE_NAME).findAllHabitante();
    }
    
     @Override
    public boolean isAlive() {
         return this.getDelegado(JNDI_REMOTE_NAME).isAlive();
    }

    @Override
    public HabitanteDTO create(HabitanteDTO habitante) {
        return this.getDelegado(JNDI_REMOTE_NAME).create(habitante);
    }

    @Override
    public HabitanteDTO edit(HabitanteDTO habitante) {
        return this.getDelegado(JNDI_REMOTE_NAME).edit(habitante);
    }

    @Override
    public void remove(HabitanteDTO habitante) {
        this.getDelegado(JNDI_REMOTE_NAME).remove(habitante);
    }
}
