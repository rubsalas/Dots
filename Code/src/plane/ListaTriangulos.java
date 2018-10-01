package plane;

import static game.Main.drawTrianguloTest;

public class ListaTriangulos {

    private Triangulo head;
    private Triangulo tail;
    private int size;
    private String name;


    public ListaTriangulos(String name){
        this.head = null;
        this.tail = null;
        this.size = 0;
        this.name = name;
    }

    public Triangulo getHead() {
        return head;
    }

    public void setHead(Triangulo head) {
        this.head = head;
    }

    public Triangulo getTail() {
        return tail;
    }

    public void setTail(Triangulo tail) {
        this.tail = tail;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    /**
     * Consulta si la lista está vacía.
     *
     * @return true si el primer Enemy (head), no apunta a otro Enemy.
     */
    public boolean itsEmpty(){
        return this.head == null;
    }

    /**
     * Agrega una nueva Line al final de la lista.
     * @param newLine - nueva Line por ingresar en lista
     */


    public void add(Triangulo newLine){
        if (this.itsEmpty()) { //Verifica que la lista esté vacia
            this.setHead(newLine); //Agrega como head a newFila
        }
        else { //Recorre la lista hasta llegar a la última Fila
            Triangulo temp = this.getHead(); //Crea una Fila temporal para referencia
            while(temp.getNext() != null){ //Recorre la lista hasta llegar a la ultima Fila
                temp = temp.getNext();
            }
            temp.setNext(newLine); //Agrega a newLine al final de la lista
        }
        this.setSize(this.getSize()+1);
        //System.out.println("Added: " + newLine.getName());
    }


    /**
     * Imprime la Malla
     */

    //public void print(){}



    public void show(){
        Triangulo temp = this.getHead();

        while (temp != null){

            drawTrianguloTest(temp);

            temp = temp.getNext();
        }
    }


    //public Triangulo search(Dot dot1, Dot dot2){}


}
