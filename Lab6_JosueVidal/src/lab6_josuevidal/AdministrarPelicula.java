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
public class AdministrarPelicula {

    private ArrayList<Pelicula> listaPeliculas = new ArrayList();
    private File archivo = null;

    public AdministrarPelicula(String path) {
        archivo = new File(path);
    }

    public ArrayList<Pelicula> getListaPersonas() {
        return listaPeliculas;
    }

    public void setListaPeliculas(ArrayList<Pelicula> listaPeliculas) {
        this.listaPeliculas = listaPeliculas;
    }

    public File getArchivo() {
        return archivo;
    }

    public void setArchivo(File archivo) {
        this.archivo = archivo;
    }

    @Override
    public String toString() {
        return "AdministrarPelicula{" + "listaPeliculas=" + listaPeliculas + ", archivo=" + archivo + '}';
    }

    public void setPelicula(Pelicula p) {
        this.listaPeliculas.add(p);
    }

    public void esccribirArchivo() throws IOException {
        FileWriter fw = null;
        BufferedWriter bw = null;
        try {
            fw = new FileWriter(archivo, false);
            bw = new BufferedWriter(fw);
            for (Pelicula t : listaPeliculas) {
                bw.write(t.getNombre() + ",");
                bw.write(t.getDuracion() + ",");
                bw.write(t.getCategoria() + ",");
                bw.write(t.getActores() + ",");
                bw.write(t.getDirector() + ",");
                bw.write(t.getCompania() + ",");
                bw.write(t.getIdioma() + ",");
                bw.write(t.getDoblaje() + ",");
                bw.write(t.getSubtitulos() + ";");

            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        bw.close();
        fw.close();
    }

    public void cargarArchivo() {
        Scanner sc = null;
        Scanner sc2 = null;
        listaPeliculas = new ArrayList();
        if (archivo.exists()) {
            try {
                sc = new Scanner(archivo);
                sc2 = new Scanner(archivo);
                sc.useDelimiter(",");
                sc2.useDelimiter(";");
                while (sc2.hasNext()) {
                    listaPeliculas.add(new Pelicula(sc.next(), sc.nextInt(), sc.next(), sc.next(), sc.next(), sc.next(), sc.next(), sc.next(), sc.next()));
                }
            } catch (Exception e) {
            } finally {
                sc.close();
            }
        }
    }
}
