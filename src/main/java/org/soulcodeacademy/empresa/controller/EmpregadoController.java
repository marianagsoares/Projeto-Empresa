package org.soulcodeacademy.empresa.controller;

import org.soulcodeacademy.empresa.domain.Empregado;
import org.soulcodeacademy.empresa.domain.Endereco;
import org.soulcodeacademy.empresa.domain.dto.EmpregadoDTO;
import org.soulcodeacademy.empresa.services.EmpregadoService;
import org.soulcodeacademy.empresa.services.EnderecoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class EmpregadoController {

    @Autowired
    private EmpregadoService empregadoService;

    @Autowired
    private EnderecoService enderecoService;

    //listar todos os empregados
    @GetMapping("/empregados")
    public List<Empregado> listarEmpregados(){
        return this.empregadoService.listarEmpregados();
    }

    //listar empregado por id
    @GetMapping("/empregados/{idEmpregado}")
    public Empregado getEmpregadoById(@PathVariable Integer idEmpregado){
        return this.empregadoService.getEmpregadoById(idEmpregado);
    }

    //Adicionar novo empregado

    @PostMapping("/empregados")
    public Empregado gerarEmpregado(@Valid @RequestBody EmpregadoDTO dto){
        Empregado novoEmpregado = this.empregadoService.gerarEmpregado(dto);
        return novoEmpregado;
    }

    //Atualizar empregado
    @PutMapping("/empregados/{idEmpregado}")
    public Empregado atualizarEmpregado(@PathVariable Integer idEmpregado, @Valid @RequestBody EmpregadoDTO dto){
        System.out.println(idEmpregado);
        return this.empregadoService.atualizarEmpregado(idEmpregado, dto);
    }

    //Deletar projeto de empregado
    @PutMapping("/empregados/{idEmpregado}/projetos/{idProjeto}/remove")
    public Empregado removerProjeto(@PathVariable Integer idEmpregado, @PathVariable Integer idProjeto){
        return this.empregadoService.removerProjeto(idEmpregado, idProjeto);
    }

    //Adicionar projeto em empregado
    @PutMapping("/empregados/{idEmpregado}/projetos/{idProjeto}/add")
    public Empregado adicionarProjeto(@PathVariable Integer idEmpregado, @PathVariable Integer idProjeto){
        return this.empregadoService.adicionarProjeto(idEmpregado, idProjeto);
    }

    //Deletar Empregado
    @DeleteMapping("/empregados/{idEmpregado}")
    public void deletarEmpregado(@PathVariable Integer idEmpregado){

        this.empregadoService.deletarEmpregado(idEmpregado);
    }
}
