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
import model.Venda;
import util.FacesUtil;
import util.JpaUtil;

/**
 *
 * @author MOISES
 */
public class VendaRepository implements Serializable {

    public boolean save(Venda objeto) {
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
    
    public Venda findById(Long id){
        EntityManager manager = JpaUtil.getEntityManager();
        try {
            return manager.find(Venda.class, id);
        } catch (Exception e) {
            return null;
        }finally{
            manager.close();
        }
    }
    
    public boolean delete(Venda obj){
        boolean result= false;
        EntityManager manager = JpaUtil.getEntityManager();
        try {
            Venda u = manager.find(Venda.class, obj.getId());
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
    
    
    public List<Venda> getVendas(){
        EntityManager manager = JpaUtil.getEntityManager();
        try {
            Query q = manager.createQuery("FROM Venda U ORDER BY U.id desc", Venda.class);
            
            return q.setMaxResults(1000).getResultList();
        } catch (Exception e) {
            return null;
        }finally{
            manager.close();
        }
    }
}
