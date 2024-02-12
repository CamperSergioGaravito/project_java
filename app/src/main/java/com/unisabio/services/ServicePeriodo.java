package com.unisabio.services;

import java.util.List;

import com.unisabio.exceptions.periods.PeriodoNullException;
import com.unisabio.repository.models.models_extends.Periodo;


public interface ServicePeriodo {

    List<Periodo> listar();

    Periodo porId(int id) throws PeriodoNullException;

    void crear(Periodo period);
    
    void editar(Periodo period, int id);
    
    void eliminar(Periodo period, int id);
    
} 
