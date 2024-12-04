package com.eduardocruzdev.med_voll.domain.consulta.validaciones;

import com.eduardocruzdev.med_voll.domain.ValidacionException;
import com.eduardocruzdev.med_voll.domain.consulta.ConsultaRepository;
import com.eduardocruzdev.med_voll.domain.consulta.DatosReservaConsulta;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ValidacionPacienteSinOtraConsultaEnElMismoDia implements ValidacionDeConsultas{

    @Autowired
    private ConsultaRepository repository;

    public void validar(DatosReservaConsulta datos){
        var primerHorario = datos.fecha().withHour(7);
        var ultimoHoraro = datos.fecha().withHour(18);
        var pacienteTieneOtraConsultaEnElDia = repository.existsByPacienteIdAndFechaBetween(datos.idPaciente(),primerHorario,ultimoHoraro);
        if(pacienteTieneOtraConsultaEnElDia){
            throw new ValidacionException("Paciente solo puede tener una consulta en el dia");
        }
    }

}
