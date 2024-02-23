package org.example.repository;

import java.util.ArrayList;

public interface Repository<T> { // GENÉRICOS
    public ArrayList<T> getMovies();
    /*public T find(int id);
    public ArrayList<T> findAll();
    public int delete(int id);
    public int update(int id, T objeto);
    public int add(T objeto);*/
}
