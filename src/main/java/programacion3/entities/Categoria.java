package programacion3.entities;

import java.time.LocalDateTime;
import java.util.Objects;
import java.util.Set;

public class Categoria extends Base {

    private String nombre;
    private String descripcion;
    private Set<Producto> productos;

    public Categoria() {
    }

    public Categoria(Long id, boolean eliminado, LocalDateTime createdAt,
                     String nombre, String descripcion, Set<Producto> productos) {

        super(id, eliminado, createdAt);
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.productos = productos;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Set<Producto> getProductos() {
        return productos;
    }

    public void setProductos(Set<Producto> productos) {
        this.productos = productos;
    }

    @Override
    public String toString() {
        return "Categoria{" +
                "nombre='" + nombre + '\'' +
                ", descripcion='" + descripcion + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Categoria that)) return false;
        return Objects.equals(nombre, that.nombre);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nombre);
    }
}