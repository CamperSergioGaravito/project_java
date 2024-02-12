package com.unisabio.services;

import java.util.List;

import com.unisabio.exceptions.teachers.TeacherNotFound;
import com.unisabio.repository.models.models_extends.Teacher;

public interface TeacherServices {
    
    void crearTeacher(Teacher teacher);

    void actualizarTeacher(Teacher teacher);

    Teacher buscarDocumTeacher(long documento) throws TeacherNotFound;

    List<Teacher> buscarTeachers() throws TeacherNotFound;

    void elimiarTeacher(Teacher teacher);

}
