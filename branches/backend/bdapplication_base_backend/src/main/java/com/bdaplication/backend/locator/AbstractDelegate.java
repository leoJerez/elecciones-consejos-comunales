/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bdaplication.backend.locator;

import javax.naming.NamingException;

/**
 *
 * @author CarlosDaniel
 */
public abstract class AbstractDelegate<T> {

    @SuppressWarnings("unchecked")
    protected T getDelegado(String jndiName) {
        T delegado = null;
        try {
            delegado = (T) ServiceLocator.instance().get(jndiName);
        } catch (NamingException e) {
            e.printStackTrace();
        }
        return delegado;
    }
}
