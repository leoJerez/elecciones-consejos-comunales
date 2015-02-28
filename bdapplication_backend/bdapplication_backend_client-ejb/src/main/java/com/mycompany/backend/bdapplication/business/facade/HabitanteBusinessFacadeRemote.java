/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.backend.bdapplication.business.facade;

import com.bdaplication.backend.locator.ServiceVerifier;
import com.mycompany.backend.bdapplication.business.dto.HabitanteDTO;
import java.util.List;
import javax.ejb.Remote;

/**
 *
 * @author Roberth
 */
@Remote
public interface HabitanteBusinessFacadeRemote extends ServiceVerifier {

    public final String JNDI_REMOTE_NAME = "ejb/habitanteBusinessFacadeRemote";

    public List<HabitanteDTO> findAllHabitante();

    public HabitanteDTO create(HabitanteDTO habitante);

    public HabitanteDTO edit(HabitanteDTO habitante);

    public void remove(HabitanteDTO habitante);

}
