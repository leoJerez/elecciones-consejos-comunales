/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.conamerica.backend.auth.ldap;

import com.conamerica.backend.auth.business.dto.RolDTO;
import com.conamerica.backend.auth.business.dto.UsuarioDTO;
import com.conamerica.backend.conf.business.delegate.PropiedadDelegate;
import com.conamerica.backend.conf.business.enums.PropiedadClave;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.Stateless;
import javax.naming.Context;
import javax.naming.NamingEnumeration;
import javax.naming.NamingException;
import javax.naming.directory.Attribute;
import javax.naming.directory.Attributes;
import javax.naming.directory.DirContext;
import javax.naming.directory.InitialDirContext;
import javax.naming.directory.SearchControls;
import javax.naming.directory.SearchResult;

/**
 *
 * @author CarlosDaniel
 */
@Stateless
public class LdapSessionBean implements LdapSessionBeanLocal {

    @Override
    public DirContext getSchema(String name) {
        try {
            return this.getConnection(new PropiedadDelegate().findByKey(PropiedadClave.LDAP_USUARIO_ADMIN).getValorString(), new PropiedadDelegate().findByKey(PropiedadClave.LDAP_CLAVE_ADMIN).getValorString()).getSchema(name);
        } catch (NamingException ex) {
            Logger.getLogger(LdapSessionBean.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    private DirContext getConnection(String userName, String userPassword) {
        Hashtable env = new Hashtable(11);
        env.put(Context.INITIAL_CONTEXT_FACTORY, new PropiedadDelegate().findByKey(PropiedadClave.LDAP_SERVIDOR_CONTEXT_FACTORY).getValorString());
        env.put(Context.PROVIDER_URL, new PropiedadDelegate().findByKey(PropiedadClave.LDAP_SERVIDOR_URL).getValorString());
        env.put("java.naming.ldap.version", "3");
        if (userName != null && userPassword != null) {
            env.put(Context.REFERRAL, "follow");
            env.put(Context.SECURITY_AUTHENTICATION, "simple");
            env.put(Context.SECURITY_PRINCIPAL, userName);
            env.put(Context.SECURITY_CREDENTIALS, userPassword);
        } else {
            env.put(Context.SECURITY_AUTHENTICATION, "none");
        }
        DirContext ctx = null;
        try {
            ctx = new InitialDirContext(env);
        } catch (NamingException ex) {
            Logger.getLogger(LdapSessionBean.class.getName()).log(Level.SEVERE, null, ex);
        }
        return ctx;
    }

    private NamingEnumeration getResults(String dn, String userName, String userPassword) {
        NamingEnumeration results = null;
        try {
            SearchControls controls = new SearchControls();
            controls.setSearchScope(SearchControls.ONELEVEL_SCOPE);
            results = this.getConnection(userName, userPassword).search(dn, "(objectclass=*)", controls);
        } catch (NamingException ex) {
            Logger.getLogger(LdapSessionBean.class.getName()).log(Level.SEVERE, null, ex);
        }
        return results;
    }

    @Override
    public Object lookup(String name) {
        try {
            return this.getConnection(new PropiedadDelegate().findByKey(PropiedadClave.LDAP_USUARIO_ADMIN).getValorString(), new PropiedadDelegate().findByKey(PropiedadClave.LDAP_CLAVE_ADMIN).getValorString()).lookup(name);
        } catch (NamingException ex) {
            Logger.getLogger(LdapSessionBean.class
                    .getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public Boolean validateLogin(String userName, String userPassword) {
        DirContext result = null;
        String usuario = "cn=" + userName + "," + new PropiedadDelegate().findByKey(PropiedadClave.LDAP_USUARIO_DN).getValorString();
        result = this.getConnection(usuario, userPassword);
        return result != null;
    }

    @Override
    public List<UsuarioDTO> findAllUsuario() {
        List<UsuarioDTO> usuarios = new ArrayList<>();
        try {
            NamingEnumeration results = this.getResults(new PropiedadDelegate().findByKey(PropiedadClave.LDAP_USUARIO_DN).getValorString(), new PropiedadDelegate().findByKey(PropiedadClave.LDAP_USUARIO_ADMIN).getValorString(), new PropiedadDelegate().findByKey(PropiedadClave.LDAP_CLAVE_ADMIN).getValorString());
            while (results.hasMore()) {
                SearchResult searchResult = (SearchResult) results.next();
                Attributes attributes = searchResult.getAttributes();
                Attribute attr = attributes.get("cn");
                String cn = (String) attr.get();
                System.out.println(" Person Common Name = " + attributes.get("cn").get());
                System.out.println(" Person Display Name = " + attributes.get("givenname").get() + " " + attributes.get("sn").get());
                usuarios.add(new UsuarioDTO(cn));
            }
        } catch (NamingException ex) {
            Logger.getLogger(LdapSessionBean.class.getName()).log(Level.SEVERE, null, ex);
        }
        return usuarios;
    }

    @Override
    public List<RolDTO> findAllRol() {
        List<RolDTO> roles = new ArrayList<>();
        try {
            NamingEnumeration results = this.getResults(new PropiedadDelegate().findByKey(PropiedadClave.LDAP_ROL_DN).getValorString(), new PropiedadDelegate().findByKey(PropiedadClave.LDAP_USUARIO_ADMIN).getValorString(), new PropiedadDelegate().findByKey(PropiedadClave.LDAP_CLAVE_ADMIN).getValorString());
            while (results.hasMore()) {
                SearchResult searchResult = (SearchResult) results.next();
                Attributes attributes = searchResult.getAttributes();
                List<String> members = new ArrayList<>();
                if(attributes.get("memberuid") != null){
                    NamingEnumeration results1 = attributes.get("memberuid").getAll();
                    while (results1.hasMore()) {
                        String member = (String) results1.next();
                        System.out.println(" Group member = " + member);
                        members.add(member);
                    }
                } else {
                    System.out.println(" Group members = " + attributes.get("memberuid"));
                }
                Attribute attr = attributes.get("cn");
                String cn = (String) attr.get();
                System.out.println(" Group Common Name = " + cn);
                RolDTO rolDTO = new RolDTO(cn);
//                if(!members.isEmpty()){
//                    for (String usuario : members) {
//                        rolDTO.getUsuarioDTOs().add(new UsuarioDTO(usuario));
//                    } 
//                }
                roles.add(rolDTO);         
            }
        } catch (NamingException ex) {
            Logger.getLogger(LdapSessionBean.class.getName()).log(Level.SEVERE, null, ex);
        }
        return roles;
    }

    @Override
    public UsuarioDTO getUser(String userName) {
        String usu = "cn=" + userName + "," + new PropiedadDelegate().findByKey(PropiedadClave.LDAP_USUARIO_DN).getValorString();
        UsuarioDTO usuario = null;
        try {
            NamingEnumeration results = this.getResults(usu, new PropiedadDelegate().findByKey(PropiedadClave.LDAP_USUARIO_ADMIN).getValorString(), new PropiedadDelegate().findByKey(PropiedadClave.LDAP_CLAVE_ADMIN).getValorString());
            while (results.hasMore()) {
                SearchResult searchResult = (SearchResult) results.next();
                Attributes attributes = searchResult.getAttributes();
                Attribute attr = attributes.get("cn");
                String cn = (String) attr.get();
                System.out.println(" Person Common Name = " + attributes.get("cn"));
                System.out.println(" Person Display Name = " + attributes.get("displayName"));
                System.out.println(" Person logonhours = " + attributes.get("logonhours"));
                System.out.println(" Person MemberOf = " + attributes.get("memberOf"));
                usuario = new UsuarioDTO(cn);
            }
        } catch (NamingException ex) {
            Logger.getLogger(LdapSessionBean.class.getName()).log(Level.SEVERE, null, ex);
        }
        return usuario;
    }

}
