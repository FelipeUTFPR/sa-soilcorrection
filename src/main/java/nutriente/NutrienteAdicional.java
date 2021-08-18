package nutriente;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor //Notação para criar Construtor da classe
@Getter //Notação para criar método get em tempo de compilação
@Setter //Notação para criar método set em tempo de compilação
@Builder //Notação para maniputar variáveis da classe quando instancidas.
public class NutrienteAdicional {
	
	@Setter(value = AccessLevel.NONE)
    private final NomeNutrienteAdicional nome;
    
    private final double teorNutriente;

    private double correcaoAdicional;

    

 
    
}
