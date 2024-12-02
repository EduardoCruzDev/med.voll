package com.eduardocruzdev.med_voll.domain.paciente;

import com.eduardocruzdev.med_voll.domain.direccion.DatosDireccion;
import jakarta.validation.constraints.NotNull;

public record DatosActualizarPaciente(@NotNull Long id, String nombre, String documento,String telefono, DatosDireccion direccion) {
}
