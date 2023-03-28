package br.com.unifacol.gerenciador.model.service;

public class EstruturaDeDados<T> {
    protected T[] elementos;
    protected Integer tamanho;

    public EstruturaDeDados(Integer capacidade) {
        this.elementos = (T[]) new Object[capacidade];
        this.tamanho = 0;
    }

    public EstruturaDeDados(){
        this(10);
    }

    protected boolean adicionar(T elemento){
        this.aumentarCapacidade();
        if (this.tamanho < this.elementos.length){
            elementos[this.tamanho] = elemento;
            this.tamanho++;
            return true;
        }
        return false;
    }

    protected boolean adicionar(int posicao, T elemento){
        if (!(posicao >= 0 && posicao < tamanho)){
            throw new IllegalArgumentException("Posição invalida!");
        }

        this.aumentarCapacidade();

        for (int i = this.tamanho -1; i >= posicao; i-- ){
            this.elementos[i+1] = this.elementos[i];
        }

        this.elementos[posicao] = elemento;
        this.tamanho++;

        return false;
    }

    protected void aumentarCapacidade(){
        if (this.tamanho == this.elementos.length){
            T[] elementosNovos = (T[]) new Object[elementos.length * 2];
            for (int i = 0; i < elementos.length; i++){
                elementosNovos[i] = elementos[i];
            }
            this.elementos = elementosNovos;
        }
    }

    public boolean buscarElemento(String nome){
        for (int i = 0; i < tamanho; i++){
            if (this.elementos[i].equals(nome)){
                return true;
            }
        }
        return false;
    }

    @Override
    public String toString() {
        StringBuilder s = new StringBuilder();
        s.append("[");

        for (int i = 0; i < this.tamanho-1; i++){
            s.append(this.elementos[i]);
            s.append(", ");
        }

        if (this.tamanho > 0){
            s.append(this.elementos[this.tamanho-1]);
        }

        s.append("]");

        return s.toString();
    }
}
