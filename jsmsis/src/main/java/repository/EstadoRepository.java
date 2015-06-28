/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package repository;

import dao.Dao;
import interfaces.InterfaceDao;
import java.io.Serializable;
import java.util.List;
import model.Estado;
import org.hibernate.Session;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author MOISES
 */
public class EstadoRepository implements Serializable, interfaces.InterfaceDao {
    
    private InterfaceDao<Estado> Dao() {
        InterfaceDao<Estado> dao = new Dao<>(Estado.class);
        return dao;
    }

    @Override
    public boolean save(Object entity) {
        return Dao().save((Estado)entity);
    }

    @Override
    public boolean saveOrUpdate(Object entity) {
        return Dao().saveOrUpdate((Estado)entity);
    }

    @Override
    public boolean update(Object entity) {
       return Dao().update((Estado)entity);
    }

    @Override
    public boolean remove(Object entity) {
        return Dao().remove((Estado)entity);
    }

    @Override
    public boolean merge(Object entity) {
        return Dao().merge((Estado)entity);
    }

    @Override
    public Object getEntity(Serializable id) {
        return Dao().getEntity(id);
    }

    @Override
    public Object getEntityByDetachedCriteria(DetachedCriteria criteria) {
        return Dao().getEntityByDetachedCriteria(criteria);
    }

    @Override
    public List getEntities() {
        return Dao().getEntities();
    }

    @Override
    public List getEntitiesTop(int top, String campo) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List getEntitiesByDetachetCriteria(DetachedCriteria criteria) {
         return Dao().getEntitiesByDetachetCriteria(criteria);
    }

    @Override
    public List getEntitiesByQuery(String query) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void commit(Session session) {
        session.getTransaction().commit();
    }

    @Override
    public void rollback(Session session) {
        session.getTransaction().rollback();
    }

    @Override
    public void begin(Session session) {
        session.getTransaction().begin();
    }

    @Override
    public Session getSession() {
         return Dao().getSession();
    }

    @Override
    public List getTop(int totalRest, String query) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
    public Estado getEstadoBySigla(String sigla){
         DetachedCriteria detachedCriteria = DetachedCriteria.forClass(Estado.class);
         detachedCriteria.add(Restrictions.ilike("sigla", sigla));
         Estado estado = new Estado();
         estado = Dao().getEntityByDetachedCriteria(detachedCriteria);
         System.out.println("sigla " + sigla);
         return estado;
    }
    
    public Estado getEstadoByNome(String nome){
         DetachedCriteria detachedCriteria = DetachedCriteria.forClass(Estado.class);
         detachedCriteria.add(Restrictions.ilike("nome", nome));
         return Dao().getEntityByDetachedCriteria(detachedCriteria);
    }

//    public boolean save(Estado objeto) {
//        EntityManager manager = JpaUtil.getEntityManager();
//        try {
//            
//            manager.getTransaction().begin();
//            if(objeto.getId()!=null){
//                manager.persist(objeto);
//                FacesUtil.addInfoMessage("Salvo com sucesso!!!");
//            }else{
//                manager.refresh(objeto);
//                FacesUtil.addInfoMessage("Atualizado com sucesso!!!");
//            }
//            
//            manager.getTransaction().commit();
//            
//            return true;
//        } catch (Exception e) {
//            FacesUtil.addInfoMessage("Erro"+e);
//            return false;
//        }finally{
//            manager.close();
//        }
//
//    }
//    
//    public Estado findById(Long id){
//        EntityManager manager = JpaUtil.getEntityManager();
//        try {
//            return manager.find(Estado.class, id);
//        } catch (Exception e) {
//            return null;
//        }finally{
//            manager.close();
//        }
//    }
//    
//    public boolean delete(Estado obj){
//        boolean result= false;
//        EntityManager manager = JpaUtil.getEntityManager();
//        try {
//            Estado u = manager.find(Estado.class, obj.getId());
//            if(u!=null){
//                manager.remove(u);
//                result = true;
//                FacesUtil.addInfoMessage("Excluído com sucesso!!!");                
//            }else{
//                FacesUtil.addInfoMessage("Objeto não encontrado para exclusão!!!"); 
//            }
//            
//        } catch (Exception e) {
//            
//        }finally{
//            manager.close();
//        }
//        return result;
//    }
//    
//    
//    public List<Estado> getEstados(){
//        EntityManager manager = JpaUtil.getEntityManager();
//        try {
//            Query q = manager.createQuery("FROM Estado U ORDER BY U.id desc", Estado.class);
//            
//            return q.setMaxResults(1000).getResultList();
//        } catch (Exception e) {
//            return null;
//        }finally{
//            manager.close();
//        }
//    }
}
