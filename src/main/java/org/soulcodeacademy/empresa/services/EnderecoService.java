package org.soulcodeacademy.empresa.services;

import org.soulcodeacademy.empresa.reposirtories.EmpregadoRepository;
import org.soulcodeacademy.empresa.reposirtories.EnderecoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EnderecoService {

    @Autowired
    private EmpregadoRepository empregadoRepository;

    @Autowired
    private EnderecoRepository enderecoRepository;
}
