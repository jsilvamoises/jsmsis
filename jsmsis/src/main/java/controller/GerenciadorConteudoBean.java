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
import javax.faces.bean.RequestScoped;
import model.FotoProfissoes;
import repository.FotoProfissoesRepository;

/**
 *
 * @author MOISES
 */
@ManagedBean
@RequestScoped
public class GerenciadorConteudoBean implements Serializable {

    private FotoProfissoes fotoUm;
    private FotoProfissoes fotoDois;
    
     
    private List<FotoProfissoes> fotos = new ArrayList<>();

    public FotoProfissoes getFotoUm() {
        return fotoUm;
    }

    public void setFotoUm(FotoProfissoes fotoUm) {
        this.fotoUm = fotoUm;
    }

    public FotoProfissoes getFotoDois() {
        return fotoDois;
    }

    public void setFotoDois(FotoProfissoes fotoDois) {
        this.fotoDois = fotoDois;
    }

   

   

    private final FotoProfissoesRepository profissoesRepository;

    public GerenciadorConteudoBean() {
        profissoesRepository = new FotoProfissoesRepository();
        fotos = profissoesRepository.Top8();
        preecherFotos();
    }

    private void preecherFotos() {
        int tamanhoDaLista = fotos.size();
        if (fotos.size() > 0) {
            int a, b;
            do {
                a = (int) (Math.random() * tamanhoDaLista);
                b = (int) (Math.random() * tamanhoDaLista);
            } while (a == b && tamanhoDaLista > 1);

            fotoUm = fotos.get(a);
            fotoDois = fotos.get(b);
        }
    }

    public List<FotoProfissoes> getFotos() {
        return fotos;
    }

    public void setFotos(List<FotoProfissoes> fotos) {
        this.fotos = fotos;
    }

    

    

}
