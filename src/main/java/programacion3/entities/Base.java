package programacion3.entities;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

import java.time.LocalDateTime;
import java.util.Objects;

@Getter
@SuperBuilder
@Setter
@AllArgsConstructor
@EqualsAndHashCode
@NoArgsConstructor
@ToString

public class Base {

    protected Long id;
    protected boolean eliminado;
    protected LocalDateTime createdAt;
}