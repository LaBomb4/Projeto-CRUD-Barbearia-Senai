package com.barbearia.fiodanavalha.app.repository;

import org.springframework.data.repository.CrudRepository;

import com.barbearia.fiodanavalha.app.model.Agendamento;

public interface AgendamentoRepository extends CrudRepository<Agendamento, String> {
    Agendamento findByIdAgendamento(long idAgendamento);
    Agendamento deleteByIdAgendamento(long idAgendamento);
}