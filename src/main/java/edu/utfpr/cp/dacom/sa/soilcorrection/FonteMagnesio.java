package edu.utfpr.cp.dacom.sa.soilcorrection;

import java.util.Set;

import lombok.AllArgsConstructor;
import lombok.Getter;



@AllArgsConstructor //Notação para criar Construtor da classe
@Getter //Notação para criar método get em tempo de compilação

public enum FonteMagnesio implements IFonteNutriente{
/* Magnesio nas Fontes de Calcio em % */
	
	CALCARIO_DOMITICO(18.0, Set.of()),
    CALCARIO_CALCITICO(5.0, Set.of()),
    CALCARIO_CONCHA(0.0, Set.of()),
    GESSO_AGRICOLA(0.0, Set.of()),
    HIDROXIDO_CALCIO(0.0, Set.of()),
    CALCARIO_MAGNESIANO(10.0, Set.of()),
	
    /* Magnesio nas Fontes de Fosforo em % */
    SUPERFOSFATO_SIMPLES(0.0, Set.of()),
    SUPERFOSFATO_TRIPO(0.0, Set.of()),
    MAP(0.0, Set.of()),
	DAP(0.0, Set.of()),
	YOORIN(15.0, Set.of()),
	FOSFATO_ARAD(0.0, Set.of()),
	FOSFATO_GAFSA(0.0, Set.of()),
	FOSFATO_DAOUI(0.0, Set.of()),
	FOSF_PATOS_MINAS(0.0, Set.of()),
	ESCORAI_DE_THOMAS(0.0, Set.of()),
	ACIDO_FOSFORICO(0.0, Set.of()),
	MULTIF_MAGNESIANO(0.0, Set.of()),
	
	/* Magnesio nas Fontes de Potassio em % */
	CLORETO_POTASSIO(0.0, Set.of()),
    SULFATO_POTASSIO(0.0, Set.of()),
    SULFATO_POTASSIO_MAGNESIO(18.0, Set.of());

    private final double teorFonte;
    private final Set<NutrienteAdicional> nutrientesAdicionais;

   

   
}
