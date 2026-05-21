package dev.java10x.CadastroDeNinjas.Missoes;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/missoes")
public class MissaoController {

    private final MissaoService missaoService;

    public MissaoController(MissaoService missaoService) {
        this.missaoService = missaoService;
    }

    //Adicionar Missões (CREATE)
    @PostMapping("/criar")
    public String criarMissao(){
        return "Missao criada";
    }

    //Mostrar Missao por ID (READ)
    @GetMapping("/ID")
    public String mostrarMissaoPorID(){
        return "Missão apresentado por ID";
    }

    //Mostrar todas as Missões (READ)
    @GetMapping("/todas")
    public List<MissaoModel> mostrarMissoes(){
        return missaoService.listarMissoes();
    }

    //Alterar dados das Missões (UPDATE)
    @PutMapping("/alterarPorID")
    public String alterarMissaoPorID(){
        return "Missão alterado por ID";
    }

    //Deletar Missão (DELETE)
    @DeleteMapping("/deletarPorID")
    public String deletarMissaoPorID(){
        return "Missão deletada por ID";
    }


}
