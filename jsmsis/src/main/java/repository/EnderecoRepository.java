/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package repository;

import java.io.Serializable;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import model.Endereco;
import util.FacesUtil;
import util.JpaUtil;

/**
 *
 * @author MOISES
 */
public class EnderecoRepository implements Serializable {

    public boolean save(Endereco objeto) {
        EntityManager manager = JpaUtil.getEntityManager();
        try {
            
            manager.getTransaction().begin();
            if(objeto.getId()!=null){
                manager.persist(objeto);
                FacesUtil.addInfoMessage("Salvo com sucesso!!!");
            }else{
                manager.refresh(objeto);
                FacesUtil.addInfoMessage("Atualizado com sucesso!!!");
            }
            
            manager.getTransaction().commit();
            
            return true;
        } catch (Exception e) {
            FacesUtil.addInfoMessage("Erro"+e);
            return false;
        }finally{
            manager.close();
        }

    }
    
    public Endereco findById(Long id){
        EntityManager manager = JpaUtil.getEntityManager();
        try {
            return manager.find(Endereco.class, id);
        } catch (Exception e) {
            return null;
        }finally{
            manager.close();
        }
    }
    
    public boolean delete(Endereco obj){
        boolean result= false;
        EntityManager manager = JpaUtil.getEntityManager();
        try {
            Endereco u = manager.find(Endereco.class, obj.getId());
            if(u!=null){
                manager.remove(u);
                result = true;
                FacesUtil.addInfoMessage("Excluído com sucesso!!!");                
            }else{
                FacesUtil.addInfoMessage("Objeto não encontrado para exclusão!!!"); 
            }
            
        } catch (Exception e) {
            
        }finally{
            manager.close();
        }
        return result;
    }
    
    
    public List<Endereco> getEnderecos(){
        EntityManager manager = JpaUtil.getEntityManager();
        try {
            Query q = manager.createQuery("FROM Endereco U ORDER BY U.id desc", Endereco.class);
            
            return q.setMaxResults(1000).getResultList();
        } catch (Exception e) {
            return null;
        }finally{
            manager.close();
        }
    }
}
