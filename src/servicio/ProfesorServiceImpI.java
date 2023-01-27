/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package servicio;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import modelo.Profesor;

/**
 *
 * @author ochoa
 */
public class ProfesorServiceImpI implements ProfesorService {

    private static List<Profesor> profesorList = new ArrayList<>();

    public ProfesorServiceImpI() {
    }

    @Override
    public void crear(Profesor profesor) {

        this.profesorList.add(profesor);
        this.almacenarEscritura(profesor, "C:/PooUnidasPoo/Docente.txt");

    }

    @Override
    public Profesor codigoProfesor(int codigo) {

        Profesor retorno = null;
        for (var profesor : this.profesorList) {
            if (codigo == profesor.getCodigo()) {
                retorno = profesor;
                break;
            }
        }
        return retorno;
    }

    @Override
    public List<Profesor> listar() {
        
        this.profesorList = this.recuperarArchivo("C:/PooUnidasPoo/Docente.txt");
         
        
        return this.profesorList;

    }

    @Override
    public Profesor bucarNombre(String nombre) {

        Profesor retorno = null;

        for (var ciudad : this.profesorList) {
            if (nombre.equals(ciudad.getNombre())) {
                retorno = ciudad;
                break;
            }
        }

        return retorno;
    }

    @Override
    public void eliminar(int codigo) {
        var indice = 0;
        for (var materia : this.profesorList) {
            if (materia.getCodigo() == codigo) {
                this.profesorList.remove(indice);
                this.Actualizar();
                break;
            } else {
                indice++;
            }
        }
    }

    @Override
    public boolean codigoExiste(int codigo) {
        var retorno = false;
        for (var ciudad : this.profesorList) {
            if (codigo == ciudad.getCodigo()) {
                retorno = true;
                break;
            }
        }

        return retorno;

    }

    @Override
    public boolean fechaExiste(LocalDate fecha) {
        var retorno = false;
        for (var ciudad : this.profesorList) {
            if (fecha == ciudad.getFechaNacimiento()) {
                retorno = true;
                break;
            }
        }

        return retorno;
    }

    @Override
    public void codigoEliminar(int codigo) {

        var retorno = "";
        for (var profe : this.profesorList) {
            if (codigo == profe.getCodigo()) {

            } else {

                break;
            }

        }
    }

    @Override
    public Profesor buscarPorNombre(String nombre) {

        Profesor retorno = null;

        for (var docente : this.profesorList) {
            if (nombre.equals(docente.getNombre())) {
                retorno = docente;
                break;
            }
        }

        return retorno;

    }
//--------------------------------Almacenamiento de archivos ----------------------------------------------//

    @Override
    public void almacenarEscritura(Profesor docente, String ruta) {
        DataOutputStream salida = null;
        try {
            salida = new DataOutputStream(new FileOutputStream(ruta, true));
            salida.writeInt(docente.getCodigo());
            salida.writeUTF(docente.getNombre());
            salida.writeInt(docente.getFechaNacimiento().getYear());
            salida.writeUTF(docente.getFechaNacimiento().getMonth().name());
            salida.writeInt(docente.getFechaNacimiento().getDayOfMonth());
            salida.writeUTF(docente.getProfecion());
            salida.writeUTF(docente.getCorreo());
            salida.writeUTF(docente.getGenero());

            salida.close();

        } catch (IOException ex) {
            Logger.getLogger(ProfesorServiceImpI.class.getName()).log(Level.SEVERE, null, ex);

        }
    }

    

    public List<Profesor> recuperarArchivo(String ruta) {
       
        var profesorList = new ArrayList<Profesor>();
        DataInputStream entrada = null;
        try {
            
            entrada = new DataInputStream(new FileInputStream(ruta));
            while (true) {
                var codigo = entrada.readInt();
                var nombre = entrada.readUTF();
                var year = entrada.readInt();
                var mes = entrada.readUTF();
                var dia = entrada.readInt();
                var profesion = entrada.readUTF();
                var correo = entrada.readUTF();
                var genero = entrada.readUTF();
                var fecha = LocalDate.of(year, Month.valueOf(mes), dia);
                var profesor = new Profesor(codigo, nombre,fecha, profesion, correo, genero);
                profesorList.add(profesor);
                
            }
        } catch (IOException e) {
            try {
                entrada.close();
            } catch (IOException es) {
                Logger.getLogger(ProfesorServiceImpI.class.getName()).log(Level.SEVERE, null, es);
            }
        }

        return profesorList;

    }
     

    public void Actualizar() {
        var Borrarfile = new File("C:/PooUnidasPoo/Docente.txt");
        Borrarfile.delete();

        for (var i = 0; i < profesorList.size(); i++) {
            this.almacenarEscritura(profesorList.get(i), "C:/PooUnidasPoo/Docente.txt");

        }
    }
    
    public void modificar(Profesor profesor, int codigo) {

        var indice = -1;
        for (var profsores : this.profesorList) {
            indice++;
            if (codigo == profsores.getCodigo()) {
                this.profesorList.set(indice, profesor);

            }

        }
        this.Actualizar();
    }

}
