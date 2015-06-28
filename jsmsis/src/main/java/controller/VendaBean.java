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
import model.Venda;
import repository.VendaRepository;

/**
 *
 * @author MOISES
 */
@ManagedBean
@ViewScoped
public class VendaBean implements Serializable{
    private Venda venda;
    private Venda vendaSelecionado;
    private List<Venda> vendas = new ArrayList<>();
    private final VendaRepository repository;

    public VendaBean() {
        venda = new Venda();
        vendaSelecionado = new Venda();
        repository = new VendaRepository();
    }
    
    
    
    public void save(){
        repository.save(venda);
    }
    
    public void delete(){
        repository.delete(venda);
    }
    
    public void pesquisarTodos(){
        vendas = repository.getVendas();
    }

    public Venda getVenda() {
        return venda;
    }

    public void setVenda(Venda venda) {
        this.venda = venda;
    }

    public Venda getVendaSelecionado() {
        return vendaSelecionado;
    }

    public void setVendaSelecionado(Venda vendaSelecionado) {
        this.vendaSelecionado = vendaSelecionado;
    }

    public List<Venda> getVendas() {
        return vendas;
    }

    public void setVendas(List<Venda> vendas) {
        this.vendas = vendas;
    }
    
    
}
