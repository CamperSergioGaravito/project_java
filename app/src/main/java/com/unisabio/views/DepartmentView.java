package com.unisabio.views;

import com.unisabio.Main;
import com.unisabio.exceptions.department.DepartamentoNullException;
import com.unisabio.repository.models.models_extends.Department;

public class DepartmentView {
    private static final int SALIR = 6;

    private DepartmentView() {}

    private static int mostrarMenu() {
        System.out.println("\n");
        System.out.println("MENU DEPARTAMENTO");
        System.out.println("\n");
        System.out.println("1) Crear departamento");
        System.out.println("2) Listar departamento");
        System.out.println("3) Buscar departamento");
        System.out.println("4) Modificar departamento");
        System.out.println("5) Eliminar departamento");
        System.out.println("6) Salir");
        System.out.println("\n");
        System.out.print("-> Opción: ");
        return Main.input.nextInt();
    }

    public static void startMenu() {

        int op = 0;

        do {

            op = mostrarMenu();

            switch (op) {
                case 1:
                    crearDepartamento();
                    break;
                case 2:
                    listarDepartamentos();
                    break;
                case 3:
                    buscarDepartamento();
                    break;
                case 4:
                    modificarDepartamento();
                    break;
                case 5:
                    eliminarDepartamento();
                    break;
                case 6:
                    System.out.println("\nSaliendo...\n");

                    try {
                        Thread.sleep(2000); 
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                    break;
                default:
                    System.out.println("Opción no valida");
                    break;
            }

        } while (op != SALIR);
    }

    private static void crearDepartamento(){
        System.out.println("\n");
        System.out.println("Crear Departamento");
        Main.input.nextLine();
        System.out.print("\n-> Nombre departamento: ");
        String name = Main.input.nextLine();
        Department depart = new Department(name);
        Main.departmentServices.crear(depart);
    }

    private static void listarDepartamentos(){
        System.out.println("\n");
        System.out.println("Listar Departamentos");
        System.out.println("\n");
        int cont = 0;
        for (Department depart : Main.departmentServices.listar()) {
            cont += 1;
            System.out.println("\u001B[31m" + cont + ". \u001B[0m" + depart.getNombre());
            System.out.println();
        }
        
    }

    private static void buscarDepartamento(){
        System.out.println("\n");
        System.out.println("Buscar Departamento");
        System.out.print("\n> ID del departamento: ");
        int id = Main.input.nextInt();

        try {
            Department depart = Main.departmentServices.porId(id);
            System.out.println("Se ha encontrado: " + depart.getNombre());
        } catch (DepartamentoNullException e) {
            System.out.println(e.getMessage());
        }

        
    }

    private static void modificarDepartamento(){
        System.out.println("\n");
        System.out.println("Modificar Departamento");
        System.out.print("\n-> ID del departamento: ");
        int id = Main.input.nextInt();

        try {
            Department depart = Main.departmentServices.porId(id);
            Main.input.nextLine();
            System.out.print(" ¿Modificar nombre? si/no: " );
            String siNo = Main.input.nextLine();
            if (siNo.equalsIgnoreCase("si")) {
                System.out.print("\n-> Nombre: ");
                String nuevoNombre = Main.input.nextLine();
                depart.setNombre(nuevoNombre);
                Main.departmentServices.editar(depart,id);
            }
        } catch (DepartamentoNullException e) {
            System.out.println(e.getMessage());
        }

        
    }

    private static void eliminarDepartamento(){
        System.out.println("\n");
        System.out.println("Eliminar Departamento");
        System.out.print("\n-> ID del departamento: ");
        int id = Main.input.nextInt();

        try {
            Department depart = Main.departmentServices.porId(id);
            Main.input.nextLine();
            System.out.print(" ¿Desea eliminar " +depart.getNombre() + "? si/no: " );
            String siNo = Main.input.nextLine();
            if (siNo.equalsIgnoreCase("si")) {
                Main.departmentServices.eliminar(depart,id);
            }
        } catch (DepartamentoNullException e) {
            System.out.println(e.getMessage());
        }
    }
}
