package br.com.unifacol.gerenciador.model.service;

import br.com.unifacol.gerenciador.model.entidades.Cliente;
import br.com.unifacol.gerenciador.model.entidades.Funcionario;
import br.com.unifacol.gerenciador.model.repository.RepositoryCliente;
import br.com.unifacol.gerenciador.model.repository.RepositoryFuncionario;

import java.util.Queue;

public class Buscador {
    private RepositoryFuncionario repositoryFuncionario;
    private RepositoryCliente repositoryCliente;

    public Buscador(RepositoryFuncionario repositoryFuncionario, RepositoryCliente repositoryCliente) {
        this.repositoryFuncionario = repositoryFuncionario;
        this.repositoryCliente = repositoryCliente;
    }

    public Funcionario encontrarContaFuncionario(Long id, Integer senha){
        Queue<Funcionario> listarFuncionario = repositoryFuncionario.listarFuncionario();
        for (Funcionario funcionario : listarFuncionario){
            if (funcionario.getId().equals(id) && funcionario.getSenha().equals(senha)){
                return funcionario;
            }
        }
        return null;
    }

    public Cliente encontrarContaCliente(Long id, Integer senha){
        Queue<Cliente> listarCliente = repositoryCliente.listarCliente();
        for (Cliente cliente : listarCliente){
            if (cliente.getId().equals(id) && cliente.getSenha().equals(senha)){
                return cliente;
            }
        }
        return null;
    }
}
