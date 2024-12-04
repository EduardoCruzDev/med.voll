package com.eduardocruzdev.med_voll.domain.consulta;


import com.eduardocruzdev.med_voll.domain.ValidacionException;
import com.eduardocruzdev.med_voll.domain.consulta.validaciones.ValidacionDeConsultas;
import com.eduardocruzdev.med_voll.domain.medico.Medico;
import com.eduardocruzdev.med_voll.domain.medico.MedicoRepository;
import com.eduardocruzdev.med_voll.domain.paciente.PacienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReservaDeConsultas {


    @Autowired
    private MedicoRepository medicoRepository;


    @Autowired
    private PacienteRepository pacienteRepository;


    @Autowired
    private ConsultaRepository consultaRepository;


    @Autowired
    private List<ValidacionDeConsultas> validadores;



    public DatosDetalleConsulta reservar(DatosReservaConsulta datos){

        if(!pacienteRepository.existsById(datos.idPaciente())){
            throw new ValidacionException("No existe un paciente con el id informado");
        }

        if(datos.idMedico() != null  &&  !medicoRepository.existsById(datos.idMedico())){
            throw new ValidacionException("No existe un medico con el id informado");
        }


        validadores.forEach(v->v.validar(datos));



        var medico = elegirMedico(datos);
        if(medico==null){
            throw new ValidacionException("No existe un medico disponible en ese horario");
        }
        var paciente = pacienteRepository.findById(datos.idPaciente()).get();
        var consulta = new Consulta(null, null ,medico, paciente ,datos.fecha());
        consultaRepository.save(consulta);
        return new DatosDetalleConsulta(consulta);

    }

    private Medico elegirMedico(DatosReservaConsulta datos) {
        if(datos.idMedico() != null ){
            return medicoRepository.getReferenceById(datos.idMedico());
        }

        if(datos.especialidad() == null){
            throw new ValidacionException("Es necesario elegir una especialidad cuando no se elige el medico");
        }

        return medicoRepository.elegirMedicoAleatorioDisponibleEnLaFecha(datos.especialidad(),datos.fecha());
    }

    public void cancelar(DatosCancelamientoConsulta datos) {
        if (!consultaRepository.existsById(datos.idConsulta())) {
            throw new ValidacionException("Id de la consulta informado no existe!");
        }
        var consulta = consultaRepository.getReferenceById(datos.idConsulta());
        consulta.cancelar(datos.motivo());
    }

    }



