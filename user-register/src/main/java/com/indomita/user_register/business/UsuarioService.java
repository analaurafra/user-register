package com.indomita.user_register.business;

import com.indomita.user_register.infrastructure.entitys.Usuario;
import com.indomita.user_register.infrastructure.repository.UsuarioRepository;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService {

    // Metodo de Salvar Usuario
    private final UsuarioRepository repository;

    public UsuarioService(UsuarioRepository repository){
        this.repository = repository;
    }

    public void salvarUsuario(Usuario usuario) {
        repository.saveAndFlush(usuario);

    }
        // Metodo de Buscar Usuario por Email

    public Usuario buscarUsuarioPorEmail(String email){

        return repository.findByEmail(email).orElseThrow(
                () -> new RuntimeException("Email não encontrado") //excessoes personalizadas
        );
    }

    // Metodo de Deletar Usário por Email

    public void deletarUsuarioPorEmail(String email){
        repository.deleteByEmail(email);

    }

    // Metodo atualização de dados(Update) sem sobscrever os dados já existente do banco de dados
    // O get é o meu read

    public void atualizarUsuarioPorId(Integer id, Usuario usuario){
        Usuario usuarioEntity = repository.findById(id).orElseThrow(() ->
                new RuntimeException("Usuario Não Encontrado"));
        Usuario usuarioAtualizado = Usuario.builder()
                .email(usuario.getEmail() != null ? // usuario diferente de nulo?
                        usuario.getEmail() : usuarioEntity.getEmail()) //preencho meu email com usario.getmail, senão preencho com usuarioentity
                .nome(usuario.getNome() != null?
                        usuario.getNome() : usuarioEntity.getNome())
                .id(usuarioEntity.getId())
                .build();
        repository.saveAndFlush(usuarioAtualizado);

    }

}