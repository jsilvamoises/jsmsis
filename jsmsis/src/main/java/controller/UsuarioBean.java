/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import model.Usuario;
import repository.UsuarioRepository;
import util.FacesUtil;

/**
 *
 * @author MOISES
 */
@ManagedBean
@SessionScoped
public class UsuarioBean implements Serializable{
    private Usuario usuario;
    private Usuario usuarioSelecionado;
    private List<Usuario> usuarios = new ArrayList<>();
    private final UsuarioRepository repository;

    public UsuarioBean() {
        usuario = new Usuario();
        usuarioSelecionado = new Usuario();
        repository = new UsuarioRepository();
    }
    
    public void validarSenha(){
        if(repository.validarSenha(usuario)){
            try {
                FacesContext.getCurrentInstance().getExternalContext().redirect("/");
            } catch (IOException ex) {
                Logger.getLogger(UsuarioBean.class.getName()).log(Level.SEVERE, null, ex);
            }
        }else{
            FacesUtil.addErrorMessage("Login ou senha inválidos!!!!");
        }
    }
    
    
    public void save(){
        repository.save(usuario);
    }
    
    public void delete(){
        repository.save(usuario);
    }
    
    public void pesquisarTodos(){
        usuarios = repository.getEntities();
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Usuario getUsuarioSelecionado() {
        return usuarioSelecionado;
    }

    public void setUsuarioSelecionado(Usuario usuarioSelecionado) {
        this.usuarioSelecionado = usuarioSelecionado;
    }

    public List<Usuario> getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(List<Usuario> usuarios) {
        this.usuarios = usuarios;
    }
    
    
}
