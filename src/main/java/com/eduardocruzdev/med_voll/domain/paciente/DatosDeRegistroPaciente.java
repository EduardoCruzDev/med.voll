package com.eduardocruzdev.med_voll.domain.paciente;

import com.eduardocruzdev.med_voll.domain.direccion.DatosDireccion;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record DatosDeRegistroPaciente(

        @NotBlank
        String nombre,
        @NotBlank
        @Email
        String email,
        @NotBlank
        String telefono,
        @NotBlank
        String documento,
        @NotNull
        @Valid
        DatosDireccion direccion
)
{
}
