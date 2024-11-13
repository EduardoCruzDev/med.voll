package com.eduardocruzdev.med_voll.controller;


import com.eduardocruzdev.med_voll.medico.*;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/medicos")
public class MedicoController {

    @Autowired
    private MedicoRepository medicoRepository;

    @PostMapping
        public void registrarMedicos(@RequestBody @Valid DatosDeRegistroMedico datosRegistroMedico){
        medicoRepository.save(new Medico(datosRegistroMedico));
    }


    @GetMapping
    public Page<DatosListadoMedico> listarMedicos(@PageableDefault(size = 2) Pageable paginacion) {
        //return medicoRepository.findAll(paginacion).map(DatosListadoMedico::new);
        return medicoRepository.findByActivoTrue(paginacion).map(DatosListadoMedico::new);
    }

    @PutMapping
    @Transactional
    public void actualizarMedicos(@RequestBody @Valid  DatosActualizarMedico datosActualizarMedico){
        Medico medico = medicoRepository.getReferenceById(datosActualizarMedico.id());
        medico.actualizarDatos(datosActualizarMedico);
    }

    @DeleteMapping("/{id}")
    @Transactional
    public void eliminarMedico(@PathVariable Long id){
        Medico medico = medicoRepository.getReferenceById(id);
        medico.desactivarMedico();
    }

    /* public void eliminarMedico(@PathVariable Long id){
        Medico medico = medicoRepository.getReferenceById(id);
        medicoRepository.delete(medico);*/
}
