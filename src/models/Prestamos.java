package models;

import java.util.ArrayList;

public class Prestamos {
    private ArrayList<Cliente> prestamo = new ArrayList<>();
    public void addPrestamo(Cliente cliente){
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



    public ArrayList<Cliente> getPrestamo() {
        return prestamo;
    }
}
