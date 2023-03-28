package br.com.unifacol.gerenciador.model.service;

import br.com.unifacol.gerenciador.model.entidades.Cliente;
import br.com.unifacol.gerenciador.model.enums.Sexo;
import br.com.unifacol.gerenciador.model.interfaceService.IServiceCliente;
import br.com.unifacol.gerenciador.model.repository.RepositoryCliente;

import javax.swing.*;

public class ServiceCliente implements IServiceCliente {
    private RepositoryCliente repositoryCliente;

    public ServiceCliente(RepositoryCliente repositoryCliente) {
        this.repositoryCliente = repositoryCliente;
    }
    @Override
    public void adicionar(){
        String nome = JOptionPane.showInputDialog("Nome: ");
        String email = JOptionPane.showInputDialog("Email: ");
        String tel = JOptionPane.showInputDialog("Telefone: ");
        Sexo sexo = Sexo.valueOf(JOptionPane.showInputDialog("Sexo: "));
        String cpf = JOptionPane.showInputDialog("CPF: ");

        Cliente cliente = new Cliente(nome,email,tel,sexo,cpf);

        repositoryCliente.adicionarCliente(cliente);
    }
    @Override
    public void alterarCliente(){
        String cpf = JOptionPane.showInputDialog("CPF: ");
        repositoryCliente.buscarElemento(cpf);
        if (cpf != null){
            String nome = JOptionPane.showInputDialog("Nome: ");
            String email = JOptionPane.showInputDialog("Email: ");
            String tel = JOptionPane.showInputDialog("Telefone: ");
            Sexo sexo = Sexo.valueOf(JOptionPane.showInputDialog("Sexo: "));
            String novoCpf = JOptionPane.showInputDialog("CPF: ");

            Cliente cliente = new Cliente(nome,email,tel,sexo,novoCpf);

            repositoryCliente.alterarCliente(cpf,cliente);
        }


    }
    @Override
    public void remover(){
        String cpf = JOptionPane.showInputDialog("CPF: ");
        if (cpf != null){
            repositoryCliente.removerPorCpf(cpf);
        }
    }
    @Override
    public void listar(){
        JOptionPane.showMessageDialog(null, repositoryCliente.toString());
    }
}
