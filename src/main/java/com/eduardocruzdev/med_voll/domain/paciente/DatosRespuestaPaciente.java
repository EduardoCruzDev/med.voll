package com.eduardocruzdev.med_voll.domain.paciente;

import com.eduardocruzdev.med_voll.domain.direccion.DatosDireccion;

public record DatosRespuestaPaciente(Long id,


                                     String nombre ,


                                     String email ,


                                     String telefono ,



                                     String documento,




                                     DatosDireccion direccion) {
}
