package com.eduardocruzdev.med_voll.domain.consulta;


import com.eduardocruzdev.med_voll.domain.ValidacionException;
import com.eduardocruzdev.med_voll.domain.medico.Medico;
import com.eduardocruzdev.med_voll.domain.medico.MedicoRepository;
import com.eduardocruzdev.med_voll.domain.paciente.PacienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReservaDeConsultas {


    @Autowired
    private MedicoRepository medicoRepository;


    @Autowired
    private PacienteRepository pacienteRepository;


    @Autowired
    private ConsultaRepository consultaRepository;

    public void reservar(DatosReservaConsulta datos){

        if(!pacienteRepository.existsById(datos.idPaciente())){
            throw new ValidacionException("No existe un paciente con el id informado");
        }

        if(datos.idMedico() != null  &&  !medicoRepository.existsById(datos.idMedico())){
            throw new ValidacionException("No existe un medico con el id informado");
        }

        var medico = elegirMedico(datos);
        var paciente = pacienteRepository.findById(datos.idPaciente()).get();


        var consulta = new Consulta(null, medico , paciente , datos.fecha());
        consultaRepository.save(consulta);

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


}