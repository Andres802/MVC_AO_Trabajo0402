/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import java.io.Serializable;

/**
 *
 * @author ochoa
 */
public class Grupo implements Serializable{
    
    private int numeroGrupo;
    private int aula;
    private int numeroAlumnos;
    private String Ciclo;
    private Asignatura asignatura;
    private Profesor profesor;

    public Grupo(int numeroGrupo, int aula, int numeroAlumnos, String nivelCiclo, Asignatura asignatura, Profesor profesor) {
        this.numeroGrupo = numeroGrupo;
        this.aula = aula;
        this.numeroAlumnos = numeroAlumnos;
        this.Ciclo = nivelCiclo;
        this.asignatura = asignatura;
        this.profesor = profesor;
    }

    public int getNumeroGrupo() {
        return numeroGrupo;
    }

    public void setNumeroGrupo(int numeroGrupo) {
        this.numeroGrupo = numeroGrupo;
    }

    public int getAula() {
        return aula;
    }

    public void setAula(int aula) {
        this.aula = aula;
    }

    public int getNumeroAlumnos() {
        return numeroAlumnos;
    }

    public void setNumeroAlumnos(int numeroAlumnos) {
        this.numeroAlumnos = numeroAlumnos;
    }

    public String getNivelCiclo() {
        return Ciclo;
    }

    public void setNivelCiclo(String nivelCiclo) {
        this.Ciclo = nivelCiclo;
    }

    public Asignatura getAsignatura() {
        return asignatura;
    }

    public void setAsignatura(Asignatura asignatura) {
        this.asignatura = asignatura;
    }

    public Profesor getProfesor() {
        return profesor;
    }

    public void setProfesor(Profesor profesor) {
        this.profesor = profesor;
    }

    @Override
    public String toString() {
        return "Grupo{" + "numero de Grupo=" + numeroGrupo + ", aula=" + aula + ", numeros de Alumnos=" + numeroAlumnos + ", nivel del Ciclo=" + Ciclo + ", asignatura=" + asignatura + ", profesor=" + profesor + '}';
    }
    
    
}
