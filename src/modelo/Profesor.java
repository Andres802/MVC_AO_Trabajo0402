/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import java.io.Serializable;
import java.time.LocalDate;

/**
 *
 * @author ochoa
 */
public class Profesor implements Serializable{
    
    private int codigo;
    public String nombre;
    private LocalDate fechaNacimiento;
    private String profecion;
    private String correo;
    private String genero;

    public Profesor(int codigo, String nombre, LocalDate fechaNacimiento, String profecion, String correo, String genero) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.fechaNacimiento = fechaNacimiento;
        this.profecion = profecion;
        this.correo = correo;
        this.genero = genero;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public LocalDate getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(LocalDate fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getProfecion() {
        return profecion;
    }

    public void setProfecion(String profecion) {
        this.profecion = profecion;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }
    

    @Override
    public String toString() {
        return "Profesor{" + "codigo=" + codigo + ", nombre=" + nombre + ", fecha de Nacimiento=" + fechaNacimiento + ", profecion=" + profecion + ", correo=" + correo + ", Genero="+ genero + '}';
    }
    
    
    
}
