public class Espiral {
	int x, y, h, w, qtd_Voltas;
	
	Espiral (int x, int y, int h, int w, int qtd_Voltas) {
		this.x = x;
		this.y = y;
		this.h = h;
		this.w = w;
		this.qtd_Voltas = qtd_Voltas;
	}
	
	void print () {
		System.out.format("Posicao (%d, %d) / Tamanho (%d, %d) / Quantidade de voltas (%d)", 
				this.x, this.y, this.h, this.w, this.qtd_Voltas);
	}

	public static void main(String[] args) {
		
		Espiral e1 = new Espiral(1, 1, 3, 3, 4);
		e1.print();
		
	}

}