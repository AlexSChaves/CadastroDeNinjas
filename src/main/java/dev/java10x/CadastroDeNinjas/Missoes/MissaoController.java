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
    public MissaoModel criarMissao(@RequestBody MissaoModel missao){
        return missaoService.criarMissao(missao);
    }

    //Mostrar Missao por ID (READ)
    @GetMapping("/listar/{id}")
    public MissaoModel listarMissaoPorID(@PathVariable Long id){
        return missaoService.listarMissaoPorID(id);
    }

    //Mostrar todas as Missões (READ)
    @GetMapping("/listar")
    public List<MissaoModel> mostrarMissoes(){
        return missaoService.listarMissoes();
    }

    //Alterar dados das Missões (UPDATE)
    @PatchMapping("/atualizar/{id}")
    public MissaoModel atualizarMissao(@PathVariable Long id, @RequestBody MissaoModel missaoAtualizado){
        return missaoService.atualizarMissao(id, missaoAtualizado);
    }

    //Deletar Missão (DELETE)
    @DeleteMapping("/deletar/{id}")
    public void deletarMissaoPorID(@PathVariable Long id){
        missaoService.deletarMissaoPorID(id);
    }
}
