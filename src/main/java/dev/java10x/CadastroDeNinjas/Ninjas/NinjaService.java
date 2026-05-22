package dev.java10x.CadastroDeNinjas.Ninjas;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class NinjaService {

    private final NinjaRepository ninjaRepository;

    public NinjaService(NinjaRepository ninjaRepository) {
        this.ninjaRepository = ninjaRepository;
    }

    //Listar todos os meus ninjas
    public List<NinjaModel> listarNinjas(){
        return ninjaRepository.findAll();
    }

    //Listar todos os meus ninjas pelo ID
    public NinjaModel listarNinjaPorID(Long id){
        Optional<NinjaModel> ninjaPorID = ninjaRepository.findById(id);
        return ninjaPorID.orElse(null);
    }

    //Criar ninjas
    public NinjaModel criarNinja(NinjaModel ninja){
        return ninjaRepository.save(ninja);
    }

    //Atualizar ninjas
    public NinjaModel atualizarNinja(Long id, NinjaModel ninjaAtualizado){
        Optional<NinjaModel> ninjaExiste = ninjaRepository.findById(id);

        if (ninjaExiste.isPresent()){
            NinjaModel ninja = ninjaExiste.get();

            if(ninjaAtualizado.getNome() != null){
                ninja.setNome(ninjaAtualizado.getNome());
            }
            if(ninjaAtualizado.getEmail() != null){
                ninja.setEmail(ninjaAtualizado.getEmail());
            }
            if(ninjaAtualizado.getAldeia() != null){
                ninja.setAldeia(ninjaAtualizado.getAldeia());
            }
            if(ninjaAtualizado.getIdade() != null && ninjaAtualizado.getIdade() > 0){
                ninja.setIdade(ninjaAtualizado.getIdade());
            }
            if(ninjaAtualizado.getMissoes() != null){
                ninja.setMissoes(ninjaAtualizado.getMissoes());
            }

            return ninjaRepository.save(ninja);
        }

        return null;
    }

    //Deletar ninjas - É um metodo void
    public void deletarNinjaPorID(Long id){
        ninjaRepository.deleteById(id);
    }
}
