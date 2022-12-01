package org.soulcodeacademy.empresa.services;

import org.soulcodeacademy.empresa.reposirtories.DependenteRepository;
import org.soulcodeacademy.empresa.reposirtories.EmpregadoRepository;
import org.soulcodeacademy.empresa.reposirtories.EnderecoRepository;
import org.soulcodeacademy.empresa.reposirtories.ProjetoRepository;
import org.soulcodeacademy.empresa.domain.Dependente;
import org.soulcodeacademy.empresa.domain.Empregado;
import org.soulcodeacademy.empresa.domain.Endereco;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.soulcodeacademy.empresa.domain.Projeto;

import javax.annotation.PostConstruct;
import java.util.List;

@Service
public class PopulateService {
    @Autowired
    private EmpregadoRepository empregadoRepository;

    @Autowired
    private DependenteRepository dependenteRepository;

    @Autowired
    private EnderecoRepository enderecoRepository;

    @Autowired
    private ProjetoRepository projetoRepository;

    @PostConstruct
    public void populate(){

        //RELACAO 1:1 ENTRE EMPREGADO E ENDERECO

        Empregado empregado1 = new Empregado(null, "Maria Lima", "jc@gmail.com", 7000.0);
        Empregado empregado2 = new Empregado(null, "José Antonio", "ja@gmail.com", 8500.0);
        Empregado empregado3 = new Empregado(null, "Cláudio José", "cj@gmail.com", 5000.0);



        Endereco endereco1 = new Endereco(null, "Ubajara", "CE");
        Endereco endereco2 = new Endereco(null, "São Paulo", "SP");
        Endereco endereco3 = new Endereco(null, "São Paulo", "SP");

        empregado1.setEndereco(endereco1);
        empregado2.setEndereco(endereco2);
        empregado3.setEndereco(endereco3);

        this.enderecoRepository.saveAll(List.of(endereco1, endereco2, endereco3));
        this.empregadoRepository.saveAll(List.of(empregado1, empregado2, empregado3));



        //RELACAO 1:N ENTRE EMPREGADO E DEPENDENTE

        Dependente dependente1 = new Dependente(null, "Maria Antonieta", 13);
        Dependente dependente2 = new Dependente(null, "Carlos José", 11);
        Dependente dependente3 = new Dependente(null, "Pedro Alves", 9);

        dependente1.setResponsavel(empregado1);
        dependente2.setResponsavel(empregado2);
        dependente3.setResponsavel(empregado1);

        this.dependenteRepository.saveAll(List.of(dependente1, dependente2, dependente3));

        //ASSOCIACAO N:N
        Projeto projeto1 = new Projeto(null, "Campanha de marketing I", 5000.0, "Campanha 1º semestre");
        Projeto projeto2 = new Projeto(null, "Campanha de marketing II", 8500.0, "Campanha 2º semestre");

        this.projetoRepository.saveAll(List.of(projeto1, projeto2));

        //ADICIONANDO EMPREGADOS AOS PROJETOS

        empregado1.getProjetos().add(projeto1);
        empregado1.getProjetos().add(projeto2);
        empregado2.getProjetos().add(projeto2);



        //JA QUE VOCE ADICIONOU PROJETOS PARA EMPREGADOS, VOCE DEVE SALVAR OS EMPREGADOS NOVAMENTE NO BANCO
        //POIS AGORA ESTAO ASSOCIADOS AO PROJETO

        this.empregadoRepository.save(empregado1);
        this.empregadoRepository.save(empregado2);

    }

}
