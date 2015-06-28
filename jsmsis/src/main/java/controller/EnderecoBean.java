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
import model.Endereco;
import repository.EnderecoRepository;

/**
 *
 * @author MOISES
 */
@ManagedBean
@ViewScoped
public class EnderecoBean implements Serializable{
    private Endereco endereco;
    private Endereco enderecoSelecionado;
    private List<Endereco> enderecos = new ArrayList<>();
    private final EnderecoRepository repository;

    public EnderecoBean() {
        endereco = new Endereco();
        enderecoSelecionado = new Endereco();
        repository = new EnderecoRepository();
    }
    
    
    
    public void save(){
        repository.save(endereco);
    }
    
    public void delete(){
        repository.delete(endereco);
    }
    
    public void pesquisarTodos(){
        enderecos = repository.getEnderecos();
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    public Endereco getEnderecoSelecionado() {
        return enderecoSelecionado;
    }

    public void setEnderecoSelecionado(Endereco enderecoSelecionado) {
        this.enderecoSelecionado = enderecoSelecionado;
    }

    public List<Endereco> getEnderecos() {
        return enderecos;
    }

    public void setEnderecos(List<Endereco> enderecos) {
        this.enderecos = enderecos;
    }
    
    
}
