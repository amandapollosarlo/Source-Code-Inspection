package com.ticketmachine;

public class PapelMoeda {

    protected int valor;
    protected int quantidade;

    public PapelMoeda(int valor, int quantidade) {
        if (valor != 2 && valor != 5 && valor != 10 && valor != 20 && valor != 50 && valor != 100) {
            throw new IllegalArgumentException("Valor de papel-moeda inválido");
        }
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
