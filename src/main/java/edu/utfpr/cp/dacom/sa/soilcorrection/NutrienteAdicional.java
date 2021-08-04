package edu.utfpr.cp.dacom.sa.soilcorrection;

import java.util.Set;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@RequiredArgsConstructor //Notação para criar Construtor da classe
@Getter //Notação para criar método get em tempo de compilação
@Setter //Notação para criar método set em tempo de compilação
public class NutrienteAdicional {
	
	@Setter(value = AccessLevel.NONE)
    private final NomeNutrienteAdicional nome;
    
    private final double teorNutriente;

    private double correcaoAdicional;

    

 
    
}
