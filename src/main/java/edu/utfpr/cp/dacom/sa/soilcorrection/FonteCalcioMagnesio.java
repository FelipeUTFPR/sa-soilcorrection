package edu.utfpr.cp.dacom.sa.soilcorrection;

import java.util.Set;

import lombok.AllArgsConstructor;
import lombok.Getter;


@AllArgsConstructor //Notação para criar Construtor da classe
@Getter //Notação para criar método get em tempo de compilação

public enum FonteCalcioMagnesio implements IFonteNutriente {
	
	/* Os valores foram retirados da planilha */
	
	CALCARIO_DOMITICO(0.3, 
			Set.of(
            NutrienteAdicional.builder()
            .nome(NomeNutrienteAdicional.MAGNESIO)
            .teorNutriente(0.18).build())),
    CALCARIO_CALCITICO(0.56, 
    		Set.of(
            NutrienteAdicional.builder()
            .nome(NomeNutrienteAdicional.MAGNESIO)
            .teorNutriente(0.05).build())),
    CALCARIO_CONCHA(0.54, Set.of()),
    GESSO_AGRICOLA(0.29, Set.of()),
    HIDROXIDO_CALCIO(0.76, Set.of()),
    CALCARIO_MAGNESIANO(0.35, 
    		Set.of(
            NutrienteAdicional.builder()
            .nome(NomeNutrienteAdicional.MAGNESIO)
            .teorNutriente(0.1).build())),
	
    /* Os valores foram retirados da planilha (VALORES DE CONVERSÃO??) */
    SUPERFOSFATO_SIMPLES(0.49924, Set.of()),
    SUPERFOSFATO_TRIPO(0.33877, Set.of()),
    MAP(0.0, Set.of()),
	DAP(0.0, Set.of()),
	YOORIN(0.49924, Set.of()),
	FOSFATO_ARAD(0.92716, Set.of()),
	FOSFATO_GAFSA(0.92716, Set.of()),
	FOSFATO_DAOUI(0.80235, Set.of()),
	FOSF_PATOS_MINAS(0.49924, Set.of()),
	ESCORAI_DE_THOMAS(0.795218, Set.of()),
	ACIDO_FOSFORICO(0.0, Set.of()),
	MULTIF_MAGNESIANO(0.0, Set.of());
	
	
    private final double teorFonte;
    private final Set<NutrienteAdicional> nutrientesAdicionais;



}
