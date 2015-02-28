/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.backend.bdapplication.model.facade;

import com.mycompany.backend.bdapplication.model.Ciudad;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Roberth
 */
@Local
public interface CiudadFacadeLocal {

    void create(Ciudad ciudad);

    void edit(Ciudad ciudad);

    void remove(Ciudad ciudad);

    Ciudad find(Object id);

    List<Ciudad> findAll();
}
