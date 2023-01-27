
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
import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import modelo.Asignatura;
import modelo.Profesor;

/**
 *
 * @author ochoa
 */
public class AsignaturaServiceImpI implements AsignaturaService {

    private static List<Asignatura> asignaturaList = new ArrayList<>();

    @Override
    public void crear(Asignatura asignatura) {
        this.asignaturaList.add(asignatura);
        this.almacenarEscritura(asignatura, "C:/PooUnidasPoo/Asignautra.txt");
    }

    @Override
    public Asignatura codigoAsignautra(int codigo) {

        Asignatura barco = null;
        for (var b : this.asignaturaList) {
            if (codigo == b.getCodigo()) {
                barco = b;
                break;
            }
        }
        return barco;
    }

    @Override
    public List<Asignatura> listar() {

        
        this.asignaturaList = this.recuperarArchivo("C:/PooUnidasPoo/Asignautra.txt");

        return this.asignaturaList;
    }

    @Override
    public Asignatura buscarNombre(String nombre) {
        Asignatura retorno = null;

        for (var ciudad : this.asignaturaList) {
            if (nombre.equals(ciudad.getPlanEstudio())) {
                retorno = ciudad;
                break;
            }
        }

        return retorno;
    }

    @Override
    public void eliminar(int codigo) {

        var indice = 0;
        for (var materia : this.asignaturaList) {
            if (materia.getCodigo() == codigo) {
                this.asignaturaList.remove(indice);
                this.Actualizar();
                break;
            } else {
                indice++;
            }
        }

    }

    @Override
    public void modificar(int condigo, Asignatura asignatura) {

        var indice = 0;

        this.asignaturaList.set(indice, asignatura);
    }

    @Override
    public boolean codigoEliminar(int codigo) {
        var retorno = true;
        for (var materia : this.asignaturaList) {
            if (codigo == materia.getCodigo()) {
                retorno = false;
            } else {

                retorno = true;

            }

        }
        return retorno;
    }

    @Override
    public boolean codigoExiste(int codigo) {

        var retorno = false;
        for (var materia : this.asignaturaList) {
            if (codigo == materia.getCodigo()) {
                retorno = true;
                break;
            }
        }

        return retorno;

    }

    @Override
    public Asignatura buscarPorNombre(String nombre) {

        Asignatura retorno = null;

        for (var materia : this.asignaturaList) {
            if (nombre.equals(materia.getNombreMateria())) {
                retorno = materia;
                break;
            }
        }

        return retorno;
    }

    //--------------------------------Almacenamiento de archivos ----------------------------------------------//
    @Override
    public void almacenarEscritura(Asignatura asignatura, String ruta) {
        DataOutputStream salida = null;
        try {
            salida = new DataOutputStream(new FileOutputStream(ruta, true));
            salida.writeInt(asignatura.getCodigo());
            salida.writeUTF(asignatura.getNombreMateria());
            salida.writeUTF(asignatura.getHorasClases());
            salida.writeUTF(asignatura.getPlanEstudio());
            salida.writeUTF(asignatura.getCarreraAignatura());
            salida.close();

        } catch (IOException ex) {
            Logger.getLogger(AsignaturaServiceImpI.class.getName()).log(Level.SEVERE, null, ex);

        }
    }

    public List<Asignatura> recuperarArchivo(String ruta) {
        var materiaList = new ArrayList<Asignatura>();
        DataInputStream entrada = null;
        try {

            entrada = new DataInputStream(new FileInputStream(ruta));
            while (true) {
                var codigo = entrada.readInt();
                var nombreMateria = entrada.readUTF();
                var horasClases = entrada.readUTF();
                var planEstudio = entrada.readUTF();
                var carreraAsignatura = entrada.readUTF();
                var asignatura = new Asignatura(codigo, nombreMateria, horasClases, planEstudio, carreraAsignatura);
                materiaList.add(asignatura);
            }
        } catch (IOException e) {
            try {
                entrada.close();
            } catch (IOException es) {
                Logger.getLogger(AsignaturaServiceImpI.class.getName()).log(Level.SEVERE, null, es);
            }
        }

        return materiaList;

    }
    public void Actualizar() {
        var Borrarfile = new File("C:/PooUnidasPoo/Asignautra.txt");
        Borrarfile.delete();

        for (var i = 0; i < asignaturaList.size(); i++) {
            this.almacenarEscritura(asignaturaList.get(i), "C:/PooUnidasPoo/Asignautra.txt");

        }
    }
}
