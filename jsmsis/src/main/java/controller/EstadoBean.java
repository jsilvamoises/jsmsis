/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import model.Estado;
import repository.EstadoRepository;

/**
 *
 * @author MOISES
 */
@ManagedBean
@ViewScoped
public class EstadoBean implements Serializable{
  private Estado estado;
  private List<Estado> estados = new ArrayList<>();
  private final EstadoRepository repository;

    public EstadoBean() {
        estado = new Estado();
        repository = new EstadoRepository();
    }
    
    public void init(){
        estados = repository.getEntities();
    }
    
    public void save(){
        
    }
    
    public void delete(){
        
    }
    
    public void listAll(){
        estados = repository.getEntities();
    }
    
    public void clear(){
        estado = new Estado();
    }
    
    public void getEstadoBySigla(){
        
    }

    public Estado getEstado() {
        return estado;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }

    public List<Estado> getEstados() {
        return estados;
    }

    public void setEstados(List<Estado> estados) {
        this.estados = estados;
    }
  
  
  
    
    
    
    
}
