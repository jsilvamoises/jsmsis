/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;
import javax.persistence.Transient;

/**
 *
 * @author MOISES
 */
@Entity
@Table(name="tbl_foto_profissoes")
public class FotoProfissoes implements Serializable{
    @Id
    @Column(name="foto_profissao_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    @Column(name="foto_profissao_titulo", nullable = false)
    private String titulo;
    
    @Column(name="foto_profissao_subtitulo", nullable = false)
    private String subtitulo;
    
    @Lob
    @Column(name="foto_profissao_texto", nullable = false)
    private String texto;
    
    @Column(name="foto_profissao_outcome")
    private String outcome;
    
    @Embedded
    private ImagemBase64 imagem;
    
    @Column(name="foto_profissao_is_firstpage")
    private boolean isFistPage;
    
    @Transient
    private String render;

    public FotoProfissoes() {
        imagem = new ImagemBase64();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getSubtitulo() {
        return subtitulo;
    }

    public void setSubtitulo(String subtitulo) {
        this.subtitulo = subtitulo;
    }

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }

    public String getOutcome() {
        return outcome;
    }

    public void setOutcome(String outcome) {
        this.outcome = outcome;
    }

    public ImagemBase64 getImagem() {
        return imagem;
    }

    public void setImagem(ImagemBase64 imagem) {
        this.imagem = imagem;
    }

    public String getRender() {
        return render;
    }

    public void setRender(String render) {
        this.render = render;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 47 * hash + Objects.hashCode(this.id);
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
        final FotoProfissoes other = (FotoProfissoes) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return String.valueOf(id);
    }

    public boolean isIsFistPage() {
        return isFistPage;
    }

    public void setIsFistPage(boolean isFistPage) {
        this.isFistPage = isFistPage;
    }
    
    
}
