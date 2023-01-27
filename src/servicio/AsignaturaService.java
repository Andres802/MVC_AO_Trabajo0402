/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package servicio;

import java.util.List;
import modelo.*;

/**
 *
 * @author ochoa
 */
public interface AsignaturaService {
    
    public void crear(Asignatura asignatura);
    public  Asignatura codigoAsignautra(int codigo);
    public Asignatura buscarNombre(String nombre);
    public void modificar(int condigo, Asignatura asignatura);
    public void eliminar(int codigo);
    public abstract List<Asignatura> listar();
    public boolean codigoEliminar(int codigo);
     public boolean codigoExiste(int codigo);
     public Asignatura buscarPorNombre(String nombre);
     public void almacenarEscritura(Asignatura asignatura, String ruta);
    public List<Asignatura>recuperarArchivo(String ruta);
}
