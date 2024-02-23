package org.example.repository;

import org.example.entidades.Pelicula;

import java.util.ArrayList;

public class RepositoryDB implements Repository<Pelicula>{
    private static final String SQL_SELECT = "SELECT * FROM PELICULAS";

    private MotorSQL motorSQL;

    public RepositoryDB(MotorSQL motorSQL){
        this.motorSQL = motorSQL;
        // Un hijo que será ORACLE, POSTGRE, me da igual
    }
    @Override
    public ArrayList<Pelicula> getMovies() {
        ArrayList<Pelicula> lstPeliculas = new ArrayList<>();
        motorSQL.connect();
        String SQL = "";
            SQL+="SELECT id, titulo, sinopsis ";
            SQL+=" FROM PELICULA; "
        ResultSet rs = motorSQL.ejecutarQuery(SQL_SELECT);
        while(rs.next()){
         int id = rs.getInt(1);
         String titulo = rs.getString(2);
         String sinopsis = rs.getString(3);
         Pelicula pelicula1 = new Pelicula();
            pelicula1.setTitulo(titulo);
            pelicula1.setSinopsis(sinopsis);
            lstPeliculas.add(pelicula1);
        }
        motorSQL.disconnect();
        return lstPeliculas;
    }

}
