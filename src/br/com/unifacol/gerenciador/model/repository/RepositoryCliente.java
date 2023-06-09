package br.com.unifacol.gerenciador.model.repository;

import br.com.unifacol.gerenciador.model.entidades.Cliente;
import br.com.unifacol.gerenciador.model.interfaceRepository.IRepositoryCliente;
import br.com.unifacol.gerenciador.model.service.EstruturaDeDados;

public class RepositoryCliente<T> extends EstruturaDeDados implements IRepositoryCliente {

    public RepositoryCliente(Integer capacidade){
        super(10);
    }

    @Override
    public void adicionarCliente(Cliente cliente) {
        super.adicionar(cliente);
    }

    @Override
    public void alterarCliente(String cpfAtual, Cliente clienteAtualizado) {
        boolean encontrado = false;
        for (int i = 0; i < tamanho; i++) {
            Cliente cliente = (Cliente) elementos[i];
            if (cliente.getCpf().equals(cpfAtual)) {
                elementos[i] = clienteAtualizado;
                encontrado = true;
                break;
            }
        }
        if (!encontrado) {
            throw new IllegalArgumentException("Cliente não encontrado!");
        }
    }

    @Override
    public void removerCliente(int posicao) {
        if (!(posicao >= 0 && posicao < tamanho)){
            throw new IllegalArgumentException("Posição inválida!");
        }

        for (int i = posicao; i < this.tamanho - 1; i++){
            this.elementos[i] = this.elementos[i + 1];
        }

        this.tamanho--;
    }

    @Override
    public void removerPorCpf(String cpf){
        for (int i = 0; i < tamanho; i++) {
            Cliente cliente = (Cliente) elementos[i];
            if (cliente.getCpf().equals(cpf)) {
                removerCliente(i);
                break;
            }
        }
    }



    @Override
    public String listar() {
        return super.toString();
    }

    public boolean buscarElemento(String elemento){
        super.buscarElemento(elemento);
        return false;
    }
}
