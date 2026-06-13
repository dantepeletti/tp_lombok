package programacion3.repository;

import programacion3.entities.Producto;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import java.util.List;

public class ProductoRepository extends BaseRepository <Producto> {

    public ProductoRepository(){
        super(Producto.class);
    }

    public List<Producto> buscarPorCategoria(Long id) {

        EntityManager em = emf.createEntityManager();

        try {

            String jpql = """
                SELECT p
                FROM Producto p
                WHERE p.categoria.id = :id
                AND p.eliminado = false
                """;

            TypedQuery<Producto> query =
                    em.createQuery(jpql, Producto.class);

            query.setParameter("id", id);

            return query.getResultList();

        } finally {

            em.close();
        }
    }
}