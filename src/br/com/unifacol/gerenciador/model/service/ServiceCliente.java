package br.com.unifacol.gerenciador.model.service;

import br.com.unifacol.gerenciador.model.entidades.Cliente;
import br.com.unifacol.gerenciador.model.enums.Sexo;
import br.com.unifacol.gerenciador.model.interfaceService.IServiceCliente;
import br.com.unifacol.gerenciador.model.repository.RepositoryCliente;
import javax.swing.*;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;


public class ServiceCliente implements IServiceCliente {

    private RepositoryCliente repositoryCliente;
    private Buscador buscador;
    private VerificadorCpf verificadorCpf = new VerificadorCpf();
    public ServiceCliente(RepositoryCliente repositoryCliente, Buscador buscador) {
        this.repositoryCliente = repositoryCliente;
        this.buscador = buscador;
    }

    @Override
    public void adicionarCliente() {
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

        Cliente cliente = new Cliente(nome,sobrenome,idade,dataDeNacimento,cpf,sexo,id,senha);

        repositoryCliente.adicionarCliente(cliente);
    }

    @Override
    public void alterarCliente() {
        Long id = Long.valueOf(JOptionPane.showInputDialog("ID: "));
        Integer senha = Integer.parseInt(JOptionPane.showInputDialog("Senha: "));
        Cliente cliente = buscador.encontrarContaCliente(id,senha);
        if (cliente != null){
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
            Long novoId = Long.valueOf(JOptionPane.showInputDialog("ID: "));
            Integer novaSenha = Integer.parseInt(JOptionPane.showInputDialog("Senha: "));

            Cliente novoCliente = new Cliente(nome,sobrenome,idade,dataDeNacimento,cpf,sexo,novoId,novaSenha);
            repositoryCliente.alterarCliente(novoCliente);
        }
    }

    @Override
    public void removerCliente() {
        Long id = Long.valueOf(JOptionPane.showInputDialog("ID: "));
        Integer senha = Integer.parseInt(JOptionPane.showInputDialog("Senha: "));
        repositoryCliente.removerCliente(id,senha);
    }

    @Override
    public void listarCliente() {
        Long id = Long.valueOf(JOptionPane.showInputDialog("ID: "));
        Integer senha = Integer.parseInt(JOptionPane.showInputDialog("Senha: "));
        Cliente cliente = buscador.encontrarContaCliente(id,senha);
        if (cliente != null){
            JOptionPane.showMessageDialog(null,cliente.toString());
        }else {
            JOptionPane.showMessageDialog(null,"Cliente inexistente!");
        }
    }
}
