package com.unisabio.services.teacher_services;

import java.util.List;

import com.unisabio.exceptions.errors.TeacherErr;
import com.unisabio.exceptions.teachers.TeacherNotFound;
import com.unisabio.repository.RepositoryTeacher;
import com.unisabio.repository.models.models_extends.Teacher;
import com.unisabio.services.TeacherServices;

public class TeacherServicesImpl implements TeacherServices {
    private final RepositoryTeacher repositoryTeacher;

    public TeacherServicesImpl(RepositoryTeacher repositoryTeacher) {
        this.repositoryTeacher = repositoryTeacher;
    }

    @Override
    public void crearTeacher(Teacher teacher) {
        this.repositoryTeacher.crearTeacher(teacher);
    }

    @Override
    public Teacher buscarDocumTeacher(long documento) throws TeacherNotFound {
        Teacher teacher = this.repositoryTeacher.buscarDocumTeacher(documento);

        if(teacher != null) {
            return teacher;
        }
        else {
            throw new TeacherNotFound(TeacherErr.notFound());
        }
    }

    @Override
    public List<Teacher> buscarTeachers() throws TeacherNotFound {
        List<Teacher> teachers = this.repositoryTeacher.buscarTeachers();

        if (teachers != null && !teachers.isEmpty()) {
            return teachers;
        }
        else {
            throw new TeacherNotFound(TeacherErr.notFoundTeachers());
        }
}

    @Override
    public void actualizarTeacher(Teacher teacher) {
        this.repositoryTeacher.actualizarTeacher(teacher);
    }

    @Override
    public void elimiarTeacher(Teacher teacher) {
        this.repositoryTeacher.elimiarTeacher(teacher);
    }
    
}
