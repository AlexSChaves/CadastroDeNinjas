package dev.java10x.CadastroDeNinjas.Ninjas;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class NinjaService {

    private final NinjaRepository ninjaRepository;
    private final NinjaMapper ninjaMapper;

    public NinjaService(NinjaRepository ninjaRepository, NinjaMapper ninjaMapper) {
        this.ninjaRepository = ninjaRepository;
        this.ninjaMapper = ninjaMapper;
    }

    //Listar todos os meus ninjas
    public List<NinjaDTO> listarNinjas(){
        List<NinjaModel> ninjas = ninjaRepository.findAll();
        return ninjas.stream()
                .map(ninjaMapper::map)
                .collect(Collectors.toList());
    }

    //Listar todos os meus ninjas pelo ID
    public NinjaDTO listarNinjaPorID(Long id){
        Optional<NinjaModel> ninjaPorID = ninjaRepository.findById(id);
        return ninjaPorID.map(ninjaMapper::map).orElse(null);
    }

    //Criar ninjas
    public NinjaDTO criarNinja(NinjaDTO ninjaDTO){
        NinjaModel ninja = ninjaMapper.map(ninjaDTO);
        ninja = ninjaRepository.save(ninja);
        return ninjaMapper.map(ninja);
    }

    //Atualizar ninjas
    public NinjaDTO atualizarNinja(Long id, NinjaDTO ninjaDTO){
        Optional<NinjaModel> ninjaExistente = ninjaRepository.findById(id);

        if(ninjaExistente.isPresent()){
//            NinjaModel ninjaAtualizado = ninjaMapper.map(ninjaDTO);
//            ninjaAtualizado.setId(id);
//
            NinjaModel ninjaAtualizado = ninjaExistente.get();

            ninjaAtualizado.setNome(Objects.requireNonNullElse(ninjaDTO.getNome(), ninjaAtualizado.getNome()));
            ninjaAtualizado.setEmail(Objects.requireNonNullElse(ninjaDTO.getEmail(), ninjaAtualizado.getEmail()));
            ninjaAtualizado.setAldeia(Objects.requireNonNullElse(ninjaDTO.getAldeia(), ninjaAtualizado.getAldeia()));
            ninjaAtualizado.setIdade(Objects.requireNonNullElse(ninjaDTO.getIdade(), ninjaAtualizado.getIdade()));
            ninjaAtualizado.setRank(Objects.requireNonNullElse(ninjaDTO.getRank(), ninjaAtualizado.getRank()));
            ninjaAtualizado.setMissoes(Objects.requireNonNullElse(ninjaDTO.getMissoes(), ninjaAtualizado.getMissoes()));

            NinjaModel ninjaSalvo = ninjaRepository.save(ninjaAtualizado);


            return ninjaMapper.map(ninjaSalvo);
        }

        return null;

    }

    //Deletar ninjas - É um metodo void
    public void deletarNinjaPorID(Long id){
        ninjaRepository.deleteById(id);
    }
}
