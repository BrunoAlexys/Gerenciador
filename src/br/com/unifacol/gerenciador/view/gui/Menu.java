package br.com.unifacol.gerenciador.view.gui;

import br.com.unifacol.gerenciador.model.repository.RepositoryCliente;
import br.com.unifacol.gerenciador.model.repository.RepositoryFuncionario;
import br.com.unifacol.gerenciador.model.service.Buscador;
import br.com.unifacol.gerenciador.model.service.ServiceCliente;
import br.com.unifacol.gerenciador.model.service.ServiceFuncionario;

import javax.swing.*;
import java.util.LinkedList;

public class Menu {
    RepositoryCliente repositoryCliente = new RepositoryCliente(new LinkedList<>());
    RepositoryFuncionario repositoryFuncionario = new RepositoryFuncionario(new LinkedList<>());
    ServiceFuncionario funcionario = new ServiceFuncionario(repositoryFuncionario,new Buscador(repositoryFuncionario,repositoryCliente));
    ServiceCliente cliente = new ServiceCliente(repositoryCliente,new Buscador(repositoryFuncionario,repositoryCliente));

    public void menu(){
        Integer menu =
                Integer.parseInt(JOptionPane.showInputDialog("\n------- Gerenciador -------" +
                        "\n|Opção 1 - Cadastrar Funcionario |" +
                        "\n|Opção 2 - Alterar Funcionario |" +
                        "\n|Opção 3 - Excluir Funcionario |" +
                        "\n|Opção 4 - Listar Funcionario |" +
                        "\n|Opção 5 - Cadastrar Cliente |" +
                        "\n|Opção 6 - Alterar Cliente |" +
                        "\n|Opção 7 - Excluir Cliente |" +
                        "\n|Opção 8 - Listar Cliente |" +
                        "\n|Opção 9 - Sair |"));

        switch (menu){
            case 1:
                funcionario.adicionarFuncinario();
                menu();
            case 2:
                funcionario.alterarFuncionario();
                menu();
            case 3:
                funcionario.removerFuncionario();
                menu();
            case 4:
                funcionario.listarFuncionario();
                menu();
            case 5:
                cliente.adicionarCliente();
                menu();
            case 6:
                cliente.alterarCliente();
                menu();
            case 7:
                cliente.removerCliente();
                menu();
            case 8:
                cliente.listarCliente();
                menu();
            case 9:
                System.exit(0);
        }
    }
}
