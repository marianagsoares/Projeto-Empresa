package org.soulcodeacademy.empresa.domain.dto;

import javax.validation.constraints.NotBlank;

public class DependenteDTO {

    @NotBlank(message = "nome é obrigatório")
    String nome ;

    @NotBlank(message = "Idade é obrigatório")
     String idade ;

    private Integer idReponsavel;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getIdade() {
        return idade;
    }

    public void setIdade(String idade) {
        this.idade = idade;
    }

    public Integer getIdReponsavel() {
        return idReponsavel;
    }

    public void setIdReponsavel(Integer idReponsavel) {
        this.idReponsavel = idReponsavel;
    }
}