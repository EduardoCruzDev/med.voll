package com.eduardocruzdev.med_voll.domain.consulta.validaciones;

import com.eduardocruzdev.med_voll.domain.ValidacionException;
import com.eduardocruzdev.med_voll.domain.consulta.DatosReservaConsulta;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.DayOfWeek;

@Component
public class ValidacionFueraDeHorario implements ValidacionDeConsultas{


    public void validar(DatosReservaConsulta datos) {

        var fechaConsulta = datos.fecha();
        var domingo = fechaConsulta.getDayOfWeek().equals(DayOfWeek.SUNDAY);
        var horarioAntesDeAperturaClinica = fechaConsulta.getHour()<7;
        var horarioDespuesDeAperturaClinica = fechaConsulta.getHour()>18;
        if(domingo  || horarioDespuesDeAperturaClinica || horarioAntesDeAperturaClinica){
            throw new ValidacionException("Fuera de horario de atencion");
        }

    }



}
