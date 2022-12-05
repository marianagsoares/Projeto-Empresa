package org.soulcodeacademy.empresa.services;

import org.soulcodeacademy.empresa.domain.Endereco;
import org.soulcodeacademy.empresa.domain.dto.EnderecoDTO;
import org.soulcodeacademy.empresa.repositories.EnderecoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class EnderecoService {

    @Autowired
    private EnderecoRepository enderecoRepository;

    public List<Endereco> lista() {
        return this.enderecoRepository.findAll();
    }

    public Endereco getEndereco(Integer idEndereco){
        Optional<Endereco> endereco = this.enderecoRepository.findById(idEndereco);
        if (endereco.isEmpty()) {
            throw new RuntimeException("O endereço não foi encontrado!");
        } else {
            return endereco.get();
        }
    }
    public Endereco salvar(EnderecoDTO dto) {
        Endereco novoEndereco = new Endereco(null, dto.getCidade(), dto.getUf());
        return this.enderecoRepository.save(novoEndereco);

    }
    public Endereco atulizar(Integer idEndereco, EnderecoDTO dto){
        Endereco enderecoAtual = this.getEndereco(idEndereco);

        enderecoAtual.setUf(dto.getUf());
        enderecoAtual.setCidade(dto.getCidade());

        Endereco atualizado = this.enderecoRepository.save(enderecoAtual);
        return  atualizado;
    }
    public void deletar(Integer idEndereco){
        Endereco endereco = this.getEndereco(idEndereco);
        this.enderecoRepository.delete(endereco);
    }
}
