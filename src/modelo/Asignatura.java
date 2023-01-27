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
public class Asignatura implements Serializable{
    
    private int codigo;
    public String nombreMateria;
    private String horasClases;
    private String planEstudio;
    private String carreraAignatura;

    public Asignatura(int codigo,String nombreMateria, String horasClases, String planEstudio, String carreraAignatura) {
        this.nombreMateria = nombreMateria;
        this.horasClases = horasClases;
        this.planEstudio = planEstudio;
        this.carreraAignatura = carreraAignatura;
        this.codigo = codigo;
    }

    public String getNombreMateria() {
        return nombreMateria;
    }

    public void setNombreMateria(String nombreMateria) {
        this.nombreMateria = nombreMateria;
    }

    public String getHorasClases() {
        return horasClases;
    }

    public void setHorasClases(String horasClases) {
        this.horasClases = horasClases;
    }

    public String getPlanEstudio() {
        return planEstudio;
    }

    public void setPlanEstudio(String planEstudio) {
        this.planEstudio = planEstudio;
    }

    public String getCarreraAignatura() {
        return carreraAignatura;
    }

    public void setCarreraAignatura(String carreraAignatura) {
        this.carreraAignatura = carreraAignatura;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }
    

    @Override
    public String toString() {
        return "Asignatura{" + "codigo="+ codigo + ", Nombre de la Materia=" + nombreMateria + ", Horas de Clases=" + horasClases + ", Plan de Estudio=" + planEstudio + ", Carrera de Asignatura=" + carreraAignatura + '}';
    }
    
    
    
}
