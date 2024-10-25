package com.ticketmachine;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PapelMoedaTest {

    private PapelMoeda papelMoedaValida;
    private PapelMoeda papelMoedaInvalida;
    private int valorValido = 10;
    private int quantidadeValida = 1;
    private int valorInvalido = -1;  // Exemplo de valor inválido (assumindo que valores negativos sejam inválidos)

    @BeforeEach
    void setUp() {
        // Passa dois parâmetros (valor e quantidade) para o construtor
        papelMoedaValida = new PapelMoeda(valorValido, quantidadeValida);
    }

    @Test
    void testConstrutorComValorValido() {
        assertNotNull(papelMoedaValida, "PapelMoeda deve ser criado com valor válido");
    }

    @Test
    void testConstrutorComValorInvalido() {
        // Exemplo de verificação para construtor com valores negativos, ajuste conforme sua lógica de negócio
        assertThrows(IllegalArgumentException.class, () -> {
            papelMoedaInvalida = new PapelMoeda(valorInvalido, quantidadeValida);
        }, "Deve lançar IllegalArgumentException para valores negativos");
    }

    @Test
    void testValorCorreto() {
        assertEquals(valorValido, papelMoedaValida.getValor(), "O valor da PapelMoeda deve ser o valor inserido");
    }
}