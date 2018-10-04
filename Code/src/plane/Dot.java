package plane;

import javafx.scene.image.ImageView;

/**
 * Representación de un Dot
 *
 * @author Rubén Salas
 * @version 1.4
 * @since 09/11/18
 */
public class Dot {

    private Dot next;
    private double posX;
    private double posY;
    private String name;
    private ImageView image;

    /**
     * Constructor de Dot.
     * @param name - Nombre
     * @param image - Imagen
     */
    public Dot(String name, ImageView image){
        this.next = null;
        this.posX = 0;
        this.posY = 0;
        this.name = name;
        this.image = image;
    }

    //Métodos setters y getters

    public Dot getNext() {
        return next;
    }

    public void setNext(Dot next) {
        this.next = next;
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

}
