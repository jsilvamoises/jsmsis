/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import Embeddable.TelefoneCelular;
import Embeddable.TelefoneFixo;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.Transient;

/**
 *
 * @author MOISES
 */
@Entity
@Table(name = "tbl_pessoa")
public class PessoaFisica implements Serializable{
    
    @Id
    @GeneratedValue(strategy =  GenerationType.AUTO)
    @Column(name = "pessoa_id")
    private Long id;
    
    @Column(name = "pessoa_fisica_nome", nullable = false, length = 120)
    private String nome;
    
    @Embedded    
    private TelefoneFixo telefoneFixo;
    
    @Embedded 
    private TelefoneCelular telefoneCelular;
    
   
    @Column(name = "pessoa_data_nascimento", nullable = false)
    
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date dataNascimento;
    
    @Column(name = "pessoa_rg", nullable = false)
    private String rg;
    
    @Column(name = "pessoa_cpf", nullable = false)
    private String cpf;
    
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "pessoa_enderecos_id")
    private List<Endereco>  enderecos = new ArrayList<>();
     
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "pessoa_fisica_usuario_id")
     private Usuario usuario;
    
    @Column(name = "pessoa_profissao")
    private String profissao;
    
    @Transient
    private Endereco enderecoPrincipal;

    public PessoaFisica() {
        telefoneCelular = new TelefoneCelular();
        telefoneFixo = new TelefoneFixo();
        usuario = new Usuario();
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public TelefoneFixo getTelefoneFixo() {
        return telefoneFixo;
    }

    public void setTelefoneFixo(TelefoneFixo telefoneFixo) {
        this.telefoneFixo = telefoneFixo;
    }

    public TelefoneCelular getTelefoneCelular() {
        return telefoneCelular;
    }

    public void setTelefoneCelular(TelefoneCelular telefoneCelular) {
        this.telefoneCelular = telefoneCelular;
    }
    //@Temporal(javax.persistence.TemporalType.DATE)
    public Date getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(Date dataNascimento) {       
        this.dataNascimento = dataNascimento;
    }

    public String getRg() {
        return rg;
    }

    public void setRg(String rg) {
        this.rg = rg;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public List<Endereco> getEnderecos() {
        return enderecos;
    }

    public void setEnderecos(List<Endereco> enderecos) {
        this.enderecos = enderecos;
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

    public Endereco getEnderecoPrincipal() {
        return enderecos.get(0);
    }

    public void setEnderecoPrincipal(Endereco enderecoPrincipal) {
        this.enderecoPrincipal = enderecoPrincipal;
    }

    public String getProfissao() {
        return profissao;
    }

    public void setProfissao(String profissao) {
        this.profissao = profissao;
    }
    
    
     
    
}
