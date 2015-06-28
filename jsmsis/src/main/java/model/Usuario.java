/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import enums.StatusUsuario;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import org.hibernate.annotations.ForeignKey;

/**
 *
 * @author MOISES
 */
@Entity
@Table(name = "tbl_usuario")
public class Usuario  implements Serializable{
    
    @Id
    @GeneratedValue
    @Column(name = "usuario_id")
    private Long id;
    
    @Column(name = "usuario_login", nullable = false, length = 20)
    private String login;
    
    @Column(name = "usuario_senha", nullable = false, length = 15)
    private String senha;
    
    @Column(name = "usuario_email", nullable = false, length = 120)
    private String email;
    
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    @Column(name = "usuario_data_cadastro", nullable = false)
    private Date dataCadastro;
    
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    @Column(name = "usuario_ultimo_acesso", nullable = false)
    private Date dataUltimoAcesso;
    
    @Enumerated(EnumType.STRING)
    @Column(name = "usuario_status", nullable = false)
    private StatusUsuario statusUsuario;
    
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "usuario_pessoa_id")
    @ForeignKey(name = "FK_USUARIO_PESSOA")
    private PessoaFisica pessoa;
    
    @OneToMany(mappedBy = "usuario")
    private List<Anuncio> anuncios = new ArrayList<>();
    @OneToMany(mappedBy = "usuario")
    private List<Venda> vendas;
    
    @Column(name = "usuario_aceita_termos", nullable = false)
    private boolean aceitaTemosDeUso;
    
   
    @Embedded
    private ImagemBase64 fotoPerfil;
    
    //CONTRUTOR
    public Usuario() {
        fotoPerfil = new ImagemBase64();
        fotoPerfil.setSize(0);
    }
    
    //GETTERS E SETTERS 
    
    

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getDataCadastro() {
        return dataCadastro;
    }

    public void setDataCadastro(Date dataCadastro) {
        this.dataCadastro = dataCadastro;
    }

    public Date getDataUltimoAcesso() {
        return dataUltimoAcesso;
    }

    public void setDataUltimoAcesso(Date dataUltimoAcesso) {
        this.dataUltimoAcesso = dataUltimoAcesso;
    }

    public StatusUsuario getStatusUsuario() {
        return statusUsuario;
    }

    public void setStatusUsuario(StatusUsuario statusUsuario) {
        this.statusUsuario = statusUsuario;
    }
    //EQUALS AND HASHCODE
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 13 * hash + Objects.hashCode(this.id);
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
        final Usuario other = (Usuario) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }
    //TOSTRING
    @Override
    public String toString() {
        return String.valueOf(id);
    }

    public PessoaFisica getPessoa() {
        return pessoa;
    }

    public void setPessoa(PessoaFisica pessoa) {
        this.pessoa = pessoa;
    }

    public List<Anuncio> getAnuncios() {
        return anuncios;
    }

    public void setAnuncios(List<Anuncio> anuncios) {
        this.anuncios = anuncios;
    }

    public List<Venda> getVendas() {
        return vendas;
    }

    public void setVendas(List<Venda> vendas) {
        this.vendas = vendas;
    }

    public boolean isAceitaTemosDeUso() {
        return aceitaTemosDeUso;
    }

    public void setAceitaTemosDeUso(boolean aceitaTemosDeUso) {
        this.aceitaTemosDeUso = aceitaTemosDeUso;
    }

    public ImagemBase64 getFotoPerfil() {
        return fotoPerfil;
    }

    public void setFotoPerfil(ImagemBase64 fotoPerfil) {
        this.fotoPerfil = fotoPerfil;
    }

    public void setEnderecoLogradouro(String endereco) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void setEnderecoBairro(String bairro) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void setEnderecoCidade(String cidade) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
    
}
