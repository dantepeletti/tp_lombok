package programacion3.entities;

import lombok.*;

@Getter
@Setter
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode (of = "producto")

public class DetallePedido {

    private int cantidad;
    private Double subtotal;
    private Producto producto;

    @Override
    public String toString(){
        return "DetallePedido{" +
                "cantidad=" + cantidad +
                ", subtotal=" + subtotal +
                ", producto=" + producto.getNombre() +
                '}';
    }
}