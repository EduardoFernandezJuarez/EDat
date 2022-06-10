/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lineales.estaticas;

/**
 *
 * @author Eduardo Fernandez Juarez
 */
public class Pila {
    private Object[] arreglo;
    private int tope;
    private static final int tamanio=10;
    
    public Pila(){
        this.arreglo=new Object[tamanio];
        this.tope = -1;
    }
    
    public boolean apilar(Object nuevoElem){
        //Agrega un elemento al tope de la pila
        boolean exito;
        if(this.tope+1>=this.tamanio){
            exito=false;
        }else{
            this.tope++;
            this.arreglo[tope]=nuevoElem;
            exito=true;
        }
        return exito;
    }
    
    public boolean desapilar(){
        //Elimina el elemento tope de la pila
        boolean exito;
        if(this.tope<0){
            exito=false;
        }else{
            this.arreglo[this.tope]=null;
            this.tope--;
            exito=true;
        }
        return exito;
    }
    
    public Object obtenerTope(){
        //Devuelve el elemento al tope de la pila
        if(this.tope>=0){
            return this.arreglo[this.tope];
        }
        return null;
    }
    
    public boolean esVacia(){
        //Devuelve si la pila esta vacia(true) o no(false)
        boolean vacio=false;
        if(this.tope==-1){
            vacio=true;
        }
        return vacio;
    }
    
    public void vaciar(){
        //Elimina todos los elementos de la pila
        if(this.tope>=0){
            arreglo[this.tope]=null;
            this.tope--;
            vaciar();
        }
    }
    
    public Pila clone(){
        //Devuelve una Pila copia exacta de la pila original
        Pila clon=new Pila();
        clon.tope=this.tope;
        clon.arreglo=this.arreglo.clone();
        return clon;
    }
    
    public String toString(){
        //Devuelve una representacion en String de todos los elementos de la Pila
        int i=0;
        String s="";
        boolean hastaTope=true;
        if(this.tope<0){
            s="Pila vacía";
        }else{
            s = "[";
            while(hastaTope){
                if(i<this.tope){
                    s+=this.arreglo[i].toString()+", ";
                    i++;
                }else if(i==this.tope){
                    s+=this.arreglo[i].toString();
                    i++;
                }else{
                    hastaTope=false;
                }
            }
            s+="]";
        }
        return s;
    }
}
