package org.example;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

class ProdutoBeanTest {

    @Test
    void testCompareTo_ValoresIguais() {
        ProdutoBean produto1 = new ProdutoBean("A", "Produto A", "", 100.0, "Novo");
        ProdutoBean produto2 = new ProdutoBean("B", "Produto B", "", 100.0, "Novo");
        assertEquals(0, produto1.compareTo(produto2));
    }

    @Test
    void testCompareTo_ValorMaior() {
        ProdutoBean produtoMaisCaro = new ProdutoBean("A", "Produto Caro", "", 200.0, "Novo");
        ProdutoBean produtoMaisBarato = new ProdutoBean("B", "Produto Barato", "", 100.0, "Novo");
        assertEquals(1, produtoMaisCaro.compareTo(produtoMaisBarato));
    }
    //o teste falhava antes da implementação da correção
    @Test
    void testCompareTo_ValorMenor_DeveFalhar() {
        ProdutoBean produtoMaisBarato = new ProdutoBean("A", "Produto Barato", "", 100.0, "Novo");
        ProdutoBean produtoMaisCaro = new ProdutoBean("B", "Produto Caro", "", 200.0, "Novo");
        assertEquals(-1, produtoMaisBarato.compareTo(produtoMaisCaro));
    }
}