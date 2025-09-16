package org.example;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;

class AnuncianteBeanTest {

    @Test
    void testValorMedioAnuncios_SemAnuncios_RetornaZero() {
        AnuncianteBean anunciante = new AnuncianteBean("Vendedor", "123", new ArrayList<>());
        Double media = anunciante.valorMedioAnuncios();
        assertEquals(0.0, media);
    }

    @Test
    void testValorMedioAnuncios_ComAnuncios_RetornaValor(){
        ProdutoBean produto = new ProdutoBean("A", "Produto", "", 100.0, "Novo");
        AnuncioBean anuncio = new AnuncioBean(produto, null, 0.2);
        ArrayList<AnuncioBean> anuncios = new ArrayList<AnuncioBean>();
        anuncios.add(anuncio);
        AnuncianteBean anunciante = new AnuncianteBean("Vendedor", "123", anuncios);
        assertEquals(80, anunciante.valorMedioAnuncios());
    }
}