package models;

public class Libro {
    private String nombre;

    private int id;
    private boolean status;

    public Libro(String nombre, int id) {
        this.nombre = nombre;
        this.id = id;
        status = true;
    }

    public boolean getStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    @Override
    public String toString() {
        return  nombre + "    ID: " + id +'\'';
    }
}
