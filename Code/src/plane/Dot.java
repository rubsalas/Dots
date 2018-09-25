package plane;

import javafx.scene.image.ImageView;

/**
 * Representación de un Dot
 *
 * @author Rubén Salas
 * @version 1.2
 * @since 09/11/18
 */
public class Dot {

    private Dot next;
    private Dot prev;
    private double posX; //posicion en X
    private double posY; //posicion en Y
    private String name;
    private ImageView image;
    private int maxSegments;
    private int actualSegments;

    public Dot(String name, ImageView image, int max){
        this.next = null;
        this.prev = null;
        this.posX = 0;
        this.posY = 0;
        this.name = name;
        this.image = image;
        this.maxSegments = max;
        this.actualSegments = 0;
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

    public int getMaxSegments() {
        return maxSegments;
    }

    public void setMaxSegments(int maxSegments) {
        this.maxSegments = maxSegments;
    }

    public int getActualSegments() {
        return actualSegments;
    }

    public void setActualSegments(int actualSegments) {
        this.actualSegments = actualSegments;
    }

    public boolean available(){
        return (this.maxSegments - this.actualSegments) > 0;
    }
}
