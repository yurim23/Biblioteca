package models;

public class Usuario {
    private int idlibro;
    private int id;
    private String domicilio;

    public Usuario(int idlibro, int id, String domicilio){
        this.idlibro = idlibro;
        this.id = id;
        this.domicilio = domicilio;
    }


    public int getId() {
        return id;
    }


    @Override
    public String toString() {
        return "ID del libro: " + idlibro  + "      ID cliente: " + id + "       Domicilio: " + domicilio;
    }
}
