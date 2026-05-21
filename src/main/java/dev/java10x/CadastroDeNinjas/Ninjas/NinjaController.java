package dev.java10x.CadastroDeNinjas.Ninjas;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping
public class NinjaController {

    //Adicionar Ninjas (CREATE)
    @PostMapping("/criarNinja")
    public String criarNinja(){
        return "Ninja criado";
    }

    //Mostrar Ninja por ID (READ)
    @GetMapping("/ninjaID")
    public String mostrarNinjaPorID(){
        return "Ninja apresentado por ID";
    }

    //Mostrar todos os Ninjas (READ)
    @GetMapping("/todosNinjas")
    public String mostrarNinjas(){
        return "Ninjas apresentados";
    }

    //Alterar dados dos Ninjas (UPDATE)
    @PutMapping("/alterarNinjaID")
    public String alterarNinjaPorID(){
        return "Ninja alterado por ID";
    }

    //Deletar Ninja (DELETE)
    @DeleteMapping("/deletarNinjaID")
    public String deletarNinjaPorID(){
        return "Ninja deletador por ID";
    }

}
