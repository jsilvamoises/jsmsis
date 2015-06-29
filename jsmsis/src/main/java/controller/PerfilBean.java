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
import model.Mensagem;
import model.PessoaFisica;
import model.Usuario;
import org.primefaces.context.RequestContext;
import repository.MensagemRepository;
import repository.PessoaFisicaRepository;

/**
 *
 * @author MOISES
 */
@ManagedBean
@ViewScoped
public class PerfilBean implements Serializable {
    /*@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@*/
    //                       CLASSES DE MODELO                                   //
    /*@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@*/
    private Usuario usuario;
    private PessoaFisica pessoaFisica;
    /*@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@*/
    //                       LISTA DE OBJETOS                                    //
    /*@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@*/
    private List<Mensagem> mensagens = new ArrayList<>();
    private List<Endereco> enderecos;
    /*@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@*/
    //                       REPOSITORIOS                                        //
    /*@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@*/
    public MensagemRepository repository;
    private PessoaFisicaRepository pessRepository;
   

    public PerfilBean() {
        pessoaFisica = new PessoaFisica();
        repository = new MensagemRepository();
        pessRepository = new PessoaFisicaRepository();

    }

    public void init() {
       pessoaFisica = pessRepository.pessoaByUsuario(usuario);
    }

    public List<Mensagem> getMensagens() {
        return mensagens;
    }

    public void setMensagens(List<Mensagem> mensagens) {
        this.mensagens = mensagens;
    }

    public PessoaFisica getPessoaFisica() {
        return pessoaFisica;
    }

    public void setPessoaFisica(PessoaFisica pessoaFisica) {
        this.pessoaFisica = pessoaFisica;
    }

    public List<Endereco> getEndereco() {
        return enderecos;
    }

    public void setEndereco(List<Endereco> enderecos) {
        this.enderecos = enderecos;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
    
//    Menu
    public void verMensagens(){
        System.out.println("Menu Perfil");
        try {
//            RequestContext context = RequestContext.getCurrentInstance();
//            context.execute("PF('mensagens').show();");
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    

}
