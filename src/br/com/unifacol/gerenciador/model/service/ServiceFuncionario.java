package br.com.unifacol.gerenciador.model.service;

import br.com.unifacol.gerenciador.model.entidades.Funcionario;
import br.com.unifacol.gerenciador.model.enums.Sexo;
import br.com.unifacol.gerenciador.model.interfaceService.IServiceFuncionario;
import br.com.unifacol.gerenciador.model.repository.RepositoryFuncionario;

import javax.swing.*;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;

public class ServiceFuncionario implements IServiceFuncionario {

    private RepositoryFuncionario repositoryFuncionario;
    private VerificadorCpf verificadorCpf = new VerificadorCpf();
    private Buscador buscador;

    public ServiceFuncionario(RepositoryFuncionario repositoryFuncionario,Buscador buscador) {
        this.repositoryFuncionario = repositoryFuncionario;
        this.buscador = buscador;
    }

    @Override
    public void adicionarFuncinario() {
        String nome = JOptionPane.showInputDialog("Nome: ");
        String sobrenome = JOptionPane.showInputDialog("Sobrenome: ");
        String dataDeNacimentoStr = JOptionPane.showInputDialog("Data de nascimento (DD/MM/YYYY): ");
        LocalDate dataDeNacimento = LocalDate.parse(dataDeNacimentoStr, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        LocalDate dataAtual = LocalDate.now();
        Integer idade = Period.between(dataDeNacimento,dataAtual).getYears();

        String cpf = JOptionPane.showInputDialog("CPF: ");

        do {

            if (!verificadorCpf.verificarCpf(cpf)) {
                JOptionPane.showMessageDialog(null, "CPF inválido. Digite novamente.");
                cpf = JOptionPane.showInputDialog("CPF: ");
            }
        } while (!verificadorCpf.verificarCpf(cpf));

        cpf = cpf;

        Sexo sexo = Sexo.valueOf(JOptionPane.showInputDialog("Sexo: "));
        Long id = Long.valueOf(JOptionPane.showInputDialog("ID: "));
        Integer senha = Integer.parseInt(JOptionPane.showInputDialog("Senha: "));

        Funcionario funcionario = new Funcionario(nome,sobrenome,idade,dataDeNacimento,cpf,sexo,id,senha);

        repositoryFuncionario.adicionarFuncionario(funcionario);

    }

    @Override
    public void alterarFuncionario() {

        Long id = Long.parseLong(JOptionPane.showInputDialog("ID: "));
        Integer senha = Integer.parseInt(JOptionPane.showInputDialog("Senha: "));
        String nome = JOptionPane.showInputDialog("Nome: ");
        String sobrenome = JOptionPane.showInputDialog("Sobrenome: ");
        String dataDeNacimentoStr = JOptionPane.showInputDialog("Data de nascimento (DD/MM/YYYY): ");
        LocalDate dataDeNacimento = LocalDate.parse(dataDeNacimentoStr, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        LocalDate dataAtual = LocalDate.now();
        Integer idade = Period.between(dataDeNacimento,dataAtual).getYears();

        String cpf = JOptionPane.showInputDialog("CPF: ");

        do {

            if (!verificadorCpf.verificarCpf(cpf)) {
                JOptionPane.showMessageDialog(null, "CPF inválido. Digite novamente.");
                cpf = JOptionPane.showInputDialog("CPF: ");
            }
        } while (!verificadorCpf.verificarCpf(cpf));

        cpf = cpf;

        Sexo sexo = Sexo.valueOf(JOptionPane.showInputDialog("Sexo: "));

        Funcionario funcionario = new Funcionario(nome,sobrenome,idade,dataDeNacimento,cpf,sexo,id,senha);
        repositoryFuncionario.atualizarFuncionario(funcionario);

    }

    @Override
    public void removerFuncionario() {
        Long id = Long.valueOf(JOptionPane.showInputDialog("ID: "));
        Integer senha = Integer.parseInt(JOptionPane.showInputDialog("Senha: "));
        repositoryFuncionario.removerFuncionario(id,senha);
    }

    @Override
    public void listarFuncionario() {
        Long id = Long.valueOf(JOptionPane.showInputDialog("ID: "));
        Integer senha = Integer.parseInt(JOptionPane.showInputDialog("Senha: "));
        Funcionario funcionario = buscador.encontrarContaFuncionario(id,senha);
        if (funcionario != null){
            JOptionPane.showMessageDialog(null, funcionario.toString());
        }else {
            JOptionPane.showMessageDialog(null,"Funcionario não existe!");
        }
    }
}
