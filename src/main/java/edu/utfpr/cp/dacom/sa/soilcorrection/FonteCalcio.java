package edu.utfpr.cp.dacom.sa.soilcorrection;

import java.util.Set;

public enum FonteCalcio implements IFonteNutriente {
	
	/* Os valores foram retirados da planilha */
	
	CALCARIO_DOMITICO(0.3, Set.of(new NutrienteAdicional(NomeNutrienteAdicional.MAGNESIO, 0.18))),
    CALCARIO_CALCITICO(0.56, Set.of(new NutrienteAdicional(NomeNutrienteAdicional.MAGNESIO, 0.05))),
    CALCARIO_CONCHA(0.54, Set.of()),
    GESSO_AGRICOLA(0.29, Set.of()),
    HIDROXIDO_CALCIO(0.76, Set.of()),
    CALCARIO_MAGNESIANO(0.35, Set.of(new NutrienteAdicional(NomeNutrienteAdicional.MAGNESIO, 0.1))),
	
    /* Os valores foram retirados da planilha */
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

    FonteCalcio(
        double teorFonte,
        final Set<NutrienteAdicional> nutrientesAdicionais) {

        this.teorFonte = teorFonte;
        this.nutrientesAdicionais = nutrientesAdicionais;
    }

    @Override
    public double getTeorFonte() {
        return this.teorFonte;
    }

    @Override
    public Set<NutrienteAdicional> getNutrientesAdicionais() {
        return this.nutrientesAdicionais;
    }

}
