public class RectApp {
    public static void main(String[] args) {
        Rect r1 = new Rect(20, 20, 10, 10);
        r1.print();
        r1.Drag(10, 10);
        r1.print();
    }
}

class Rect {
    int x, y, w, h;

    Rect(int x, int y, int w, int h) {
        this.x = x;
        this.y = y;
        this.w = w;
        this.h = h;
    }

    void print() {
        System.out.format("O tamanho do retangulo eh (%d,%d) ele esta na posicao (%d,%d) e a sua area eh %d.\n", this.w, this.h, this.x, this.y, this.Area());
    }

    void Drag(int dx, int dy) {
        this.x += dx;
        this.y += dy;
    }

    int Area(){
        return this.w * this.h;
    }
}