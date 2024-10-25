package com.ticketmachine;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TrocoTest {

    private Troco troco;
    private Troco trocoZero;
    private int valorTroco = 25;  // Exemplo de valor para o troco

    @BeforeEach
    void setUp() {
        // Inicializa o objeto Troco com um valor
        troco = new Troco(valorTroco);
        trocoZero = new Troco(0); // Exemplo de troco com valor zero
    }

    @Test
    void testConstrutor() {
        assertNotNull(troco, "Troco deve ser criado com sucesso");
    }

    @Test
    void testTrocoComValorZero() {
        // Testa a criação de um troco com valor zero (se sua implementação permitir isso)
        assertNotNull(trocoZero, "Troco com valor zero deve ser criado com sucesso");
    }

    @Test
    void testTrocoComValorNegativo() {
        // Caso o valor negativo seja aceito, apenas verificamos se o objeto é criado com sucesso
        Troco trocoNegativo = new Troco(-5);
        assertNotNull(trocoNegativo, "Troco com valor negativo deve ser criado com sucesso");
    }
}