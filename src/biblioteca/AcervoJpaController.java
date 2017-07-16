/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package biblioteca;

import biblioteca.exceptions.NonexistentEntityException;
import biblioteca.exceptions.PreexistingEntityException;
import java.io.Serializable;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import src.Acervo;

/**
 *
 * @author rafael
 */
public class AcervoJpaController implements Serializable {

    public AcervoJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Acervo acervo) throws PreexistingEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(acervo);
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findAcervo(acervo.getId()) != null) {
                throw new PreexistingEntityException("Acervo " + acervo + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Acervo acervo) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            acervo = em.merge(acervo);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = acervo.getId();
                if (findAcervo(id) == null) {
                    throw new NonexistentEntityException("The acervo with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(Integer id) throws NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Acervo acervo;
            try {
                acervo = em.getReference(Acervo.class, id);
                acervo.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The acervo with id " + id + " no longer exists.", enfe);
            }
            em.remove(acervo);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Acervo> findAcervoEntities() {
        return findAcervoEntities(true, -1, -1);
    }

    public List<Acervo> findAcervoEntities(int maxResults, int firstResult) {
        return findAcervoEntities(false, maxResults, firstResult);
    }

    private List<Acervo> findAcervoEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Acervo.class));
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

    public Acervo findAcervo(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Acervo.class, id);
        } finally {
            em.close();
        }
    }

    public int getAcervoCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Acervo> rt = cq.from(Acervo.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
