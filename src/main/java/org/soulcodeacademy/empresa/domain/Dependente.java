package org.soulcodeacademy.empresa.domain;

import javax.persistence.*;


@Entity
@Table
public class Dependente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idDependente;

    @Column(length = 20, nullable = false)
    private String nome;

    @Column(length = 3, nullable = false)
    private Integer idade;

    @ManyToOne
    @JoinColumn(name="id_responsavel", nullable = false)
    private Empregado responsavel; //O GET E O SETTER VAI FICAR COMO RESPONSAVEL

    public Dependente(){}

    public Dependente(Integer idDependente, String nome,Integer idade){
        this.idDependente=idDependente;
        this.nome=nome;
        this.idade=idade;
    }

    public Integer getIdDependente() {
        return idDependente;
    }

    public void setIdDependente(Integer idDependente) {
        this.idDependente = idDependente;
    }

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

    public Empregado getResponsavel() {
        return responsavel;
    }

    public void setResponsavel(Empregado responsavel) {
        this.responsavel = responsavel;
    }
}
