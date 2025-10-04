package dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.Query;
import model.Subject;

import java.util.List;

public class SubjectDaoImpl implements SubjectDAO {
    EntityManagerFactory fabric;
    EntityManager em;

    public SubjectDaoImpl() {
        fabric = Persistence.createEntityManagerFactory("Examen");
        em = fabric.createEntityManager();
    }

   
    @Override
    public void create(Subject sub) {
        try {
            em.getTransaction().begin();
            em.persist(sub);
            em.getTransaction().commit();
        } catch (Exception e) {
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
            e.printStackTrace(); 
        }
    }


    @Override
    public void update(Subject sub) {
        try {
            em.getTransaction().begin();
            em.merge(sub);
            em.getTransaction().commit();
        } catch (Exception e) {
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
            e.printStackTrace(); // Opcional: para depurar errores más fácilmente
        }
    }


    @Override
    public void delete(Integer id) {
        try {
            em.getTransaction().begin();
            Subject sub = em.find(Subject.class, id);
            if (sub != null) {
                em.remove(sub);
            }
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
        }
    }

    @Override
    public Subject find(Integer id) {
        try {
            return em.find(Subject.class, id);
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public List<Subject> findAll() {
        List<Subject> lista;
        try {
            Query query = em.createNamedQuery("Subject.findAll");
            lista = query.getResultList();
        } catch (Exception e) {
            lista = null;
        }
        return lista;
    }

    public void close() {
        if (em != null && em.isOpen()) em.close();
        if (fabric != null && fabric.isOpen()) fabric.close();
    }
    public List<Subject> findByName(String name) {
        List<Subject> lista;
        try {
            Query query = em.createQuery("SELECT s FROM Subject s WHERE s.subject LIKE :name");
            query.setParameter("name", "%" + name + "%"); // búsqueda parcial
            lista = query.getResultList();
        } catch (Exception e) {
            lista = null;
        }
        return lista;
    }

}
