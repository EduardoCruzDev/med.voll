package com.eduardocruzdev.med_voll.medico;

import com.eduardocruzdev.med_voll.direccion.DatosDireccion;
import jakarta.validation.constraints.NotNull;

public record DatosActualizarMedico(@NotNull Long id, String nombre, String documento, DatosDireccion direccion) {
}
