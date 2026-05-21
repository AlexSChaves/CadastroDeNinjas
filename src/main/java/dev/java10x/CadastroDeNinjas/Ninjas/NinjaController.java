package dev.java10x.CadastroDeNinjas.Ninjas;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("ninjas")
public class NinjaController {

    //Adicionar Ninjas (CREATE)
    @PostMapping("/criar")
    public String criarNinja(){
        return "Ninja criado";
    }

    //Mostrar Ninja por ID (READ)
    @GetMapping("/ID")
    public String mostrarNinjaPorID(){
        return "Ninja apresentado por ID";
    }

    //Mostrar todos os Ninjas (READ)
    @GetMapping("/todos")
    public String mostrarNinjas(){
        return "Ninjas apresentados";
    }

    //Alterar dados dos Ninjas (UPDATE)
    @PutMapping("/alterarPorID")
    public String alterarNinjaPorID(){
        return "Ninja alterado por ID";
    }

    //Deletar Ninja (DELETE)
    @DeleteMapping("/deletarPorID")
    public String deletarNinjaPorID(){
        return "Ninja deletador por ID";
    }

}
