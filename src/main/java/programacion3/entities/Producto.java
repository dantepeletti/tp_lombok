package programacion3.entities;

import lombok.*;
import lombok.experimental.SuperBuilder;

import java.lang.invoke.CallSite;

@Getter
@Setter
@ToString(of = {"nombre","precio","stock"})
@EqualsAndHashCode(of = "nombre", callSuper = false)
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder

public class Producto extends Base {

    private String nombre;
    private Double precio;
    private String descripcion;
    private int stock;
    private String imagen;
    private Boolean disponible;
    private Categoria categoria;
}