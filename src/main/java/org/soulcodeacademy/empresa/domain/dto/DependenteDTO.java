package org.soulcodeacademy.empresa.domain.dto;

import javax.validation.constraints.NotBlank;

public class DependenteDTO {

    @NotBlank(message = "nome é obrigatório")
    String nome ;

    @NotBlank(message = "Idade é obrigatório")
     Integer idade ;


    private Integer idEmpregado;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Integer getIdade() {
        return idade;
    }

    public void setIdade(Integer idade) {
        this.idade = idade;
    }

    public Integer getIdEmpregado() {
        return idEmpregado;
    }

    public void setIdEmpregado(Integer idEmpregado) {
        this.idEmpregado = idEmpregado;
    }
}