package plane;

import javafx.scene.paint.Color;
import javafx.scene.shape.Polygon;

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
    private Polygon figura;

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

    public Polygon getFigura() {
        return figura;
    }

    public void setFigura(Polygon figura) {
        this.figura = figura;
    }



    public void checkCerrado(){
        System.out.println("checkCerrado");
        if (this.hipotenusa.isDrawn() == true && this.vertical.isDrawn() == true && this.horizontal.isDrawn() == true){
            System.out.println("CERRADO");
            this.figura.setFill(Color.GRAY);
            this.figura.setStroke(Color.GRAY);
            this.figura.toFront();

            //Lleva los puntos al frente de los triangulos
            this.getHipotenusa().getFirst().getImage().toFront();
            this.getHipotenusa().getLast().getImage().toFront();
            this.getHorizontal().getFirst().getImage().toFront();
            this.getHorizontal().getLast().getImage().toFront();
            this.getVertical().getFirst().getImage().toFront();
            this.getVertical().getLast().getImage().toFront();
        }
    }

}
