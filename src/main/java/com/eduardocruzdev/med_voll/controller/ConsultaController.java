package com.eduardocruzdev.med_voll.controller;


import com.eduardocruzdev.med_voll.domain.consulta.DatosDetalleConsulta;
import com.eduardocruzdev.med_voll.domain.consulta.DatosReservaConsulta;
import com.eduardocruzdev.med_voll.domain.consulta.ReservaDeConsultas;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("consultas")
public class ConsultaController {


    @Autowired
    private ReservaDeConsultas reserva;


    @PostMapping
    @Transactional
    public ResponseEntity reservar(@RequestBody @Valid DatosReservaConsulta datos)
    {
        reserva.reservar(datos);
        return ResponseEntity.ok(new DatosDetalleConsulta(null,null,null,null));

    }


}