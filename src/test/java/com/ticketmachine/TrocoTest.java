package com.ticketmachine;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.Map;

class TrocoTest {

    private Troco troco;
    private int valorTroco = 25; // Exemplo de valor para troco

    @BeforeEach
    void setUp() {
        troco = new Troco(valorTroco);
    }

    @Test
    void testConstrutor() {
        assertNotNull(troco, "Troco deve ser criado com sucesso");
        assertEquals(valorTroco, troco.getValor(), "Valor do troco deve ser igual ao valor fornecido");
    }

    @Test
    void testCalcularNotas() {
        Map<Integer, Integer> notas = troco.getNotas();
        assertNotNull(notas, "Map de notas não deve ser nulo");
        assertFalse(notas.isEmpty(), "Map de notas não deve estar vazio");

        int totalCalculado = 0;
        for (Map.Entry<Integer, Integer> entry : notas.entrySet()) {
            totalCalculado += entry.getKey() * entry.getValue();
        }

        assertEquals(valorTroco, totalCalculado, "Total das notas deve ser igual ao valor do troco");
    }

    @Test
    void testCalcularNotasComValorZero() {
        Troco trocoZero = new Troco(0);
        Map<Integer, Integer> notas = trocoZero.getNotas();
        assertTrue(notas.isEmpty(), "Map de notas deve estar vazio quando o valor do troco é zero");
    }

    @Test
    void testCalcularNotasComValorNegativo() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Troco(-5);
        }, "Deve lançar IllegalArgumentException para valor de troco negativo");
    }
}