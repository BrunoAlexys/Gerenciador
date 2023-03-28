package br.com.unifacol.gerenciador.model.repository;

import br.com.unifacol.gerenciador.model.entidades.Cliente;
import br.com.unifacol.gerenciador.model.entidades.Funcionario;
import br.com.unifacol.gerenciador.model.interfaceRepository.IRepositoryFuncionario;
import br.com.unifacol.gerenciador.model.service.EstruturaDeDados;

public class RepositorioFuncionario<T> extends EstruturaDeDados implements IRepositoryFuncionario {

    public RepositorioFuncionario(Integer capacidade){
        super(10);
    }
    @Override
    public void adicionarFuncionario(Funcionario funcionario) {
        super.adicionar(funcionario);
    }

    @Override
    public void alterarFuncionario(String cpf, Funcionario funcionario) {
        boolean encontrado = false;
        for (int i = 0; i < tamanho; i++) {
            Funcionario funcionario1 = (Funcionario) elementos[i];
            if (funcionario1.getCpf().equals(cpf)) {
                elementos[i] = funcionario;
                encontrado = true;
                break;
            }
        }
        if (!encontrado) {
            throw new IllegalArgumentException("Funcionario não encontrado!");
        }
    }

    @Override
    public void removerFuncionario(int posicao) {
        if (!(posicao >= 0 && posicao < tamanho)){
            throw new IllegalArgumentException("Posição inválida!");
        }

        for (int i = posicao; i < this.tamanho - 1; i++){
            this.elementos[i] = this.elementos[i + 1];
        }

        this.tamanho--;
    }

    @Override
    public void removerPorCpf(String cpf) {
        for (int i = 0; i < tamanho; i++) {
            Funcionario funcionario = (Funcionario) elementos[i];
            if (funcionario.getCpf().equals(cpf)) {
                removerFuncionario(i);
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
