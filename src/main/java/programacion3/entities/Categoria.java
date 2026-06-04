package programacion3.entities;

import lombok.*;
import lombok.experimental.SuperBuilder;

import java.util.Set;

@Getter
@Setter
@ToString(of = {"nombre","descripcion"})
@EqualsAndHashCode(of = "nombre",callSuper = false)
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder

public class Categoria extends Base {
    protected String nombre;
    protected String descripcion;
    protected Set<Producto> productos;
}