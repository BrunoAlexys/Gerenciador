package br.com.unifacol.gerenciador.model.interfaceRepository;

import br.com.unifacol.gerenciador.model.entidades.Cliente;

public interface IRepositoryCliente {
    void adicionarCliente(Cliente cliente);
    void alterarCliente(String cpf, Cliente clienteAtualizado);
    void removerCliente(int posicao);
    public void removerPorCpf(String cpf);
    String listar();

}
