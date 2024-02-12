package com.unisabio.services.student_services;

import java.util.List;

import com.unisabio.exceptions.errors.StudentErr;
import com.unisabio.exceptions.students.StudentNotFound;
import com.unisabio.repository.RepositoryStudent;
import com.unisabio.repository.models.models_extends.Student;
import com.unisabio.services.StudentServices;

public class StudentServicesImpl implements StudentServices {
    private final RepositoryStudent repositoryStudent;

    public StudentServicesImpl(RepositoryStudent repositoryStudent) {
        this.repositoryStudent = repositoryStudent;
    }

    @Override
    public void crearStudent(Student student) {
        this.repositoryStudent.crearStudent(student);
    }

    @Override
    public Student buscarDocumStudent(long documento) throws StudentNotFound {
        Student student = this.repositoryStudent.buscarDocumStudent(documento);

        if(student != null) {
            return student;
        }
        else {
            throw new StudentNotFound(StudentErr.notFound());
        }
    }

    @Override
    public List<Student> buscarStudents() throws StudentNotFound {
        List<Student> students = this.repositoryStudent.buscarStudents();

        if (students != null && !students.isEmpty()) {
            return students;
        }
        else {
            throw new StudentNotFound(StudentErr.notFoundStudents());
        }
}

    @Override
    public void actualizarStudent(Student student) {
        this.repositoryStudent.actualizarStudent(student);
    }

    @Override
    public void elimiarStudent(Student student) {
        this.repositoryStudent.elimiarStudent(student);
    }
    
}
