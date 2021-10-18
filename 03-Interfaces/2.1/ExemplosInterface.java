/*****************************************************************
. Interface 1: Objetos que possuem teclas e que são tecláveis    *
                                                                 *
. Objetos: Teclado de Computador, Piano, Urna Eletrônica         *
                                                                 *
. Adjetivo: ‘Teclável’                                           *
                                                                 *
. Métodos: teclar(), pressionar()                                *
                                                                 *
*****************************************************************/

interface Teclavel{
int teclar(int f);
int pressionar(int f);
}

class Teclado implements Teclavel{
	void teclar (int f){ //f = parâmetro força
	}
	void pressionar (int f){	
	}
}

class Piano implements Teclavel{
	void teclar (int f){
	}
	void pressionar (int f){	
	}
}
class UrnaEletronica implements Teclavel{
	void teclar (int f){
	}
	void pressionar (int f){	
	}
}

/*********************************************************************************
. Interface 2: Instrumentos musicais que podem ser tocados                       *
                                                                                 *
. Objetos: Sopro(Wind), Percurssão(Percurssion), Instrumento de Corda(Stringed)  *
                                                                                 *
. Adjetivo: ‘Playable’                                                           *
                                                                                 *
. Métodos: play(), adjust()                                                      *
                                                                                 *
*********************************************************************************/


interface Playable {
     void play(int note) ;  
     void adjust(int tuner);

}

class Wind implements Playable{
     public void play(int note) {  
     //tocar nota musical
    }
     public void adjust(int tuner){
     //ajustar instrumento
    }
}

class Percussion implements Playable{
     public void play(int note) {  
     //tocar nota musical
    }
     public void adjust(int tuner){
     //ajustar instrumento
    }
}

class Stringed implements Playable{
      public void play(int note) {  
      //tocar nota musical
    }
      public void adjust(int tuner){
      //ajustar instrumento
    }
}