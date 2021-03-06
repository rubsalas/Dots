package game;

import org.json.JSONException;
import plane.*;

/**
 * Creador de la malla.
 *
 * @author Rubén Salas
 * @version 2.2
 * @since 13/09/18
 */
public class MallaCreator {

    //Se define la malla
    Malla malla = new Malla();

    //Se definen todas las filas con su respectivo nombre
    Fila fila1 = new Fila("fila1");
    Fila fila2 = new Fila("fila2");
    Fila fila3 = new Fila("fila3");
    Fila fila4 = new Fila("fila4");
    Fila fila5 = new Fila("fila5");

    //Se definen todos los puntos con su respectivo nombre y su imagen
    Dot dot11 = new Dot("dot11", Main.imageDot11);
    Dot dot12 = new Dot("dot12", Main.imageDot12);
    Dot dot13 = new Dot("dot13", Main.imageDot13);
    Dot dot14 = new Dot("dot14", Main.imageDot14);
    Dot dot15 = new Dot("dot15", Main.imageDot15);

    Dot dot21 = new Dot("dot21", Main.imageDot21);
    Dot dot22 = new Dot("dot22", Main.imageDot22);
    Dot dot23 = new Dot("dot23", Main.imageDot23);
    Dot dot24 = new Dot("dot24", Main.imageDot24);
    Dot dot25 = new Dot("dot25", Main.imageDot25);

    Dot dot31 = new Dot("dot31", Main.imageDot31);
    Dot dot32 = new Dot("dot32", Main.imageDot32);
    Dot dot33 = new Dot("dot33", Main.imageDot33);
    Dot dot34 = new Dot("dot34", Main.imageDot34);
    Dot dot35 = new Dot("dot35", Main.imageDot35);

    Dot dot41 = new Dot("dot41", Main.imageDot41);
    Dot dot42 = new Dot("dot42", Main.imageDot42);
    Dot dot43 = new Dot("dot43", Main.imageDot43);
    Dot dot44 = new Dot("dot44", Main.imageDot44);
    Dot dot45 = new Dot("dot45", Main.imageDot45);

    Dot dot51 = new Dot("dot51", Main.imageDot51);
    Dot dot52 = new Dot("dot52", Main.imageDot52);
    Dot dot53 = new Dot("dot53", Main.imageDot53);
    Dot dot54 = new Dot("dot54", Main.imageDot54);
    Dot dot55 = new Dot("dot55", Main.imageDot55);

    ListaTriangulos triangulosLowerRight;
    ListaTriangulos triangulosLowerLeft;
    ListaTriangulos triangulosUpperRight;
    ListaTriangulos triangulosUpperLeft;

    /**
     * Retorna la malla.
     * @return malla
     */
    public Malla getMalla(){
        return this.malla;
    }

    /**
     * Construye la malla, con sus respectivas filas y puntos predefinidos.
     */
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
        //malla.print();
        malla.show();

    }

    //Se definen las listas de segmentos por su dirección
    static Lista segmentosVerticales = new Lista("Verticlaes");
    static Lista segmentosHorizontales = new Lista("Horizontales");
    static Lista segmentosDiagIzqDer = new Lista("Diagonales de Izquierda a Derecha");
    static Lista segmentosDiagDerIzq = new Lista("Diagonales de Derecha a Izquierda");


    /**
     * Define los segmentos para que queden listos de dibujar y sus respectivas figuras.
     */
    public void buildSegments() throws JSONException {

        //Creación de los segmentos verticales
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

        //Creación de los segmentos horizontales

        Segmento s11_12 = new Segmento(dot11, dot12);
        Segmento s21_22 = new Segmento(dot21, dot22);
        Segmento s31_32 = new Segmento(dot31, dot32);
        Segmento s41_42 = new Segmento(dot41, dot42);
        Segmento s51_52 = new Segmento(dot51, dot52);

        Segmento s12_13 = new Segmento(dot12, dot13);
        Segmento s22_23 = new Segmento(dot22, dot23);
        Segmento s32_33 = new Segmento(dot32, dot33);
        Segmento s42_43 = new Segmento(dot42, dot43);
        Segmento s52_53 = new Segmento(dot52, dot53);

        Segmento s13_14 = new Segmento(dot13, dot14);
        Segmento s23_24 = new Segmento(dot23, dot24);
        Segmento s33_34 = new Segmento(dot33, dot34);
        Segmento s43_44 = new Segmento(dot43, dot44);
        Segmento s53_54 = new Segmento(dot53, dot54);

        Segmento s14_15 = new Segmento(dot14, dot15);
        Segmento s24_25 = new Segmento(dot24, dot25);
        Segmento s34_35 = new Segmento(dot34, dot35);
        Segmento s44_45 = new Segmento(dot44, dot45);
        Segmento s54_55 = new Segmento(dot54, dot55);

        //Creación de los segmentos diagonales de izquierda a derecha

        Segmento s11_22 = new Segmento(dot11, dot22);
        Segmento s21_32 = new Segmento(dot21, dot32);
        Segmento s31_42 = new Segmento(dot31, dot42);
        Segmento s41_52 = new Segmento(dot41, dot52);

        Segmento s12_23 = new Segmento(dot12, dot23);
        Segmento s22_33 = new Segmento(dot22, dot33);
        Segmento s32_43 = new Segmento(dot32, dot43);
        Segmento s42_53 = new Segmento(dot42, dot53);

        Segmento s13_24 = new Segmento(dot13, dot24);
        Segmento s23_34 = new Segmento(dot23, dot34);
        Segmento s33_44 = new Segmento(dot33, dot44);
        Segmento s43_54 = new Segmento(dot43, dot54);

        Segmento s14_25 = new Segmento(dot14, dot25);
        Segmento s24_35 = new Segmento(dot24, dot35);
        Segmento s34_45 = new Segmento(dot34, dot45);
        Segmento s44_55 = new Segmento(dot44, dot55);

        //Creación de los segmentos diagonales de derecha a izquierda

        Segmento s12_21 = new Segmento(dot12, dot21);
        Segmento s22_31 = new Segmento(dot22, dot31);
        Segmento s32_41 = new Segmento(dot32, dot41);
        Segmento s42_51 = new Segmento(dot42, dot51);

        Segmento s13_22 = new Segmento(dot13, dot22);
        Segmento s23_32 = new Segmento(dot23, dot32);
        Segmento s33_42 = new Segmento(dot33, dot42);
        Segmento s43_52 = new Segmento(dot43, dot52);

        Segmento s14_23 = new Segmento(dot14, dot23);
        Segmento s24_33 = new Segmento(dot24, dot33);
        Segmento s34_43 = new Segmento(dot34, dot43);
        Segmento s44_53 = new Segmento(dot44, dot53);

        Segmento s15_24 = new Segmento(dot15, dot24);
        Segmento s25_34 = new Segmento(dot25, dot34);
        Segmento s35_44 = new Segmento(dot35, dot44);
        Segmento s45_54 = new Segmento(dot45, dot54);

        //Adición de los segmentos horizontales

        segmentosVerticales.add(s11_21);
        segmentosVerticales.add(s21_31);
        segmentosVerticales.add(s31_41);
        segmentosVerticales.add(s41_51);

        segmentosVerticales.add(s12_22);
        segmentosVerticales.add(s22_32);
        segmentosVerticales.add(s32_42);
        segmentosVerticales.add(s42_52);

        segmentosVerticales.add(s13_23);
        segmentosVerticales.add(s23_33);
        segmentosVerticales.add(s33_43);
        segmentosVerticales.add(s43_53);

        segmentosVerticales.add(s14_24);
        segmentosVerticales.add(s24_34);
        segmentosVerticales.add(s34_44);
        segmentosVerticales.add(s44_54);

        segmentosVerticales.add(s15_25);
        segmentosVerticales.add(s25_35);
        segmentosVerticales.add(s35_45);
        segmentosVerticales.add(s45_55);

        segmentosVerticales.show();

        //Adición de los segmetos verticales

        segmentosHorizontales.add(s11_12);
        segmentosHorizontales.add(s21_22);
        segmentosHorizontales.add(s31_32);
        segmentosHorizontales.add(s41_42);
        segmentosHorizontales.add(s51_52);

        segmentosHorizontales.add(s12_13);
        segmentosHorizontales.add(s22_23);
        segmentosHorizontales.add(s32_33);
        segmentosHorizontales.add(s42_43);
        segmentosHorizontales.add(s52_53);

        segmentosHorizontales.add(s13_14);
        segmentosHorizontales.add(s23_24);
        segmentosHorizontales.add(s33_34);
        segmentosHorizontales.add(s43_44);
        segmentosHorizontales.add(s53_54);

        segmentosHorizontales.add(s14_15);
        segmentosHorizontales.add(s24_25);
        segmentosHorizontales.add(s34_35);
        segmentosHorizontales.add(s44_45);
        segmentosHorizontales.add(s54_55);

        segmentosHorizontales.show();

        //Adición de los segmentos diagonales de izquierda a derecha

        segmentosDiagIzqDer.add(s11_22);
        segmentosDiagIzqDer.add(s21_32);
        segmentosDiagIzqDer.add(s31_42);
        segmentosDiagIzqDer.add(s41_52);

        segmentosDiagIzqDer.add(s12_23);
        segmentosDiagIzqDer.add(s22_33);
        segmentosDiagIzqDer.add(s32_43);
        segmentosDiagIzqDer.add(s42_53);

        segmentosDiagIzqDer.add(s13_24);
        segmentosDiagIzqDer.add(s23_34);
        segmentosDiagIzqDer.add(s33_44);
        segmentosDiagIzqDer.add(s43_54);

        segmentosDiagIzqDer.add(s14_25);
        segmentosDiagIzqDer.add(s24_35);
        segmentosDiagIzqDer.add(s34_45);
        segmentosDiagIzqDer.add(s44_55);

        segmentosDiagIzqDer.show();

        //Adición de los segmentos de derecha a izquierda

        segmentosDiagDerIzq.add(s12_21);
        segmentosDiagDerIzq.add(s22_31);
        segmentosDiagDerIzq.add(s32_41);
        segmentosDiagDerIzq.add(s42_51);

        segmentosDiagDerIzq.add(s13_22);
        segmentosDiagDerIzq.add(s23_32);
        segmentosDiagDerIzq.add(s33_42);
        segmentosDiagDerIzq.add(s43_52);

        segmentosDiagDerIzq.add(s14_23);
        segmentosDiagDerIzq.add(s24_33);
        segmentosDiagDerIzq.add(s34_43);
        segmentosDiagDerIzq.add(s44_53);

        segmentosDiagDerIzq.add(s15_24);
        segmentosDiagDerIzq.add(s25_34);
        segmentosDiagDerIzq.add(s35_44);
        segmentosDiagDerIzq.add(s45_54);

        segmentosDiagDerIzq.show();


        //Listas de triangulos

        triangulosLowerRight = new ListaTriangulos("TriangulosLowerRight");
        triangulosLowerLeft = new ListaTriangulos("TriangulosLowerLeft");
        triangulosUpperRight = new ListaTriangulos("TriangulosUpperRight");
        triangulosUpperLeft = new ListaTriangulos("TriangulosUpperLeft");

        //Creación de los triangulos lower right

        Triangulo triLowRightaa = new Triangulo(s12_21, s12_22, s21_22);
        Triangulo triLowRightab = new Triangulo(s13_22, s13_23, s22_23);
        Triangulo triLowRightac = new Triangulo(s14_23, s14_24, s23_24);
        Triangulo triLowRightad = new Triangulo(s15_24, s15_25, s24_25);

        Triangulo triLowRightba = new Triangulo(s22_31, s22_32, s31_32);
        Triangulo triLowRightbb = new Triangulo(s23_32, s23_33, s32_33);
        Triangulo triLowRightbc = new Triangulo(s24_33, s24_34, s33_34);
        Triangulo triLowRightbd = new Triangulo(s25_34, s25_35, s34_35);

        Triangulo triLowRightca = new Triangulo(s32_41, s32_42, s41_42);
        Triangulo triLowRightcb = new Triangulo(s33_42, s33_43, s42_43);
        Triangulo triLowRightcc = new Triangulo(s34_43, s34_44, s43_44);
        Triangulo triLowRightcd = new Triangulo(s35_44, s35_45, s44_45);

        Triangulo triLowRightda = new Triangulo(s42_51, s42_52, s51_52);
        Triangulo triLowRightdb = new Triangulo(s43_52, s43_53, s52_53);
        Triangulo triLowRightdc = new Triangulo(s44_53, s44_54, s53_54);
        Triangulo triLowRightdd = new Triangulo(s45_54, s45_55, s54_55);

        //Adición de los triangulos lower right

        triangulosLowerRight.add(triLowRightaa);
        triangulosLowerRight.add(triLowRightab);
        triangulosLowerRight.add(triLowRightac);
        triangulosLowerRight.add(triLowRightad);

        triangulosLowerRight.add(triLowRightba);
        triangulosLowerRight.add(triLowRightbb);
        triangulosLowerRight.add(triLowRightbc);
        triangulosLowerRight.add(triLowRightbd);

        triangulosLowerRight.add(triLowRightca);
        triangulosLowerRight.add(triLowRightcb);
        triangulosLowerRight.add(triLowRightcc);
        triangulosLowerRight.add(triLowRightcd);

        triangulosLowerRight.add(triLowRightda);
        triangulosLowerRight.add(triLowRightdb);
        triangulosLowerRight.add(triLowRightdc);
        triangulosLowerRight.add(triLowRightdd);

        triangulosLowerRight.show();

        //Creación de los triangulos lower left

        Triangulo triLowLeftaa = new Triangulo(s11_22,s11_21,s21_22);
        Triangulo triLowLeftab = new Triangulo(s12_23,s12_22,s22_23);
        Triangulo triLowLeftac = new Triangulo(s13_24,s13_23,s23_24);
        Triangulo triLowLeftad = new Triangulo(s14_25,s14_24,s24_25);

        Triangulo triLowLeftba = new Triangulo(s21_32,s21_31,s31_32);
        Triangulo triLowLeftbb = new Triangulo(s22_33,s22_32,s32_33);
        Triangulo triLowLeftbc = new Triangulo(s23_34,s23_33,s33_34);
        Triangulo triLowLeftbd = new Triangulo(s24_35,s24_34,s34_35);

        Triangulo triLowLeftca = new Triangulo(s31_42,s31_41,s41_42);
        Triangulo triLowLeftcb = new Triangulo(s32_43,s32_42,s42_43);
        Triangulo triLowLeftcc = new Triangulo(s33_44,s33_43,s43_44);
        Triangulo triLowLeftcd = new Triangulo(s34_45,s34_44,s44_45);

        Triangulo triLowLeftda = new Triangulo(s41_52,s41_51,s51_52);
        Triangulo triLowLeftdb = new Triangulo(s42_53,s42_52,s52_53);
        Triangulo triLowLeftdc = new Triangulo(s43_54,s43_53,s53_54);
        Triangulo triLowLeftdd = new Triangulo(s44_55,s44_54,s54_55);

        //Adición de los triangulos lower left

        triangulosLowerLeft.add(triLowLeftaa);
        triangulosLowerLeft.add(triLowLeftab);
        triangulosLowerLeft.add(triLowLeftac);
        triangulosLowerLeft.add(triLowLeftad);

        triangulosLowerLeft.add(triLowLeftba);
        triangulosLowerLeft.add(triLowLeftbb);
        triangulosLowerLeft.add(triLowLeftbc);
        triangulosLowerLeft.add(triLowLeftbd);

        triangulosLowerLeft.add(triLowLeftca);
        triangulosLowerLeft.add(triLowLeftcb);
        triangulosLowerLeft.add(triLowLeftcc);
        triangulosLowerLeft.add(triLowLeftcd);

        triangulosLowerLeft.add(triLowLeftda);
        triangulosLowerLeft.add(triLowLeftdb);
        triangulosLowerLeft.add(triLowLeftdc);
        triangulosLowerLeft.add(triLowLeftdd);

        triangulosLowerLeft.show();

        //Creación de los triangulos upper right

        Triangulo triUpRightaa = new Triangulo(s11_22,s12_22,s11_12);
        Triangulo triUpRightab = new Triangulo(s12_23,s13_23,s12_13);
        Triangulo triUpRightac = new Triangulo(s13_24,s14_24,s13_14);
        Triangulo triUpRightad = new Triangulo(s14_25,s15_25,s14_15);

        Triangulo triUpRightba = new Triangulo(s21_32,s22_32,s21_22);
        Triangulo triUpRightbb = new Triangulo(s22_33,s23_33,s22_23);
        Triangulo triUpRightbc = new Triangulo(s23_34,s24_34,s23_24);
        Triangulo triUpRightbd = new Triangulo(s24_35,s25_35,s24_25);

        Triangulo triUpRightca = new Triangulo(s31_42,s32_42,s31_32);
        Triangulo triUpRightcb = new Triangulo(s32_43,s33_43,s32_33);
        Triangulo triUpRightcc = new Triangulo(s33_44,s34_44,s33_34);
        Triangulo triUpRightcd = new Triangulo(s34_45,s35_45,s34_35);

        Triangulo triUpRightda = new Triangulo(s41_52,s42_52,s41_42);
        Triangulo triUpRightdb = new Triangulo(s42_53,s43_53,s42_43);
        Triangulo triUpRightdc = new Triangulo(s43_54,s44_54,s43_44);
        Triangulo triUpRightdd = new Triangulo(s44_55,s45_55,s44_45);

        //Adición de los triangulos upper right

        triangulosUpperRight.add(triUpRightaa);
        triangulosUpperRight.add(triUpRightab);
        triangulosUpperRight.add(triUpRightac);
        triangulosUpperRight.add(triUpRightad);

        triangulosUpperRight.add(triUpRightba);
        triangulosUpperRight.add(triUpRightbb);
        triangulosUpperRight.add(triUpRightbc);
        triangulosUpperRight.add(triUpRightbd);

        triangulosUpperRight.add(triUpRightca);
        triangulosUpperRight.add(triUpRightcb);
        triangulosUpperRight.add(triUpRightcc);
        triangulosUpperRight.add(triUpRightcd);

        triangulosUpperRight.add(triUpRightda);
        triangulosUpperRight.add(triUpRightdb);
        triangulosUpperRight.add(triUpRightdc);
        triangulosUpperRight.add(triUpRightdd);

        triangulosUpperRight.show();

        //Creación de los triangulos upper left

        Triangulo triUpLeftaa = new Triangulo(s12_21,s11_21,s11_12);
        Triangulo triUpLeftab = new Triangulo(s13_22,s12_22,s12_13);
        Triangulo triUpLeftac = new Triangulo(s14_23,s13_23,s13_14);
        Triangulo triUpLeftad = new Triangulo(s15_24,s14_24,s14_15);

        Triangulo triUpLeftba = new Triangulo(s22_31,s21_31,s21_22);
        Triangulo triUpLeftbb = new Triangulo(s23_32,s22_32,s22_23);
        Triangulo triUpLeftbc = new Triangulo(s24_33,s23_33,s23_24);
        Triangulo triUpLeftbd = new Triangulo(s25_34,s24_34,s24_25);

        Triangulo triUpLeftca = new Triangulo(s32_41,s31_41,s31_32);
        Triangulo triUpLeftcb = new Triangulo(s33_42,s32_42,s32_33);
        Triangulo triUpLeftcc = new Triangulo(s34_43,s33_43,s33_34);
        Triangulo triUpLeftcd = new Triangulo(s35_44,s34_44,s34_35);

        Triangulo triUpLeftda = new Triangulo(s42_51,s41_51,s41_42);
        Triangulo triUpLeftdb = new Triangulo(s43_52,s42_52,s42_43);
        Triangulo triUpLeftdc = new Triangulo(s44_53,s43_53,s43_44);
        Triangulo triUpLeftdd = new Triangulo(s45_54,s44_54,s44_45);

        //Adición de los triangulos upper left

        triangulosUpperLeft.add(triUpLeftaa);
        triangulosUpperLeft.add(triUpLeftab);
        triangulosUpperLeft.add(triUpLeftac);
        triangulosUpperLeft.add(triUpLeftad);

        triangulosUpperLeft.add(triUpLeftba);
        triangulosUpperLeft.add(triUpLeftbb);
        triangulosUpperLeft.add(triUpLeftbc);
        triangulosUpperLeft.add(triUpLeftbd);

        triangulosUpperLeft.add(triUpLeftca);
        triangulosUpperLeft.add(triUpLeftcb);
        triangulosUpperLeft.add(triUpLeftcc);
        triangulosUpperLeft.add(triUpLeftcd);

        triangulosUpperLeft.add(triUpLeftda);
        triangulosUpperLeft.add(triUpLeftdb);
        triangulosUpperLeft.add(triUpLeftdc);
        triangulosUpperLeft.add(triUpLeftdd);

        triangulosUpperLeft.show();

    }

    //Métodos setters y getters

    public ListaTriangulos getTriangulosLowerRight() {
        return triangulosLowerRight;
    }

    public void setTriangulosLowerRight(ListaTriangulos triangulosLowerRight) {
        this.triangulosLowerRight = triangulosLowerRight;
    }

    public ListaTriangulos getTriangulosLowerLeft() {
        return triangulosLowerLeft;
    }

    public void setTriangulosLowerLeft(ListaTriangulos triangulosLowerLeft) {
        this.triangulosLowerLeft = triangulosLowerLeft;
    }

    public ListaTriangulos getTriangulosUpperRight() {
        return triangulosUpperRight;
    }

    public void setTriangulosUpperRight(ListaTriangulos triangulosUpperRight) {
        this.triangulosUpperRight = triangulosUpperRight;
    }

    public ListaTriangulos getTriangulosUpperLeft() {
        return triangulosUpperLeft;
    }

    public void setTriangulosUpperLeft(ListaTriangulos triangulosUpperLeft) {
        this.triangulosUpperLeft = triangulosUpperLeft;
    }

    public static Lista getSegmentosVerticales() {
        return segmentosVerticales;
    }

    public static void setSegmentosVerticales(Lista segmentosVerticales) {
        MallaCreator.segmentosVerticales = segmentosVerticales;
    }

    public static Lista getSegmentosHorizontales() {
        return segmentosHorizontales;
    }

    public static void setSegmentosHorizontales(Lista segmentosHorizontales) {
        MallaCreator.segmentosHorizontales = segmentosHorizontales;
    }

    public static Lista getSegmentosDiagIzqDer() {
        return segmentosDiagIzqDer;
    }

    public static void setSegmentosDiagIzqDer(Lista segmentosDiagIzqDer) {
        MallaCreator.segmentosDiagIzqDer = segmentosDiagIzqDer;
    }

    public static Lista getSegmentosDiagDerIzq() {
        return segmentosDiagDerIzq;
    }

    public static void setSegmentosDiagDerIzq(Lista segmentosDiagDerIzq) {
        MallaCreator.segmentosDiagDerIzq = segmentosDiagDerIzq;
    }
}