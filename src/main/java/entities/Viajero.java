package entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;

@Entity
@Table(name = "viajeros")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Viajero {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable = false)
    private String dni;

    @Column(nullable = false)
    private String nombre;

    private Integer edad;

    private String municipio;

    @Column(name = "tipo_abono")
    @Enumerated(EnumType.STRING)
    private TipoAbono tipoAbono;

    @Column(name = "saldo_puntos")
    private Integer saldoPuntos;

    @OneToMany(mappedBy = "viajero")
    @ToString.Exclude
    private List<Viaje> viajes;
}
