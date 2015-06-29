/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import enums.EstadoEnum;
import java.io.Serializable;
import java.util.Objects;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import org.hibernate.annotations.ForeignKey;

/**
 *
 * @author MOISES
 */
@Entity
@Table(name="tbl_endereco")

public class Endereco implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="endereco_id")
    private Long id;
    
    @Column(name="endereco_logradouro", nullable = false, length = 120)
    private String logradouro;
    
    @Column(name="endereco_numero", nullable = false, length = 15)
    private String numero;
    
    @Column(name="endereco_bairro", nullable = false, length = 120)
    private String bairro;
    
    @Column(name="endereco_cidade", nullable = false, length = 120)
    private String cidade;
    
    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name="endereco_estado", nullable = false)
    private Estado estado;
    
    @Column(name="endereco_cep", nullable = false, length = 12)
    private String cep;
    
    @Column(name="endereco_complemento",  length = 120)
    private String complemento;
    
    @Column(name="endereco_observacao",  length = 255)
    private String observacao;
    
    @ManyToOne(cascade = CascadeType.ALL)
    @ForeignKey(name = "FK_ENDERECO_PESSOA")
    @JoinColumn(name="pessoa_id")    
    private PessoaFisica pessoa;
    
    //CONTRUTOR

    public Endereco() {
        estado = new Estado();
    }
    //GETTERS E SETTER

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLogradouro() {
        return logradouro;
    }

    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public Estado getEstado() {
        return estado;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    public String getObservacao() {
        return observacao;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }

    public PessoaFisica getPessoa() {
        return pessoa;
    }

    public void setPessoa(PessoaFisica pessoa) {
        this.pessoa = pessoa;
    }
    
    //EQUALS AND HASHCODE

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 17 * hash + Objects.hashCode(this.id);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Endereco other = (Endereco) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return String.valueOf(id);
    }

    public void setEstado(EstadoEnum e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
