package br.com.unifacol.gerenciador.model.interfaceRepository;

import br.com.unifacol.gerenciador.model.entidades.Cliente;
import br.com.unifacol.gerenciador.model.entidades.Funcionario;

import java.util.Queue;

public interface IRepositoryFuncionario {
    void adicionarFuncionario(Funcionario funcionario);
    void alterarFuncionario(String cpf, Funcionario funcionario);
    void removerFuncionario(int posicao);
    public void removerPorCpf(String cpf);
    String listar();

}
