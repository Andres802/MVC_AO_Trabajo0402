/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import java.time.LocalDate;
import java.util.List;
import modelo.Asignatura;
import servicio.AsignaturaServiceImpI;

/**
 *
 * @author ochoa
 */
public class AsignaturaControlador {

    private AsignaturaServiceImpI asignaturaServi;

    public AsignaturaControlador() {
        this.asignaturaServi = new AsignaturaServiceImpI();
    }

    public void crear(String[] data) {
        try{
            
        var codigo = Integer.valueOf(data[0]);
        var nombreMateria = data[1];
        var horasClases = data[2];
        var planEstudio = data[3];
        var carreraAsignatura = data[4];
        var asignatura = new Asignatura(codigo, nombreMateria, horasClases, planEstudio, carreraAsignatura);
        if (this.asignaturaServi.codigoExiste(codigo)) {
            throw new RuntimeException("Codigo Existe");
        } else {

            this.asignaturaServi.crear(asignatura);
        }
        }catch (NumberFormatException e) {
            throw new NumberFormatException("Error al convetir el formato");
        }

    }

    public List<Asignatura> listar() {
        return this.asignaturaServi.listar();
    }

    public void eliminar(String[] data) {
        try {

            var codigo = Integer.valueOf(data[0]);
            if (this.asignaturaServi.codigoEliminar(codigo)) {
                throw new RuntimeException("Codigo no existe");
            } else {

                this.asignaturaServi.eliminar(codigo);
            }
        } catch (NumberFormatException e) {
            throw new NumberFormatException("Error al convetir el formato");
        }

    }

    public void modificar(String[] data) {
        var codigo = Integer.valueOf(data[0]);
        var nombreMateria = data[1];
        var horasClases = data[2];
        var planEstudio = data[3];
        var carreraAsignatura = data[4];
        var asignatura = new Asignatura(codigo, nombreMateria, horasClases, planEstudio, carreraAsignatura);
        this.asignaturaServi.modificar(codigo, asignatura);
    }

}
