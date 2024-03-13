package org.example.repository;

import org.example.entidades.Pelicula;
import org.example.utils.MotorSQL;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class RepositoryDB implements Repository<Pelicula>{
    private static final String SQL_SELECT = "SELECT" + Pelicula.ID +" titulo, descripcion, fecha_lanzamiento, imagen, creado_en FROM public.peliculas ";
    private MotorSQL motorSQL;

    public RepositoryDB(MotorSQL motorSQL){
        this.motorSQL = motorSQL;
        // Un hijo que será ORACLE, POSTGRE, me da igual
    }
    @Override
    public ArrayList<Pelicula> getMovies() {
        ArrayList<Pelicula> lstPeliculas = new ArrayList<>();
        try {
            this.motorSQL.connect();
            ResultSet rs = motorSQL.ejecutarQuery(SQL_SELECT);
            while(rs.next()){
                int id = rs.getInt(1);
                String titulo = rs.getString(2);
                String sinopsis = rs.getString(3);
                Pelicula pelicula = new Pelicula();
                pelicula.setTitulo(titulo);
                pelicula.setSinopsis(sinopsis);
                lstPeliculas.add(pelicula);
            }
            this.motorSQL.disconnect();
        } catch (SQLException e) {
                throw new RuntimeException(e);
        }
        return lstPeliculas;
    }

}
