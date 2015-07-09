/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Teste;

import enums.StatusUsuario;
import java.math.BigInteger;
import java.util.Calendar;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import model.Endereco;
import model.Estado;
import model.PessoaFisica;
import model.Usuario;
import repository.EstadoRepository;
import repository.PessoaFisicaRepository;

/**
 *
 * @author MOISES
 */
@ManagedBean
@ViewScoped
public class InsertPessoa {

    /**
     * @param args the command line arguments
     */
    private PessoaFisica pessoa; 
    private PessoaFisicaRepository repository = new PessoaFisicaRepository();
    private EstadoRepository repositoryEstado = new EstadoRepository();
    private Endereco endereco;
    private Estado estado;
    private Usuario usuario;
    private  int i;
//    public static void main(String[] args) {
//        new InsertPessoa().inserir();
//    }
    
    
    public void inserir(){
        for(int i = 0 ; i <=10; i++){
            
            pessoa = new PessoaFisica();
            endereco = new Endereco();
            estado = new Estado();
            usuario = new Usuario();
            
            usuario.setAceitaTemosDeUso(true);
            usuario.setDataCadastro(Calendar.getInstance().getTime());
            usuario.setDataUltimoAcesso(Calendar.getInstance().getTime());
            usuario.setEmail(i+"@"+i+".com.br");
            usuario.setLogin(""+i);
            usuario.setSenha(""+i);
            usuario.setStatusUsuario(StatusUsuario.ATIVO);
            
            
            estado.setNome("São Paulo "+i);
            estado.setSigla("SP "+i);
            repositoryEstado.save(estado);
            
            endereco.setBairro("Jardim America "+i);
            endereco.setCep("13."+i);
            endereco.setCidade("Varzea Paulista "+i);
            endereco.setComplemento("complemento "+i);
            endereco.setEstado(estado);
            endereco.setLogradouro("Rua Bertioga "+i);
            endereco.setNumero(""+i);
            endereco.setObservacao(""+i);
            endereco.setPessoa(pessoa);
            
            pessoa.setCpf("12345"+i);
            pessoa.setDataNascimento(Calendar.getInstance().getTime());
            pessoa.getEnderecos().add(endereco);
            pessoa.setNome("MOISES JUVENAL DA SILVA"+i);
            pessoa.setProfissao("PROFISSAO "+i);
            pessoa.setRg(""+i);
            pessoa.setUsuario(usuario);
            repository.save(pessoa);
            this.i =i;
        }
        
    }

    public int getI() {
        return i;
    }

    public void setI(int i) {
        this.i = i;
    }

    
}
