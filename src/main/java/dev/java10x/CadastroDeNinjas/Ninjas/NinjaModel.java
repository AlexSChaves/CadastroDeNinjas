package dev.java10x.CadastroDeNinjas.Ninjas;

import dev.java10x.CadastroDeNinjas.Missoes.MissaoModel;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "tb_cadastro")
@NoArgsConstructor //Construtor sem argumentos
@AllArgsConstructor //Construtor com todos os argumentos
@Data //Getters, Setters e ToString

public class NinjaModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "nome")
    private String nome;

    @Column(unique = true)
    private String email;

    @Column(name = "aldeia")
    private String aldeia;

    @Column(name = "idade")
    private int idade;

    //@ManyToOne um ninja para uma única missão
    @ManyToOne
    @JoinColumn(name="missoes_id")
    private MissaoModel missoes;


}
