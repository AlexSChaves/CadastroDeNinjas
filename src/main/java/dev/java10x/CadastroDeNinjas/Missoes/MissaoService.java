package dev.java10x.CadastroDeNinjas.Missoes;

import dev.java10x.CadastroDeNinjas.Ninjas.NinjaModel;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MissaoService {

    private final MissaoRepository missaoRepository;

    public MissaoService(MissaoRepository missaoRepository) {
        this.missaoRepository = missaoRepository;
    }

    //Listar todas as Missões
    public List<MissaoModel> listarMissoes(){
        return missaoRepository.findAll();
    }

    //Listar todas as missões por ID
    public MissaoModel listarMissaoPorID(Long id){
        Optional<MissaoModel> missaoPorID = missaoRepository.findById(id);
        return missaoPorID.orElse(null);
    }

    //Criar missão
    public MissaoModel criarMissao(MissaoModel missao){
        return missaoRepository.save(missao);
    }

    //Atualizar Missao
    public MissaoModel atualizarMissao(Long id, MissaoModel missaoAtualizado){
        Optional<MissaoModel> missaoExiste = missaoRepository.findById(id);

        if (missaoExiste.isPresent()){
            MissaoModel missao = missaoExiste.get();

            if(missaoAtualizado.getNome() != null){
                missao.setNome(missaoAtualizado.getNome());
            }
            if(missaoAtualizado.getDificuldade() != null){
                missao.setDificuldade(missaoAtualizado.getDificuldade());
            }


            return missaoRepository.save(missao);
        }

        return null;
    }

    //Deletar Missao
    public void deletarMissaoPorID(Long id){
        missaoRepository.deleteById(id);
    }
}
