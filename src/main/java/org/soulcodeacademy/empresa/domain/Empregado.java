package org.soulcodeacademy.empresa.domain;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Empregado {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idEmpregado;

    @Column(nullable = false)
    private String nome;


    @Column(unique = true, nullable = false)
    private String email;

    @Column( length =5, nullable = false)
    private Double salario;

    @OneToOne
    @JoinColumn(name = "id_endereco")
    private Endereco endereco;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinColumn(name="id_projeto", nullable = false)
    private List<Projeto> projetos = new ArrayList<>();

    public Empregado(){}

    public Empregado(Integer idEmpregado, String nome, String email, Double salario){
        this.idEmpregado = idEmpregado;
        this.nome = nome;
        this.email = email;
        this.salario = salario;
    }

    public Integer getIdEmpregado() {
        return idEmpregado;
    }

    public void setIdEmpregado(Integer idEmpregado) {
        this.idEmpregado = idEmpregado;
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

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    public List<Projeto> getProjetos() {
        return projetos;
    }

    public void setProjetos(List<Projeto> projetos) {
        this.projetos = projetos;
    }
}
