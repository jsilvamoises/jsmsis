/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.Serializable;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import org.primefaces.context.RequestContext;

/**
 *
 * @author MOISES
 */
@ManagedBean
@ViewScoped
public class MenuPerfilBean implements Serializable{
    
    public void verMensagens(){
        System.out.println("Menu Perfil");
        try {
            //RequestContext context = RequestContext.getCurrentInstance();
           // context.execute("PF('mensagens').show();");
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
