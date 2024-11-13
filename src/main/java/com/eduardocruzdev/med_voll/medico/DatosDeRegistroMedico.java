package com.eduardocruzdev.med_voll.medico;

import com.eduardocruzdev.med_voll.direccion.DatosDireccion;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

public record DatosDeRegistroMedico(

        @NotBlank
        String nombre ,

        @NotBlank
        @Email
        String email ,

        @NotBlank
        String telefono ,

        @NotBlank
        @Pattern(regexp = "\\d{4,8}")
        String documento,

        @NotNull
        Especialidad especialidad,

        @NotNull
        DatosDireccion direccion) {
}
