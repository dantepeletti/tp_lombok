package programacion3.entities;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
@ToString(of = {"nombre", "precio", "stock"})
@EqualsAndHashCode(of = "nombre", callSuper = false)
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder

@Entity
@Table(name = "productos")

public class Producto extends Base {

    private String nombre;

    private Double precio;

    private String descripcion;

    private int stock;

    private String imagen;

    private Boolean disponible;

    @ManyToOne
    @JoinColumn(name = "categoria_id")
    private Categoria categoria;

}