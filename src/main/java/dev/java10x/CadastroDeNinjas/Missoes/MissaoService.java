package dev.java10x.CadastroDeNinjas.Missoes;

import dev.java10x.CadastroDeNinjas.Ninjas.NinjaModel;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class MissaoService {

    private final MissaoRepository missaoRepository;
    private final MissaoMapper missaoMapper;

    public MissaoService(MissaoRepository missaoRepository, MissaoMapper missaoMapper) {
        this.missaoRepository = missaoRepository;
        this.missaoMapper = missaoMapper;
    }

    //Listar todas as Missões
    public List<MissaoDTO> listarMissoes(){
        List<MissaoModel> missoes = missaoRepository.findAll();
        return missoes.stream()
                .map(missaoMapper::map)
                .collect(Collectors.toList());
    }

    //Listar todas as missões por ID
    public MissaoDTO listarMissaoPorID(Long id){
        Optional<MissaoModel> missaoPorID = missaoRepository.findById(id);
        return missaoPorID.map(missaoMapper::map).orElse(null);
    }

    //Criar missão
    public MissaoDTO criarMissao(MissaoDTO missaoDTO){
        MissaoModel missao = missaoMapper.map(missaoDTO);
        missao = missaoRepository.save(missao);
        return missaoMapper.map(missao);
    }

    //Atualizar Missao
    public MissaoDTO atualizarMissao(Long id, MissaoDTO missaoDTO){
        Optional<MissaoModel> missaoExistente = missaoRepository.findById(id);

        if (missaoExistente.isPresent()){

            MissaoModel missaoAtualizada = missaoExistente.get();

            missaoAtualizada.setNome(Objects.requireNonNullElse(missaoDTO.getNome(), missaoAtualizada.getNome()));
            missaoAtualizada.setDificuldade(Objects.requireNonNullElse(missaoDTO.getDificuldade(), missaoAtualizada.getDificuldade()));
            missaoAtualizada.setNinjas(Objects.requireNonNullElse(missaoDTO.getNinjas(), missaoAtualizada.getNinjas()));
        }

        return null;
    }

    //Deletar Missao
    public void deletarMissaoPorID(Long id){
        missaoRepository.deleteById(id);
    }
}
