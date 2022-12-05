package org.soulcodeacademy.empresa.services;

import org.soulcodeacademy.empresa.domain.Dependente;
import org.soulcodeacademy.empresa.domain.Empregado;
import org.soulcodeacademy.empresa.domain.dto.DependenteDTO;
import org.soulcodeacademy.empresa.repositories.DependenteRepository;
import org.soulcodeacademy.empresa.services.errors.ParametrosInsuficientesError;
import org.soulcodeacademy.empresa.services.errors.RecursoNaoEncontradoError;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@Service
public class DependenteService {


    @Autowired
    private DependenteRepository dependenteRepository;

    @Autowired
     private EmpregadoService empregadoService;


    public List<Dependente> listar() {
        return this.dependenteRepository.findAll();
    }

    public Dependente getDependente(Integer idDependente) {

        return  this.dependenteRepository.findById(idDependente)
           .orElseThrow(() -> new RecursoNaoEncontradoError("Chamado não encontrado"));
    }


    public Dependente salvar(DependenteDTO dto){
        Empregado empregado =  this.empregadoService.getEmpregadoById(dto.getIdEmpregado());
        Dependente dependente = new Dependente(null, dto.getNome(), dto.getIdade());
        dependente.setResponsavel(empregado);
        Dependente salvo = this.dependenteRepository.save(dependente);
        return salvo;

    }

    public Dependente atualizar (Integer idDependente, DependenteDTO dto){

        Dependente dependenteAtual =  this.getDependente(idDependente);

        dependenteAtual.setNome(dto.getNome());
        dependenteAtual.setIdade(dto.getIdade());

        if(dto.getIdEmpregado() == null){
            throw new ParametrosInsuficientesError("idEmpregado é obrigatório");

        }else{
            Empregado empregado = this.empregadoService.getEmpregadoById(dto.getIdEmpregado());
            dependenteAtual.setResponsavel(empregado);
        }

        Dependente atualizado = this.dependenteRepository.save(dependenteAtual);
        return atualizado;
    }

    public void deletar(Integer idDependente){
        Dependente dependente = this.getDependente(idDependente);
        this.dependenteRepository.delete(dependente);
    }

}












