package plane;

import static game.Main.drawTrianguloTest;

public class ListaTriangulos {

    private Triangulo head;
    private int size;
    private String name;


    public ListaTriangulos(String name){
        this.head = null;
        this.size = 0;
        this.name = name;
    }

    public Triangulo getHead() {
        return head;
    }

    public void setHead(Triangulo head) {
        this.head = head;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    /**
     * Consulta si la lista está vacía.
     * @return true si el primer Triangulo(head), no apunta a otro Triangulo.
     */
    public boolean itsEmpty(){
        return this.head == null;
    }

    /**
     * Agrega un nuevo Triangulo al final de la lista.
     * @param newTriangle - nuevo Triangulo por ingresar en lista
     */
    public void add(Triangulo newTriangle){
        if (this.itsEmpty()) { //Verifica que la lista esté vacia
            this.setHead(newTriangle); //Agrega como head a newTriangle
        }
        else { //Recorre la lista hasta llegar al último Triangulo
            Triangulo temp = this.getHead(); //Crea un Triangulo temporal para referencia
            while(temp.getNext() != null){ //Recorre la lista hasta llegar al último Triangulo
                temp = temp.getNext();
            }
            temp.setNext(newTriangle); //Agrega a newTriangle al final de la lista
        }
        this.setSize(this.getSize()+1);
    }

    /**
     * Muestra los triangulos.
     */
    public void show(){
        Triangulo temp = this.getHead();

        while (temp != null){

            drawTrianguloTest(temp,this.getName());

            temp = temp.getNext();
        }
    }

}
