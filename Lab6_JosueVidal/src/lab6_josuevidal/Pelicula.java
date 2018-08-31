/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab6_josuevidal;

/**
 *
 * @author josue
 */
public class Pelicula {

    private String nombre;
    private int duracion;
    private String categoria;
    private String actores;
    private String director;
    private String compania;
    private String idioma;
    private String doblaje;
    private String subtitulos;

    public Pelicula() {
    }

    public Pelicula(String nombre, int duracion, String categoria, String actores, String director, String compania, String idioma, String doblaje, String subtitulos) {
        this.nombre = nombre;
        this.duracion = duracion;
        this.categoria = categoria;
        this.actores = actores;
        this.director = director;
        this.compania = compania;
        this.idioma = idioma;
        this.doblaje = doblaje;
        this.subtitulos = subtitulos;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getDuracion() {
        return duracion;
    }

    public void setDuracion(int duracion) {
        this.duracion = duracion;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getActores() {
        return actores;
    }

    public void setActores(String actores) {
        this.actores = actores;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public String getCompania() {
        return compania;
    }

    public void setCompania(String compania) {
        this.compania = compania;
    }

    public String getIdioma() {
        return idioma;
    }

    public void setIdioma(String idioma) {
        this.idioma = idioma;
    }

    public String getDoblaje() {
        return doblaje;
    }

    public void setDoblaje(String doblaje) {
        this.doblaje = doblaje;
    }

    public String getSubtitulos() {
        return subtitulos;
    }

    public void setSubtitulos(String subtitulos) {
        this.subtitulos = subtitulos;
    }

    @Override
    public String toString() {
        return "Pelicula{" + "nombre=" + nombre + ", duracion=" + duracion + ", categoria=" + categoria + ", actores=" + actores + ", director=" + director + ", compania=" + compania + ", idioma=" + idioma + ", doblaje=" + doblaje + ", subtitulos=" + subtitulos + '}';
    }

}
