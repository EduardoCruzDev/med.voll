package com.eduardocruzdev.med_voll.controller;


import com.eduardocruzdev.med_voll.domain.consulta.DatosCancelamientoConsulta;
import com.eduardocruzdev.med_voll.domain.consulta.DatosReservaConsulta;
import com.eduardocruzdev.med_voll.domain.consulta.ReservaDeConsultas;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("consultas")
public class ConsultaController {


    @Autowired
    private ReservaDeConsultas reserva;


    @PostMapping
    @Transactional
    public ResponseEntity reservar(@RequestBody @Valid DatosReservaConsulta datos)
    {

        var detalleConsulta = reserva.reservar(datos);

        return ResponseEntity.ok(detalleConsulta);

    }

    @DeleteMapping
    @Transactional
    public ResponseEntity cancelar(@RequestBody @Valid DatosCancelamientoConsulta datos){
        reserva.cancelar(datos);
        return ResponseEntity.noContent().build();

    }


}
