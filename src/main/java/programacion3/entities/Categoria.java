package programacion3.entities;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@ToString(of = {"nombre", "descripcion"})
@EqualsAndHashCode(of = "nombre", callSuper = false)
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder

@Entity
@Table(name = "categorias")

public class Categoria extends Base {

    protected String nombre;

    protected String descripcion;

    @OneToMany(mappedBy = "categoria",
            cascade = CascadeType.ALL,
            orphanRemoval = true)
    @Builder.Default
    protected Set<Producto> productos = new HashSet<>();

    // Helper
    public void addProducto(Producto producto) {
        productos.add(producto);
        producto.setCategoria(this);
    }

    public void removeProducto(Producto producto) {
        productos.remove(producto);
        producto.setCategoria(null);
    }
}