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
public class Cola {
    private Object[] arreglo;
    private int frente;
    private int fin;
    private static final int TAMANIO = 10;
    
    public Cola(){
        this.arreglo=new Object[this.TAMANIO];
        this.frente=0;
        this.fin=0;
    }
    
    public boolean poner(Object elem){
        //pone un elemento al final de la cola
        boolean exito=true;
        if((this.fin+1)%this.TAMANIO==this.frente){   //si la cola esta llena retorna false
            exito=false;
        }else{
            this.arreglo[this.fin]=elem;
            this.fin=(this.fin+1)%this.TAMANIO;
        }
        return exito;
    }
    
    public boolean sacar(){
        //saca el primer elemento de la cola
        boolean exito = true;
        if (this.esVacia()){     //si la cola esta vacia retorna false
            exito=false;
        }else{
            this.arreglo[this.frente]=null;
            this.frente=(this.frente +1) % this.TAMANIO;
            exito=true;
        }
        return exito;
    }
    
    public Object obtenerFrente(){
        //retorna el primer elemento de la cola
        Object elem;
        if(this.esVacia()){
            elem=null;
        }else{
            elem=this.arreglo[this.frente];
        }
        return elem;
    }
    
    public boolean esVacia(){
        //retorna true si la cola esta vacia y false si no lo está
        return this.frente==this.fin;
    }
    
    public void vaciar(){
        //vacia toda la cola
        while(frente!=fin){
            this.arreglo[this.frente]=null;
            this.frente=(this.frente+1)%this.TAMANIO;
        }
    }
    
    public Cola clone(){
        //retorna una cola identica a la original
        Cola clon=new Cola();
        clon.frente=this.frente;
        clon.arreglo=this.arreglo.clone();
        clon.fin=this.fin;
        return clon;
    }
    
    public String toString(){
        //devuelve una representacion en String de la cola
        String s="";
        int i=this.frente;
        if(this.esVacia()){
            s="Cola vacía";
        }else{
            s="[";
            while(i!=fin){
                s+=this.arreglo[i];
                i=(i+1)%this.TAMANIO;
                if(arreglo[i]!=null){
                    s+=", ";
                }
                
            }
            s+="]";
        }
        return s;
    }
}
