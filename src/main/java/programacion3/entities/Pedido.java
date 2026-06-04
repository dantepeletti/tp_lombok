package programacion3.entities;
import programacion3.interfaces.Calculable;

import programacion3.enums.Estado;
import programacion3.enums.FormaPago;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class Pedido extends Base implements Calculable {

    private LocalDate fecha;
    private Estado estado;
    private Double total;
    private FormaPago formaPago;

    private Set<DetallePedido> detalles;

    public Pedido() {
        this.detalles = new HashSet<>();
    }

    public Pedido(Long id, boolean eliminado, LocalDateTime createdAt,
                  LocalDate fecha, Estado estado,
                  Double total, FormaPago formaPago,
                  Set<DetallePedido> detalles) {

        super(id, eliminado, createdAt);

        this.fecha = fecha;
        this.estado = estado;
        this.total = total;
        this.formaPago = formaPago;
        this.detalles = detalles;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public Estado getEstado() {
        return estado;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

    public FormaPago getFormaPago() {
        return formaPago;
    }

    public void setFormaPago(FormaPago formaPago) {
        this.formaPago = formaPago;
    }

    public Set<DetallePedido> getDetalles() {
        return detalles;
    }

    public void setDetalles(Set<DetallePedido> detalles) {
        this.detalles = detalles;
    }

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

    @Override
    public String toString() {
        return "Pedido{" +
                "fecha=" + fecha +
                ", estado=" + estado +
                ", total=" + total +
                ", formaPago=" + formaPago +
                ", detalles=" + detalles +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Pedido pedido)) return false;
        return Objects.equals(getId(), pedido.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }
}