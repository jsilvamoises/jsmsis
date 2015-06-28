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
import model.Usuario;
import org.hibernate.Session;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author MOISES
 */
public class UsuarioRepository implements Serializable, interfaces.InterfaceDao {

    private InterfaceDao<Usuario> Dao() {
        InterfaceDao<Usuario> dao = new Dao<>(Usuario.class);
        return dao;
    }

    @Override
    public boolean save(Object entity) {
        return Dao().save((Usuario) entity);
    }

    @Override
    public boolean saveOrUpdate(Object entity) {
        return Dao().saveOrUpdate((Usuario) entity);
    }

    @Override
    public boolean update(Object entity) {
        return Dao().update((Usuario) entity);
    }

    @Override
    public boolean remove(Object entity) {
        return Dao().remove((Usuario) entity);
    }

    @Override
    public boolean merge(Object entity) {
        return Dao().merge((Usuario) entity);
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

    public boolean validarSenha(Usuario usuario) {
        DetachedCriteria criteria = DetachedCriteria.forClass(Usuario.class);

        Criterion loginSenha = Restrictions.and(
                Restrictions.ilike("login", usuario.getLogin()),
                Restrictions.like("senha", usuario.getSenha()));
        
        Criterion emailSenha = Restrictions.and(
                Restrictions.ilike("email", usuario.getLogin()),
                Restrictions.like("senha", usuario.getSenha()));
        
        criteria.add(Restrictions.or(loginSenha, emailSenha));
        
        // SELECT * FROM USUARIO AS U WHERE (U.LOGIN LIKE LOWER('MOISES') AND U.SENHA LIKE '123456')OR(U.EMAIL LIKE LOWER('MOISES') AND U.SENHA LIKE '123456')
       
        return Dao().getEntityByDetachedCriteria(criteria) != null;
    }

}
