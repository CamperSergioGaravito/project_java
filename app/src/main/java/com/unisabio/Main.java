package com.unisabio;

import java.util.Scanner;

import com.unisabio.exceptions.errors.ErrorU;
import com.unisabio.repository.repo_mysql.department.RepoDepartImpl;
import com.unisabio.repository.repo_mysql.period.RepositoryPeriodoMysqlImpl;
import com.unisabio.repository.repo_mysql.student.RepoStudentImpl;
import com.unisabio.repository.repo_mysql.teacher.RepoTeacherImpl;
import com.unisabio.services.DepartmentServices;
import com.unisabio.services.ServicePeriodo;
import com.unisabio.services.StudentServices;
import com.unisabio.services.TeacherServices;
import com.unisabio.services.department_services.ServiceDepartamentoImpl;
import com.unisabio.services.period_services.ServicePeriodoImpl;
import com.unisabio.services.student_services.StudentServicesImpl;
import com.unisabio.services.teacher_services.TeacherServicesImpl;
import com.unisabio.views.AdminView;
import com.unisabio.views.DepartmentView;
import com.unisabio.views.ViewPeriodo;

public class Main {

    // Services
    public static final StudentServices studentServices = new StudentServicesImpl(new RepoStudentImpl());
    public static final TeacherServices teacherServices = new TeacherServicesImpl(new RepoTeacherImpl());
    public static final DepartmentServices departmentServices = new ServiceDepartamentoImpl(new RepoDepartImpl());
    public static final ServicePeriodo servicePeriodo = new ServicePeriodoImpl(new RepositoryPeriodoMysqlImpl());

    public static final Scanner input = new Scanner(System.in);
    private static final int EXIT = 6;

    public static int menuPrincipal() {
        System.out.println(
            " \u001B[34m\n-----------------------------\n" +
            "|            MENU           |\n" +
            "|                           |\n" +
            "|  1) Rol Administrador     |\n" +
            "|  2) Rol Profesor          |\n" +
            "|  3) Rol Estudiante        |\n" +
            "|  4) Departamentos         |\n" +
            "|  5) Periodos              |\n" +
            "|  "+EXIT+") Salir                 |\n" +
            "|                           |\n" +
            "-----------------------------"
        );
        // Selecciona el rol
        System.out.println("\n@ Selecciona una opción:");
        System.out.print("    > ");
        return input.nextInt();

    }
    public static void main(String[] args) {

        int sel = 0;
        
        do {
            try {                
                sel = menuPrincipal();

                switch (sel) {
                    case 1:
                        AdminView.adminInit();
                        break;

                    case 4:
                        DepartmentView.startMenu();
                        break;

                    case 5:
                        ViewPeriodo.startMenu();
                        break;

                    case EXIT:
                        System.out.println("\n  Adios!!\n");
                        break;
                
                    default:
                        break;
                }

            } catch (Exception e) {
                ErrorU.errorNum();
                input.nextLine();
            }
            
        } while (sel != EXIT);

    }
}