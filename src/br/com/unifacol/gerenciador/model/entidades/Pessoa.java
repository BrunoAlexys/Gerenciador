package br.com.unifacol.gerenciador.model.entidades;

import br.com.unifacol.gerenciador.model.enums.Sexo;

import java.time.LocalDate;

public abstract class Pessoa {
    private String nome;
    private String sobrenome;
    private int idade;
    private LocalDate dataDeNascimento;
    private String cpf;
    private Sexo sexo;

    public Pessoa(String nome, String sobrenome, int idade, LocalDate dataDeNascimento, String cpf,Sexo sexo) {
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.idade = idade;
        this.dataDeNascimento = dataDeNascimento;
        this.cpf = cpf;
        this.sexo = sexo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSobrenome() {
        return sobrenome;
    }

    public void setSobrenome(String sobrenome) {
        this.sobrenome = sobrenome;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public LocalDate getDataDeNascimento() {
        return dataDeNascimento;
    }

    public void setDataDeNascimento(LocalDate dataDeNascimento) {
        this.dataDeNascimento = dataDeNascimento;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public Sexo getSexo() {
        return sexo;
    }

    public void setSexo(Sexo sexo) {
        this.sexo = sexo;
    }

    @Override
    public String toString() {
        return "\nNome: " + this.getNome() + "\nSobrenome: " + this.getSobrenome() + "\nIdade: " + this.getIdade() +
                "\nData de nascimento: " + this.dataDeNascimento + "\nCPF: " + this.getCpf() + "\nSexo: " + this.getSexo();
    }
}
