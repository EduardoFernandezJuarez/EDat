/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lineales.dinamicas;

/**
 *
 * @author eduardo.fernandez
 *
public class metodo_arregloALista {
    //Copiar y pegar este metodo en la clase Lista
    
    //para test ArbolGen
    public void arregloALista(Object[] arreglo){
        //Modifica la lista para tener los mismos elementos que el arreglo
        //Asumimos que la lista esta vacia, porque es para el testArbolGen
        int tamanio = arreglo.length;
        if(tamanio != 0){
            for(int i=tamanio-1;i>0;i--){
                this.cabecera = new Nodo(arreglo[i],this.cabecera);
            }
            this.longitud=tamanio;
        }
    }
}*/
