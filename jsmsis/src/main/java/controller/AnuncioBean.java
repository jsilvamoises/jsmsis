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
import model.Anuncio;
import repository.AnuncioRepository;

/**
 *
 * @author MOISES
 */
@ManagedBean
@ViewScoped
public class AnuncioBean implements Serializable{
    private Anuncio anuncio;
    private Anuncio anuncioSelecionado;
    private List<Anuncio> anuncios = new ArrayList<>();
    private AnuncioRepository repository;

    public AnuncioBean() {
        anuncio = new Anuncio();
        anuncioSelecionado = new Anuncio();
        repository = new AnuncioRepository();
    }
    
    
    
    public void save(){
        repository.save(anuncio);
    }
    
    public void delete(){
        repository.delete(anuncio);
    }
    
    public void pesquisarTodos(){
        anuncios = repository.getAnuncios();
    }

    public Anuncio getAnuncio() {
        return anuncio;
    }

    public void setAnuncio(Anuncio anuncio) {
        this.anuncio = anuncio;
    }

    public Anuncio getAnuncioSelecionado() {
        return anuncioSelecionado;
    }

    public void setAnuncioSelecionado(Anuncio anuncioSelecionado) {
        this.anuncioSelecionado = anuncioSelecionado;
    }

    public List<Anuncio> getAnuncios() {
        return anuncios;
    }

    public void setAnuncios(List<Anuncio> anuncios) {
        this.anuncios = anuncios;
    }
    
    
}
