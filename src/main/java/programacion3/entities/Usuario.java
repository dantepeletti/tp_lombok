package programacion3.entities;

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

public class Usuario extends Base {

    private String nombre;
    private String apellido;
    private String mail;
    private String celular;
    private String password;
    private Rol rol;

    @Builder.Default
    private Set<Pedido> pedidos = new HashSet<>();
}