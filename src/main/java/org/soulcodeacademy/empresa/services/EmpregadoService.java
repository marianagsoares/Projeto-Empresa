package org.soulcodeacademy.empresa.services;


import org.soulcodeacademy.empresa.domain.Empregado;
import org.soulcodeacademy.empresa.domain.Endereco;
import org.soulcodeacademy.empresa.domain.Projeto;
import org.soulcodeacademy.empresa.domain.dto.EmpregadoDTO;
import org.soulcodeacademy.empresa.repositories.EmpregadoRepository;
import org.soulcodeacademy.empresa.repositories.ProjetoRepository;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmpregadoService {
    @Autowired
    private EmpregadoRepository empregadoRepository; //EU QUERO FAZER OPERAÇÕES NO BANCO COM EMPREGADO

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
            throw new RuntimeException("O Empregado não foi encontrado!");
        }
        else{
            return empregado.get();
        }
    }

    //Criar novo empregado
    public Empregado gerarEmpregado(EmpregadoDTO dto){ //Crio um novo empregado passando os dados no corpo da requisicao
        Endereco endereco = this.enderecoService.getEndereco(dto.getIdEndereco());
        //para empregado exisitir, endereco precisa exisitir
        // logo eu vejo se já existe um endereco com aquele id no banco
        //se existir eu posso setar aquele endereco no empregado

        Empregado empregado = new Empregado(null, dto.getNome(), dto.getEmail(), dto.getSalario());
        empregado.setEndereco(endereco);
        //uma vez que existe eu crio o novo empregado
        //e alem de passar as propriedades pra ele dentro do consturtor
        //uma vez que eu verifiquei se existe o endereco, eu seto o endereco dentro do empregado

        //so que tudo isso foi com base no dto, e agora que ja passou pelas validacoes do dto
        //eu seto dentro da entidade empregado o novo empregado
        Empregado novoEmpregado = this.empregadoRepository.save(empregado);
        return novoEmpregado;
    }


    //Atualizar empregado
    public Empregado atualizarEmpregado(Integer idEmpregado, EmpregadoDTO dto){
        System.out.println(idEmpregado);
        Empregado empregadoDadosAtuais = this.getEmpregadoById(idEmpregado);
        //se o id do empregado que eu quero atualizar existe

           Endereco endereco = this.enderecoService.getEndereco(dto.getIdEndereco());
           //ele espera receber no corpo da requisicao de atualizar empregado o idendereco
            //verificar qual o idendereco que esta relacionado a aquele empregado

        empregadoDadosAtuais.setNome(dto.getNome());
        empregadoDadosAtuais.setEmail(dto.getEmail());
        empregadoDadosAtuais.setSalario(dto.getSalario());
        empregadoDadosAtuais.setEndereco(endereco);

        Empregado empregadoAtualizado = this.empregadoRepository.save(empregadoDadosAtuais);
        return empregadoAtualizado;
    }

    //Remover projeto de empregado
    public Empregado removerProjeto(Integer idEmpregado, Integer idProjeto){
        Empregado empregado = this.getEmpregadoById(idEmpregado);
        Projeto projeto = this.projetoService.getProjeto(idProjeto);

        empregado.getProjetos().remove(projeto);

        return this.empregadoRepository.save(empregado);
    }

    //Deletar Empregado
    //PRA USAR O DELETE PRECISA PRIMEIRO DELETAR O ENDERECO
    public void deletarEmpregado(Integer idEmpregado){
        Empregado empregado = this.getEmpregadoById(idEmpregado);
        this.empregadoRepository.delete(empregado);
    }


}
