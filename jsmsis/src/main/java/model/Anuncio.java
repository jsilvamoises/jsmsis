/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import enums.AnuncioStatus;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;

/**
 *
 * @author MOISES
 */
@Entity
@Table(name = "tbl_anuncio")
public class Anuncio implements Serializable {

    @Id
    @Column(name = "anuncio_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    @ManyToOne
    @JoinColumn(name = "anuncio_usuario_id", nullable = false)
    private Usuario usuario;

    @Column(name = "anuncio_titulo", nullable = false, length = 255)
    private String titulo;

    @Lob
    @Column(name = "anuncio_descricao", nullable = false)
    private String Descricao;

    @Lob
    @Column(name = "anuncio_observacao", nullable = false)
    private String observacao;

    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    @Column(name="anuncio_data_publicacao")
    private Date dataPublicacao;
    
    @Temporal(javax.persistence.TemporalType.DATE)
    @Column(name="anuncio_data_vencimento")
    private Date dataVencimento;
    
    @Enumerated(EnumType.STRING)
    @Column(name="anuncio_status")
    private AnuncioStatus status;
    
    @OneToOne
    @JoinColumn(name = "anuncio_plano_id")
    private Plano plano;
    
    @Column(name = "anuncio_valor_pago", precision = 10, scale = 2)
    private BigDecimal valorPagoAnuncio;
    
    @Column(name="anuncio_palavras_chave")
    private String[] palavrasChave;

    public Anuncio() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescricao() {
        return Descricao;
    }

    public void setDescricao(String Descricao) {
        this.Descricao = Descricao;
    }

    public String getObservacao() {
        return observacao;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }

    public Date getDataPublicacao() {
        return dataPublicacao;
    }

    public void setDataPublicacao(Date dataPublicacao) {
        this.dataPublicacao = dataPublicacao;
    }

    public Date getDataVencimento() {
        return dataVencimento;
    }

    public void setDataVencimento(Date dataVencimento) {
        this.dataVencimento = dataVencimento;
    }

    public AnuncioStatus getStatus() {
        return status;
    }

    public void setStatus(AnuncioStatus status) {
        this.status = status;
    }

    public Plano getPlano() {
        return plano;
    }

    public void setPlano(Plano plano) {
        this.plano = plano;
    }

    public BigDecimal getValorPagoAnuncio() {
        return valorPagoAnuncio;
    }

    public void setValorPagoAnuncio(BigDecimal valorPagoAnuncio) {
        this.valorPagoAnuncio = valorPagoAnuncio;
    }

    public String[] getPalavrasChave() {
        return palavrasChave;
    }

    public void setPalavrasChave(String[] palavrasChave) {
        this.palavrasChave = palavrasChave;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 29 * hash + Objects.hashCode(this.id);
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
        final Anuncio other = (Anuncio) obj;
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
