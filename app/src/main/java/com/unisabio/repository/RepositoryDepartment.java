package com.unisabio.repository;

import java.util.List;

import com.unisabio.repository.models.models_extends.Department;

public interface RepositoryDepartment {
    
    List<Department> listar();

    Department porId(int id);

    void crear(Department department);

    void editar(Department department, int id);

    void eliminar(Department department, int id);


}
