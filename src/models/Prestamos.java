package models;

import java.util.ArrayList;

public class Prestamos {
    private ArrayList<Usuario> prestamo = new ArrayList<>();
    public void addPrestamo(Usuario cliente){
        prestamo.add(cliente);

    }
    public boolean updatePrestamo(int id){
        boolean flag = false;
        for (int i = 0; i < prestamo.size(); i++) {
            if (prestamo.get(i).getId() == id) {
                prestamo.remove(i);
                flag = true;
                break;
            }
        }
        return flag;
    }



    public ArrayList<Usuario> getPrestamo() {
        return prestamo;
    }
}
