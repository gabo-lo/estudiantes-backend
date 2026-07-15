package com.example.crud.model;

import jakarta.persistence.*;

@Entity
@Table(name = "estudiantes")
public class Estudiante {

    @Id
    private Long matricula; // Llave primaria

    @Column(name = "nombre_completo", nullable = false, length = 150)
    private String nombreCompleto;

    @Column(nullable = false, length = 100)
    private String carrera;

   
    public Estudiante() {}

    public Estudiante(Long matricula, String nombreCompleto, String carrera) {
        this.matricula = matricula;
        this.nombreCompleto = nombreCompleto;
        this.carrera = carrera;
    }

    
    public Long getMatricula() { return matricula; }
    public void setMatricula(Long matricula) { 
        this.matricula = matricula; }

    public String getNombreCompleto() { return nombreCompleto; }
    public void setNombreCompleto(String nombreCompleto) { 
        this.nombreCompleto = nombreCompleto; }

    public String getCarrera() { return carrera; }
    public void setCarrera(String carrera) { 
        this.carrera = carrera; }
}