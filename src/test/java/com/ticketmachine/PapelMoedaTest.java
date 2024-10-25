package com.ticketmachine;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class PapelMoedaTest {

    private PapelMoeda papelMoedaValida;
    private int valorValido = 10;
    private int quantidadeValida = 5;
    private int valorInvalido = 3;
    private int quantidadeInvalida = -1;

    @BeforeEach
    void setUp() throws PapelMoedaInvalidaException {
        // Instanciando com valor e quantidade v�lidos
        papelMoedaValida = new PapelMoeda(valorValido, quantidadeValida);
    }

    @Test
    void testConstrutorComValorValido() {
        assertNotNull(papelMoedaValida, "PapelMoeda deve ser criado com valor v�lido");
        assertEquals(valorValido, papelMoedaValida.getValor(), "Valor da PapelMoeda deve ser igual ao valor v�lido");
        assertEquals(quantidadeValida, papelMoedaValida.getQuantidade(), "Quantidade da PapelMoeda deve ser igual � quantidade v�lida");
    }

    @Test
    void testConstrutorComValorInvalido() {
        // Testando a cria��o de PapelMoeda com valor e quantidade inv�lidos
        assertThrows(PapelMoedaInvalidaException.class, () -> {
            new PapelMoeda(valorInvalido, quantidadeInvalida);
        }, "Deve lan�ar PapelMoedaInvalidaException para valor e/ou quantidade inv�lidos");
    }

    @Test
    void testIsValidaParaValorValido() {
        assertTrue(papelMoedaValida.isValida(), "isValida deve retornar true para valor e quantidade v�lidos");
    }

    @Test
    void testIsValidaParaValorInvalido() {
        // Tentando criar um PapelMoeda inv�lido; a exce��o ser� lan�ada
        assertThrows(PapelMoedaInvalidaException.class, () -> {
            new PapelMoeda(valorInvalido, quantidadeInvalida);
        }, "isValida deve retornar false para valor e/ou quantidade inv�lida");
    }
}