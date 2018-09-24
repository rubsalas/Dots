package game;

import plane.*;
public class MallaCreator {

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

        Dot dot11 = new Dot("dot11", Main.imageDot11, 3);
        Dot dot12 = new Dot("dot12", Main.imageDot12, 5);
        Dot dot13 = new Dot("dot13", Main.imageDot13, 5);
        Dot dot14 = new Dot("dot14", Main.imageDot14, 5);
        Dot dot15 = new Dot("dot15", Main.imageDot15, 3);

        fila1.add(dot11);
        fila1.add(dot12);
        fila1.add(dot13);
        fila1.add(dot14);
        fila1.add(dot15);

        fila1.setY(1);
        fila1.setX();

        Dot dot21 = new Dot("dot21", Main.imageDot21, 5);
        Dot dot22 = new Dot("dot22", Main.imageDot22, 8);
        Dot dot23 = new Dot("dot23", Main.imageDot23, 8);
        Dot dot24 = new Dot("dot24", Main.imageDot24, 8);
        Dot dot25 = new Dot("dot25", Main.imageDot25, 5);

        fila2.add(dot21);
        fila2.add(dot22);
        fila2.add(dot23);
        fila2.add(dot24);
        fila2.add(dot25);

        fila2.setY(2);
        fila2.setX();

        Dot dot31 = new Dot("dot31", Main.imageDot31, 5);
        Dot dot32 = new Dot("dot32", Main.imageDot32, 8);
        Dot dot33 = new Dot("dot33", Main.imageDot33, 8);
        Dot dot34 = new Dot("dot34", Main.imageDot34, 8);
        Dot dot35 = new Dot("dot35", Main.imageDot35, 5);

        fila3.add(dot31);
        fila3.add(dot32);
        fila3.add(dot33);
        fila3.add(dot34);
        fila3.add(dot35);

        fila3.setY(3);
        fila3.setX();

        Dot dot41 = new Dot("dot41", Main.imageDot41, 5);
        Dot dot42 = new Dot("dot42", Main.imageDot42, 8);
        Dot dot43 = new Dot("dot43", Main.imageDot43, 8);
        Dot dot44 = new Dot("dot44", Main.imageDot44, 8);
        Dot dot45 = new Dot("dot45", Main.imageDot45, 5);

        fila4.add(dot41);
        fila4.add(dot42);
        fila4.add(dot43);
        fila4.add(dot44);
        fila4.add(dot45);

        fila4.setY(4);
        fila4.setX();

        Dot dot51 = new Dot("dot51", Main.imageDot51, 3);
        Dot dot52 = new Dot("dot52", Main.imageDot52, 5);
        Dot dot53 = new Dot("dot53", Main.imageDot53, 5);
        Dot dot54 = new Dot("dot54", Main.imageDot54, 5);
        Dot dot55 = new Dot("dot55", Main.imageDot55, 3);

        fila5.add(dot51);
        fila5.add(dot52);
        fila5.add(dot53);
        fila5.add(dot54);
        fila5.add(dot55);

        fila5.setY(5);
        fila5.setX();

        //malla.print(); //Imprime la malla con sus filas y puntos
        malla.show();

    }


}
