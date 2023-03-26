package br.com.unifacol.gerenciador.model.interfaceRepository;

import br.com.unifacol.gerenciador.model.entidades.Cliente;

import java.util.Queue;

public interface IRepositoryCliente {
    void adicionarCliente(Cliente cliente);
    void alterarCliente(Cliente clienteAtualizado);
    void removerCliente(Long id,Integer senha);
    Queue<Cliente> listarCliente();
}
