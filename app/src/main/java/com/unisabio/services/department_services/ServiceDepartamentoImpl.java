package com.unisabio.services.department_services;

import java.util.List;

import com.unisabio.exceptions.department.DepartamentoNullException;
import com.unisabio.repository.RepositoryDepartment;
import com.unisabio.repository.models.models_extends.Department;
import com.unisabio.services.DepartmentServices;

public class ServiceDepartamentoImpl implements DepartmentServices {
     private final RepositoryDepartment crudRepositoryDepartamento;

    public ServiceDepartamentoImpl(RepositoryDepartment crudRepositoryDepartamento){
        this.crudRepositoryDepartamento = crudRepositoryDepartamento;
    }
    
    @Override
    public List<Department> listar() {
        return this.crudRepositoryDepartamento.listar();
    }

    @Override
    public Department porId(int id) throws DepartamentoNullException {
        Department depart = this.crudRepositoryDepartamento.porId(id);

        if (depart!=null) {
            return depart;
        }else{
            throw new DepartamentoNullException("Vaya! no se ha encontrado el departamento solicitado");
        }
    }

    @Override
    public void crear(Department depart) {
        this.crudRepositoryDepartamento.crear(depart);
    }

    @Override
    public void editar(Department depart, int id) {
        this.crudRepositoryDepartamento.editar(depart,id);
    }

    @Override
    public void eliminar(Department depart, int id) {
        this.crudRepositoryDepartamento.eliminar(depart,id);
    }
}
