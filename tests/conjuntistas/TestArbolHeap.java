/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tests.conjuntistas;
import conjuntistas.ArbolHeap;

/**
 *
 * @author eduardo.fernandez
 */
public class TestArbolHeap {
    
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
    
    public static void main(String[] arg){
        //Titulo
        System.out.println(ANSI_CYAN_BACKGROUND + ROJO + "**************************************************************");
        System.out.println(ANSI_CYAN_BACKGROUND + ROJO + "*                  Test Arbol Heap                           *");
        System.out.println(ANSI_CYAN_BACKGROUND + ROJO + "**************************************************************" + "\n\n" + RESET);
        //Inicializacion de arbol
        ArbolHeap a= new ArbolHeap();
        System.out.println(ANSI_CYAN_BACKGROUND+ROJO+"Pruebas con Arbol vacio"+RESET);
        System.out.println("Checkeo si es vacio " + ((a.esVacio()) ? sOk : sErr));
        System.out.println("Intento vaciar arbol vacio ");
        a.vaciar();
        System.out.println(ANSI_CYAN_BACKGROUND+ROJO+"Pruebas con Arbol no vacio"+RESET);
        System.out.println("Intento insertar 1 en raiz"+((a.insertar(1)) ? sOk : sErr));
        System.out.println("Intento insertar 2"+((a.insertar(2)) ? sOk : sErr));
        System.out.println("Intento insertar 2"+((a.insertar(3)) ? sOk : sErr));
        System.out.println("Intento insertar 2"+((a.insertar(4)) ? sOk : sErr));
        System.out.println("Intento insertar 2"+((a.insertar(5)) ? sOk : sErr));
        System.out.println("Intento insertar 2"+((a.insertar(6)) ? sOk : sErr));
        System.out.println("Intento insertar 2"+((a.insertar(7)) ? sOk : sErr));
        System.out.println("Intento insertar 2"+((a.insertar(8)) ? sOk : sErr));
        System.out.println("Intento insertar 2"+((a.insertar(9)) ? sOk : sErr));
        System.out.println("Intento insertar 2"+((a.insertar(10)) ? sOk : sErr));
        System.out.println("El arbol heap: ");
        System.out.println(a.toString());
        System.out.println("Intento eliminar cima '1': "+((a.eliminarCima()) ? sOk : sErr));
        System.out.println("Intento eliminar cima '2': "+((a.eliminarCima()) ? sOk : sErr));
        System.out.println("Arbol heap: \n"+a.toString());
        System.out.println("Recupero cima, espero '3': --> "+a.recuperarCima());
        System.out.println("Clono arbol: ");
        ArbolHeap aClon=a.clone();
        System.out.println("Arbol clonado: \n"+aClon.toString());
        System.out.println("Vaciar arbol clonado");
        aClon.vaciar();
        System.out.println("Checkeo si clon es vacio " + ((aClon.esVacio()) ? sOk : sErr));
        
    }
}
