package br.com.unifacol.gerenciador.model.repository;

import br.com.unifacol.gerenciador.model.entidades.Funcionario;
import br.com.unifacol.gerenciador.model.interfaceRepository.IRepositoryFuncionario;
import javax.swing.*;
import java.util.Iterator;
import java.util.Queue;


public class RepositoryFuncionario implements IRepositoryFuncionario {

    private Queue<Funcionario> listFuncionario;

    public RepositoryFuncionario(Queue<Funcionario> listFuncionario) {
        this.listFuncionario = listFuncionario;
    }

    @Override
    public void adicionarFuncionario(Funcionario funcionario) {
        listFuncionario.add(funcionario);
    }

    public void removerFuncionario(Long id, Integer senha) {
        Iterator<Funcionario> iterator = listFuncionario.iterator();
        while (iterator.hasNext()) {
            Funcionario funcionario = iterator.next();
            if (funcionario.getId().equals(id) && funcionario.getSenha().equals(senha)) {
                iterator.remove();
                return;
            }
        }
    }

    @Override
    public void atualizarFuncionario(Funcionario funcionarioAtualizado) {
        if (listFuncionario.isEmpty()) {
            return;
        }

        Iterator<Funcionario> iterator = listFuncionario.iterator();
        while (iterator.hasNext()) {
            Funcionario funcionario = iterator.next();
            if (funcionario.getId().equals(funcionarioAtualizado.getId()) && funcionario.getSenha().equals(funcionarioAtualizado.getSenha())) {
                listFuncionario.remove(funcionario);
                listFuncionario.add(funcionarioAtualizado);
                return;
            }
        }
    }

    @Override
    public Queue<Funcionario> listarFuncionario() {
        return listFuncionario;
    }
}
