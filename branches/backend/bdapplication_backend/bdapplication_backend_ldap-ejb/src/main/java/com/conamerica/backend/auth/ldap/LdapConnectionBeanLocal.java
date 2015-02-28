/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.conamerica.backend.auth.ldap;

import javax.ejb.Local;
import javax.naming.directory.DirContext;

/**
 *
 * @author CarlosDaniel
 */
@Local
public interface LdapConnectionBeanLocal {
    
    DirContext getConnectionAdmin();
    
    DirContext getConnectionAnonimus();
    
}
