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
public class Cola {
    private Nodo frente;
    private Nodo fin;
    
    public boolean poner(Object elem){
        boolean exito=true;
        Nodo nuevo=new Nodo(elem, null);
        if(this.esVacia()){
            this.frente=nuevo;
            this.fin=nuevo;
        }else{
            this.fin.setEnlace(nuevo);
            this.fin=nuevo;
        }
        return exito;
    }
    
    public boolean sacar(){
        boolean exito=true;
        if(this.esVacia()){
            exito=false;
        }else{
            this.frente=this.frente.getEnlace();
            if(this.frente==null){
                this.fin=null;
            }
        }
        return exito;
    }
    
    public Object obtenerFrente(){
        Object elem;
        if(this.esVacia()){
            elem=null;
        }else{
            elem=this.frente.getElem();
        }
        return elem;
    }
    
    public boolean esVacia(){
        boolean vacio;
        vacio = this.frente==null;
        return vacio;
    }
    
    public void vaciar(){
        this.frente=null;
        this.fin=null;
    }
    
    public Cola clone(){
        Cola clon = new Cola();
        
        if(!this.esVacia()){
            Nodo aux=this.frente;
            
            Nodo auxClon;
            Nodo nuevo = new Nodo(aux.getElem(),null);
            
            clon.frente=nuevo;
            auxClon = clon.frente;
            aux=aux.getEnlace();
            
            while(aux!=null){
                nuevo=new Nodo(aux.getElem(),null);
                auxClon.setEnlace(nuevo);
                auxClon=auxClon.getEnlace();
                clon.fin=auxClon;
                aux=aux.getEnlace();
            }
        }
        return clon;
    }
    
    public String toString(){
        String s = "";
        
        if(this.esVacia()){
            s="Cola vacia";
        }else{
            Nodo aux = this.frente;
            s="[";
            while(aux!=null){
                s+=aux.getElem().toString();
                aux=aux.getEnlace();
                if(aux!=null){
                    s+=" ,";
                }
            }
            s+="]";
        }
        return s;
    }
    
}
