package com.ticketmachine;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class PapelMoedaTest {

    private PapelMoeda papelMoedaValida;
    private int valorValido = 10;
    private int valorInvalido = 3;

    @BeforeEach
    void setUp() throws PapelMoedaInvalidaException {
        papelMoedaValida = new PapelMoeda(valorValido);
    }

    @Test
    void testConstrutorComValorValido() {
        assertNotNull(papelMoedaValida, "PapelMoeda deve ser criado com valor v�lido");
        assertEquals(valorValido, papelMoedaValida.getValor(), "Valor da PapelMoeda deve ser igual ao valor v�lido");
    }

    @Test
    void testConstrutorComValorInvalido() {
        assertThrows(PapelMoedaInvalidaException.class, () -> {
            new PapelMoeda(valorInvalido);
        }, "Deve lan�ar PapelMoedaInvalidaException para valor inv�lido");
    }

    @Test
    void testIsValidaParaValorValido() {
        assertTrue(papelMoedaValida.isValida(), "isValida deve retornar true para valor v�lido");
    }

    @Test
    void testIsValidaParaValorInvalido() {
        try {
            PapelMoeda papelMoedaInvalida = new PapelMoeda(valorInvalido);
            assertFalse(papelMoedaInvalida.isValida(), "isValida deve retornar false para valor inv�lido");
        } catch (PapelMoedaInvalidaException e) {
            // Exce��o esperada para valor inv�lido, nada a fazer aqui
        }
    }
}