package edu.utfpr.cp.dacom.sa.soilcorrection;

import java.util.Set;

import lombok.AllArgsConstructor;
import lombok.Getter;



@AllArgsConstructor //Notação para criar Construtor da classe
@Getter //Notação para criar método get em tempo de compilação
public enum FontePotassio implements IFonteNutriente {
    CLORETO_POTASSIO(0.58, Set.of()),
    SULFATO_POTASSIO(0.52, Set.of()),
    SULFATO_POTASSIO_MAGNESIO(0.22, Set.of(
            NutrienteAdicional.builder()
            .nome(NomeNutrienteAdicional.MAGNESIO)
            .teorNutriente(0.18).build()));
    
    private final double teorFonte;
    private final Set<NutrienteAdicional> nutrientesAdicionais;

    

    
}
