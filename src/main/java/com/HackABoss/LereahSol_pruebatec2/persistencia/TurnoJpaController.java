
package com.HackABoss.LereahSol_pruebatec2.persistencia;

import java.io.Serializable;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import com.HackABoss.LereahSol_pruebatec2.logica.Ciudadano;
import com.HackABoss.LereahSol_pruebatec2.logica.Turno;
import com.HackABoss.LereahSol_pruebatec2.persistencia.exceptions.NonexistentEntityException;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;


public class TurnoJpaController implements Serializable {

    public TurnoJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
       public TurnoJpaController() {
        emf = Persistence.createEntityManagerFactory("GestionTurnosPU");
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Turno turno) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Ciudadano unCiudadano = turno.getUnCiudadano();
            if (unCiudadano != null) {
                unCiudadano = em.getReference(unCiudadano.getClass(), unCiudadano.getIdCiudadano());
                turno.setUnCiudadano(unCiudadano);
            }
            em.persist(turno);
            if (unCiudadano != null) {
                unCiudadano.getTurnos().add(turno);
                unCiudadano = em.merge(unCiudadano);
            }
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Turno turno) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Turno persistentTurno = em.find(Turno.class, turno.getIdTurno());
            Ciudadano unCiudadanoOld = persistentTurno.getUnCiudadano();
            Ciudadano unCiudadanoNew = turno.getUnCiudadano();
            if (unCiudadanoNew != null) {
                unCiudadanoNew = em.getReference(unCiudadanoNew.getClass(), unCiudadanoNew.getIdCiudadano());
                turno.setUnCiudadano(unCiudadanoNew);
            }
            turno = em.merge(turno);
            if (unCiudadanoOld != null && !unCiudadanoOld.equals(unCiudadanoNew)) {
                unCiudadanoOld.getTurnos().remove(turno);
                unCiudadanoOld = em.merge(unCiudadanoOld);
            }
            if (unCiudadanoNew != null && !unCiudadanoNew.equals(unCiudadanoOld)) {
                unCiudadanoNew.getTurnos().add(turno);
                unCiudadanoNew = em.merge(unCiudadanoNew);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Long id = turno.getIdTurno();
                if (findTurno(id) == null) {
                    throw new NonexistentEntityException("The turno with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(Long id) throws NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Turno turno;
            try {
                turno = em.getReference(Turno.class, id);
                turno.getIdTurno();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The turno with id " + id + " no longer exists.", enfe);
            }
            Ciudadano unCiudadano = turno.getUnCiudadano();
            if (unCiudadano != null) {
                unCiudadano.getTurnos().remove(turno);
                unCiudadano = em.merge(unCiudadano);
            }
            em.remove(turno);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Turno> findTurnoEntities() {
        return findTurnoEntities(true, -1, -1);
    }

    public List<Turno> findTurnoEntities(int maxResults, int firstResult) {
        return findTurnoEntities(false, maxResults, firstResult);
    }

    private List<Turno> findTurnoEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Turno.class));
            Query q = em.createQuery(cq);
            if (!all) {
                q.setMaxResults(maxResults);
                q.setFirstResult(firstResult);
            }
            return q.getResultList();
        } finally {
            em.close();
        }
    }

    public Turno findTurno(Long id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Turno.class, id);
        } finally {
            em.close();
        }
    }

    public int getTurnoCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Turno> rt = cq.from(Turno.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
