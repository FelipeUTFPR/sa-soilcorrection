package correcao.correcaonutriente;

import correcao.ICorrecaoNutriente;
import nutriente.fontes.FonteCalcioMagnesio;

public class CorrecaoCalcioMagnesio implements ICorrecaoNutriente<FonteCalcioMagnesio> {

	//CORREÇÃO CALCIO
	
	//Método 1: Quantidade Total de Ca a aplicar
	
	public double calcularQtdCaAplicar (
	        double caFonteCalcio,
	        double caFonteFosforo) {


	            return caFonteCalcio + caFonteFosforo;
	    }
	
	//Método 2: Quantidade de Ca a Ser adicionada para a Saturação Desejada
	
	public double calcularQtdDesejadaCa (
	        double teorCalcioAtual,
	        double saturacaoDesejada,
	        double qtdCaFosfotagem,
	        double saturacaoAtual) {


	            return  (teorCalcioAtual *
	            		saturacaoDesejada/saturacaoAtual) -
	            		teorCalcioAtual -
	            		qtdCaFosfotagem;
	    }
	
	
	//Método 3: Quantidade corretivo a incorporar

	
	public double qtdCorretivoIncorporar (
	        double qtdDesejadaCa,
	        double qtdTotalCa) {


	            return qtdDesejadaCa / qtdTotalCa;
	    }
	
	//Método 4: Quantidade Calcio adicionada /Ha

	
	public double qtdCalcioPorHa (
	        double qtdCorretivoIncorporar,
	        double qtdTotalCa) {


	            return qtdCorretivoIncorporar * qtdTotalCa;
	    }
	
	//Método 5: Quantidade de Fonte de Calcio a Adicionar em Toneladas/Hectare

	
	public double qtdFonteCalcioAdicionarHa (
	        double qtdCorretivoIncorporar,
	        double prnt) {


	            return qtdCorretivoIncorporar * 100/prnt;
	    }
	
	//Método 6: Quantidade de Fonte de Calcio a Adicionar em Toneladas/Alqueire 

	
	public double qtdFonteCalcioAdicionarAl (
	        double qtdFonteCalcioAdicionarHa) {


	            return qtdFonteCalcioAdicionarHa * 2.42;
	    }
	
	//Método 7: Quantidade corretiva a incorporar Total

	
	public double qtdCorretivoTotal (
	        double qtdCorretivoIncorporar,
	        double areaTalhao) {


	            return qtdCorretivoIncorporar * areaTalhao;
	    }
	
	//Método 8: Custo do Corretivo por Alqueire ->>Pode ser usada a interface ICorreçãoNutriente

	
	public double CustoCorretivoAl (
	        double valorTonFonte,
	        double qtdFonteCalcioAdicionarAl) {


	            return valorTonFonte * qtdFonteCalcioAdicionarAl;
	    }
	
	//Método 9: Custo Total do Corretivo

	
	public double CustoCorretivoTotal (
	        double valorTonFonte,
	        double qtdCorretivoTotal) {


	            return valorTonFonte * qtdCorretivoTotal;
	    }
	
	//CORREÇÃO MAGNÉSIO
	
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
