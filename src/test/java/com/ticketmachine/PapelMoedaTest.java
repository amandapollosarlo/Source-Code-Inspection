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
        // Instanciando com valor e quantidade válidos
        papelMoedaValida = new PapelMoeda(valorValido, quantidadeValida);
    }

    @Test
    void testConstrutorComValorValido() {
        assertNotNull(papelMoedaValida, "PapelMoeda deve ser criado com valor válido");
        assertEquals(valorValido, papelMoedaValida.getValor(), "Valor da PapelMoeda deve ser igual ao valor válido");
        assertEquals(quantidadeValida, papelMoedaValida.getQuantidade(), "Quantidade da PapelMoeda deve ser igual à quantidade válida");
    }

    @Test
    void testConstrutorComValorInvalido() {
        // Testando a criação de PapelMoeda com valor e quantidade inválidos
        assertThrows(PapelMoedaInvalidaException.class, () -> {
            new PapelMoeda(valorInvalido, quantidadeInvalida);
        }, "Deve lançar PapelMoedaInvalidaException para valor e/ou quantidade inválidos");
    }

    @Test
    void testIsValidaParaValorValido() {
        assertTrue(papelMoedaValida.isValida(), "isValida deve retornar true para valor e quantidade válidos");
    }

    @Test
    void testIsValidaParaValorInvalido() {
        // Tentando criar um PapelMoeda inválido; a exceção será lançada
        assertThrows(PapelMoedaInvalidaException.class, () -> {
            new PapelMoeda(valorInvalido, quantidadeInvalida);
        }, "isValida deve retornar false para valor e/ou quantidade inválida");
    }
}