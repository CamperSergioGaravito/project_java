package com.unisabio.exceptions.errors;

public class TeacherErr {
    
    private TeacherErr(){}

    public static String notFound() {
        
        String message =  
            "\u001B[31m\nxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx\n" +
            "|                                             |\n" +
            "|   ERROR: Estudiante no encontrado!!         |\n" +
            "|                                             |\n" +
            "xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx";

        return message;
        
    }

    public static String notFoundTeachers() {
        
        String message =  
            "\u001B[31m\nxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx\n" +
            "|                                             |\n" +
            "|   ERROR: No se ha encontrado ningún         |\n" +
            "|          estudiante!!                       |\n" +
            "|                                             |\n" +
            "xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx";

        return message;
        
    }

}
