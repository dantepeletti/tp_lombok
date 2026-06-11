package programacion3.entities;

import jakarta.persistence.*;
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
@ToString(exclude = {"usuario", "detalles"})
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder

@Entity
@Table(name = "pedidos")

public class Pedido extends Base implements Calculable {

    private LocalDate fecha;

    @Enumerated(EnumType.STRING)
    private Estado estado;

    private Double total;

    @Enumerated(EnumType.STRING)
    private FormaPago formaPago;

    @ManyToOne
    @JoinColumn(name = "usuario_id")
    private Usuario usuario;

    @OneToMany(mappedBy = "pedido",
            cascade = CascadeType.ALL,
            orphanRemoval = true)
    @Builder.Default
    private Set<DetallePedido> detalles = new HashSet<>();

    public void addDetallePedido(DetallePedido detallePedido) {
        detalles.add(detallePedido);
        detallePedido.setPedido(this);
        calcularTotal();
    }

    public void removeDetallePedido(DetallePedido detallePedido) {
        detalles.remove(detallePedido);
        detallePedido.setPedido(null);
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
            removeDetallePedido(detalle);
        }
    }

    @Override
    public void calcularTotal() {

        total = detalles.stream()
                .mapToDouble(DetallePedido::getSubtotal)
                .sum();
    }

}
