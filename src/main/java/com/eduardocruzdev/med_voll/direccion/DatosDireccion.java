package com.eduardocruzdev.med_voll.direccion;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;

public record DatosDireccion(

        @NotBlank
        String calle,

        @NotBlank
        String distrito,

        @NotBlank
        String ciudad,

        @NotBlank
        String numero ,

        @NotBlank
        @Valid
        String complemento) {
}