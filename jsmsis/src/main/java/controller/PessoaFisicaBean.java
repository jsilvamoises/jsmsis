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
import javax.faces.component.FacesComponent;
import javax.faces.context.FacesContext;
import model.Endereco;
import model.Estado;
import model.PessoaFisica;
import repository.EstadoRepository;
import repository.PessoaFisicaRepository;
import util.FacesUtil;

/**
 *
 * @author MOISES
 */
@ManagedBean
@ViewScoped
public class PessoaFisicaBean implements Serializable {

    private PessoaFisica pessoaFisica;
    private PessoaFisica pessoaFisicaSelecionado;
    private List<PessoaFisica> pessoaFisicas = new ArrayList<>();
    private final PessoaFisicaRepository repository;
    private Endereco endereco;
    private boolean isEmailCadastrado;
    private List<Estado> estados = new ArrayList<>();
    private final EstadoRepository repositoryEstado;
    private boolean habilitarCamposEndereco = false;

    public PessoaFisicaBean() {
        pessoaFisica = new PessoaFisica();
        pessoaFisicaSelecionado = new PessoaFisica();
        repository = new PessoaFisicaRepository();
        repositoryEstado = new EstadoRepository();
        endereco = new Endereco();
    }

    public void verificarSeExisteLoginCadastrado() {
        if (!pessoaFisica.getUsuario().getLogin().isEmpty()) {
            if (repository.isLoginCadastrado(pessoaFisica.getUsuario().getLogin())) {
                pessoaFisica.getUsuario().setLogin("");
                FacesUtil.addErrorMessage("Usuario escolhido já está em uso");
            } else {
                FacesUtil.addInfoMessage("Usuario disponível");
            }
        }

    }

    public void validarEmail() {
        isEmailCadastrado = repository.isEmaiCadastrado(pessoaFisica.getUsuario().getEmail());
        if (isEmailCadastrado) {
            FacesUtil.addWarnMessage("Email não pode ser utilizado, já existe um cadastro!!!!");
            pessoaFisica.getUsuario().setEmail("");
        }
    }

    public void init() {
        estados = repositoryEstado.getEntities();
    }

    public void buscarCep() {
        CepBean cep = CepBean.getInstance();
        cep.buscarEndereco(endereco.getCep());
        if (cep != null) {
            endereco.setBairro(cep.getBairro());
            endereco.setCidade(cep.getCidade());
            endereco.setLogradouro(cep.getEndereco());
            System.out.println("UF = " + cep.getUf());
            endereco.setEstado(repositoryEstado.getEstadoBySigla(cep.getUf()));
        }
        System.out.println(cep.getBairro());
        habilitarCamposEndereco = !endereco.getBairro().isEmpty();
    }

    public void save() {
        pessoaFisica.getEnderecos().add(endereco);
        endereco.setPessoa(pessoaFisica);
        if (repository.save(pessoaFisica)) {

            clear();
        }
    }

    public void clear() {
        pessoaFisica = new PessoaFisica();
        endereco = new Endereco();
    }

    public void delete() {
        if (repository.delete(pessoaFisica)) {
            clear();
        }
    }

    public void pesquisarTodos() {
        pessoaFisicas = repository.list();
    }

    public PessoaFisica getPessoaFisica() {
        return pessoaFisica;
    }

    public void setPessoaFisica(PessoaFisica pessoaFisica) {
        this.pessoaFisica = pessoaFisica;
    }

    public PessoaFisica getPessoaFisicaSelecionado() {
        return pessoaFisicaSelecionado;
    }

    public void setPessoaFisicaSelecionado(PessoaFisica pessoaFisicaSelecionado) {
        this.pessoaFisicaSelecionado = pessoaFisicaSelecionado;
    }

    public List<PessoaFisica> getPessoaFisicas() {
        return pessoaFisicas;
    }

    public void setPessoaFisicas(List<PessoaFisica> pessoaFisicas) {
        this.pessoaFisicas = pessoaFisicas;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    public boolean isIsEmailCadastrado() {
        return isEmailCadastrado;
    }

    public void setIsEmailCadastrado(boolean isEmailCadastrado) {
        this.isEmailCadastrado = isEmailCadastrado;
    }

    public List<Estado> getEstados() {
        return estados;
    }

    public void setEstados(List<Estado> estados) {
        this.estados = estados;
    }

    public boolean isHabilitarCamposEndereco() {
        return habilitarCamposEndereco;
    }

    public void setHabilitarCamposEndereco(boolean habilitarCamposEndereco) {
        this.habilitarCamposEndereco = habilitarCamposEndereco;
    }

}
