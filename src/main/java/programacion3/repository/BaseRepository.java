package programacion3.repository;

import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.TypedQuery;
import programacion3.entities.Base;
import programacion3.util.JPAUtil;
import java.util.Optional;
import java.util.List;

public abstract class BaseRepository<T extends Base> {
    protected EntityManagerFactory emf;
    protected Class <T> clazz;

    public BaseRepository(Class<T> clazz){
        this.clazz = clazz;
        this.emf = JPAUtil.getEntityManagerFactory();
    }

    public T guardar(T entity){
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();

        try{
            tx.begin();

            T entityGuardada = em.merge(entity);

            tx.commit();

            return entityGuardada;
        }catch (Exception e) {

            if (tx.isActive()) {
                tx.rollback();
            }
            throw e;

        }finally {

            em.close();
        }
    }

    public Optional <T> buscarPorId(Long id) {

        EntityManager em = emf.createEntityManager();

        try {
            T entity = em.find( clazz, id);

            return Optional.ofNullable(entity);

        }finally {
            em.close();

        }
    }

    public List <T> listarActivos() {

        EntityManager em = emf.createEntityManager();

        try {

            String jpql = "SELECT e FROM " + clazz.getSimpleName() + " e WHERE e.eliminado = false";

            TypedQuery<T> query = em.createQuery(jpql, clazz);

            return query.getResultList();

        } finally {

            em.close();
        }
    }

    public boolean eliminarLogico(Long id) {

        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();

        try {

            tx.begin();

            T entity = em.find(clazz, id);

            if (entity == null) {
                return false;
            }

            entity.setEliminado(true);

            em.merge(entity);

            tx.commit();

            return true;

        } catch (Exception e) {

            if (tx.isActive()) {
                tx.rollback();
            }

            throw e;

        } finally {

            em.close();
        }
    }
}