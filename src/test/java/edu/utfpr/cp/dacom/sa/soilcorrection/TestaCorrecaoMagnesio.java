package edu.utfpr.cp.dacom.sa.soilcorrection;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class TestaCorrecaoMagnesio {

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
