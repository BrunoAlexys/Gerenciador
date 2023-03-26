package br.com.unifacol.gerenciador.model.interfaceRepository;

import br.com.unifacol.gerenciador.model.entidades.Funcionario;

import java.util.Queue;

public interface IRepositoryFuncionario {
    void adicionarFuncionario(Funcionario funcionario);
    void removerFuncionario(Long id, Integer senha);
    void atualizarFuncionario(Funcionario funcionarioAtualizado);
    Queue<Funcionario> listarFuncionario();

}
