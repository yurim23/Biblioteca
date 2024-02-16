package models;

import java.util.ArrayList;

public class Bibliotecario {
    private ArrayList<String> opciones = new ArrayList<>();
    public void addOpcion(String opcion){
        opciones.add(opcion);
    }

    public ArrayList<String> getOpciones() {
        return opciones;
    }
}
