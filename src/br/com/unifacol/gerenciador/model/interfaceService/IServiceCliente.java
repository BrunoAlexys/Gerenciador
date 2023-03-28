package br.com.unifacol.gerenciador.model.interfaceService;

import br.com.unifacol.gerenciador.model.entidades.Cliente;

import java.util.Queue;

public interface IServiceCliente {
    public void adicionar();
    public void alterarCliente();
    public void remover();
    public void listar();
}
