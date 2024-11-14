package com.eduardocruzdev.med_voll.domain.medico;

import com.eduardocruzdev.med_voll.domain.direccion.DatosDireccion;
import jakarta.validation.constraints.NotNull;

public record DatosActualizarMedico(@NotNull Long id, String nombre, String documento, DatosDireccion direccion) {
}
