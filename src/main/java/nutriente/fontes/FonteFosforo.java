package nutriente.fontes;

import java.util.Set;

import lombok.AllArgsConstructor;
import lombok.Getter;
import nutriente.IFonteNutriente;
import nutriente.NomeNutrienteAdicional;
import nutriente.NutrienteAdicional;


@AllArgsConstructor//Notação para criar Construtor da classe
@Getter //Notação para criar método get em tempo de compilação
public enum FonteFosforo implements IFonteNutriente {
    SUPERFOSFATO_SIMPLES(0.18, 
    		Set.of(
            NutrienteAdicional.builder()
            .nome(NomeNutrienteAdicional.CALCIO)
            .teorNutriente(0.28).build())),
    SUPERFOSFATO_TRIPO(0.41, 
    		Set.of(
            NutrienteAdicional.builder()
            .nome(NomeNutrienteAdicional.CALCIO)
            .teorNutriente(0.2).build())),
    MAP(0.48, 
    		Set.of(
            NutrienteAdicional.builder()
            .nome(NomeNutrienteAdicional.CALCIO)
            .teorNutriente(0.09).build()));

    private final double teorFonte;
    private final Set<NutrienteAdicional> nutrientesAdicionais;

    

  
}
