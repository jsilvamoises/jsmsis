/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Teste;

import Embeddable.TelefoneCelular;
import Embeddable.TelefoneFixo;
import java.util.Date;
import javax.persistence.EntityManager;
import model.Endereco;
import model.PessoaFisica;
import model.Usuario;
import util.JpaUtil;

/**
 *
 * @author MOISES
 */
public class Tete {
    
    public static void main(String[] args) {
//        PessoaFisica pessoa = new PessoaFisica();
//        Usuario usuario = new Usuario();
//        Endereco endereco= new Endereco();
//        TelefoneFixo telFixo = new TelefoneFixo();
//        TelefoneCelular telCel = new TelefoneCelular();
//        
//        
//        
//        endereco.setBairro("JARDIM AMERICA I");
//        endereco.setCep("13.221-300");
//        endereco.setCidade("VÁRZEA PAULISTA");
//        endereco.setComplemento("CASA");
//        //endereco.setEstado("SÃO PAULO");
//        endereco.setLogradouro("RUA BERTIOGA");
//        endereco.setNumero("49");
//        endereco.setObservacao("CASA");
//        endereco.setPessoa(pessoa);
//        
//        telCel.setCodigoPais("55");
//        telCel.setDDD("11");
//        telCel.setNumero("9.9556.2455");
//        
//        telFixo.setCodigoPais("55");
//        telFixo.setDDD("11");        
//        telFixo.setNumero("4493-2288");
//        
//        pessoa.setCpf("215.049.798-00");
//       // Date datanasc = Date.getInstance();
//       // datanasc.set(1982, 9, 7);
//       // pessoa.setDataNascimento(datanasc);
//        pessoa.getEnderecos().add(endereco);
//        pessoa.setNome("MOISES JUVENAL DA SILVA");
//        pessoa.setRg("32.100.705-0");
//        pessoa.setTelefoneCelular(telCel);
//        pessoa.setTelefoneFixo(telFixo);
//        
        
        EntityManager manager = JpaUtil.getEntityManager();
        
        manager.getTransaction().begin();
        //manager.persist(pessoa);
        manager.getTransaction().commit();
        manager.close();
        
    }
    
}
