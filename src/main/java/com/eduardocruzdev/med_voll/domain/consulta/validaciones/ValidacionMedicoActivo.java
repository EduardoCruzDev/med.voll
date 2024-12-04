package com.eduardocruzdev.med_voll.domain.consulta.validaciones;

import com.eduardocruzdev.med_voll.domain.ValidacionException;
import com.eduardocruzdev.med_voll.domain.consulta.DatosReservaConsulta;
import com.eduardocruzdev.med_voll.domain.medico.Medico;
import com.eduardocruzdev.med_voll.domain.medico.MedicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ValidacionMedicoActivo implements ValidacionDeConsultas{

    @Autowired
    private MedicoRepository medicoRepository;

    public void validar(DatosReservaConsulta datos) {

            var medicoEstaActivo = medicoRepository.findActivoById(datos.idMedico());

            if(!medicoEstaActivo) {
                throw new ValidacionException("Consulta no se puede reservar por que el medico no esta activo");
            }

    }

}
