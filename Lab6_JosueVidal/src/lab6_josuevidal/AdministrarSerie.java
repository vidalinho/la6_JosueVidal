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
                bw.write(t.getCodigo() + ";");
                bw.write(t.getNombre()+ ";");
                bw.write(t.getEdad()+ ";");
                for (int i = 0; i < t.getHobbies().size(); i++) {
                    bw.write(t.getHobbies().get(i)+",");
                }
            }
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
                sc.useDelimiter(";");
                while (sc.hasNext()) {
                    listaSeries.add(new Serie(sc.nextInt(), sc.next(), sc.nextInt()));
                }
            } catch (Exception e) {
            } finally {
                sc.close();
            }
        }
    } 
}
