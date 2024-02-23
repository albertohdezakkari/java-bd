package org.example.services;

import org.example.entidades.Pelicula;
import org.example.repository.Repository;

import java.util.ArrayList;

public class ServicePeliculas {
    Repository<Pelicula> myRepo;
    public ServicePeliculas(Repository<Pelicula> myRepo){
        this.myRepo = myRepo;

    }
    public ArrayList<Pelicula> leerPeliculas(){
        return myRepo.getMovies();
    }
}
