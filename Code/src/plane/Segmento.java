package plane;

import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.scene.shape.StrokeLineCap;

public class Segmento {

    private Segmento next;
    private Segmento prev;
    private Dot first;
    private Dot last;
    private Line line;
    private boolean drawn;
    private boolean available;

    public Segmento(Dot first, Dot last){
        this.next = null;
        this.prev = null;
        this.first = first;
        this.last = last;
        this.setLine();
        this.drawn = false;
        this.available = true;

    }

    public Segmento getNext() {
        return next;
    }

    public void setNext(Segmento next) {
        this.next = next;
    }

    public Segmento getPrev() {
        return prev;
    }

    public void setPrev(Segmento prev) {
        this.prev = prev;
    }

    public Dot getFirst() {
        return first;
    }

    public void setFirst(Dot first) {
        this.first = first;
    }

    public Dot getLast() {
        return last;
    }

    public void setLast(Dot last) {
        this.last = last;
    }

    public Line getLine(){
        return this.line;
    }

   public void setLine(Line line) {
        this.line = line;
    }

    public boolean isDrawn() {
        return drawn;
    }

    public void setDrawn(boolean drawn) {
        this.drawn = drawn;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    public void setLine(){
        double x1 = this.getFirst().getPosX();
        double y1 = this.getFirst().getPosY();
        double x2 = this.getLast().getPosX();
        double y2 = this.getLast().getPosY();

        //dibuja la linea donde se especifica
        this.line = new Line(x1+12.5,y1+12.5,x2+12.5,y2+12.5);
        this.line.setStroke(Color.WHITE);
        this.line.setStrokeLineCap(StrokeLineCap.ROUND);
        this.line.setStrokeWidth(5);
    }

    public boolean isDiagonal(){
        if (this.getFirst().getPosX() == this.getLast().getPosX()){
            return false;
        } else if(this.getFirst().getPosY() == this.getLast().getPosY()){
            return false;
        } else {
            return true;
        }
    }



}
