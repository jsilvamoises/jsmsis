/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import model.PessoaFisica;

/**
 *
 * @author MOISES
 */
@ManagedBean
@ApplicationScoped
public class NovosUsuarios implements Serializable {

    private static NovosUsuarios instance;

    public static NovosUsuarios getInstance() {
        return instance == null ? instance = new NovosUsuarios() : instance;
    }
    private static final List<PessoaFisica> usuarios = new ArrayList<>();

    public void addPessoaFisica(PessoaFisica u) {
        int ultimo = usuarios.size();

       // System.out.println("Adicionando usuario " + u.getLogin());
        
        usuarios.add(0, u);
        if (usuarios.size() > 5) {
            //System.out.println("Removendo usuario " + usuarios.get(ultimo).getLogin());
            usuarios.remove(ultimo);
        }
        
        for (Iterator<PessoaFisica> it = usuarios.iterator(); it.hasNext();) {
            PessoaFisica uu = it.next();
          //  System.out.println(uu.getLogin());
        }
    }

    public List<PessoaFisica> getPessoaFisicas() {
        return usuarios;
    }

}
