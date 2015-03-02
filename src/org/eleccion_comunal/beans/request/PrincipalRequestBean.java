package org.eleccion_comunal.beans.request;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import org.eleccion_comunal.beans.controller.BaseBean;


@ManagedBean(name = "principalRequestBean")
@RequestScoped
public class PrincipalRequestBean extends BaseBean implements Serializable{

    private static final long serialVersionUID = 6310152595584201197L;
}
