package br.com.unifacol.gerenciador.model.interfaceService;

import br.com.unifacol.gerenciador.model.entidades.Cliente;

import java.util.Queue;

public interface IServiceCliente {
    void adicionarCliente();
    void alterarCliente();
    void removerCliente();
    void listarCliente();
}
