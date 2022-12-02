package org.soulcodeacademy.empresa.controller;

import org.soulcodeacademy.empresa.domain.Endereco;
import org.soulcodeacademy.empresa.domain.dto.EnderecoDTO;
import org.soulcodeacademy.empresa.services.EnderecoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class EnderecoController {

    @Autowired
    public EnderecoService enderecoService;

    @GetMapping("/endereco")
    public List<Endereco> listar() {
        return this.enderecoService.lista();
    }

    @GetMapping("/endereco/{idEndereco}")
    public Endereco getEndereco(@PathVariable Integer idEndereco){
        return this.enderecoService.getEndereco(idEndereco);
    }
    @PostMapping("/endereco")
    public  Endereco salvar(@Valid @RequestBody EnderecoDTO dto){
        return this.enderecoService.salvar(dto);
    }
    @PutMapping("/endereco/{idEndereco}")
    public Endereco atualizar(@PathVariable Integer idEndereco, @Valid @RequestBody EnderecoDTO dto) {
        Endereco endereçoAtulizado = this.enderecoService.atulizar(idEndereco, dto);
        return endereçoAtulizado;
    }
    @DeleteMapping("/endereco/{idEndereco}")
    public void deltarEndereço(@PathVariable Integer idEndereco){
        this.enderecoService.deletar(idEndereco);
    }
}
