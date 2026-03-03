package com.barbearia.fiodanavalha.app.repository;

import org.springframework.data.repository.CrudRepository;

import com.barbearia.fiodanavalha.app.model.Procedimento;

public interface ProcedimentoRepository extends CrudRepository<Procedimento, String> {
    Procedimento findByIdProcedimento(long idProcedimento);
    Procedimento deleteByIdProcedimento(long idProcedimento);
}