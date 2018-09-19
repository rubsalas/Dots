package game;

import javafx.application.Application;
import javafx.stage.Stage;
import plane.*;
public class GameWindow {


    public static void main(String args[]){

        //Para crear la malla
        GameWindow gameWindow = new GameWindow();
        gameWindow.buildPlane();

    }

    public void buildPlane(){

        Malla malla = new Malla();

        Fila fila1 = new Fila("fila1");
        Fila fila2 = new Fila("fila2");
        Fila fila3 = new Fila("fila3");
        Fila fila4 = new Fila("fila4");
        Fila fila5 = new Fila("fila5");

        malla.add(fila1);
        malla.add(fila2);
        malla.add(fila3);
        malla.add(fila4);
        malla.add(fila5);

        Dot dot11 = new Dot("dot11");
        Dot dot12 = new Dot("dot12");
        Dot dot13 = new Dot("dot13");
        Dot dot14 = new Dot("dot14");
        Dot dot15 = new Dot("dot15");

        fila1.add(dot11);
        fila1.add(dot12);
        fila1.add(dot13);
        fila1.add(dot14);
        fila1.add(dot15);

        Dot dot21 = new Dot("dot21");
        Dot dot22 = new Dot("dot22");
        Dot dot23 = new Dot("dot23");
        Dot dot24 = new Dot("dot24");
        Dot dot25 = new Dot("dot25");

        fila2.add(dot21);
        fila2.add(dot22);
        fila2.add(dot23);
        fila2.add(dot24);
        fila2.add(dot25);

        Dot dot31 = new Dot("dot31");
        Dot dot32 = new Dot("dot32");
        Dot dot33 = new Dot("dot33");
        Dot dot34 = new Dot("dot34");
        Dot dot35 = new Dot("dot35");

        fila3.add(dot31);
        fila3.add(dot32);
        fila3.add(dot33);
        fila3.add(dot34);
        fila3.add(dot35);


        Dot dot41 = new Dot("dot41");
        Dot dot42 = new Dot("dot42");
        Dot dot43 = new Dot("dot43");
        Dot dot44 = new Dot("dot44");
        Dot dot45 = new Dot("dot45");

        fila4.add(dot41);
        fila4.add(dot42);
        fila4.add(dot43);
        fila4.add(dot44);
        fila4.add(dot45);

        Dot dot51 = new Dot("dot51");
        Dot dot52 = new Dot("dot52");
        Dot dot53 = new Dot("dot53");
        Dot dot54 = new Dot("dot54");
        Dot dot55 = new Dot("dot55");

        fila5.add(dot51);
        fila5.add(dot52);
        fila5.add(dot53);
        fila5.add(dot54);
        fila5.add(dot55);

        malla.print(); //Imprime la malla con sus filas y puntos

    }


}
