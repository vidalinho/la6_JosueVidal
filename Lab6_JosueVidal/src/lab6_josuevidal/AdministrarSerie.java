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

    public ArrayList<Serie> getListaPersonas() {
        return listaSeries;
    }

    public void setListaPersonas(ArrayList<Serie> listaPersonas) {
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

    void setPersona(Serie p) {
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
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        bw.close();
        fw.close();
    }

    public void cargarArchivo() {
        Scanner sc = null;
        Scanner sc2 = null;
        listaSeries = new ArrayList();
        if (archivo.exists()) {
            try {
                sc = new Scanner(archivo);

                sc.useDelimiter(",");
                sc2.useDelimiter(";");
                while (sc.hasNext()) {
                    listaSeries.add(new Serie(sc.next(), sc.nextInt(), sc.next(), sc.next(), sc.nextInt(), sc.next(), sc.next(), sc.next(), sc.next()));
                    sc2.next();

                }
            } catch (Exception e) {
            } finally {
                sc.close();
            }
        }
    }
}
