/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author MOISES
 */
@Entity
@Table(name="tbl_mensagem")
public class Mensagem implements Serializable{
    @Id
    @Column(name="mensagem_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    @ManyToOne
    @JoinColumn(name = "mensagem_from", nullable = false)
    private Usuario from;
    
    @ManyToOne
    @JoinColumn(name = "mensagem_to")
    private Usuario to;
    @Lob
    @Column(name="mensagem_conteudo")
    private String conteudo;
    
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="mensagem_data_envio")
    private Date dateEnvio;
    
    @Column(name="mensagem_islida")
    private boolean isLida;

    public Mensagem() {
        to = new Usuario();
        from = new Usuario();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Usuario getFrom() {
        return from;
    }

    public void setFrom(Usuario from) {
        this.from = from;
    }

    public Usuario getTo() {
        return to;
    }

    public void setTo(Usuario to) {
        this.to = to;
    }

    public String getConteudo() {
        return conteudo;
    }

    public void setConteudo(String conteudo) {
        this.conteudo = conteudo;
    }

    public Date getDateEnvio() {
        return dateEnvio;
    }

    public void setDateEnvio(Date dateEnvio) {
        this.dateEnvio = dateEnvio;
    }

    public boolean isIsLida() {
        return isLida;
    }

    public void setIsLida(boolean isLida) {
        this.isLida = isLida;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 41 * hash + Objects.hashCode(this.id);
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
        final Mensagem other = (Mensagem) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return String.valueOf(id);
    }
    
    
    
    
    
}
