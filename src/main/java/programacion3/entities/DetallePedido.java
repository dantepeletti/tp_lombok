package programacion3.entities;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
@ToString(exclude = {"pedido"})

@Entity
@Table(name = "detalle_pedido")

public class DetallePedido {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private int cantidad;

    private Double subtotal;

    @ManyToOne
    @JoinColumn(name = "pedido_id")
    private Pedido pedido;

    @ManyToOne
    @JoinColumn(name = "producto_id")
    private Producto producto;

    @Override
    public String toString() {
        return "DetallePedido{" +
                "cantidad=" + cantidad +
                ", subtotal=" + subtotal +
                ", producto=" + producto.getNombre() +
                '}';
    }

}
