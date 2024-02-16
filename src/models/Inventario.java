package models;

import java.util.ArrayList;

public class Inventario {
    private ArrayList<Libro> inventory = new ArrayList<>();
    private int idLibro;
    public boolean addLibro(Libro book){
        boolean flag = false;
        int bookId = book.getId();
        for (int i = 0; i <inventory.size(); i++) {
            if (bookId == inventory.get(i).getId() && !flag){
                flag = true;
            }
        }
        if (!flag){
            inventory.add(book);
        }
        return flag;
    }
    public boolean prestarLibro(int idlibro){
        boolean flag = false;
        for (int i = 0; i < inventory.size(); i++) {
            Libro book = inventory.get(i);
            if (book.getId() == idlibro && !flag) {
                if (inventory.get(i).getStatus()){
                    book.setStatus(false);
                    flag = true;
                }
            }
        }
        return flag;
    }
public boolean devolverLibro(int idlibro){
    boolean flag = false;
    for (int i = 0; i < inventory.size(); i++) {
        Libro book = inventory.get(i);
        if (inventory.get(i).getId() == idlibro) {
            if (inventory.get(i).getStatus() == false) {
                book.setStatus(true);
                flag = true;
                break;
            }
        }
    }
    return flag;
}

    public ArrayList<Libro> getInventory() {
        ArrayList<Libro> stock = new ArrayList<>();
        for (int i = 0; i < inventory.size(); i++) {
            Libro book = inventory.get(i);
            if (inventory.get(i).getStatus() == true) {
                stock.add(book);
            }
        }
        return stock;
    }
    

}
