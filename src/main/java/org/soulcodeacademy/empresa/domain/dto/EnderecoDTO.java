package org.soulcodeacademy.empresa.domain.dto;

import javax.validation.constraints.NotBlank;

public class EnderecoDTO {

    @NotBlank(message = "Campo nome é obrigatório")
    private String uf;

    @NotBlank(message = "Campo nome é obrigatório")
    private String cidade;

    public String getUf() {
        return uf;
    }

    public void setUf(String uf) {
        this.uf = uf;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }
}