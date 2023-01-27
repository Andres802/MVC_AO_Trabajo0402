/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package servicio;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import modelo.Grupo;

/**
 *
 * @author ochoa
 */
public class GrupoServiceImpI implements GrupoService {

    private static List<Grupo> grupoList;

    public GrupoServiceImpI() {

        this.grupoList = new ArrayList<>();

    }

    @Override
    public void crear(Grupo grupo) {

        this.grupoList.add(grupo);
        this.almacenarEscritura(grupo, "C:/PooUnidasPoo/GrupoText.txt");
        this.almacenarEscritura(grupo, "C:/PooUnidasPoo/Asignautra.txt");
        this.almacenarEscritura(grupo, "C:/PooUnidasPoo/Docente.txt");
    }

    @Override
    public List<Grupo> listar() {
        try {

            return this.grupoList = this.recuperarArchivo("C:/PooUnidasPoo/GrupoText.txt");
        } catch (Exception ex) {
            throw new RuntimeException("No se puede recuperar datos del archivo " + ex.getMessage());
        }

    }

    @Override
    public void eliminar(int codigo) {
        this.grupoList.remove(codigo);
    }

    @Override
    public boolean codigoEliminar(int codigo) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean grupoExiste(int codigo) {

        var retorno = false;
        for (var materia : this.grupoList) {
            if (codigo == materia.getNumeroGrupo()) {
                retorno = true;
                break;
            }
        }
        return retorno;
    }

    @Override
    public boolean aulaExiste(int codigo) {

        var retorno = false;
        for (var materia : this.grupoList) {
            if (codigo == materia.getAula()) {
                retorno = true;
                break;
            }
        }
        return retorno;

    }

    @Override
    public void almacenarEscritura(Grupo grupo, String ruta) {

        ObjectOutputStream salida = null;

        try {
            salida = new ObjectOutputStream(new FileOutputStream(ruta, true));
            salida.writeObject(grupo);
            salida.close();

        } catch (IOException ex) {
            Logger.getLogger(GrupoServiceImpI.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public List<Grupo> recuperarArchivo(String ruta) throws Exception {
        List<Grupo> grupoList = new ArrayList<Grupo>();
        var fis = new FileInputStream(new File(ruta));
        ObjectInputStream entrada = null;
        try {
            while (fis.available() > 0) {
                entrada = new ObjectInputStream(fis);
                Grupo persona = (Grupo) entrada.readObject();
                grupoList.add(persona);
            }
            entrada.close();
        } catch (Exception ex) {
            entrada.close();
        }
        return grupoList;

    }

    public static List<Grupo> getGrupoList() {
        return grupoList;
    }

    public static void setGrupoList(List<Grupo> grupoList) {
        GrupoServiceImpI.grupoList = grupoList;
    }
    public void Actualizar() {
        var Borrarfile = new File("C:/PooUnidasPoo/GrupoText.txt");
        Borrarfile.delete();

        for (var i = 0; i < grupoList.size(); i++) {
            this.almacenarEscritura(grupoList.get(i), "C:/PooUnidasPoo/GrupoText.txt");

        }
    }

}
