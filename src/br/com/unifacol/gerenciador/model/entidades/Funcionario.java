package br.com.unifacol.gerenciador.model.entidades;

import br.com.unifacol.gerenciador.model.enums.Sexo;

public class Funcionario {
    private String nome;
    private String email;
    private String telefone;
    private Sexo sexo;
    private String cpf;
    private double salario;

    public Funcionario(String nome, String email, String telefone, Sexo sexo, String cpf, double salario) {
        this.nome = nome;
        this.email = email;
        this.telefone = telefone;
        this.sexo = sexo;
        this.cpf = cpf;
        this.salario = salario;
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

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public Sexo getSexo() {
        return sexo;
    }

    public void setSexo(Sexo sexo) {
        this.sexo = sexo;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    @Override
    public String toString() {
        return "Funcionario{" +
                "nome='" + nome + '\'' +
                ", email='" + email + '\'' +
                ", telefone='" + telefone + '\'' +
                ", sexo=" + sexo +
                ", cpf='" + cpf + '\'' +
                ", salario=" + salario +
                '}';
    }
}
