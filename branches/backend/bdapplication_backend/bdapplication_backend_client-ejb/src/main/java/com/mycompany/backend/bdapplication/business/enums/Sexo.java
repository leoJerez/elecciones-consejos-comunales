/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.mycompany.backend.bdapplication.business.enums;

/**
 *
 * @author Roberth
 */
public enum Sexo {
    MASCULINO("MASCULINO"),
    FEMENINO("FEMENINO");
    
    private final String valor;

    private Sexo(String valor) {
        this.valor = valor;
    }

    public String getValor() {
        return valor;
    }
}
