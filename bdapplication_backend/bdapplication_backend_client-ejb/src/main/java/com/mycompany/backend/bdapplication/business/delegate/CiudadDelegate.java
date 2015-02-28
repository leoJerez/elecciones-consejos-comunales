/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.mycompany.backend.bdapplication.business.delegate;

import com.bdaplication.backend.locator.AbstractDelegate;
import com.mycompany.backend.bdapplication.business.dto.CiudadDTO;
import com.mycompany.backend.bdapplication.business.facade.CiudadBusinessFacadeRemote;
import java.util.List;

/**
 *
 * @author Roberth
 */
public class CiudadDelegate extends AbstractDelegate<CiudadBusinessFacadeRemote> implements CiudadBusinessFacadeRemote {
    public CiudadDelegate() {
        this.getDelegado(JNDI_REMOTE_NAME);
    }

    
    @Override
    public List<CiudadDTO> findAllCiudad() {
        return this.getDelegado(JNDI_REMOTE_NAME).findAllCiudad();
    }
    
     
    @Override
    public boolean isAlive() {
         return this.getDelegado(JNDI_REMOTE_NAME).isAlive();
    }
}
