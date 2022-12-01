package org.soulcodeacademy.empresa.domain.DTO;

import javax.validation.constraints.NotBlank;

public class ProjetoDTO {

    @NotBlank (message = "Nome é obrigatorio")
    private String nome;

    @NotBlank( message = "Orçamento é obrigatorio")
    private Double orcamento;

    @NotBlank(message = "Descrição é obrigatorio")
    private String descricao;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Double getOrcamento() {
        return orcamento;
    }

    public void setOrcamento(Double orcamento) {
        this.orcamento = orcamento;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
}
