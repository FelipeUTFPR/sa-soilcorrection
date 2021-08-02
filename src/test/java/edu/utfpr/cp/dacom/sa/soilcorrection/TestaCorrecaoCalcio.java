package edu.utfpr.cp.dacom.sa.soilcorrection;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class TestaCorrecaoCalcio {

	@Test
    public void testarQtdCaoKgAlqueireFosfotagem() {

        var correcaoFosforo = new CorrecaoFosforo();

        var qtdeAplicadaFosfotagemKgAl = 299.96;

        assertEquals(
            83.99, 
            correcaoFosforo.getNutrientesAdicionais(
            		qtdeAplicadaFosfotagemKgAl, 
                        FonteFosforo.SUPERFOSFATO_SIMPLES)
                            .stream()
                            .findFirst()
                            .get()
                            .getCorrecaoAdicional(),0.5);
    }

    @Test
    public void testaQtdCaoKgHectareFosfotagem() {

    	 var correcaoFosforo = new CorrecaoFosforo();

         var qtdCaoKgAlqueireFosfotagem = 83.99;

         assertEquals(
             34.70, 
             correcaoFosforo.calculaQtdCaoKgHectare(qtdCaoKgAlqueireFosfotagem),0.5);
    }

    @Test
    public void TestaqQtdCaFosfotagemCmolm3() {
    	
    	var correcaoFosforo = new CorrecaoFosforo();

        double QtdCaoKgHectareFosfotagem = 34.70;
        

        assertEquals(0.017, 
             correcaoFosforo.qtdCaFosfotagemCmolm3(QtdCaoKgHectareFosfotagem,
            		 								FonteFosforo.SUPERFOSFATO_SIMPLES),0.5);
                

    }
    
    @Test
    public void testaQtdCaFontePorHe() {
    	
    	var correcaoCalcio = new CorrecaoCalcio();

        

        assertEquals(0.998, 
             correcaoCalcio.qtdCaFontePorHe(FonteCalcio.CALCARIO_CALCITICO),0.5);
                

    }
    
    
    @Test
    public void testaQtdCaAplicar() {
    	
    	var correcaoCalcio = new CorrecaoCalcio();
    	
    	var QtdCaFontePorHe = 0.998;
    	var QtdCaFosfotagemCmolm3 = 0.017;

        

        assertEquals(0.998, 
             correcaoCalcio.calcularQtdCaAplicar(QtdCaFontePorHe, QtdCaFosfotagemCmolm3),0.5);
                

    }

}
