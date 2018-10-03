package plane;

/**
 * Representa un triangulo.
 *
 * @author Rubén Salas
 * @version 1.1
 * @since 30/09/18
 */
public class Triangulo {

    private Triangulo next;
    private Segmento hipotenusa;
    private Segmento horizontal;
    private Segmento vertical;

    /**
     * Constructor de Triangulo.
     * @param diag - Segmento Diagonal
     * @param vert - Segmento Vertical
     * @param hori - Segmento Horizontal
     */
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
