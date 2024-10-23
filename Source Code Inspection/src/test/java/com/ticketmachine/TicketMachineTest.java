package com.ticketmachine;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.ticketmachine.PapelMoedaInvalidaException;
import com.ticketmachine.SaldoInsuficienteException;
import com.ticketmachine.TicketMachine;

import static org.junit.jupiter.api.Assertions.*;

class TicketMachineTest {

    private TicketMachine tm;

    @BeforeEach
    void setUp() {
        tm = new TicketMachine(10); // Define o preço do bilhete como 10
    }

    @Test
    void testInserirValorValido() throws PapelMoedaInvalidaException {
        tm.inserir(10);
        assertEquals(10, tm.getSaldo(), "Saldo deve ser 10 após inserir 10");
    }

    @Test
    void testInserirValorInvalido() {
        assertThrows(PapelMoedaInvalidaException.class, () -> tm.inserir(3), "Deve lançar PapelMoedaInvalidaException para valor inválido");
    }

    @Test
    void testEmitirBilheteComSaldoSuficiente() throws PapelMoedaInvalidaException, SaldoInsuficienteException {
        tm.inserir(10); // Insere uma nota válida
        tm.inserir(5);  // Insere outra nota válida, totalizando 15
        tm.emitirBilhete();
        assertEquals(5, tm.getSaldo(), "Saldo deve ser 5 após emitir bilhete de 10");
    }


    @Test
    void testEmitirBilheteComSaldoInsuficiente() throws PapelMoedaInvalidaException {
        tm.inserir(5); // Insere saldo insuficiente
        assertThrows(SaldoInsuficienteException.class, () -> tm.emitirBilhete(), "Deve lançar SaldoInsuficienteException quando saldo for insuficiente");
    }

    @Test
    void testImprimirComSaldoSuficiente() throws PapelMoedaInvalidaException, SaldoInsuficienteException {
        tm.inserir(20); // Insere saldo suficiente
        String recibo = tm.imprimir();
        assertNotNull(recibo, "Recibo não deve ser nulo");
        assertTrue(recibo.contains("R$ 20,00"), "Recibo deve conter o saldo inserido");
    }

    @Test
    void testImprimirComSaldoInsuficiente() throws PapelMoedaInvalidaException {
        tm.inserir(5); // Insere saldo insuficiente
        assertThrows(SaldoInsuficienteException.class, () -> tm.imprimir(), "Deve lançar SaldoInsuficienteException quando saldo for insuficiente para imprimir");
    }
}
