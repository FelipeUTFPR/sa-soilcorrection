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
    	
    	var correcaoCalcio = new CorrecaoCalcio();

        double QtdCaoKgHectareFosfotagem = 34.70;
        

        assertEquals(0.017, 
             correcaoCalcio.qtdCaFosfotagemCmolm3(QtdCaoKgHectareFosfotagem,
            		 								FonteCalcio.SUPERFOSFATO_SIMPLES), 0.05);
                

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

        

        assertEquals(1.015, 
             correcaoCalcio.calcularQtdCaAplicar(QtdCaFontePorHe, QtdCaFosfotagemCmolm3));
                

    }
    
    @Test
    public void testaQtdDesejadaCa() {
    	
    	var correcaoCalcio = new CorrecaoCalcio();
    	
    	var teorCalcioAtual = 5.76;
    	var saturacaoAtual = 44.7	;	
        var saturacaoDesejada = 55;
        var qtdCaFosfotagem = 0.017;

        

        assertEquals(1.312, 
             correcaoCalcio.calcularQtdDesejadaCa(teorCalcioAtual,
            		 saturacaoDesejada,
            		 qtdCaFosfotagem,
            		 saturacaoAtual),0.5);
                

    }
    
    @Test
    public void testaqtdCorretivoIncorporar() {
    	
    	var correcaoCalcio = new CorrecaoCalcio();
    	
    	var qtdDesejadaCa = 1.312;
        var QtdCaAplicar = 0.998;

        

        assertEquals(1.29, 
             correcaoCalcio.qtdCorretivoIncorporar(qtdDesejadaCa, QtdCaAplicar),0.5);
                

    }
    
    @Test
    public void testaqtdCalcioPorHa() {
    	
    	var correcaoCalcio = new CorrecaoCalcio();
    	
    	var qtdCorretivoIncorporar = 1.29;
        var qtdTotalCa = 1.016;

        

        assertEquals(1.32, 
             correcaoCalcio.qtdCalcioPorHa(qtdCorretivoIncorporar, qtdTotalCa),0.05);
                

    }
    
    @Test
    public void testaqtdFonteCalcioAdicionarHa() {
    	
    	var correcaoCalcio = new CorrecaoCalcio();
    	
    	var qtdCorretivoIncorporar = 1.29;
        var prnt = 70;

        

        assertEquals(1.85, 
             correcaoCalcio.qtdFonteCalcioAdicionarHa(qtdCorretivoIncorporar, prnt),0.05);
                

    }
    
    @Test
    public void testaqtdFonteCalcioAdicionarAl() {
    	
    	var correcaoCalcio = new CorrecaoCalcio();
    	
    	var qtdFonteCalcioAdicionarHa = 1.85;
        

        

        assertEquals(4.47, 
             correcaoCalcio.qtdFonteCalcioAdicionarAl(qtdFonteCalcioAdicionarHa),0.05);
                

    }
    
    
    @Test
    public void testaqtdCorretivoTotal() {
    	
    	var correcaoCalcio = new CorrecaoCalcio();
    	
    	var qtdCorretivoIncorporar = 1.29;
    	var areaTalhao = 4.84;
        

        

        assertEquals(6.25, 
             correcaoCalcio.qtdCorretivoTotal(qtdCorretivoIncorporar,areaTalhao),0.05);
                

    }
    //Diferença de valores, calculado 2235
    @Test
    public void testaCustoCorretivoAl() {
    	
    	var correcaoCalcio = new CorrecaoCalcio();
    	
    	var valorTonFonte = 500;
    	var qtdFonteCalcioAdicionarAl = 4.47;
        

        

        assertEquals(2232.89, 
             correcaoCalcio.CustoCorretivoAl(valorTonFonte,qtdFonteCalcioAdicionarAl),0.5);
                

    }
  //Diferença de valores, calculado 3125
    @Test
    public void testaCustoCorretivoTotal() {
    	
    	var correcaoCalcio = new CorrecaoCalcio();
    	
    	var valorTonFonte = 500;
    	var qtdCorretivoTotal = 6.25;
        

        

        assertEquals(3126.05, 
             correcaoCalcio.CustoCorretivoAl(valorTonFonte,qtdCorretivoTotal),0.5);
                

    }

}
