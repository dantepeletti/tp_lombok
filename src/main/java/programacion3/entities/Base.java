package programacion3.entities;

import lombok.*;
import lombok.experimental.SuperBuilder;

import java.time.LocalDateTime;

@Getter
@SuperBuilder
@Setter
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
@NoArgsConstructor
@ToString

public class Base {

    protected Long id;
    protected boolean eliminado;
    protected LocalDateTime createdAt;
}