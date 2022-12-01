package org.soulcodeacademy.empresa.services;

import org.soulcodeacademy.empresa.domain.Empregado;
import org.soulcodeacademy.empresa.reposirtories.EmpregadoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmpregadoService {
    @Autowired
    private EmpregadoRepository empregadoRepository;


    //Listar todos os empregados
    public List<Empregado> listarEmpregados(){
        return this.empregadoRepository.findAll();
    }
}
