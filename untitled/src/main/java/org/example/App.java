package org.example;

import org.example.entidades.Pelicula;
import org.example.repository.Repository;
import org.example.repository.RepositoryDB;
import org.example.repository.RepositoryFichero;
import org.example.services.ServicePeliculas;
import org.example.utils.MotorSQL;
import org.example.utils.MotorSQLPostgre;

import java.util.ArrayList;

public class App
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
         MotorSQL motorSQLPostgre = new MotorSQLPostgre();
         // PISTA PARA EXAMEN
            //MotorSQL motorSQLPostgre = Factory.getInstance("POSTGRE");
        //

        // MotorSQL motorSQLPostgre = new MotorSQLOracle();
        // MotorSQL motorSQLPostgre = new MotorSQLAurora();
        Repository<Pelicula> repPostgree = new RepositoryDB(motorSQLPostgre);
        Repository<Pelicula> repFichero = new RepositoryFichero("Peliculas.txt");
        //RepositoryDB repOracle = new RepositoryDB(motorSQLOracle);

        ServicePeliculas myService = new ServicePeliculas(repPostgree);
        ArrayList<Pelicula> lstPeliculas1 = myService.leerPeliculas();
        System.out.println("Base de datos!!");
        for (Pelicula pelicula: lstPeliculas1
             ) {
            System.out.println(pelicula.toString());
        }
        ServicePeliculas myService1 = new ServicePeliculas(repFichero);
        System.out.println("Fichero!!");
         ArrayList<Pelicula> lstPeliculas = myService1.leerPeliculas();
        System.out.println(lstPeliculas.toString());

    }
}
