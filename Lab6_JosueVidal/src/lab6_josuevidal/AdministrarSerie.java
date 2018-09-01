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
public class AdministrarSerie {

    private ArrayList<Serie> listaSeries = new ArrayList();
    private File archivo = null;

    public AdministrarSerie(String path) {
        archivo = new File(path);
    }

    public ArrayList<Serie> getListaSeries() {
        return listaSeries;
    }

    public void setListaSeries(ArrayList<Serie> listasSeries) {
        this.listaSeries = listaSeries;
    }

    public File getArchivo() {
        return archivo;
    }

    public void setArchivo(File archivo) {
        this.archivo = archivo;
    }

    @Override
    public String toString() {
        return "AdministrarSerie{" + "listaSeries=" + listaSeries + ", archivo=" + archivo + '}';
    }

    void setSerie(Serie p) {
        this.listaSeries.add(p);
    }

    public void esccribirArchivo() throws IOException {
        FileWriter fw = null;
        BufferedWriter bw = null;
        try {
            fw = new FileWriter(archivo, false);
            bw = new BufferedWriter(fw);
            for (Serie t : listaSeries) {
                bw.write(t.getNombre() + ",");
                bw.write(t.getDuracion() + ",");
                bw.write(t.getCategoria() + ",");
                bw.write(t.getActores() + ",");
                bw.write(t.getTemporadas() + ",");
                bw.write(t.getProductora() + ",");
                bw.write(t.getIdioma() + ",");
                bw.write(t.getDoblaje() + ",");
                bw.write(t.getSubtitulos() + ";");

            }
            bw.flush();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        bw.close();
        fw.close();
    }

    public void cargarArchivo() {
        Scanner sc = null;
        listaSeries = new ArrayList();
        if (archivo.exists()) {
            try {
                sc = new Scanner(archivo);
                sc.useDelimiter(",");
                while (sc.hasNext()) {

                    String nombre;
                    int duracion, temp;
                    String Categoria, productora, idioma, doblaje, subs, actor;

                    nombre = sc.next();
                    duracion = sc.nextInt();
                    Categoria = sc.next();
                    actor = sc.next();
                    temp = sc.nextInt();
                    productora = sc.next();
                    idioma = sc.next();
                    doblaje = sc.next();
                    subs = sc.next();
                    listaSeries.add(new Serie(nombre, duracion, Categoria, actor, temp, productora, idioma, doblaje, subs));

                }
            } catch (Exception e) {
            } finally {
                sc.close();
            }
        }
    }
}
