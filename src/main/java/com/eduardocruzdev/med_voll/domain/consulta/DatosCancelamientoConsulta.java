package com.eduardocruzdev.med_voll.domain.consulta;

import jakarta.validation.constraints.NotNull;

public record DatosCancelamientoConsulta(

        @NotNull
        Long idConsulta,

        @NotNull
        MotivoCancelamiento motivo

) {
}
