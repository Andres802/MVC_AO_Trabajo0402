/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package servicio;

import java.time.LocalDate;
import java.util.List;
import modelo.Profesor;

/**
 *
 * @author ochoa
 */
public interface ProfesorService {
    
    public void crear(Profesor profesor);
    public  List<Profesor> listar();
    public  Profesor codigoProfesor(int codigo);
    public Profesor bucarNombre(String nombre);
    public boolean codigoExiste(int codigo);
    public boolean fechaExiste(LocalDate fecha);
    public void eliminar (int codigo);
    public void codigoEliminar(int codigo);
    public Profesor buscarPorNombre(String nombre);
    
     public void almacenarEscritura(Profesor docente, String ruta);
     /*
    public List<Profesor>recuperarArchivo(String ruta);
*/
}
