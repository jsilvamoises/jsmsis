/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package repository;

import controller.NovosUsuarios;
import dao.Dao;
import enums.StatusUsuario;

import interfaces.InterfaceDao;
import java.io.Serializable;
import java.util.Calendar;
import java.util.List;
import model.Endereco;
import model.PessoaFisica;
import model.Usuario;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import util.FacesUtil;
import util.FotoSemFoto;

/**
 *
 * @author MOISES
 */
public class PessoaFisicaRepository implements Serializable, interfaces.InterfaceCrud {

    private InterfaceDao<PessoaFisica> Dao() {
        InterfaceDao<PessoaFisica> dao = new Dao<>(PessoaFisica.class);
        return dao;
    }

    @Override
    public boolean save(Object o) {
        if (((PessoaFisica) o).getId() == null) {
            ((PessoaFisica) o).getUsuario().setDataCadastro(Calendar.getInstance().getTime());
            ((PessoaFisica) o).getUsuario().setDataUltimoAcesso(Calendar.getInstance().getTime());
            ((PessoaFisica) o).getUsuario().setStatusUsuario(StatusUsuario.ATIVO);
            ((PessoaFisica) o).getUsuario().getFotoPerfil().setSize(FotoSemFoto.SIZE);
            ((PessoaFisica) o).getUsuario().getFotoPerfil().setBase64Encod(FotoSemFoto.ENCODE);
            ((PessoaFisica) o).getUsuario().getFotoPerfil().setFileName(FotoSemFoto.NOME);
        } else {
            ((PessoaFisica) o).getUsuario().setDataUltimoAcesso(Calendar.getInstance().getTime());
        }
        
         //VERIFICA SE NOME E DATA DE NASCIMENTO FORAM PREENCHIDOS
        if (isDadosPessoaisPreenchidos((PessoaFisica) o)) {
            //VERIFICA SE FOI CRIADO USUARIO E SENHA E EMAIL
            if (isLoginPreenchido((PessoaFisica) o)) {
                //VERIFICA SE O ENDERECO FOI PREENCHIDO
                if (isEnderecoPreenchido((PessoaFisica) o)) {
                    boolean salvou = false;
                    salvou = Dao().saveOrUpdate((PessoaFisica) o);
                    if(salvou){
                      System.out.println("Paso");
                      Dao().merge((PessoaFisica) o);
                      NovosUsuarios.getInstance().addPessoaFisica((PessoaFisica) o);
                      
                    }
                      
                    return salvou;
                } else {
                    FacesUtil.addWarnMessage("Endereco é um campo obrigatório");
                    
                    return false;
                }

            } else {
                FacesUtil.addWarnMessage("É obrigatório definir e-mail, login e senha!!!!");
                return false;
            }

        } else {
            FacesUtil.addWarnMessage("Nome e data de nascimento são obrigatórios!!!!");
            return false;
        }

    }

    @Override
    public boolean saveOrUpdate(Object o) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean delete(Object o) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean merge(Object o) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List list() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public boolean isEnderecoPreenchido(PessoaFisica pessoa) {
        Endereco e = pessoa.getEnderecos().get(0);
        try {
            return !e.getBairro().isEmpty() && !e.getCep().isEmpty() && !e.getCidade().isEmpty() && e.getEstado()!=null && !e.getLogradouro().isEmpty()
                    && !e.getNumero().isEmpty();
        } catch (Exception err) {
            return false;
        }

    }

    public boolean isLoginPreenchido(PessoaFisica pessoa) {
        Usuario u = pessoa.getUsuario();
        try {
            return !u.getLogin().isEmpty() && !u.getEmail().isEmpty() && !u.getSenha().isEmpty();
        } catch (Exception e) {
            return false;
        }

    }

    public boolean isDadosPessoaisPreenchidos(PessoaFisica pessoa) {
        try {
            return !pessoa.getNome().isEmpty() && pessoa.getDataNascimento() != null;
        } catch (Exception e) {
            return false;
        }
    }
    
    /*@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@*/
    //                VALIDA EMAIL SE JÁ FOI CADASTRADO                            //
    /*@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@*/
    
    public boolean isEmaiCadastrado(String email){
        DetachedCriteria criteria = DetachedCriteria.forClass(Usuario.class);
        criteria.add(Restrictions.ilike("email", email));
        try{
            return Dao().getEntitiesByDetachetCriteria(criteria).size()>0;
        }catch(Exception ex){
            return false;
        }
        
    }
    
    /*@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@*/
    //                VALIDA EMAIL SE JÁ FOI CADASTRADO                            //
    /*@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@*/
    
    public boolean isLoginCadastrado(String login){
        DetachedCriteria criteria = DetachedCriteria.forClass(Usuario.class);
        criteria.add(Restrictions.ilike("login", login));
        try{
            return Dao().getEntitiesByDetachetCriteria(criteria).size()>0;
        }catch(Exception ex){
            return false;
        }
        
    }

}
