package br.calebe.ticketmachine.core;

/**
 *
 * @author Calebe de Paula Bianchini
 */
public class PapelMoeda {
    if (valor != 2 && valor != 5 && valor != 10 && valor != 20 && valor != 50 && valor != 100) { // Linha 6
        throw new IllegalArgumentException("Valor de papel-moeda inválido");
    }
    this.valor = valor;
    this.quantidade = quantidade;

    protected int valor;
    protected int quantidade;

    public PapelMoeda(int valor, int quantidade) {
        this.valor = valor;
        this.quantidade = quantidade;
    }

    public int getValor() {
        return valor;
    }

    public int getQuantidade() {
        return quantidade;
    }
}
