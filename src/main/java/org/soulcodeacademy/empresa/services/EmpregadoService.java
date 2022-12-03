package org.soulcodeacademy.empresa.services;


import org.soulcodeacademy.empresa.domain.Dependente;
import org.soulcodeacademy.empresa.domain.Empregado;
import org.soulcodeacademy.empresa.domain.Endereco;
import org.soulcodeacademy.empresa.domain.dto.DependenteDTO;
import org.soulcodeacademy.empresa.domain.dto.EmpregadoDTO;
import org.soulcodeacademy.empresa.repositories.EmpregadoRepository;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmpregadoService {
    @Autowired
    private EmpregadoRepository empregadoRepository;

    @Autowired
    private EnderecoService enderecoService;

    //Listar todos os empregados
    public List<Empregado> listarEmpregados(){
        return this.empregadoRepository.findAll();
    }

    //Listar empregados por ID

    public Empregado getEmpregadoById(Integer idEmpregado){
        Optional<Empregado> empregado = this.empregadoRepository.findById(idEmpregado);

        if(empregado.isEmpty()){
            throw new RuntimeException("O Empregado não foi encontrado!");
        }
        else{
            return empregado.get();
        }
    }

    //Criar novo empregado
    public Empregado gerarEmpregado(EmpregadoDTO dto){
        Endereco endereco = this.enderecoService.getEndereco(dto.getIdEndereco());
        Empregado novoEmpregado = this.empregadoRepository.save(new Empregado(null, dto.getNome(), dto.getEmail(), dto.getSalario()));
        return novoEmpregado;
    }


    //Atualizar empregado
    public Empregado atualizarEmpregado(Integer idEmpregado, EmpregadoDTO dto){

        Empregado empregadoDadosAtuais = this.getEmpregadoById(idEmpregado);

        Endereco endereco = this.enderecoService.getEndereco(dto.getIdEndereco());

        empregadoDadosAtuais.setNome(dto.getNome());
        empregadoDadosAtuais.setEmail(dto.getEmail());
        empregadoDadosAtuais.setSalario(dto.getSalario());
        empregadoDadosAtuais.setEndereco(endereco);

        Empregado empregadoAtualizado = this.empregadoRepository.save(empregadoDadosAtuais);
        return empregadoAtualizado;
    }

    //Deletar Empregado

    public void deletarEmpregado(Integer idEmpregado){
        Empregado empregado = this.getEmpregadoById(idEmpregado);
        this.empregadoRepository.delete(empregado);
    }


}
