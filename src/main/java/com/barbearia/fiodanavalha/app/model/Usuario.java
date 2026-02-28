package com.barbearia.fiodanavalha.app.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.Collections;

@Entity
public class Usuario implements UserDetails{
    @Id
    private String login; // O login será o ID (chave primária)
    private String nomeCompleto;
    private String senha;

    public Usuario(){

    }

    public String getLogin() {
        return this.login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getNomeCompleto() {
        return this.nomeCompleto;
    }

    public void setNomeCompleto(String nomeCompleto) {
        this.nomeCompleto = nomeCompleto;
    }

    public String getSenha() {
        return this.senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    // Métodos da interface UserDetails
    @Override
    public Collection<? extends GrantedAuthority>getAuthorities(){
        return Collections.emptyList();
    }

    @Override
    public String getUsername(){
        return this.login; // Retorna o login come "nome de usuário"
    }

    @Override
    public boolean isAccountNonExpired(){
        return true;
    }

    @Override
    public boolean isAccountNonLocked(){
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired(){
        return true;
    }

    @Override
    public boolean isEnabled(){
        return true;
    }
}
