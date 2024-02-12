package com.unisabio.repository;

import java.util.List;

import com.unisabio.repository.models.models_extends.Periodo;

public interface RepositoryPeriodo {
    
    List<Periodo> listar();

    Periodo porId(int id);

    void crear(Periodo periodo);

    void editar(Periodo periodo, int id);

    void eliminar(Periodo periodo, int id);
    
} 