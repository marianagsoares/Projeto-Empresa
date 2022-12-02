package org.soulcodeacademy.empresa.controller;

import org.soulcodeacademy.empresa.domain.Dependente;
import org.soulcodeacademy.empresa.domain.dto.DependenteDTO;
import org.soulcodeacademy.empresa.services.DependenteService;
import org.soulcodeacademy.empresa.services.EmpregadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
@RestController
public class DependenteController {

    @Autowired
    private DependenteService dependenteService;


    @GetMapping("/dependentes")
    public List<Dependente> listar(){
        return this.dependenteService.listar();
    }

    @GetMapping("/dependente/{idDependente}")
    public Dependente getDependente(@PathVariable Integer idDependente){
        return this.dependenteService.getDependente(idDependente);

    }


}



