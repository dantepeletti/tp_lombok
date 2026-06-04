package programacion3.entities;

import lombok.*;
import lombok.experimental.SuperBuilder;
import programacion3.enums.Estado;
import programacion3.enums.FormaPago;
import programacion3.interfaces.Calculable;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@ToString
@EqualsAndHashCode(of = "id", callSuper = false)
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder

public class Pedido extends Base implements Calculable {

    private LocalDate fecha;
    private Estado estado;
    private Double total;
    private FormaPago formaPago;

    @Builder.Default
    private Set<DetallePedido> detalles = new HashSet<>();

    public void addDetallePedido(DetallePedido detallePedido) {
        detalles.add(detallePedido);
        calcularTotal();
    }

    public DetallePedido findDetallePedidoByProducto(Producto producto) {

        for (DetallePedido detalle : detalles) {

            if (detalle.getProducto().equals(producto)) {
                return detalle;
            }
        }

        return null;
    }

    public void deleteDetallePedidoByProducto(Producto producto) {

        DetallePedido detalle = findDetallePedidoByProducto(producto);

        if (detalle != null) {
            detalles.remove(detalle);
        }

        calcularTotal();
    }

    @Override
    public void calcularTotal() {

        total = 0.0;

        for (DetallePedido detalle : detalles) {
            total += detalle.getSubtotal();
        }
    }
}