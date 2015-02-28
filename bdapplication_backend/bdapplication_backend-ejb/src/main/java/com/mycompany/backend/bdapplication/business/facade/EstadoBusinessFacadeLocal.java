/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.backend.bdapplication.business.facade;

import com.mycompany.backend.bdapplication.business.dto.EstadoDTO;
import com.mycompany.backend.bdapplication.model.Estado;
import javax.ejb.Local;

/**
 *
 * @author CarlosDaniel
 */
@Local
public interface EstadoBusinessFacadeLocal extends EstadoBusinessFacadeRemote {
    
    public EstadoDTO prepareEstado(Estado estado);

}
