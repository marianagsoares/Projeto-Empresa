package org.soulcodeacademy.empresa.domain.dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class EmpregadoDTO {

    private Integer idEndereco;


    @NotBlank(message = "nome é obrigatório")
    private String nome;

    @Email
    @NotBlank(message = "email é obrigatório")
    private String email;

    @NotNull(message = "salario é obrigatório")
    private Double salario;

    public Integer getIdEndereco() {
        return idEndereco;
    }

    public void setIdEndereco(Integer idEndereco) {
        this.idEndereco = idEndereco;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Double getSalario() {
        return salario;
    }

    public void setSalario(Double salario) {
        this.salario = salario;
    }
}
