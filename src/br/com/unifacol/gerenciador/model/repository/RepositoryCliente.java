package br.com.unifacol.gerenciador.model.repository;

import br.com.unifacol.gerenciador.model.entidades.Cliente;
import br.com.unifacol.gerenciador.model.interfaceRepository.IRepositoryCliente;
import java.util.Queue;

public class RepositoryCliente implements IRepositoryCliente {
    private Queue<Cliente> listarCliente;

    public RepositoryCliente(Queue<Cliente> listarCliente) {
        this.listarCliente = listarCliente;
    }

    @Override
    public void adicionarCliente(Cliente cliente) {
        listarCliente.add(cliente);
    }

    @Override
    public void alterarCliente(Cliente clienteAtualizado) {
        for (Cliente cliente : listarCliente){
            if (cliente.getId() == clienteAtualizado.getId() && cliente.getSenha() == clienteAtualizado.getSenha()){
                listarCliente.poll();
                listarCliente.add(clienteAtualizado);
            }
        }
    }

    @Override
    public void removerCliente(Long id, Integer senha) {
        for (Cliente cliente : listarCliente){
            if (cliente.getId().equals(id) && cliente.getSenha().equals(senha)){
                listarCliente.remove(cliente);
            }
        }
    }

    @Override
    public Queue<Cliente> listarCliente() {
        return listarCliente;
    }
}
