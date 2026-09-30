package com.indomita.user_register.controller;

import com.indomita.user_register.business.UsuarioService;
import com.indomita.user_register.infrastructure.entitys.Usuario;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController //uso do padrao Rest
@RequestMapping("/usuario")
@RequiredArgsConstructor //constructor do Lombok


public class UsuarioController {

    //injetando dependencia

    private final UsuarioService usuarioService;

    //gravando dados (Via requisicao http)
    @PostMapping
    public ResponseEntity<Void> salvarUsuario(@RequestBody Usuario usuario){
        usuarioService.salvarUsuario(usuario);
        return ResponseEntity.ok().build();  // no requestbody devemos usar um DTO(Data transfer Object) para transferência de dados
    }

    //lendo os  dados
    @GetMapping
    public ResponseEntity<Usuario> buscarUsuarioPorEmail(@RequestParam String email){ //recebe o email por parâmtro
        return ResponseEntity.ok(usuarioService.buscarUsuarioPorEmail(email));
    }

    // deletar os dados
    @DeleteMapping
    public ResponseEntity<Void> deletarUsuarioPorEmail(@RequestParam String email){
        usuarioService.deletarUsuarioPorEmail(email);
        return ResponseEntity.ok().build();
    }

    // put atualiza todos os campos
    @PutMapping
    public ResponseEntity<Void> atualizarUsuarioPorId(@RequestParam Integer id,
                                                      @RequestBody Usuario usuario) {

        usuarioService.atualizarUsuarioPorId(id, usuario);
        return ResponseEntity.ok().build();
    }

}
