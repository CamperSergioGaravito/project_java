package com.unisabio.services;

import java.util.List;

import com.unisabio.exceptions.students.StudentNotFound;
import com.unisabio.repository.models.models_extends.Student;

public interface StudentServices {
    
    void crearStudent(Student student);

    void actualizarStudent(Student student);

    Student buscarDocumStudent(long documento) throws StudentNotFound;

    List<Student> buscarStudents() throws StudentNotFound;

    void elimiarStudent(Student student);

}
