/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;
import javax.swing.JOptionPane;
import modelo.Profesor;
import servicio.ProfesorServiceImpI;

/**
 *
 * @author ochoa
 */
public class ProfesorControlador {
    
     private ProfesorServiceImpI profesorServi = new ProfesorServiceImpI();

    public void crear(String[] data) throws Exception{
        
         try {
        var codigo = Integer.valueOf(data[0]);
        var nombre = data[1];
        var year = Integer.valueOf(data[2]);
        var mes = data[3];
        var dia = Integer.valueOf(data[4]);
        var profesion = data[5];
        var correo = data[6];
        var genero = data[7];
        var profesor = new Profesor(codigo,nombre,LocalDate.of(year, Month.valueOf(mes), dia),profesion,correo,genero);
        
        if (this.profesorServi.codigoExiste(codigo)) {
                throw new RuntimeException("Codigo Existe");
            }            
        else if (this.profesorServi.fechaExiste(LocalDate.of(year,Month.valueOf(mes), dia))) {
                throw new RuntimeException("Fecha existe");
            } else {

             this.profesorServi.crear(profesor);   
            }
        } catch (NumberFormatException e) {
            throw new NumberFormatException("Error al convetir el formato");
        }
    }
    
    public List<Profesor>listar(){
        var retorno = profesorServi.listar();
        return retorno;
    }
    public boolean codigoEliminar(int codigo) {

        var retorno = true;
        for (var profe : this.profesorServi.listar()) {
            if (codigo == profe.getCodigo()) {
               retorno = false;
            } else {
               
                retorno = true;
                
            }
            
        }
        return retorno;
    }
    public void eliminar(String[] data){
        try{
            
        var codigo = Integer.valueOf(data[0]);
        if(this.codigoEliminar(codigo)){
            throw new RuntimeException("Codigo no existe");
        }else{
        
            this.profesorServi.eliminar(codigo);
        }
        }catch(NumberFormatException e){
            throw new NumberFormatException("Error al convetir el formato");
        }
     }
    public void modificar(String[] data){
        
    }
}
