/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package servicio;

import java.util.List;
import modelo.Grupo;

/**
 *
 * @author ochoa
 */
public interface GrupoService {
    
    public abstract void crear(Grupo grupo);
    public void eliminar(int codigo);
    public abstract List<Grupo> listar();
    public boolean codigoEliminar(int codigo);
    public boolean grupoExiste(int codigo);
    public boolean aulaExiste(int codigo);
    
     public void almacenarEscritura(Grupo viaje, String ruta);
}
