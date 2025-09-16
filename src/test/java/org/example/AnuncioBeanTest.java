package org.example;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

class AnuncioBeanTest {

    //o teste lançava execeção, foi refatorado para atender e testar a correção
    @Test
    void testGetValor_DescontoZero_NaoLancaExcecao() {
        ProdutoBean produto = new ProdutoBean("A", "Produto", "", 100.0, "Novo");
        AnuncioBean anuncio = new AnuncioBean(produto, null, 0.0);
        assertEquals(100, anuncio.getValor());
    }

    @Test
    void testGetValor_ComDesconto_CalculoCorreto() {
        ProdutoBean produto = new ProdutoBean("A", "Produto", "", 100.0, "Novo");
        AnuncioBean anuncio = new AnuncioBean(produto, null, 0.2);
        assertEquals(80, anuncio.getValor());
    }
    @Test
    void testGetValor_ProdutoNulo_LancaExcecao() {
        assertThrows(IllegalArgumentException.class, () -> {
            new AnuncioBean(null, null, 0.1);
        });
    }
}