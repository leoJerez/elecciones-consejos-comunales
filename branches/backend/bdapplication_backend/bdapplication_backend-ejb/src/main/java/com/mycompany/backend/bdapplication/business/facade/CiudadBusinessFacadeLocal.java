/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.backend.bdapplication.business.facade;

import com.mycompany.backend.bdapplication.business.dto.CiudadDTO;
import com.mycompany.backend.bdapplication.model.Ciudad;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author CarlosDaniel
 */
@Local
public interface CiudadBusinessFacadeLocal extends CiudadBusinessFacadeRemote {
   
     public CiudadDTO prepareCiudad(Ciudad ciudad);
     
   

}
