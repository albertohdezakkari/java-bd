package org.example.repository;

import org.example.entidades.Pelicula;

import java.util.ArrayList;

public class RepositoryArrayList implements Repository<Pelicula> {

    public RepositoryArrayList(){

    }
    @Override
    public ArrayList<Pelicula> getMovies() {
        return null;
    }
}
