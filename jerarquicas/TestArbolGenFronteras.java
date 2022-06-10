/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jerarquicas;

import lineales.dinamicas.Lista;

/**
 *
 * @author eduardo.fernandez
 */
public class TestArbolGenFronteras {

    static String sOk = "\u001B[32m OK! \u001B[0m", sErr = " \u001B[31m ERROR \u001B[0m";
    static String TRUE = "\u001B[32m TRUE \u001B[0m", FALSE = " \u001B[31m FALSE \u001B[0m";
    public static final String NEGRO = "\u001B[30m";
    public static final String ROJO = "\u001B[31m";
    public static final String VERDE = "\u001B[32m";
    public static final String AMARILLO = "\u001B[33m";
    public static final String AZUL = "\u001B[34m";
    public static final String PURPLE = "\u001B[35m";
    public static final String CYAN = "\u001B[36m";
    public static final String BLANCO = "\u001B[37m";

    public static final String ANSI_RED_BACKGROUND = "\u001B[41m";
    public static final String ANSI_GREEN_BACKGROUND = "\u001B[42m";
    public static final String ANSI_YELLOW_BACKGROUND = "\u001B[43m";
    public static final String ANSI_BLUE_BACKGROUND = "\u001B[44m";
    public static final String ANSI_PURPLE_BACKGROUND = "\u001B[45m";
    public static final String ANSI_CYAN_BACKGROUND = "\u001B[46m";
    public static final String ANSI_WHITE_BACKGROUND = "\u001B[47m";

    public static final String RESET = "\u001B[0m";

    public static void main(String[] arg) {
        //Titulo
        System.out.println(ANSI_WHITE_BACKGROUND + PURPLE + "**************************************************************");
        System.out.println(ANSI_WHITE_BACKGROUND + PURPLE + "*                  Test método sonFronteras                  *");
        System.out.println(ANSI_WHITE_BACKGROUND + PURPLE + "*                        de ArbolGen                         *");
        System.out.println(ANSI_WHITE_BACKGROUND + PURPLE + "**************************************************************" + "\n" + RESET);
        System.out.println("---------------------------------------------------------------------" + "\n" + RESET);
        //ArbolGen de intergers
        ArbolGen arbolVacio = new ArbolGen();
        ArbolGen arbol = new ArbolGen();
        arbol.insertar(1, 1);
        arbol.insertar(2, 1);
        arbol.insertar(3, 1);
        arbol.insertar(4, 1);
        arbol.insertar(5, 4);
        arbol.insertar(6, 4);
        arbol.insertar(7, 6);
        arbol.insertar(8, 6);
        arbol.insertar(9, 6);
        arbol.insertar(10, 8);
        arbol.insertar(11, 9);
        arbol.insertar(12, 11);
        arbol.insertar(13, 2);
        arbol.insertar(14, 2);
        arbol.insertar(15, 2);
        arbol.insertar(16, 13);
        arbol.insertar(17, 13);
        arbol.insertar(18, 15);
        arbol.insertar(19, 15);
        arbol.insertar(20, 15);
        System.out.println(ANSI_PURPLE_BACKGROUND  + "Arbol de intergers:" + RESET+"\n");
        System.out.println(
                  "\n                                1"
                + "\n                +---------------+------------+"
                + "\n                |               |            |"
                + "\n                2               3            4"
                + "\n            +---+----+                    +--+--+"
                + "\n            |   |    |                    |     |"
                + "\n           13   14   15                   5     6"
                + "\n         +--+--+   +--+--+                   +--+--+"
                + "\n         |     |   |  |  |                   |  |  |"
                + "\n        16     17  18 19 20                  7  8  9"
                + "\n                                                +  +"
                + "\n                                                |  |"
                + "\n                                                10 11"
                + "\n                                                    +"
                + "\n                                                    |"
                + "\n                                                    12"
                + "\n");
        System.out.println(arbol.toString()+"\n");
        //Listas de intergers
        Lista lsVacia = new Lista();
        Lista lsConFrontera = new Lista();
        Lista lsConYSinFrontera = new Lista();
        Lista lsSinFrontera = new Lista();
        Lista lsSinElementosDelArbol = new Lista();
        
        Object[] arreglo = new Object[]{3,14,7,16,12};
        lsConFrontera.arregloALista(arreglo);
        arreglo = new Object[]{14,4,15,10,18};
        lsConYSinFrontera.arregloALista(arreglo);
        arreglo = new Object[]{1,4,13,9,2};
        lsSinFrontera.arregloALista(arreglo);
        arreglo = new Object[]{21,'a',42,"hola",1.5};
        lsSinElementosDelArbol.arregloALista(arreglo);
        System.out.println(ANSI_PURPLE_BACKGROUND  + "Listas de intergers:" + RESET);
        System.out.println("Lista vacia: "+"[]");
        System.out.println("Lista con elementos de frontera: "+lsConFrontera.toString());
        System.out.println("Lista sin elementos de frontera: "+lsSinFrontera.toString());
        System.out.println("Lista con y sin elementos de frontera: "+lsConYSinFrontera.toString());
        System.out.println("Lista sin elementos del arbol: "+lsSinElementosDelArbol.toString()+"\n");
        System.out.println(ANSI_PURPLE_BACKGROUND  + "Test:" + RESET);
        System.out.println("Llamados a arbol no vacio:");
        System.out.println("Llamo a metodo con lista vacia tiene que dar"+TRUE+"-->"+(arbol.sonFrontera(lsVacia) ? sOk:sErr));
        System.out.println("Llamo a metodo con lista con elementos de frontera tiene que dar"+TRUE+"-->"+(arbol.sonFrontera(lsConFrontera) ? sOk:sErr));
        System.out.println("Llamo a metodo con lista sin elementos de frontera tiene que dar"+FALSE+"-->"+(!arbol.sonFrontera(lsSinFrontera) ? sOk:sErr));
        System.out.println("Llamo a metodo con lista con y sin elementos de frontera tiene que dar"+FALSE+"-->"+(!arbol.sonFrontera(lsConYSinFrontera) ? sOk:sErr));
        System.out.println("Llamo a metodo con lista sin elementos del arbol tiene que dar"+FALSE+"-->"+(!arbol.sonFrontera(lsSinElementosDelArbol) ? sOk:sErr));
        System.out.println("Llamados a arbol vacio:");
        System.out.println("Llamo a metodo con lista vacia tiene que dar"+TRUE+"-->"+(arbolVacio.sonFrontera(lsVacia) ? sOk:sErr));
        System.out.println("Llamo a metodo con lista con elementos tiene que dar"+FALSE+"-->"+(!arbolVacio.sonFrontera(lsConFrontera) ? sOk:sErr));
        
    }
}
