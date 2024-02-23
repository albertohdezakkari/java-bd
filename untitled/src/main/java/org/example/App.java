package org.example;

import org.example.repository.RepositoryDB;
import org.example.services.ServicePeliculas;

public class App
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
        MotorSQL motorSQLPostgre = new MotorSQLPostgre();
        MotorSQL motorSQLPostgre = new MotorSQLOracle();
        MotorSQL motorSQLPostgre = new MotorSQLAurora();
        RepositoryDB repPostgree = new RepositoryDB(motorSQLPostgre);
        RepositoryDB repOracle = new RepositoryDB(motorSQLOracle);

        ServicePeliculas myService = new ServicePeliculas(repPostgree);
        myService.leerPeliculas();
        ServicePeliculas myService1 = new ServicePeliculas(repFichero);
        myService1.leerPeliculas();

    }
}
