package com.eduardocruzdev.med_voll.domain.consulta;

import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotNull;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDateTime;

public interface ConsultaRepository extends JpaRepository<Consulta, Long> {
    boolean existsByPacienteIdAndFechaBetween(@NotNull Long idPaciente, LocalDateTime primerHorario, LocalDateTime ultimoHoraro);


    boolean existsByMedicoIdAndFecha(@NotNull @Future Long idMedico, LocalDateTime fecha);
}
