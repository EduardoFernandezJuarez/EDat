/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lineales.dinamicas;

/**
 *
 * @author Eduardo Fernandez Juarez
 */
public class Pila {
    private Nodo tope;
    
    public Pila(){
        this.tope=null;
    }
    
    public boolean apilar(Object nuevoElem){
        Nodo nuevo=new Nodo(nuevoElem, this.tope);
        this.tope=nuevo;
        return true;
    }
    
    public boolean desapilar(){
        boolean exito;
        if(tope==null){
            exito=false;
        }else{
            tope=tope.getEnlace();
            exito=true;
        }
        return exito;
    }
    
    public Object obtenerTope(){
        Object res;
        if(this.tope==null){
            res=null;
        }else{
            res = this.tope.getElem();
        }
        return res;
    }
    
    public boolean esVacia(){
        boolean vacio=false;
        if(tope==null){
           vacio=true;
        }
        return vacio;
    }
    
    public void vaciar(){
        this.tope=null;
    }
    
    public Pila clone(){
        Pila clon = new Pila();
        
        if(!this.esVacia()){
            Nodo aux=this.tope;
            
            Nodo auxClon;
            Nodo nuevo = new Nodo(aux.getElem(),null);
            
            clon.tope=nuevo;
            auxClon = clon.tope;
            aux=aux.getEnlace();
            
            while(aux!=null){
                nuevo=new Nodo(aux.getElem(),null);
                auxClon.setEnlace(nuevo);
                auxClon=auxClon.getEnlace();
                aux=aux.getEnlace();
            }
        }
        return clon;
    }
    
    public String toString(){
        String s="";
        if(this.tope==null){
            s="Pila vacía";
        }else{
            Nodo aux=this.tope;
            s="[";
            while(aux != null){
                s+=aux.getElem().toString();
                aux=aux.getEnlace();
                if(aux!=null){
                    s+=",";
                }
            }
            s+="]";
        }
        return s;
    }
}
