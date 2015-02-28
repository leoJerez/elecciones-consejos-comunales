/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.conamerica.backend.auth.ldap;

import java.util.List;
import javax.ejb.Local;
import javax.naming.directory.DirContext;
import com.conamerica.backend.auth.business.dto.RolDTO;
import com.conamerica.backend.auth.business.dto.UsuarioDTO;

/**
 *
 * @author CarlosDaniel
 */
@Local
public interface LdapSessionBeanLocal {
    
    DirContext getSchema(String name);
    
    Object lookup(String name);
    
    Boolean validateLogin(String userName, String userPassword);
    
    UsuarioDTO getUser(String userName);
        
    List<UsuarioDTO> findAllUsuario();
    
    List<RolDTO> findAllRol();
        
}
