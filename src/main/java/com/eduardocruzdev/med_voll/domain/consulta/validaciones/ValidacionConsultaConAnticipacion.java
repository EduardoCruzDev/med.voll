package com.eduardocruzdev.med_voll.domain.consulta.validaciones;

import com.eduardocruzdev.med_voll.domain.ValidacionException;
import com.eduardocruzdev.med_voll.domain.consulta.DatosReservaConsulta;
import org.springframework.stereotype.Component;

import java.time.Duration;
import java.time.LocalDateTime;

@Component
public class ValidacionConsultaConAnticipacion implements ValidacionDeConsultas{

    public void validar(DatosReservaConsulta datos) {

        var fechaConsulta = datos.fecha();
        var ahora = LocalDateTime.now();
        var diferenciaEnMinutos = Duration.between(fechaConsulta, ahora).toMinutes();

        if(diferenciaEnMinutos < 30) {
            throw new ValidacionException("Horario selecionado menor que 30 minutos de anticipacion");
        }

    }
}
