package org.example;

public class Pelicula {
    private static final String ID_PELICULA = "ID_PELICULA";
    private static final String TITULO = "TITULO";
    private static final String ACTOR = "ACTOR";

    private int IdPelicula;
    private String titulo;
    private String actor;

    public Pelicula(int idPelicula, String titulo, String actor) {
        IdPelicula = idPelicula;
        this.titulo = titulo;
        this.actor = actor;
    }

    public int getIdPelicula() {
        return IdPelicula;
    }
    public void setIdPelicula(int idPelicula) {
        IdPelicula = idPelicula;
    }
    public String getTitulo() {
        return titulo;
    }
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }
    public String getActor() {
        return actor;
    }
    public void setActor(String actor) {
        this.actor = actor;
    }

    @Override
    public String toString() {
        return "Pelicula{" +
                "IdPelicula=" + IdPelicula +
                ", titulo='" + titulo + '\'' +
                ", actor='" + actor + '\'' +
                '}';
    }
}
