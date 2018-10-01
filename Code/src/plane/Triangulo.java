package plane;

public class Triangulo {

    Triangulo next;
    Triangulo prev;
    Segmento hipotenusa;
    Segmento horizontal;
    Segmento vertical;

    public Triangulo(Segmento diag, Segmento vert, Segmento hori){
        this.hipotenusa = diag;
        this.horizontal = hori;
        this.vertical = vert;
    }

    public Triangulo getNext() {
        return next;
    }

    public void setNext(Triangulo next) {
        this.next = next;
    }

    public Triangulo getPrev() {
        return prev;
    }

    public void setPrev(Triangulo prev) {
        this.prev = prev;
    }

    public Segmento getHipotenusa() {
        return hipotenusa;
    }

    public void setHipotenusa(Segmento hipotenusa) {
        this.hipotenusa = hipotenusa;
    }

    public Segmento getHorizontal() {
        return horizontal;
    }

    public void setHorizontal(Segmento horizontal) {
        this.horizontal = horizontal;
    }

    public Segmento getVertical() {
        return vertical;
    }

    public void setVertical(Segmento vertical) {
        this.vertical = vertical;
    }
}
