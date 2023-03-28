package br.com.unifacol.gerenciador.model.service;

import br.com.unifacol.gerenciador.model.entidades.Funcionario;
import br.com.unifacol.gerenciador.model.enums.Sexo;
import br.com.unifacol.gerenciador.model.interfaceService.IServiceFuncionario;
import br.com.unifacol.gerenciador.model.repository.RepositorioFuncionario;

import javax.swing.*;

public class ServicoFuncionario implements IServiceFuncionario {

    private RepositorioFuncionario repositorioFuncionario;

    public ServicoFuncionario(RepositorioFuncionario repositorioFuncionario) {
        this.repositorioFuncionario = repositorioFuncionario;
    }

    @Override
    public void adicionarFuncinario() {
        String nome = JOptionPane.showInputDialog("Nome: ");
        String email = JOptionPane.showInputDialog("Email: ");
        String tel = JOptionPane.showInputDialog("Telefone: ");
        Sexo sexo = Sexo.valueOf(JOptionPane.showInputDialog("Sexo: "));
        String cpf = JOptionPane.showInputDialog("CPF: ");
        Double salario = Double.valueOf(JOptionPane.showInputDialog("Salario: "));

        Funcionario funcionario = new Funcionario(nome,email,tel,sexo,cpf,salario);

        repositorioFuncionario.adicionarFuncionario(funcionario);
    }

    @Override
    public void alterarFuncionario() {
        String cpf = JOptionPane.showInputDialog("CPF: ");
        repositorioFuncionario.buscarElemento(cpf);
        if (cpf != null){
            String nome = JOptionPane.showInputDialog("Nome: ");
            String email = JOptionPane.showInputDialog("Email: ");
            String tel = JOptionPane.showInputDialog("Telefone: ");
            Sexo sexo = Sexo.valueOf(JOptionPane.showInputDialog("Sexo: "));
            String novoCpf = JOptionPane.showInputDialog("CPF: ");
            Double salario = Double.valueOf(JOptionPane.showInputDialog("Salario: "));

            Funcionario funcionario = new Funcionario(nome,email,tel,sexo,novoCpf,salario);

            repositorioFuncionario.alterarFuncionario(cpf,funcionario);
        }
    }

    @Override
    public void removerFuncionario() {
        String cpf = JOptionPane.showInputDialog("CPF: ");
        if (cpf != null){
            repositorioFuncionario.removerPorCpf(cpf);
        }
    }


    @Override
    public void listarFuncionario() {
        JOptionPane.showMessageDialog(null, repositorioFuncionario.toString());
    }
}
