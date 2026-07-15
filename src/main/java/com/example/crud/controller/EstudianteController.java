package com.example.crud.controller;

import com.example.crud.model.Estudiante;
import com.example.crud.repository.EstudianteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/estudiantes")
@CrossOrigin(origins = "http://localhost:4200") // Conexión con Angular
public class EstudianteController {

    @Autowired
    private EstudianteRepository estudianteRepository;

    // 1. LEER TODOS 
    @GetMapping
    public List<Estudiante> listarTodos() {
        return estudianteRepository.findAll();
    }

    // 2. LEER POR MATRÍCULA 
    @GetMapping("/{matricula}")
    public ResponseEntity<Estudiante> obtenerPorMatricula(@PathVariable Long matricula) {
        return estudianteRepository.findById(matricula)
                .map(estudiante -> ResponseEntity.ok().body(estudiante))
                .orElse(ResponseEntity.notFound().build());
    }

    // 3. CREAR NUEVO 
    @PostMapping
    public Estudiante guardarEstudiante(@RequestBody Estudiante estudiante) {
        return estudianteRepository.save(estudiante);
    }

    // 4. ACTUALIZAR 
    @PutMapping("/{matricula}")
    public ResponseEntity<Estudiante> actualizarEstudiante(@PathVariable Long matricula, @RequestBody Estudiante datosActualizados) {
        return estudianteRepository.findById(matricula)
                .map(estudiante -> {
                    estudiante.setNombreCompleto(datosActualizados.getNombreCompleto());
                    estudiante.setCarrera(datosActualizados.getCarrera());
                    Estudiante guardado = estudianteRepository.save(estudiante);
                    return ResponseEntity.ok().body(guardado);
                }).orElse(ResponseEntity.notFound().build());
    }

    // 5. ELIMINAR 
    @DeleteMapping("/{matricula}")
    public ResponseEntity<Void> eliminarEstudiante(@PathVariable Long matricula) {
        return estudianteRepository.findById(matricula)
                .map(estudiante -> {
                    estudianteRepository.delete(estudiante);
                    return ResponseEntity.ok().<Void>build();
                }).orElse(ResponseEntity.notFound().build());
    }
}