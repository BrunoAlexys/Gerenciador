package br.com.unifacol.gerenciador.model.entidades;

import br.com.unifacol.gerenciador.model.enums.Sexo;

import java.time.LocalDate;

public class Funcionario extends Pessoa{
    private Long id;
    private Integer senha;

    public Funcionario(String nome, String sobrenome, int idade, LocalDate dataDeNascimento, String cpf, Sexo sexo, Long id, Integer senha) {
        super(nome, sobrenome, idade, dataDeNascimento, cpf, sexo);
        this.id = id;
        this.senha = senha;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getSenha() {
        return senha;
    }

    public void setSenha(Integer senha) {
        this.senha = senha;
    }

    @Override
    public String toString() {
        return "\nID: " + this.getId() + super.toString();
    }
}
