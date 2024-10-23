package com.ticketmachine;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Classe que representa o troco a ser devolvido.
 */
public class Troco { // Tornada pública

    protected PapelMoeda[] papeisMoeda;
    private final int[] denominacoes = {100, 50, 20, 10, 5, 2}; // Declaração do array de denominações

    public Troco(int valor) {
        papeisMoeda = new PapelMoeda[6];
        for (int i = 0; i < denominacoes.length; i++) {
            int count = 0;
            while (valor >= denominacoes[i]) {
                count++;
                valor -= denominacoes[i];
            }
            papeisMoeda[i] = new PapelMoeda(denominacoes[i], count);
        }
    }

    public Iterator<PapelMoeda> getIterator() {
        return new TrocoIterator();
    }

    class TrocoIterator implements Iterator<PapelMoeda> {
        private int index = papeisMoeda.length - 1; // Começa pelo maior valor
        private int lastReturned = -1; // Mantém o controle do último elemento retornado

        public TrocoIterator() {
            // Construtor sem parâmetros
        }

        @Override
        public boolean hasNext() {
            while (index >= 0 && (papeisMoeda[index] == null || papeisMoeda[index].getQuantidade() == 0)) {
                index--;
            }
            return index >= 0;
        }

        @Override
        public PapelMoeda next() {
            if (!hasNext()) {
                throw new NoSuchElementException("Não há mais elementos.");
            }
            lastReturned = index;
            return papeisMoeda[index--];
        }

        @Override
        public void remove() {
            if (lastReturned == -1) {
                throw new IllegalStateException("O método next() não foi chamado ou o remove() já foi chamado após o último next().");
            }
            papeisMoeda[lastReturned].setQuantidade(0);
            lastReturned = -1;
        }
    }

}
