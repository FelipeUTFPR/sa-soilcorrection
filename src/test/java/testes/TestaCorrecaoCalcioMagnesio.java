package testes;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import correcao.correcaonutriente.CorrecaoCalcioMagnesio;
import correcao.correcaonutriente.CorrecaoFosforo;
import correcao.correcaonutriente.CorrecaoMagnesio;
import nutriente.fontes.FonteCalcioMagnesio;
import nutriente.fontes.FonteFosforo;
import nutriente.fontes.FonteMagnesio;

class TestaCorrecaoCalcioMagnesio {
	
	//TESTE CORREÇÃO CALCIO

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
    	
    	var correcaoCalcio = new CorrecaoCalcioMagnesio();

        double QtdCaoKgHectareFosfotagem = 34.70;
        

        assertEquals(0.017, 
             correcaoCalcio.qtdCaFosfotagemCmolm3(QtdCaoKgHectareFosfotagem,
            		 								FonteCalcioMagnesio.SUPERFOSFATO_SIMPLES), 0.05);
                

    }
    
    @Test
    public void testaQtdCaFontePorHe() {
    	
    	var correcaoCalcio = new CorrecaoCalcioMagnesio();

        

        assertEquals(0.998, 
             correcaoCalcio.qtdCaFontePorHe(FonteCalcioMagnesio.CALCARIO_CALCITICO),0.5);
                

    }
    
    
    @Test
    public void testaQtdCaAplicar() {
    	
    	var correcaoCalcio = new CorrecaoCalcioMagnesio();
    	
    	var QtdCaFontePorHe = 0.998;
    	var QtdCaFosfotagemCmolm3 = 0.017;

        

        assertEquals(1.015, 
             correcaoCalcio.calcularQtdCaAplicar(QtdCaFontePorHe, QtdCaFosfotagemCmolm3));
                

    }
    
    @Test
    public void testaQtdDesejadaCa() {
    	
    	var correcaoCalcio = new CorrecaoCalcioMagnesio();
    	
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
    	
    	var correcaoCalcio = new CorrecaoCalcioMagnesio();
    	
    	var qtdDesejadaCa = 1.312;
        var QtdCaAplicar = 0.998;

        

        assertEquals(1.29, 
             correcaoCalcio.qtdCorretivoIncorporar(qtdDesejadaCa, QtdCaAplicar),0.5);
                

    }
    
    @Test
    public void testaqtdCalcioPorHa() {
    	
    	var correcaoCalcio = new CorrecaoCalcioMagnesio();
    	
    	var qtdCorretivoIncorporar = 1.29;
        var qtdTotalCa = 1.016;

        

        assertEquals(1.32, 
             correcaoCalcio.qtdCalcioPorHa(qtdCorretivoIncorporar, qtdTotalCa),0.05);
                

    }
    
    @Test
    public void testaqtdFonteCalcioAdicionarHa() {
    	
    	var correcaoCalcio = new CorrecaoCalcioMagnesio();
    	
    	var qtdCorretivoIncorporar = 1.29;
        var prnt = 70;

        

        assertEquals(1.85, 
             correcaoCalcio.qtdFonteCalcioAdicionarHa(qtdCorretivoIncorporar, prnt),0.05);
                

    }
    
    @Test
    public void testaqtdFonteCalcioAdicionarAl() {
    	
    	var correcaoCalcio = new CorrecaoCalcioMagnesio();
    	
    	var qtdFonteCalcioAdicionarHa = 1.85;
        

        

        assertEquals(4.47, 
             correcaoCalcio.qtdFonteCalcioAdicionarAl(qtdFonteCalcioAdicionarHa),0.05);
                

    }
    
    
    @Test
    public void testaqtdCorretivoTotal() {
    	
    	var correcaoCalcio = new CorrecaoCalcioMagnesio();
    	
    	var qtdCorretivoIncorporar = 1.29;
    	var areaTalhao = 4.84;
        

        

        assertEquals(6.25, 
             correcaoCalcio.qtdCorretivoTotal(qtdCorretivoIncorporar,areaTalhao),0.05);
                

    }
    //Diferença de valores, calculado 2235
    @Test
    public void testaCustoCorretivoAl() {
    	
    	var correcaoCalcio = new CorrecaoCalcioMagnesio();
    	
    	var valorTonFonte = 500;
    	var qtdFonteCalcioAdicionarAl = 4.47;
        

        

        assertEquals(2232.89, 
             correcaoCalcio.CustoCorretivoAl(valorTonFonte,qtdFonteCalcioAdicionarAl),0.5);
                

    }
  //Diferença de valores, calculado 3125
    @Test
    public void testaCustoCorretivoTotal() {
    	
    	var correcaoCalcio = new CorrecaoCalcioMagnesio();
    	
    	var valorTonFonte = 500;
    	var qtdCorretivoTotal = 6.25;
        

        

        assertEquals(3126.05, 
             correcaoCalcio.CustoCorretivoAl(valorTonFonte,qtdCorretivoTotal),0.5);
        
        //TESTE CORREÇÃO MAGNÉSIO

    }
    
	@Test
    public void testarQtdMagnesioFonteCalcio() {

        var correcaoMagnesio = new CorrecaoMagnesio();

        var qtdCorrIncorporar = 1.29;

        assertEquals(
            0.16018, 
            correcaoMagnesio.qtdMagnesioFonteCalcio(FonteMagnesio.CALCARIO_CALCITICO, qtdCorrIncorporar),0.05);
    }
	
	@Test
    public void testarQtdMagnesioFontePotassio() {

        var correcaoMagnesio = new CorrecaoMagnesio();

        var qtdKgHePotassagem = 450.55;

        assertEquals(
            0.0, 
            correcaoMagnesio.qtdMagnesioFontePotassio(FonteMagnesio.CLORETO_POTASSIO, qtdKgHePotassagem));
    }

    @Test
    public void testarQtdMagnesioFonteFosfatagem() {

    	 var correcaoMagnesio = new CorrecaoMagnesio();

         

         assertEquals(
             0.0, 
             correcaoMagnesio.qtdMagnesioFonteFosforo(FonteMagnesio.SUPERFOSFATO_SIMPLES),0.05);
    }
    
    
    @Test
    public void testarSomaFonteMagnesio() {

    	 var correcaoMagnesio = new CorrecaoMagnesio();
    	 var fonteMgFosfatagem = 0;
	     var fonteMgCalagem = 0.16018;
	     var fonteMgPotassagem = 0;
	     var fonteMgAtual = 1.63;

         

         assertEquals(
             1.79, 
             correcaoMagnesio.somaFonteMagnesio(
            		 fonteMgFosfatagem,
                     fonteMgCalagem,
                     fonteMgPotassagem,
                     fonteMgAtual), 0.05);
    }
    
    @Test
    public void testarMgPosCorrecao() {

    	 var correcaoMagnesio = new CorrecaoMagnesio();
    	 var somaFonteMagnesio = 1.79;
    	 var ctc = 12.89;

         

         assertEquals(
             13.9, 
             correcaoMagnesio.mgPosCorrecao(somaFonteMagnesio,ctc),0.05);
    }
		

}
