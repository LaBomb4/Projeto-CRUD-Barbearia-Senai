// Interface responsável por buscar o usuário no banco pelo Login.
package com.barbearia.fiodanavalha.app.repository;

import com.barbearia.fiodanavalha.app.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario, String>{
    Usuario findByLogin(String login);

    Usuario findByUsername(String username);
}
