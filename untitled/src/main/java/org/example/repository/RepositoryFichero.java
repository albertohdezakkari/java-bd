package org.example.repository;

import org.example.entidades.Pelicula;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class RepositoryFichero implements Repository<Pelicula> {
    // FilePath
    // BufferedReader
    private FileReader fileReader;

    public RepositoryFichero(String path){
        try {
            System.out.println("Directorio de trabajo actual: " + System.getProperty("user.dir"));
            String project = System.getProperty("user.dir");
            this.fileReader = new FileReader( project + "\\src\\main\\java\\org\\example\\" + path );
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }


    @Override
    public ArrayList<Pelicula> getMovies() {
        ArrayList<Pelicula> peliculas = new ArrayList<>();
        String linea;
        int numeroLinea = 1;
        try {
            BufferedReader bufferedReader = new BufferedReader(this.fileReader);

            while ((linea = bufferedReader.readLine()) != null) {
                String[] partes = linea.split(","); // Asumiendo que el archivo usa comas como delimitador
                if (partes.length == 3) {
                    try {
                        int id = Integer.parseInt(partes[0].trim());
                        String titulo = partes[1].trim();
                        String sinopsis = partes[2].trim();
                        peliculas.add(new Pelicula(id, titulo, sinopsis));
                    } catch (NumberFormatException e) {
                        System.err.println("Error al parsear el ID: " + partes[0]);
                    }
                } else {
                    System.err.println("Línea mal formada: " + linea);
                }
                System.out.println(numeroLinea + ": " + linea);
                numeroLinea++;
            }
            bufferedReader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return peliculas;
    }
}
