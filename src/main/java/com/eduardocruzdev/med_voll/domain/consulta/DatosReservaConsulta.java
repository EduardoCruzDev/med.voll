package com.eduardocruzdev.med_voll.domain.consulta;

import com.eduardocruzdev.med_voll.domain.medico.Especialidad;
import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;

public record DatosReservaConsulta(

        Long idMedico,

        @NotNull
        Long idPaciente,

        @NotNull
        @Future
        LocalDateTime fecha,

        Especialidad especialidad

) {
}
