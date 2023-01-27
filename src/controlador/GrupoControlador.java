/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import java.time.LocalDate;
import java.util.List;
import modelo.Grupo;
import servicio.GrupoServiceImpI;
import servicio.*;


/**
 *
 * @author ochoa
 */
public class GrupoControlador {
    
     private  GrupoServiceImpI grupoServi = new GrupoServiceImpI();
     private  AsignaturaServiceImpI asignaturaServi = new AsignaturaServiceImpI();
     private ProfesorServiceImpI profesorServi = new ProfesorServiceImpI();
    
    public void crear(String[] data) {
        
        try{
        var numeroGrupo = Integer.valueOf(data[0]);
        var aula = Integer.valueOf(data[1]);
        var numeroAlumnos = Integer.valueOf(data[2]);
        var nivelCiclo= data[3];
        var asignatura = this.asignaturaServi.buscarPorNombre(data[4]);
        var profesor = this.profesorServi.buscarPorNombre(data[5]);
        
        var grupo = new Grupo(numeroGrupo,aula,numeroAlumnos,nivelCiclo,asignatura,profesor);
       
        /*
        if (this.grupoServi.grupoExiste(numeroGrupo)) {
                throw new RuntimeException("Codigo Existe");
            }            
        else if (this.grupoServi.aulaExiste(aula)) {
                throw new RuntimeException("Fecha existe");
            } else {
*/
             this.grupoServi.crear(grupo);   
            
        } catch (NumberFormatException e) {
            throw new NumberFormatException("Error al convetir el formato");
        }
        
        
    }
    
    public List<Grupo>listar(){
        return this.grupoServi.listar();
    }
    
    public void eliminar(int data){
        this.grupoServi.eliminar(data);
    }
    public void eliminarArchivo(){
        this.grupoServi.Actualizar();
    }
}
