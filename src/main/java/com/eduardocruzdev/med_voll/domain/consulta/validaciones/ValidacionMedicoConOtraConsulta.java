package com.eduardocruzdev.med_voll.domain.consulta.validaciones;

import com.eduardocruzdev.med_voll.domain.ValidacionException;
import com.eduardocruzdev.med_voll.domain.consulta.ConsultaRepository;
import com.eduardocruzdev.med_voll.domain.consulta.DatosReservaConsulta;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class ValidacionMedicoConOtraConsulta implements ValidacionDeConsultas{

    @Autowired
    private ConsultaRepository repository;

    public void validar(DatosReservaConsulta datos) {

        var medicoTieneOtraConsultaEnElMismoHorario = repository.existsByMedicoIdAndFecha(datos.idMedico(), datos.fecha());
        if(medicoTieneOtraConsultaEnElMismoHorario) {
            throw new ValidacionException("El medico ya tiene una consulta en el mismo horario");
        }
    }


}
