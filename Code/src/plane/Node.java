package plane;

import javafx.scene.shape.Line;

public class Node {

    private Node next;
    private Node prev;
    private Dot first;
    private Dot last;

    public Node(Dot first, Dot last){
        this.next = null;
        this.prev = null;
        this.first = first;
        this.last = last;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }

    public Node getPrev() {
        return prev;
    }

    public void setPrev(Node prev) {
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
}
