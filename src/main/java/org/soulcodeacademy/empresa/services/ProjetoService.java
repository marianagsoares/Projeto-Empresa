package org.soulcodeacademy.empresa.services;

import org.soulcodeacademy.empresa.domain.Projeto;
import org.soulcodeacademy.empresa.domain.dto.ProjetoDTO;
import org.soulcodeacademy.empresa.repositories.ProjetoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProjetoService {

    @Autowired
    private ProjetoRepository projetoRepository;

    public List<Projeto> listar(){
        return this.projetoRepository.findAll();
    }

    public Projeto getProjeto(Integer idProjeto){
        return this.projetoRepository.findById(idProjeto).orElseThrow(() -> new RuntimeException("Projeto não encontrado"));
    }

    public Projeto salvar(ProjetoDTO dto){
        Projeto projeto = new Projeto(null, dto.getNome(), dto.getOrcamento(), dto.getDescricao());

        return this.projetoRepository.save(projeto);
    }

    public Projeto atualizar(Integer idProjeto, ProjetoDTO dto){
        Projeto projeto = this.getProjeto(idProjeto);
        projeto.setDescricao(dto.getDescricao());
        projeto.setNome(dto.getNome());
        projeto.setOrcamento(dto.getOrcamento());

        return this.projetoRepository.save(projeto);
    }

    public void deletar(Integer idProjeto){
        Projeto projeto = this.getProjeto(idProjeto);
        this.projetoRepository.delete(projeto);
    }
}