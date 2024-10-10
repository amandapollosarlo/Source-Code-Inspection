package br.calebe.ticketmachine.core;

import br.calebe.ticketmachine.exception.PapelMoedaInvalidaException;
import br.calebe.ticketmachine.exception.SaldoInsuficienteException;
import java.util.Iterator;

/**
 *
 * @author Calebe de Paula Bianchini
 */
public class TicketMachine {

    protected int valor;
    protected int saldo;
    protected int[] papelMoeda = {2, 5, 10, 20, 50, 100};

    public TicketMachine(int valor) {
        this.valor = valor;
        this.saldo = 0;
    }

   public void inserir(int valor) throws PapelMoedaInvalidaException {
    if (valor != 2 && valor != 5 && valor != 10 && valor != 20 && valor != 50 && valor != 100) { // Linha 9
        throw new IllegalArgumentException("Valor inserido não é uma nota válida.");
    }
    this.saldo += valor;
}
    public void emitirBilhete() {
    if (saldo < precoDoBilhete) { // Linha 16
        throw new IllegalStateException("Saldo insuficiente para emitir o bilhete.");
    }
    saldo -= precoDoBilhete;
    System.out.println("Bilhete emitido. Saldo restante: " + saldo);
}

    public int getSaldo() {
        return saldo;
    }

    public Troco getTroco() {
        return new Troco(saldo);
    }

    public String imprimir() throws SaldoInsuficienteException {
        if (saldo < valor) {
            throw new SaldoInsuficienteException();
        }
        
        String result = "*****************\n";
        result += "*** R$ " + saldo + ",00 ****\n";
        result += "*****************\n";
        return result;
    }
}
