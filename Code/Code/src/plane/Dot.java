package plane;

import javafx.scene.image.ImageView;

/**
 * Representación de un Dot
 *
 * @author Rubén Salas
 * @version 1.0
 * @since 09/11/18
 */
public class Dot {

    private Dot next;
    private Dot prev;
    private int diametro;
    private double posX; //posicion en X
    private double posY; //posicion en Y
    private String name;
    private ImageView image;
    private int countSegments;

    public Dot(String name, ImageView image, int count){
        this.next = null;
        this.prev = null;
        this.diametro = 50;
        this.posX = 0;
        this.posY = 0;
        this.name = name;
        this.image = image;
        this.countSegments = count;
    }


    public Dot getNext() {
        return next;
    }

    public void setNext(Dot next) {
        this.next = next;
    }

    public Dot getPrev() {
        return prev;
    }

    public void setPrev(Dot prev) {
        this.prev = prev;
    }

    public int getDiametro() {
        return diametro;
    }

    public void setDiametro(int diametro) {
        this.diametro = diametro;
    }

    public double getPosX() {
        return posX;
    }

    public void setPosX(double posX) {
        this.posX = posX;
    }

    public double getPosY() {
        return posY;
    }

    public void setPosY(double posY) {
        this.posY = posY;
    }

    public String getName() { return name; }

    public void setName(String name) { this.name = name; }

    public ImageView getImage() {
        return image;
    }

    public void setImage(ImageView image) {
        this.image = image;
    }

    public int getCountSegments() {
        return countSegments;
    }

    public void setCountSegments(int countSegments) {
        this.countSegments = countSegments;
    }
}
