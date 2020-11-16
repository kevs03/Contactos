package com.kevin;

import java.io.IOException;
import java.util.Scanner;

public class Menu {
    Scanner scanner = new Scanner(System.in);
    int menu;
    AddressBook contactos = new AddressBook();

    private void showMenu(){
        System.out.println("---------------------------------------------------------------------");
        System.out.println("Bienvenido a Contactos, porfavor ingrese una opcion:\n" +
                "(1) Ver contactos \n" +
                "(2) Agregar contacto\n" +
                "(3) Eliminar contacto\n" +
                "(0) Salir");

        System.out.println("---------------------------------------------------------------------");
    }

    public void menuIn() throws IOException {
        boolean isRunning = true;
        do{
            showMenu();
            System.out.print("Ingrese una opcion: ");
            menu = scanner.nextInt();

            switch (menu){
                case 1:
                    System.out.println("Mostrar contactos:");
                    contactos.list();
                    break;

                case 2:
                    System.out.println("Crear contacto:");

                    System.out.print("Ingrese el nombre: ");
                    var nombre = scanner.next();

                    System.out.print("Ingrese el telefono: ");
                    var telefono = scanner.next();

                    contactos.create(nombre, telefono);

                    System.out.println("Contacto Guardado");

                    break;

                case 3:
                    System.out.println("Eliminar contacto:");
                    System.out.print("Ingrese el teléfono que desea eliminar: ");
                    var deleteTel = scanner.next();
                    contactos.delete(deleteTel);

                    System.out.println("Contacto eliminado");
                    break;


                case 0:
                    System.out.println("Vuelva pronto");
                    isRunning = false;
                    break;
            }

        }while (isRunning);
    }

}
