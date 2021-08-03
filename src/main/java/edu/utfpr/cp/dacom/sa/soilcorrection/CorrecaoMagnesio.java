package edu.utfpr.cp.dacom.sa.soilcorrection;

public class CorrecaoMagnesio implements ICorrecaoNutriente<FonteMagnesio>{
	
	
		
	//método 1: Soma Fontes de Magnésio
		
		public  double somaFonteMagnesio (
		        double fonteMgFosfatagem,
		        double fonteMgCalagem,
		        double fonteMgPotassagem,
		        double fonteMgAtual) {


		            return fonteMgFosfatagem +
		            	   fonteMgCalagem +
		            	   fonteMgPotassagem +
		            	   fonteMgAtual;
		    } 
		
		
		//método 2: Participação do Magnésio Após Correção
		
				public  double mgPosCorrecao (
				        double somaFonteMagnesio,
				        double ctc) {


				            return somaFonteMagnesio/ctc * 100;
				    } 
		
		

}
