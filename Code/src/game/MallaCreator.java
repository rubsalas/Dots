package game;

import plane.*;
public class MallaCreator {

    Malla malla = new Malla();

    Fila fila1 = new Fila("fila1");
    Fila fila2 = new Fila("fila2");
    Fila fila3 = new Fila("fila3");
    Fila fila4 = new Fila("fila4");
    Fila fila5 = new Fila("fila5");

    Dot dot11 = new Dot("dot11", Main.imageDot11, 3);
    Dot dot12 = new Dot("dot12", Main.imageDot12, 5);
    Dot dot13 = new Dot("dot13", Main.imageDot13, 5);
    Dot dot14 = new Dot("dot14", Main.imageDot14, 5);
    Dot dot15 = new Dot("dot15", Main.imageDot15, 3);

    Dot dot21 = new Dot("dot21", Main.imageDot21, 5);
    Dot dot22 = new Dot("dot22", Main.imageDot22, 8);
    Dot dot23 = new Dot("dot23", Main.imageDot23, 8);
    Dot dot24 = new Dot("dot24", Main.imageDot24, 8);
    Dot dot25 = new Dot("dot25", Main.imageDot25, 5);

    Dot dot31 = new Dot("dot31", Main.imageDot31, 5);
    Dot dot32 = new Dot("dot32", Main.imageDot32, 8);
    Dot dot33 = new Dot("dot33", Main.imageDot33, 8);
    Dot dot34 = new Dot("dot34", Main.imageDot34, 8);
    Dot dot35 = new Dot("dot35", Main.imageDot35, 5);

    Dot dot41 = new Dot("dot41", Main.imageDot41, 5);
    Dot dot42 = new Dot("dot42", Main.imageDot42, 8);
    Dot dot43 = new Dot("dot43", Main.imageDot43, 8);
    Dot dot44 = new Dot("dot44", Main.imageDot44, 8);
    Dot dot45 = new Dot("dot45", Main.imageDot45, 5);

    Dot dot51 = new Dot("dot51", Main.imageDot51, 3);
    Dot dot52 = new Dot("dot52", Main.imageDot52, 5);
    Dot dot53 = new Dot("dot53", Main.imageDot53, 5);
    Dot dot54 = new Dot("dot54", Main.imageDot54, 5);
    Dot dot55 = new Dot("dot55", Main.imageDot55, 3);



    public void buildPlane(){

        //Ingresa las filas a la malla
        malla.add(fila1);
        malla.add(fila2);
        malla.add(fila3);
        malla.add(fila4);
        malla.add(fila5);


        //Ingresa puntos a la fila1
        fila1.add(dot11);
        fila1.add(dot12);
        fila1.add(dot13);
        fila1.add(dot14);
        fila1.add(dot15);

        //Establece las coordenadas de cada punto en específico de la fila1
        fila1.setY(1);
        fila1.setX();


        //Ingresa puntos a la fila2
        fila2.add(dot21);
        fila2.add(dot22);
        fila2.add(dot23);
        fila2.add(dot24);
        fila2.add(dot25);

        //Establece las coordenadas de cada punto en específico de la fila2
        fila2.setY(2);
        fila2.setX();


        //Ingresa puntos a la fila3
        fila3.add(dot31);
        fila3.add(dot32);
        fila3.add(dot33);
        fila3.add(dot34);
        fila3.add(dot35);

        //Establece las coordenadas de cada punto en específico de la fila3
        fila3.setY(3);
        fila3.setX();


        //Ingresa puntos a la fila4
        fila4.add(dot41);
        fila4.add(dot42);
        fila4.add(dot43);
        fila4.add(dot44);
        fila4.add(dot45);

        //Establece las coordenadas de cada punto en específico de la fila4
        fila4.setY(4);
        fila4.setX();


        //Ingresa puntos a la fila5
        fila5.add(dot51);
        fila5.add(dot52);
        fila5.add(dot53);
        fila5.add(dot54);
        fila5.add(dot55);

        //Establece las coordenadas de cada punto en específico de la fila5
        fila5.setY(5);
        fila5.setX();


        //Muestra la malla en la interfaz
        malla.print();
        malla.show();


    }



    static Lista segmentosHorizontales = new Lista("Horizontales");
    static Lista segmentosVerticales = new Lista("Verticales");
    static Lista segmentosDiagIzqDer = new Lista("Diagonales de Izquierda a Derecha");
    static Lista segmentosDiagDerIzq = new Lista("Diagonales de Derecha a Izquierda");


    public void buildSegments(){

        //Creación de los segmentos horizontales
        Segmento s11_21 = new Segmento(dot11, dot21);
        Segmento s21_31 = new Segmento(dot21, dot31);
        Segmento s31_41 = new Segmento(dot31, dot41);
        Segmento s41_51 = new Segmento(dot41, dot51);

        Segmento s12_22 = new Segmento(dot12, dot22);
        Segmento s22_32 = new Segmento(dot22, dot32);
        Segmento s32_42 = new Segmento(dot32, dot42);
        Segmento s42_52 = new Segmento(dot42, dot52);

        Segmento s13_23 = new Segmento(dot13, dot23);
        Segmento s23_33 = new Segmento(dot23, dot33);
        Segmento s33_43 = new Segmento(dot33, dot43);
        Segmento s43_53 = new Segmento(dot43, dot53);

        Segmento s14_24 = new Segmento(dot14, dot24);
        Segmento s24_34 = new Segmento(dot24, dot34);
        Segmento s34_44 = new Segmento(dot34, dot44);
        Segmento s44_54 = new Segmento(dot44, dot54);

        Segmento s15_25 = new Segmento(dot15, dot25);
        Segmento s25_35 = new Segmento(dot25, dot35);
        Segmento s35_45 = new Segmento(dot35, dot45);
        Segmento s45_55 = new Segmento(dot45, dot55);

        segmentosHorizontales.add(s11_21);
        segmentosHorizontales.add(s21_31);
        segmentosHorizontales.add(s31_41);
        segmentosHorizontales.add(s41_51);

        segmentosHorizontales.add(s12_22);
        segmentosHorizontales.add(s22_32);
        segmentosHorizontales.add(s32_42);
        segmentosHorizontales.add(s42_52);

        segmentosHorizontales.add(s13_23);
        segmentosHorizontales.add(s23_33);
        segmentosHorizontales.add(s33_43);
        segmentosHorizontales.add(s43_53);

        segmentosHorizontales.add(s14_24);
        segmentosHorizontales.add(s24_34);
        segmentosHorizontales.add(s34_44);
        segmentosHorizontales.add(s44_54);

        segmentosHorizontales.add(s15_25);
        segmentosHorizontales.add(s25_35);
        segmentosHorizontales.add(s35_45);
        segmentosHorizontales.add(s45_55);

        segmentosHorizontales.show();



        //Creación de los segmentos verticales
        /*
        Segmento s_ = new Segmento(dot, dot);
        Segmento s_ = new Segmento(dot, dot);
        Segmento s_ = new Segmento(dot, dot);
        Segmento s_ = new Segmento(dot, dot);
        Segmento s_ = new Segmento(dot, dot);

        Segmento s_ = new Segmento(dot, dot);
        Segmento s_ = new Segmento(dot, dot);
        Segmento s_ = new Segmento(dot, dot);
        Segmento s_ = new Segmento(dot, dot);
        Segmento s_ = new Segmento(dot, dot);

        Segmento s_ = new Segmento(dot, dot);
        Segmento s_ = new Segmento(dot, dot);
        Segmento s_ = new Segmento(dot, dot);
        Segmento s_ = new Segmento(dot, dot);
        Segmento s_ = new Segmento(dot, dot);

        Segmento s_ = new Segmento(dot, dot);
        Segmento s_ = new Segmento(dot, dot);
        Segmento s_ = new Segmento(dot, dot);
        Segmento s_ = new Segmento(dot, dot);
        Segmento s_ = new Segmento(dot, dot);

        segmentosVerticales.add();
        segmentosVerticales.add();
        segmentosVerticales.add();
        segmentosVerticales.add();
        segmentosVerticales.add();

        segmentosVerticales.add();
        segmentosVerticales.add();
        segmentosVerticales.add();
        segmentosVerticales.add();
        segmentosVerticales.add();

        segmentosVerticales.add();
        segmentosVerticales.add();
        segmentosVerticales.add();
        segmentosVerticales.add();
        segmentosVerticales.add();

        segmentosVerticales.add();
        segmentosVerticales.add();
        segmentosVerticales.add();
        segmentosVerticales.add();
        segmentosVerticales.add();

        segmentosVerticales.show();

        */



        //Creación de los segmentos diagonales de izquierda a derecha
        /*
        Segmento s_ = new Segmento(dot, dot);
        Segmento s_ = new Segmento(dot, dot);
        Segmento s_ = new Segmento(dot, dot);
        Segmento s_ = new Segmento(dot, dot);

        Segmento s_ = new Segmento(dot, dot);
        Segmento s_ = new Segmento(dot, dot);
        Segmento s_ = new Segmento(dot, dot);
        Segmento s_ = new Segmento(dot, dot);

        Segmento s_ = new Segmento(dot, dot);
        Segmento s_ = new Segmento(dot, dot);
        Segmento s_ = new Segmento(dot, dot);
        Segmento s_ = new Segmento(dot, dot);

        Segmento s_ = new Segmento(dot, dot);
        Segmento s_ = new Segmento(dot, dot);
        Segmento s_ = new Segmento(dot, dot);
        Segmento s_ = new Segmento(dot, dot);

        segmentosDiagIzqDer.add();
        segmentosDiagIzqDer.add();
        segmentosDiagIzqDer.add();
        segmentosDiagIzqDer.add();

        segmentosDiagIzqDer.add();
        segmentosDiagIzqDer.add();
        segmentosDiagIzqDer.add();
        segmentosDiagIzqDer.add();

        segmentosDiagIzqDer.add();
        segmentosDiagIzqDer.add();
        segmentosDiagIzqDer.add();
        segmentosDiagIzqDer.add();

        segmentosDiagIzqDer.add();
        segmentosDiagIzqDer.add();
        segmentosDiagIzqDer.add();
        segmentosDiagIzqDer.add();

        segmentosDiagIzqDer.show();

        */



        //Creación de los segmentos diagonales de derecha a izquierda
        /*
        Segmento s_ = new Segmento(dot, dot);
        Segmento s_ = new Segmento(dot, dot);
        Segmento s_ = new Segmento(dot, dot);
        Segmento s_ = new Segmento(dot, dot);

        Segmento s_ = new Segmento(dot, dot);
        Segmento s_ = new Segmento(dot, dot);
        Segmento s_ = new Segmento(dot, dot);
        Segmento s_ = new Segmento(dot, dot);

        Segmento s_ = new Segmento(dot, dot);
        Segmento s_ = new Segmento(dot, dot);
        Segmento s_ = new Segmento(dot, dot);
        Segmento s_ = new Segmento(dot, dot);

        Segmento s_ = new Segmento(dot, dot);
        Segmento s_ = new Segmento(dot, dot);
        Segmento s_ = new Segmento(dot, dot);
        Segmento s_ = new Segmento(dot, dot);
        */


    }



}
