package com.unisabio.services;

import java.util.List;

import com.unisabio.exceptions.department.DepartamentoNullException;
import com.unisabio.repository.models.models_extends.Department;

public interface DepartmentServices {

    List<Department> listar();

    Department porId(int id) throws DepartamentoNullException;

    void crear(Department department);

    void editar(Department department, int id);

    void eliminar(Department department, int id);

}
