package com.eduardocruzdev.med_voll.domain.consulta;


import com.eduardocruzdev.med_voll.domain.medico.Medico;
import com.eduardocruzdev.med_voll.domain.paciente.Paciente;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;


import java.time.LocalDateTime;


@Entity(name="consulta")
@Table(name="consultas")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Consulta {


    private MotivoCancelamiento motivoCancelamiento;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="medico_id")
    private Medico medico;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="paciente_id")
    private Paciente paciente;

    private LocalDateTime fecha;


    @Column(name = "motivo_cancelamiento")
    @Enumerated(EnumType.STRING)


    public void cancelar(MotivoCancelamiento motivo) {
        this.motivoCancelamiento = motivo;
    }


}
