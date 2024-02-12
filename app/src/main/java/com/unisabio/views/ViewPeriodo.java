package com.unisabio.views;

import com.unisabio.Main;
import com.unisabio.exceptions.errors.ErrorU;
import com.unisabio.exceptions.periods.PeriodoNullException;
import com.unisabio.repository.models.models_extends.Periodo;

public class ViewPeriodo {
    
    private static final int SALIR = 6;

    private ViewPeriodo() {}

    public static void startMenu() {

        int op = 0;

        do {

            op = mostrarMenu();

            switch (op) {
                case 1:
                    crearPeriodo();
                    break;
                case 2:
                    listarPeriodoes();
                    break;
                case 3:
                    buscarPeriodo();
                    break;
                case 4:
                    modificarPeriodo();
                    break;
                case 5:
                    eliminarPeriodo();
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
                    ErrorU.errorInvalid();
                    break;
            }

        } while (op != SALIR);
    }

    private static void crearPeriodo(){
        System.out.println("\n");
        System.out.println("Crear Periodo");
        Main.input.nextLine();
        System.out.print("\n-> Año del periodo: ");
        String name = Main.input.nextLine();
        System.out.print("\n-> Semestre: ");
        int cat = Main.input.nextInt();
        Periodo periodo = new Periodo(name, cat);
        Main.servicePeriodo.crear(periodo);
    }

    private static void listarPeriodoes(){
        System.out.println("\n");
        System.out.println("Listar Periodos");
        System.out.println("\n");
        int cont = 0;
        for (Periodo Periodo : Main.servicePeriodo.listar()) {
            cont += 1;
            System.out.println("\u001B[31m" + cont + ". \u001B[0m");
            Periodo.imprimirPeriodo();
            System.out.println();
        }
        
    }

    private static void buscarPeriodo(){
        System.out.println("\n");
        System.out.println("Buscar Periodo");
        System.out.print("\n> ID del Periodo: ");
        int id = Main.input.nextInt();

        try {
            Periodo periodo = Main.servicePeriodo.porId(id);
            System.err.println("\nBuscando...\n");
            
            try {
                Thread.sleep(1000); 
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println("Se ha encontrado: ");
            periodo.imprimirPeriodo();

        } catch (PeriodoNullException e) {
            System.out.println(e.getMessage());
        }

        
    }

    private static void modificarPeriodo(){
        System.out.println("\n");
        System.out.println("Modificar Periodo");
        System.out.print("\n-> ID del Periodo: ");
        int id = Main.input.nextInt();

        try {
            Periodo periodo = Main.servicePeriodo.porId(id);
            periodo.imprimirPeriodo();
            Main.input.nextLine();
            
            System.out.print(" ¿Modificar año? si/no: " );
            String siNo = Main.input.nextLine();
            
            if (siNo.equalsIgnoreCase("si")) {
                System.out.print("\n-> Año del periodo: ");
                String nuevoNombre = Main.input.nextLine();
                periodo.setAnio(nuevoNombre);
            }
            
            System.out.println("¿Modificar Semestre? si/no: ");
            siNo = Main.input.nextLine();

            if (siNo.equalsIgnoreCase("si")) {
                System.out.println("-> Semestre: : ");
                int cat = Main.input.nextInt();
                periodo.setSemestre(cat);
            }

            Main.servicePeriodo.editar(periodo,id);
        } catch (PeriodoNullException e) {
            System.out.println(e.getMessage());
        }

        
    }

    private static void eliminarPeriodo(){
        System.out.println("\n");
        System.out.println("Eliminar Periodo");
        System.out.print("\n-> ID del Periodo: ");
        int id = Main.input.nextInt();

        try {
            Periodo periodo = Main.servicePeriodo.porId(id);
            Main.input.nextLine();
            System.out.print(" ¿Desea eliminar el Periodo " +periodo.getCod() + "? si/no: " );
            String siNo = Main.input.nextLine();
            if (siNo.equalsIgnoreCase("si")) {
                Main.servicePeriodo.eliminar(periodo,id);
            }
        } catch (PeriodoNullException e) {
            System.out.println(e.getMessage());
        }
        
    }

    private static int mostrarMenu() {

        System.out.println("\n");
        System.out.println("MENU PERIODO");
        System.out.println("\n");
        System.out.println("1) Crear periodo");
        System.out.println("2) Listar periodos");
        System.out.println("3) Buscar periodo");
        System.out.println("4) Modificar periodo");
        System.out.println("5) Eliminar periodo");
        System.out.println("6) Salir");
        System.out.println("\n");
        System.out.print("> Opcion: ");
        return Main.input.nextInt();

    }
}
