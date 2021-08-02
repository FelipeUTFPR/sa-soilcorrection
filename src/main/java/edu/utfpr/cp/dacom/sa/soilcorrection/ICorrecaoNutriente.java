package edu.utfpr.cp.dacom.sa.soilcorrection;

import java.util.Set;

public interface ICorrecaoNutriente<T extends IFonteNutriente> {

    public default double calculaQuantidadeAplicar(double necessidade, T fonteNutriente) {

        if (necessidade <= 0) {
            throw new IllegalArgumentException();
        }

        return necessidade / fonteNutriente.getTeorFonte();
    }
    
    public default double calculaCusto(double custoFonte, double qtdeAplicar) {

        if (custoFonte <= 0) {
            throw new IllegalArgumentException();
        }

        if (qtdeAplicar <= 0) {
            throw new IllegalArgumentException();
        }

        return custoFonte * qtdeAplicar / 1000;
    }

    public default Set<NutrienteAdicional> getNutrientesAdicionais(double qtdeAplicar, T fonteNutriente) {

        fonteNutriente
            .getNutrientesAdicionais()
            .forEach(
                item -> 
                        item.setCorrecaoAdicional(
                                item.getTeorNutriente() * qtdeAplicar)
            );

        return fonteNutriente.getNutrientesAdicionais();
    }

    public default double calculaEficienciaNutriente(
        double qtdeNutrienteAdicionar, 
        double eficienciaNutriente) {

        if (qtdeNutrienteAdicionar <= 0) {
            throw new IllegalArgumentException();
        }

        if (eficienciaNutriente <= 0) {
            throw new IllegalArgumentException();
        }

        return qtdeNutrienteAdicionar / eficienciaNutriente;
    }
    
    //Primeiro método Criado: Quantidade de Cao em kg/Alqueire numa fonte qualquer de fosforo
    
    public default double calculaQtdCaoKgAlqueire(double qtdAplicadaFonteKgAl, T caoFonteFosforo) {

        if (qtdAplicadaFonteKgAl <= 0) {
            throw new IllegalArgumentException();
        }

        return qtdAplicadaFonteKgAl * caoFonteFosforo.getTeorFonte();
    }
    
    //Segundo método Criado: Quantidade de Cao em Kg/Hectare
    
    public default double calculaQtdCaoKgHectare(double QtdCaoKgAlqueire) {


        return QtdCaoKgAlqueire / 2.42;
    }
    
    //Terceiro método Criado:Quantidade de Ca obtida com a Fosfotagem, portanto
  
    
    
    public default double qtdCaFosfotagemCmolm3(double caFosfatagemConv, T qtdCaoKgHectare) {


        return caFosfatagemConv * qtdCaoKgHectare.getTeorFonte()/1000;
        
    }
    
  //Quarto método Criado: Quantidade de Ca em Cmol/dm³ adicionado em 1 Hectare numa fonte qualquer de Calcio.
    
    public default double qtdCaFontePorHe(T caoFonteCalcio) {


        return caoFonteCalcio.getTeorFonte() * 0.01783 * 100;
        
    }
    
   
    
    
    
    
}
