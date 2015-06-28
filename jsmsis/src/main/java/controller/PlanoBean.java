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
import model.Plano;
import repository.PlanoRepository;

/**
 *
 * @author MOISES
 */
@ManagedBean
@ViewScoped
public class PlanoBean implements Serializable{
    private Plano plano;
    private Plano planoSelecionado;
    private List<Plano> planos = new ArrayList<>();
    private final PlanoRepository repository;

    public PlanoBean() {
        plano = new Plano();
        planoSelecionado = new Plano();
        repository = new PlanoRepository();
    }
    
    
    
    public void save(){
        repository.save(plano);
    }
    
    public void delete(){
        repository.delete(plano);
    }
    
    public void pesquisarTodos(){
        planos = repository.getPlanos();
    }

    public Plano getPlano() {
        return plano;
    }

    public void setPlano(Plano plano) {
        this.plano = plano;
    }

    public Plano getPlanoSelecionado() {
        return planoSelecionado;
    }

    public void setPlanoSelecionado(Plano planoSelecionado) {
        this.planoSelecionado = planoSelecionado;
    }

    public List<Plano> getPlanos() {
        return planos;
    }

    public void setPlanos(List<Plano> planos) {
        this.planos = planos;
    }
    
    
}
