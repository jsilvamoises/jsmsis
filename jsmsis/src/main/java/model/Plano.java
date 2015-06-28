/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author MOISES
 */
@Entity
@Table(name="tbl_plano")
public class Plano implements Serializable{
    @Id
    @GeneratedValue(strategy =  GenerationType.AUTO)
    private Long id;
    
    private String descricao;
    private BigDecimal valor;
    private BigDecimal valorPromocional;
    private boolean isPromocao;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }

    public BigDecimal getValorPromocional() {
        return valorPromocional;
    }

    public void setValorPromocional(BigDecimal valorPromocional) {
        this.valorPromocional = valorPromocional;
    }

    public boolean isIsPromocao() {
        return isPromocao;
    }

    public void setIsPromocao(boolean isPromocao) {
        this.isPromocao = isPromocao;
    }
    
    
    
    
    
    
}
