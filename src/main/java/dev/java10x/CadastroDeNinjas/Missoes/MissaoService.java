package dev.java10x.CadastroDeNinjas.Missoes;

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
}
