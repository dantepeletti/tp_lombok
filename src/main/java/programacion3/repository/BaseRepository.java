package programacion3.repository;

import jakarta.persistence.EntityManagerFactory;
import programacion3.entities.Base;
import programacion3.util.JPAUtil;

public abstract class BaseRepository<T extends Base> {
    protected EntityManagerFactory emf;
    protected Class <T> clazz;

    public BaseRepository(Class<T> clazz){
        this.clazz = clazz;
        this.emf = JPAUtil.getEntityManagerFactory();
    }
}