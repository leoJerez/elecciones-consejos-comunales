/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.mycompany.backend.bdapplication.business.facade;

import com.bdaplication.backend.locator.ServiceVerifier;
import com.mycompany.backend.bdapplication.business.dto.CiudadDTO;
import java.util.List;
import javax.ejb.Remote;

/**
 *
 * @author Roberth
 */
@Remote
public interface CiudadBusinessFacadeRemote extends ServiceVerifier {
    public final String JNDI_REMOTE_NAME = "ejb/ciudadBusinessFacadeRemote";
     
      public List<CiudadDTO> findAllCiudad();
}
