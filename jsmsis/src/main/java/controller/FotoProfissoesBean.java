/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import model.FotoProfissoes;
import org.primefaces.model.UploadedFile;
import org.primefaces.util.Base64;
import repository.FotoProfissoesRepository;

/**
 *
 * @author MOISES
 */
@ManagedBean
@ViewScoped
public class FotoProfissoesBean implements Serializable{
    private UploadedFile upload;
    private FotoProfissoes fotosProfissoes;
    private FotoProfissoesRepository repository;
    private List<FotoProfissoes> top2 = new ArrayList<>();
    private List<FotoProfissoes> top8 = new ArrayList<>();
    private List<FotoProfissoes> fotos = new ArrayList<>();

    public FotoProfissoesBean() {
        fotosProfissoes = new FotoProfissoes();
        repository = new FotoProfissoesRepository();
        
    }
    
    public void init(){
        fotos = repository.getEntities();
    }
    
    public void clear(){
        fotosProfissoes = new FotoProfissoes();
    }
    
    public void save(){
        if(repository.save(fotosProfissoes)){
            clear();
        }
    }

    public UploadedFile getUpload() {
        return upload;
    }

    public void setUpload(UploadedFile upload) {
        this.upload = upload;
    }

    public FotoProfissoes getFotosProfissoes() {
        return fotosProfissoes;
    }

    public void setFotosProfissoes(FotoProfissoes fotosProfissoes) {
        this.fotosProfissoes = fotosProfissoes;
    }

    public List<FotoProfissoes> getTop2() {
        return top2;
    }

    public void setTop2(List<FotoProfissoes> top2) {
        this.top2 = top2;
    }

    public List<FotoProfissoes> getTop8() {
        return top8;
    }

    public void setTop8(List<FotoProfissoes> top8) {
        this.top8 = top8;
    }
    
    public void enviarImagem(){
        
        byte[] imageAsByte = new byte[(int) upload.getSize()];
        try {
            upload.getInputstream().read(imageAsByte);
        } catch (IOException ex) {
            Logger.getLogger(FotoProfissoesBean.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        fotosProfissoes.getImagem().setContentType(upload.getContentType());
        fotosProfissoes.getImagem().setSize(upload.getSize());
        fotosProfissoes.getImagem().setFileName(upload.getFileName());
        fotosProfissoes.getImagem().setBase64Encod(Base64.encodeToString(imageAsByte, true));
        
        System.out.println(fotosProfissoes.getImagem().getContentType());
        System.out.println(fotosProfissoes.getImagem().getFileName());
        System.out.println(fotosProfissoes.getImagem().getSize());
        System.out.println(fotosProfissoes.getImagem().getImagemCodificada());
       // System.out.println(fotosProfissoes.getImagem().getBase64Encod());
        
//        System.out.println("passou aqui!!");
//            String formato = imagemPerfilPart.getContentType();
//            String nomeImagem = imagemPerfilPart.getName();
//            
//            
//            imagemPerfilPart.getInputStream().read(imageAsByte);
//            ImagemBase64 ib4 = new ImagemBase64();
//            String base64AsString = new String(Base64.encode(imageAsByte));
//
//            ib4.setB64(base64AsString);
//            ib4.setFormato(formato);
//            ib4.setNome(nomeImagem);
    }

    public FotoProfissoesRepository getRepository() {
        return repository;
    }

    public void setRepository(FotoProfissoesRepository repository) {
        this.repository = repository;
    }

    public List<FotoProfissoes> getFotos() {
        return fotos;
    }

    public void setFotos(List<FotoProfissoes> fotos) {
        this.fotos = fotos;
    }
    
}
