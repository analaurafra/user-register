package com.indomita.user_register.infrastructure.repository;

import com.indomita.user_register.infrastructure.entitys.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {

    Optional<Usuario> findByEmail(String email);

    @Transactional
        //se houver erro não poderá deletar infos
    void deleteByEmail(String email);

}
