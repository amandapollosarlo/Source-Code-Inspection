package com.ticketmachine;

public class TicketMachine {

    protected int valor;
    protected int saldo;
    protected int[] papelMoeda = {2, 5, 10, 20, 50, 100};
    private int precoDoBilhete;

    // Construtor que inicializa o preço do bilhete
    public TicketMachine(int precoDoBilhete) {
        this.valor = precoDoBilhete;
        this.precoDoBilhete = precoDoBilhete;
        this.saldo = 0;
    }

    // Método para inserir dinheiro na máquina
    public void inserir(int valor) throws PapelMoedaInvalidaException {
        boolean valido = false;
        for (int moeda : papelMoeda) {
            if (moeda == valor) {
                valido = true;
                break;
            }
        }
        if (!valido) {
            throw new PapelMoedaInvalidaException("Valor inserido não é uma nota válida.");
        }
        this.saldo += valor;
    }

    // Método para emitir bilhete
    public void emitirBilhete() throws SaldoInsuficienteException {
        if (saldo < precoDoBilhete) {
            throw new SaldoInsuficienteException("Saldo insuficiente para emitir o bilhete.");
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
            throw new SaldoInsuficienteException("Saldo insuficiente para completar a transação.");
        }

        String result = "*****************\n";
        result += "*** R$ " + saldo + ",00 ****\n";
        result += "*****************\n";
        return result;
    }
}
