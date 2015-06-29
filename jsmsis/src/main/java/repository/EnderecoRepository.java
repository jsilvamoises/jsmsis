/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package repository;

import interfaces.InterfaceDao;
import java.io.Serializable;
import java.util.List;
import model.Endereco;
import org.hibernate.Session;
import org.hibernate.criterion.DetachedCriteria;
import dao.Dao;
import model.PessoaFisica;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author MOISES
 */
public class EnderecoRepository implements Serializable, interfaces.InterfaceDao {
    
     private InterfaceDao<Endereco> Dao() {
        InterfaceDao<Endereco> dao = new Dao<>(Endereco.class);
        return dao;
    }
     
    public List<Endereco> enderecoPorUsuario(PessoaFisica  pessoa){
        DetachedCriteria criteria = DetachedCriteria.forClass(Endereco.class);
        criteria.add(Restrictions.eq("pessoa", pessoa));
        return Dao().getEntitiesByDetachetCriteria(criteria);
    }

    @Override
    public boolean save(Object entity) {
        return Dao().save((Endereco)entity);
    }

    @Override
    public boolean saveOrUpdate(Object entity) {
        return Dao().saveOrUpdate((Endereco)entity);
    }

    @Override
    public boolean update(Object entity) {
        return Dao().update((Endereco)entity);
    }

    @Override
    public boolean remove(Object entity) {
        
        return Dao().remove((Endereco)entity);
    }

    @Override
    public boolean merge(Object entity) {
        return Dao().merge((Endereco)entity);
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
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void rollback(Session session) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void begin(Session session) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Session getSession() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List getTop(int totalRest, String query) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List entitiesTopByDetachedCriteria(int max, DetachedCriteria criteria) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    
}
