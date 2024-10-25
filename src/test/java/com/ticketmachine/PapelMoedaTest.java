package com.ticketmachine;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PapelMoedaTest {

    private PapelMoeda papelMoedaValida;
    private PapelMoeda papelMoedaInvalida;
    private int valorValido = 10;
    private int quantidadeValida = 1;
    private int valorInvalido = -1;  // Exemplo de valor inv�lido (assumindo que valores negativos sejam inv�lidos)

    @BeforeEach
    void setUp() {
        // Passa dois par�metros (valor e quantidade) para o construtor
        papelMoedaValida = new PapelMoeda(valorValido, quantidadeValida);
    }

    @Test
    void testConstrutorComValorValido() {
        assertNotNull(papelMoedaValida, "PapelMoeda deve ser criado com valor v�lido");
    }

    @Test
    void testConstrutorComValorInvalido() {
        // Exemplo de verifica��o para construtor com valores negativos, ajuste conforme sua l�gica de neg�cio
        assertThrows(IllegalArgumentException.class, () -> {
            papelMoedaInvalida = new PapelMoeda(valorInvalido, quantidadeValida);
        }, "Deve lan�ar IllegalArgumentException para valores negativos");
    }

    @Test
    void testValorCorreto() {
        assertEquals(valorValido, papelMoedaValida.getValor(), "O valor da PapelMoeda deve ser o valor inserido");
    }
}