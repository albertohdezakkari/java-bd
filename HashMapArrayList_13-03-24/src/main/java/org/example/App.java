package org.example;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        ArrayList<Pelicula> lstPeliculas = new ArrayList<Pelicula>();
        HashMap<Integer, Pelicula> hashPeliculas = new HashMap<Integer, Pelicula>();
            Pelicula pelicula1 = new Pelicula(1, "a", "a");
            Pelicula pelicula2 = new Pelicula(2, "b", "b");
            Pelicula pelicula3 = new Pelicula(3, "c", "c");
                lstPeliculas.add(pelicula1);
                lstPeliculas.add(pelicula2);
                lstPeliculas.add(pelicula3);

                hashPeliculas.put(pelicula1.getIdPelicula(), pelicula1);
                hashPeliculas.put(pelicula2.getIdPelicula(), pelicula2);
                hashPeliculas.put(pelicula3.getIdPelicula(), pelicula3);

                    System.out.println("Valores del HashMap");
                    for (Pelicula pelicula: hashPeliculas.values()) {
                        System.out.println("Pelicula=>" + pelicula.toString());
                    }
                    // FIND ALL
                    System.out.println("Entradas HashMap");
                    for (Map.Entry<Integer, Pelicula> entrada: hashPeliculas.entrySet()) {
                        Integer key = entrada.getKey(); // 15
                        Pelicula pelicula = entrada.getValue(); // Tupla completa
                        System.out.println("Clave=>" + key + "- Película=>" + pelicula.toString());

                    }
                    for (Integer id: hashPeliculas.keySet()) {
                        System.out.println("Pelicula=>" + hashPeliculas.get(id).toString() );
                    }
                    // FINDONE
                    String idBuscar = "2";
                    if(hashPeliculas.containsKey( Integer.parseInt(idBuscar) ) ){
                        System.out.println( hashPeliculas.get(Integer.parseInt(idBuscar)).toString() );

                    }

                    // DELETE
                    hashPeliculas.remove(Integer.parseInt(idBuscar));

                    // lstPeliculas.remove(Integer.parseInt(idBuscar));
                        for (Pelicula pelicula: lstPeliculas) {
                            if(pelicula.getIdPelicula()==Integer.parseInt(idBuscar)){
                                lstPeliculas.remove(pelicula);
                            }
                        }
                    // UPDATE
                    String idBuscar2 = "2";
                    if(hashPeliculas.containsKey( Integer.parseInt(idBuscar) ) ){
                        Pelicula pelicula = hashPeliculas.get(Integer.parseInt(idBuscar));
                        pelicula.setActor("holaaa");
                        pelicula.setTitulo("holaaa!!!");
                    }







    }
}
