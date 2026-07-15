package com.example.crud.repository;

import com.example.crud.model.Estudiante;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface EstudianteRepository extends JpaRepository<Estudiante, Long> {
    
    
    List<Estudiante> findByNombreCompletoContainingIgnoreCaseOrCarreraContainingIgnoreCase(String nombre, String carrera);
}