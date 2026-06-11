package programacion3.entities;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;
import programacion3.enums.Rol;

import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@ToString(of = {"nombre", "apellido", "mail"})
@EqualsAndHashCode(of = "mail", callSuper = false)
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder

@Entity
@Table(name = "usuarios")

public class Usuario extends Base {

    private String nombre;

    private String apellido;

    @Column(unique = true)
    private String mail;

    private String celular;

    private String password;

    @Enumerated(EnumType.STRING)
    private Rol rol;

    @OneToMany(mappedBy = "usuario", cascade = CascadeType.ALL, orphanRemoval = true)
    @Builder.Default
    private Set<Pedido> pedidos = new HashSet<>();

    // Helper
    public void addPedido(Pedido pedido) {
        pedidos.add(pedido);
        pedido.setUsuario(this);
    }

    public void removePedido(Pedido pedido) {
        pedidos.remove(pedido);
        pedido.setUsuario(null);
    }
}