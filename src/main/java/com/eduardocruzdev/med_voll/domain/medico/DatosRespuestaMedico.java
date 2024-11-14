package com.eduardocruzdev.med_voll.domain.medico;

import com.eduardocruzdev.med_voll.domain.direccion.DatosDireccion;

public record DatosRespuestaMedico(

        Long id,


        String nombre ,


        String email ,


        String telefono ,



        String documento,




        DatosDireccion direccion) {
}
