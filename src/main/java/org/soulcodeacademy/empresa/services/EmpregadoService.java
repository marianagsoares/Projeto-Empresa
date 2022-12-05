package org.soulcodeacademy.empresa.services;


import org.soulcodeacademy.empresa.domain.Empregado;
import org.soulcodeacademy.empresa.domain.Endereco;
import org.soulcodeacademy.empresa.domain.Projeto;
import org.soulcodeacademy.empresa.domain.dto.EmpregadoDTO;
import org.soulcodeacademy.empresa.repositories.DependenteRepository;
import org.soulcodeacademy.empresa.repositories.EmpregadoRepository;
import org.soulcodeacademy.empresa.repositories.ProjetoRepository;
import org.soulcodeacademy.empresa.services.errors.ParametrosInsuficientesError;
import org.soulcodeacademy.empresa.services.errors.RecursoNaoEncontradoError;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmpregadoService {
    @Autowired
    private EmpregadoRepository empregadoRepository; //EU QUERO FAZER OPERAÇÕES NO BANCO COM EMPREGADO

    @Autowired
    private DependenteRepository dependenteRepository;

    @Autowired
    private ProjetoService projetoService; //EU SO QUERO IDENTIFICAR O PROJETO NO BANCO

    @Autowired
    private EnderecoService enderecoService; //EU SO QUERO IDENTIFICAR O ENDERECO NO BANCO

    //Listar todos os empregados
    public List<Empregado> listarEmpregados(){
        return this.empregadoRepository.findAll();
    }

    //Listar empregados por ID

    public Empregado getEmpregadoById(Integer idEmpregado){
        Optional<Empregado> empregado = this.empregadoRepository.findById(idEmpregado);

        if(empregado.isEmpty()){
            throw new RecursoNaoEncontradoError("O Empregado não foi encontrado!");
        }
        else{
            return empregado.get();
        }
    }

    //Criar novo empregado
    public Empregado gerarEmpregado(EmpregadoDTO dto){ //Crio um novo empregado passando os dados no corpo da requisicao
        Endereco endereco = this.enderecoService.getEndereco(dto.getIdEndereco());

        Empregado empregado = new Empregado(null, dto.getNome(), dto.getEmail(), dto.getSalario());
        empregado.setEndereco(endereco);

        Empregado novoEmpregado = this.empregadoRepository.save(empregado);
        return novoEmpregado;
    }


    //Atualizar empregado
    public Empregado atualizarEmpregado(Integer idEmpregado, EmpregadoDTO dto){

        if(dto.getIdEndereco() == null){
            throw new ParametrosInsuficientesError("idEndereco é obrigatório");
        }else{
            Empregado empregadoDadosAtuais = this.getEmpregadoById(idEmpregado);
            Endereco endereco = this.enderecoService.getEndereco(dto.getIdEndereco());

            empregadoDadosAtuais.setNome(dto.getNome());
            empregadoDadosAtuais.setEmail(dto.getEmail());
            empregadoDadosAtuais.setSalario(dto.getSalario());
            empregadoDadosAtuais.setEndereco(endereco);

            Empregado empregadoAtualizado = this.empregadoRepository.save(empregadoDadosAtuais);
            return empregadoAtualizado;
        }
    }

    //Remover projeto de empregado
    public Empregado removerProjeto(Integer idEmpregado, Integer idProjeto){
        Empregado empregado = this.getEmpregadoById(idEmpregado);
        Projeto projeto = this.projetoService.getProjeto(idProjeto);

        return this.empregadoRepository.save(empregado);
    }

    //Adicionar projeto a empregado

    public Empregado adicionarProjeto(Integer idEmpregado, Integer idProjeto){
        Empregado empregado = this.getEmpregadoById(idEmpregado);
        Projeto projeto = this.projetoService.getProjeto(idProjeto);

        empregado.getProjetos().add(projeto);

        return  this.empregadoRepository.save(empregado);
    }

    //Deletar Empregado
    public void deletarEmpregado(Integer idEmpregado){

        Empregado empregado = this.getEmpregadoById(idEmpregado);
        empregado.setProjetos(null);

        this.dependenteRepository.deleteDependentes(idEmpregado);
        this.empregadoRepository.delete(empregado);
    }

}
