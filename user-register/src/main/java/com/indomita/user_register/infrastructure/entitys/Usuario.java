package com.indomita.user_register.infrastructure.entitys;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "Usuario") //Não existe tabela sem ID
@Entity

public class Usuario { //private não repete o nome, e-mail e telefone
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(name ="email", unique = true)
    private String email;

    @Column(name = "name")
    private String nome;

}


