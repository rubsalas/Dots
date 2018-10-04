package plane;

import javafx.scene.paint.Color;
import javafx.scene.shape.Polygon;
import static game.Main.setScorePlayer1;
import static game.Main.setScorePlayer2;

/**
 * Representa un triangulo.
 *
 * @author Rubén Salas
 * @version 1.3
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

    //Métodos setters y getters

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

    /**
     * Verifica si una figura ha sido formada cuando se cierran los segmentos.
     * @param player - jugador
     */
    public void checkCerrado(int player){
        System.out.println("checkCerrado");
        if (this.hipotenusa.isDrawn() && this.vertical.isDrawn() && this.horizontal.isDrawn()){
            System.out.println("CERRADO");
            this.figura.setFill(Color.GRAY);
            this.figura.setStroke(Color.GRAY);
            this.figura.toFront();

            //Modifica el score de cada jugador dependiendo de cual haya completado la figura.
            if (player == 1){
                setScorePlayer1(6);
            } else {
                setScorePlayer2(6);
            }

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
