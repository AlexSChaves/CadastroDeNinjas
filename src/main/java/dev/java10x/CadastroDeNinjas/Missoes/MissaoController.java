package dev.java10x.CadastroDeNinjas.Missoes;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping
public class MissaoController {

    //Adicionar Missões (CREATE)
    @PostMapping("/criarMissao")
    public String criarMissao(){
        return "Missao criada";
    }

    //Mostrar Missao por ID (READ)
    @GetMapping("/missaoID")
    public String mostrarMissaoPorID(){
        return "Missão apresentado por ID";
    }

    //Mostrar todos as Missões (READ)
    @GetMapping("/todasMissoes")
    public String mostrarMissoes(){
        return "Missões apresentadas";
    }

    //Alterar dados das Missões (UPDATE)
    @PutMapping("/alterarMissaoID")
    public String alterarMissaoPorID(){
        return "Missão alterado por ID";
    }

    //Deletar Missão (DELETE)
    @DeleteMapping("/deletarMissaoID")
    public String deletarMissaoPorID(){
        return "Missão deletada por ID";
    }


}
