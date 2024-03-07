package org.example;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
public class ClsJson {


    //convierte un objeto a json de una linea simple
    public String convierteObjetoJson(Object objeto) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        //Pasa el objeto a un archivo y lo guarda
        mapper.writeValue(new File("C:\\tmp\\fuentes\\file.json"), objeto);
        //pasa el json a un string
        String jsonInString = mapper.writeValueAsString(objeto);
        return jsonInString;
    }


    public Object converteJsonaObjeto() {
        ObjectMapper mapper = new ObjectMapper();
        Object objArchivo = new Object();

        try {
            //JSON de archivo a objeto
            objArchivo = mapper.readValue(new File("C:\\tmp\\fuentes\\file.json"), mdBot.class);

            //JSON de una URL a un Objeto
            //mdCarrera objURL = mapper.readValue(new URL("http://mkyong.com/api/staff.json"), mdCarrera.class);

            //JSON de un String a Objeto
            //mdCarrera objString = mapper.readValue(jsonInString, mdCarrera.class);
        } catch (Exception ex) {

        }
        return objArchivo;
    }


    //lee un archivo json y lo pone en un objeto de type arraylist
    public ArrayList<mdBot> convierteJsonAObjeto() {
        ObjectMapper mapper = new ObjectMapper();
        ArrayList<mdBot> listaObjetos = new ArrayList<>();

        try {
            //JSON de archivo a objeto
            listaObjetos = mapper.readValue(new File("C:\\tmp\\fuentes\\file.json"), new TypeReference<ArrayList<mdBot>>(){});
        } catch (Exception ex) {
            Logger.getLogger(ClsJson.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listaObjetos;
    }


    //graba en un archivo json un objeto de tipo arraylist
    public String convierteObjetoJson(ArrayList<mdBot> listaObjetos) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        //Pasa el objeto a un archivo y lo guarda
        mapper.writeValue(new File("C:\\tmp\\fuentes\\file.json"), listaObjetos);
        //pasa el json a un string
        String jsonInString = mapper.writeValueAsString(listaObjetos);
        return jsonInString;
    }

    public static void main(String[] args) {
//        ClsJson obj = new ClsJson();
//        mdBot carrera = new mdBot();
//        carrera.setNombre("Ingenieria en Sistemas");
//        carrera.setId(1L);
//        carrera.setMensaje("Hola");
//
//        try {
//            System.out.println(obj.convierteObjetoJson(carrera));
//        } catch (IOException ex) {
//            Logger.getLogger(ClsJson.class.getName()).log(Level.SEVERE, null, ex);
//        }



//pasa de json a objeto para ponerlo en un archivo
//        ClsJson obj = new ClsJson();
//        ArrayList<mdBot> listaCarreras = new ArrayList<>();
//        mdBot carrera1 = new mdBot();
//        carrera1.setNombre("Ingenieria en Sistemas");
//        carrera1.setId(1L);
//        carrera1.setMensaje("Hola");
//        listaCarreras.add(carrera1);
//        // Agrega más objetos mdBot a listaCarreras si es necesario
//        carrera1 = new mdBot();
//        carrera1.setNombre("prueba 2");
//        carrera1.setId(5L);
//        carrera1.setMensaje("otra cosa");
//        listaCarreras.add(carrera1);
//        try {
//            System.out.println(obj.convierteObjetoJson(listaCarreras));
//        } catch (IOException ex) {
//            Logger.getLogger(ClsJson.class.getName()).log(Level.SEVERE, null, ex);
//        }



//recupera el archivo y lo pone en un objeto
            ClsJson obj = new ClsJson();
            ArrayList<mdBot> listaChats = obj.convierteJsonAObjeto();
            for (mdBot dato : listaChats) {
                System.out.println("Nombre: " + dato.getNombre());
                System.out.println("Mensaje: " + dato.getMensaje());
                System.out.println("ID: " + dato.getId());
            }









    }
}
