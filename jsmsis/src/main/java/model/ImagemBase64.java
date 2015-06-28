/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Lob;
import javax.persistence.Transient;

/**
 *
 * @author MOISES
 */
@Embeddable
public class ImagemBase64 implements Serializable {

    @Column(name = "foto_perfil_extencao")
    private String contentType;

    @Column(name = "foto_perfil_size", nullable = true)
    private long size;

    @Column(name = "foto_perfil_file_name")
    private String fileName;
    @Lob
    @Column(name = "foto_perfil_base64")
    private String base64Encod;
    
    @Transient
    private String imagemCodificada;

    public ImagemBase64() {
    }

    public String getContentType() {
        return contentType;
    }

    public void setContentType(String contentType) {
        this.contentType = contentType;
    }

    public long getSize() {
        return size;
    }

    public void setSize(long size) {
        this.size = size;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getBase64Encod() {
        return base64Encod;
    }

    public void setBase64Encod(String base64Encod) {
        this.base64Encod = base64Encod;
    }

    public String getImagemCodificada() {
        return "data:"+contentType+";base64,"+base64Encod;
       
    }

    public void setImagemCodificada(String imagemCodificada) {
        this.imagemCodificada = imagemCodificada;
    }

}
