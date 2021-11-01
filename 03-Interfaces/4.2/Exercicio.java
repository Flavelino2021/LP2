/*Classe Abstrata

A) Caso representativo

Classe: PersonagensDeRpg
Subclasses: Andarilho, Elfo, Bruxo, Feiticeiro

B) Justificativa

Bom, como a classe abstrata é utilizada quando você quer que uma classe que herde dela implemente alguns métodos, mas que também possam ter métodos implementados na própria classe abstrata, resolvi usar um exemplo de jogo de RPG porque quando um personagem é criado, temos um conjunto de subclasses (Andarilho, Elfo, Bruxo, etc..) que possuem características em comum como: força, poder, ataque, habilidade, etc.

C) Esboço do código
*/           

public class abstract Class PersonagensDeRpg {
                
int ataque, força;
String Habilidade, poder;

public Class PersonagensDeRPG(int ataque, int forca, String habilidade, String poder){

this.ataque = ataque;				
this.forca = forca;				
this.habilidade = habilidade;
this.poder = poder;		
}
    
}

/*
INTERFACE 

A)Caso representativo
O abrir e fechar de uma porta e um baú.

B) Justificativa
Resolvi usar como exemplo os objetos porta e baú, pois embora esses objetos sejam de diferentes naturezas, a interação com eles é feita da mesma forma, e métodos como abrir() e fechar() podem ser feitos por ambos objetos. 

C) Esboço do Código*/

public interface Abrivel {
		    
void abrir ( void );		    
void fechar( void );
	    
}



