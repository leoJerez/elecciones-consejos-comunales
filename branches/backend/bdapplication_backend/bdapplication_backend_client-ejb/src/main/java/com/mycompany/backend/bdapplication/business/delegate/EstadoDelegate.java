/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.mycompany.backend.bdapplication.business.delegate;

import com.bdaplication.backend.locator.AbstractDelegate;
import com.mycompany.backend.bdapplication.business.dto.EstadoDTO;
import com.mycompany.backend.bdapplication.business.facade.EstadoBusinessFacadeRemote;
import java.util.List;

/**
 *
 * @author Roberth
 */
public class EstadoDelegate extends AbstractDelegate<EstadoBusinessFacadeRemote> implements EstadoBusinessFacadeRemote {
    public EstadoDelegate() {
        this.getDelegado(JNDI_REMOTE_NAME);
    }

    @Override
    public List<EstadoDTO> findAllEstado() {
        return this.getDelegado(JNDI_REMOTE_NAME).findAllEstado();
    }

    @Override
    public boolean isAlive() {
         return this.getDelegado(JNDI_REMOTE_NAME).isAlive();
    }
    
    @Override
    public String init() {
        return this.getDelegado(JNDI_REMOTE_NAME).init();
    }

    @Override
    public void create(EstadoDTO estadoDTO) {
        this.getDelegado(JNDI_REMOTE_NAME).create(estadoDTO);
    }

    @Override
    public void edit(EstadoDTO estadoDTO) {
        this.getDelegado(JNDI_REMOTE_NAME).edit(estadoDTO);
    }

    @Override
    public void remove(EstadoDTO estadoDTO) {
        this.getDelegado(JNDI_REMOTE_NAME).remove(estadoDTO);
    }
}
