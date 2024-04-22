import models.*;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    private static Scanner key = new Scanner(System.in);
    private static Biblioteca biblioteca = new Biblioteca();
    private static Prestamos prestados = new Prestamos();
    public static void main(String[] args) {
        short opcion = 0;
            do {
                System.out.println("1 Administrador");
                System.out.println("2 Cliente");
                System.out.println("3 Salir");
                System.out.println("Identificate");
                opcion = key.nextShort();
                switch (opcion) {
                    case 1:
                        do {
                            System.out.println();
                            System.out.println("Ingrese opción");
                            System.out.println("1 Añadir Libro");
                            System.out.println("2 Añadir Préstamo");
                            System.out.println("3 Actualizar Prestamo");
                            System.out.println("4 Ver Prestamos");
                            System.out.println("5 Ver Biblioteca");
                            System.out.println("6 Salir");
                            opcion = key.nextShort();
                            switch (opcion) {
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
                        } while (opcion != 6); break;
                    case 2:
                        do {
                        System.out.println("1 Ver Biblioteca");
                        System.out.println("2 Salir");
                        opcion = key.nextShort();
                        switch (opcion){
                            case 1: verInventario();
                            break;
                            case 2:
                                break;
                            default:
                                System.out.println("Ingrese una opción válida");
                                break;
                        }
                        }while (opcion != 2);
                        break;
                    default:
                        System.out.println("Elige una opción válida");
                }
            } while (opcion != 3);
}
    public static void addLibro(){
        System.out.println("Ingrese el nombre del libro");
        key.nextLine();
        String nombre = key.nextLine();
        System.out.println("Asigne un ID númerico al libro");
        int id = key.nextInt();
        Libro book = new Libro(nombre, id);
        if (!biblioteca.addLibro(book)){
            System.out.println("Libro añadido al biblioteca");
        }else
            System.out.println("Este ID ya ha sido añadido al biblioteca");
    }
    public static void addPrestamo(){
        System.out.println("Ingrese el ID númerico del libro");
        int idlibro = key.nextInt();
        System.out.println("Asigne un ID númerico al cliente");
        int id = key.nextInt();
        key.nextLine();
        System.out.println("Ingrese el domicilio del cliente");
        String domilicio = key.nextLine();
        Cliente cliente = new Cliente(idlibro, id, domilicio);
        if (biblioteca.prestarLibro(idlibro)) {
            System.out.println("Registro del préstamo existoso");
            prestados.addPrestamo(cliente);
        }
        else
            System.out.println("El ID libro no existe el biblioteca");
    }
    public static void updatePrestamo(){
        System.out.println("Ingrese el ID númerico del libro");
        int idlibro = key.nextInt();
        System.out.println("Ingrese el ID númerico del usuario");
        int id = key.nextInt();
        if (biblioteca.devolverLibro(idlibro)){
            if (prestados.updatePrestamo(id)){
                System.out.println("Libro Devuelto");
            } else {
                biblioteca.prestarLibro(idlibro);
                System.out.println("Id del usuario incorrecto");
            }
        }else
            System.out.println("Id del libro incorrecto");
    }
    public static void viewPrestamos(){
        ArrayList<Cliente> prestamos = prestados.getPrestamo();
        for (int i = 0; i <prestamos.size() ; i++) {
            System.out.println(prestamos.get(i));
        }
        if (prestamos.isEmpty())
            System.out.println("No existen libros prestados");
    }
    public static void verInventario(){
        ArrayList<Libro> aux = biblioteca.getInventory();
            for (int i = 0; i <aux.size(); i++) {
                System.out.println(aux.get(i));
            }
            if (aux.isEmpty())
                System.out.println("No hay existencias disponibles");
    }
}