/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab6_josuevidal;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author josue
 */
public class AdmiistrarUsuario {

    private ArrayList<Usuario> listaUsuarios = new ArrayList();
    private File archivo = null;

    public AdmiistrarUsuario(String path) {
        archivo = new File(path);
    }

    public ArrayList<Usuario> getListaUsuarios() {
        return listaUsuarios;
    }

    public void setListaUsuario(ArrayList<Usuario> listaUsuarios) {
        this.listaUsuarios = listaUsuarios;
    }

    public File getArchivo() {
        return archivo;
    }

    public void setArchivo(File archivo) {
        this.archivo = archivo;
    }

    @Override
    public String toString() {
        return "AdmiistrarUsuario{" + "listaUsuarios=" + listaUsuarios + ", archivo=" + archivo + '}';
    }

    public void setUsuaio(Usuario p) {
        this.listaUsuarios.add(p);
    }

    public void cargarArchivo() {
        Scanner sc = null;
        listaUsuarios = new ArrayList();
        if (archivo.exists()) {
            try {
                sc = new Scanner(archivo);
                sc.useDelimiter(",");
                while (sc.hasNext()) {

                    String usuario, contra;

                    usuario = sc.next();
                    contra = sc.next();

                    listaUsuarios.add(new Usuario(usuario, contra));

                }

            } catch (Exception e) {
            } finally {
                sc.close();
            }
        }
    }
}
