package br.feevale.estado;

import br.feevale.quadrado.Quadrado;
import br.feevale.regra.EstadoRegras;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class EstadoTest {

    @Test
    public void deveTestarCorretamenteACriacaoDeEstados() {

        /*
        * 1 2 3
        * 4 5 6
        * 7 0 8
        * */
        String inicial = "123456708";

        /*
         * 1 2 3
         * 4 0 6
         * 7 5 8
         * */
        String objetivo = "123406758";

        Estado estado = new Estado(new Quadrado(objetivo), new Quadrado(inicial));
        boolean encontrou = estado.encontrarObjetivo();
        Assertions.assertTrue(encontrou);
    }


    @Test
    public void deveTestarCorretamenteACriacaoDeEstados2() {

        /*
         * 1 2 3
         * 4 5 6
         * 7 0 8
         * */
        String inicial = "123456708";

        /*
         * 1 0 3
         * 4 2 6
         * 7 5 8
         * */
        String objetivo = "103426758";

        Estado estado = new Estado(new Quadrado(objetivo), new Quadrado(inicial));
        boolean encontrou = estado.encontrarObjetivo();
        Assertions.assertTrue(encontrou);
    }

}