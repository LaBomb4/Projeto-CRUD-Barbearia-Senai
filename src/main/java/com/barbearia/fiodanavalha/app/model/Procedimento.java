package com.barbearia.fiodanavalha.app.model;

import java.io.Serializable;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Procedimento implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy =GenerationType.AUTO)
    private long idProcedimento;
    private String nomeProcedimento;
    private float valor;
    private String descrisao;


    public Procedimento() {
    }


    public long getIdProcedimento() {
        return this.idProcedimento;
    }

    public void setIdProcedimento(long idProcedimento) {
        this.idProcedimento = idProcedimento;
    }

    public String getNomeProcedimento() {
        return this.nomeProcedimento;
    }

    public void setNomeProcedimento(String nomeProcedimento) {
        this.nomeProcedimento = nomeProcedimento;
    }

    public float getValor() {
        return this.valor;
    }

    public void setValor(float valor) {
        this.valor = valor;
    }

    public String getDescrisao() {
        return this.descrisao;
    }

    public void setDescrisao(String descrisao) {
        this.descrisao = descrisao;
    }


}
