package com.eduardocruzdev.med_voll.domain.consulta.validaciones;

import com.eduardocruzdev.med_voll.domain.ValidacionException;
import com.eduardocruzdev.med_voll.domain.consulta.DatosReservaConsulta;
import com.eduardocruzdev.med_voll.domain.paciente.PacienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ValidacionPacienteActivo implements ValidacionDeConsultas{

    @Autowired
    private PacienteRepository pacienteRepository;

    public void validar(DatosReservaConsulta datos) {
        var pacienteEstaActivo = pacienteRepository.findActivoById(datos.idPaciente());

        if(!pacienteEstaActivo){
        throw new ValidacionException("Paciente no esta activo");
        }

    }

}
