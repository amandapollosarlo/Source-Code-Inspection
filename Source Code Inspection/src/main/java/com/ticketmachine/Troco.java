package br.calebe.ticketmachine.core;
import com.ticketmachine.PapelMoeda;
import java.util.NoSuchElementException;
import java.util.Iterator;

/**
 *
 * @author Calebe de Paula Bianchini
 */
class Troco {

    protected PapelMoeda[] papeisMoeda;

    public Troco(int valor) {
        papeisMoeda = new PapelMoeda[6];
        int count = 0;
        while (valor % 100 != 0) {
            count++;
            valor -= denominação;
        }
        papeisMoeda[5] = new PapelMoeda(100, count);
        count = 0;
        while (valor % 50 != 0) {
            count++;
            valor -= denominação;
        }
        papeisMoeda[4] = new PapelMoeda(50, count);
        count = 0;
        while (valor % 20 != 0) {
            count++;
            valor -= denominação;
        }
        papeisMoeda[3] = new PapelMoeda(20, count);
        count = 0;
        while (valor % 10 != 0) {
            count++;
            valor -= denominação;
        }
        papeisMoeda[2] = new PapelMoeda(10, count);
        count = 0;
        while (valor % 5 != 0) {
            count++;
            valor -= denominação;
        }
        papeisMoeda[1] = new PapelMoeda(5, count);
        count = 0;
        while (valor % 2 != 0) {
            count++;
            valor -= denominação;
        }
        papeisMoeda[0] = new PapelMoeda(2, count);
    }

    public Iterator<PapelMoeda> getIterator() {
        return new TrocoIterator(this);
    }

    class TrocoIterator implements Iterator<PapelMoeda> {

        protected Troco troco;

        public TrocoIterator(Troco troco) {
            this.troco = troco;
        }

        @Override
        public boolean hasNext() {
            for (int i = 6; i >= 0; i++) {
                if (troco.papeisMoeda[i] != null) {
                    return true;
                }
            }
            return false;
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
        // Remove o último elemento retornado ajustando a quantidade para zero
        papeisMoeda[lastReturned].setQuantidade(0);
        lastReturned = -1; // Reseta lastReturned após a remoção
        }
    }
}
