/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.conamerica.backend.auth.ldap;

import java.util.Hashtable;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.naming.Context;
import javax.naming.NamingException;
import javax.naming.directory.DirContext;
import javax.naming.directory.InitialDirContext;

/**
 *
 * @author CarlosDaniel
 */
@Singleton
@Startup
public class LdapConnectionBean implements LdapConnectionBeanLocal {

    private DirContext ldapConnectionAdmin;

    private DirContext ldapConnectionAnonimus;

    @PostConstruct
    public void init() {
    }

    @Override
    public DirContext getConnectionAdmin() {
        if (ldapConnectionAdmin == null) {
            Hashtable env = new Hashtable(11);
            env.put(Context.INITIAL_CONTEXT_FACTORY, "com.sun.jndi.ldap.LdapCtxFactory");
            env.put(Context.PROVIDER_URL, "ldap://192.168.56.101:389");
            env.put(Context.SECURITY_AUTHENTICATION, "simple");
            env.put(Context.SECURITY_PRINCIPAL, "cn=admin,dc=example,dc=com");
            env.put(Context.SECURITY_CREDENTIALS, "ubuntu");
            env.put("java.naming.ldap.version", "3");
            try {
                ldapConnectionAdmin = new InitialDirContext(env);
            } catch (NamingException ex) {
                Logger.getLogger(LdapConnectionBean.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return ldapConnectionAdmin;
    }

    @Override
    public DirContext getConnectionAnonimus() {
        if(ldapConnectionAnonimus == null){
            Hashtable env = new Hashtable(11);
            env.put(Context.INITIAL_CONTEXT_FACTORY, "com.sun.jndi.ldap.LdapCtxFactory");
            env.put(Context.PROVIDER_URL, "ldap://192.168.56.101:389");
            env.put("java.naming.ldap.version", "3");
            try {
                ldapConnectionAnonimus = new InitialDirContext(env);
            } catch (NamingException ex) {
                Logger.getLogger(LdapConnectionBean.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return ldapConnectionAnonimus;
    }

}
