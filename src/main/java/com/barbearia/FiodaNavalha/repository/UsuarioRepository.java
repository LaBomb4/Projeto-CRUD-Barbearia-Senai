// Interface responsável por buscar o usuário no banco pelo Login.
package com.barbearia.FiodaNavalha.repository;

import com.barbearia.FiodaNavalha.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario, String>{
    Usuario findByLogin(String login);
}
