import models.*;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    private static Scanner key = new Scanner(System.in);
    private static Inventario storage = new Inventario();
    private static Prestamos prestados = new Prestamos();
    public static void main(String[] args) {
        short eleccion = 0;
            do {
                System.out.println("1 Administrador");
                System.out.println("2 Cliente");
                System.out.println("3 Salir");
                System.out.println("Identificate");
                eleccion = key.nextShort();
                switch (eleccion) {
                    case 1:
                        do {
                            System.out.println();
                            System.out.println("Ingrese opción");
                            System.out.println("1 Añadir Libro");
                            System.out.println("2 Añadir Préstamo");
                            System.out.println("3 Actualizar Prestamo");
                            System.out.println("4 Ver Prestamos");
                            System.out.println("5 Ver Inventario");
                            System.out.println("6 Salir");
                            eleccion = key.nextShort();
                            switch (eleccion) {
                                case 1:
                                    addLibro();
                                    break;
                                case 2:
                                    addPrestamo();
                                    break;
                                case 3:
                                    updatePrestamo();
                                    break;
                                case 4:
                                    viewPrestamos();
                                    break;
                                case 5:
                                    verInventario();
                                case 6:
                                    break;
                                default:
                                    System.out.println("Ingrese opción válida");
                                    break;
                            }
                        } while (eleccion != 6); break;
                    case 2:
                        do {
                        System.out.println("1 Ver Inventario");
                        System.out.println("2 Salir");
                        eleccion = key.nextShort();
                        switch (eleccion){
                            case 1: verInventario();
                            break;
                            case 2:
                                break;
                            default:
                                System.out.println("Ingrese una opción válida");
                                break;
                        }
                        }while (eleccion != 2);
                        break;
                    default:
                        System.out.println("Elige una opción válida");
                }
            } while (eleccion != 3);
}
    public static void addLibro(){
        System.out.println("Ingrese el nombre del libro");
        key.nextLine();
        String nombre = key.nextLine();
//        System.out.println("Ingresa el autor del libro");
//        String autor = key.next();
        System.out.println("Asigne un ID númerico al libro");
        int id = key.nextInt();
        Libro book = new Libro(nombre, id);
        if (!storage.addLibro(book)){
            System.out.println("Libro añadido al inventario");
        }else
            System.out.println("Este ID ya ha sido añadido al inventario");
    }
    public static void addPrestamo(){
        System.out.println("Ingrese el ID númerico del libro");
        int idlibro = key.nextInt();
        System.out.println("Asigne un ID númerico al cliente");
        int id = key.nextInt();
        key.nextLine();
        System.out.println("Ingrese el domicilio del cliente");
        String domilicio = key.nextLine();
        Usuario cliente = new Usuario(idlibro, id, domilicio);
        if (storage.prestarLibro(idlibro)) {
            System.out.println("Registro del préstamo existoso");
            prestados.addPrestamo(cliente);
        }
        else
            System.out.println("El ID libro no existe el inventario");
    }
    public static void updatePrestamo(){
        System.out.println("Ingrese el ID númerico del libro");
        int idlibro = key.nextInt();
        System.out.println("Ingrese el ID númerico del usuario");
        int id = key.nextInt();
        if (storage.devolverLibro(idlibro)){
            if (prestados.updatePrestamo(id)){
                System.out.println("Libro Devuelto");
            } else {
                storage.prestarLibro(idlibro);
                System.out.println("Id del usuario incorrecto");
            }
        }else
            System.out.println("Id del libro incorrecto");
    }
    public static void viewPrestamos(){
        ArrayList<Usuario> loans = prestados.getPrestamo();
        for (int i = 0; i <loans.size() ; i++) {
            System.out.println(loans.get(i));
        }
        if (loans.isEmpty())
            System.out.println("No existen libros prestados");
    }
    public static void verInventario(){
        ArrayList<Libro> inventario = storage.getInventory();
            for (int i = 0; i <inventario.size(); i++) {
                System.out.println(inventario.get(i));
            }
            if (inventario.isEmpty())
                System.out.println("No hay existencias disponibles");
    }
}