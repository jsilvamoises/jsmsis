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
import model.Plano;
import util.FacesUtil;
import util.JpaUtil;

/**
 *
 * @author MOISES
 */
public class PlanoRepository implements Serializable {

    public boolean save(Plano objeto) {
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
    
    public Plano findById(Long id){
        EntityManager manager = JpaUtil.getEntityManager();
        try {
            return manager.find(Plano.class, id);
        } catch (Exception e) {
            return null;
        }finally{
            manager.close();
        }
    }
    
    public boolean delete(Plano obj){
        boolean result= false;
        EntityManager manager = JpaUtil.getEntityManager();
        try {
            Plano u = manager.find(Plano.class, obj.getId());
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
    
    
    public List<Plano> getPlanos(){
        EntityManager manager = JpaUtil.getEntityManager();
        try {
            Query q = manager.createQuery("FROM Plano U ORDER BY U.id desc", Plano.class);
            
            return q.setMaxResults(1000).getResultList();
        } catch (Exception e) {
            return null;
        }finally{
            manager.close();
        }
    }
}
