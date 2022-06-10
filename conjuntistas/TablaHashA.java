/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package conjuntistas;
import lineales.dinamicas.Nodo;
import lineales.dinamicas.Lista;

/**
 *
 * @author eduardo.fernandez
 */
public class TablaHashA {
    
    private static final int TAMANIO=100;
    private Nodo[] hash;
    private int cant;
    
    public TablaHashA(){
        this.hash=null;
        this.cant=0;
    }
    
    public boolean insertar(Object nuevoElem){
        //primero verifica que el elemento ya esta cargado
        //si no lo encuentra, lo pone adelante del resto
        int pos = nuevoElem.hashCode()%this.TAMANIO;
        Nodo aux = this.hash[pos];
        boolean encontrado=false;
        while(!encontrado && aux!=null){
            encontrado = aux.getElem().equals(nuevoElem);
            aux=aux.getEnlace();
        }
        if(!encontrado){
            this.hash[pos]=new Nodo(nuevoElem, this.hash[pos]);
            this.cant++;
        }
        return !encontrado;
    }
    public boolean eliminar(Object elem){
        boolean encontrado=false;
        int pos = elem.hashCode()%this.TAMANIO;
        Nodo aux = this.hash[pos];
        
        if(aux.getElem().equals(elem)){//Se quiere eliminar el primer nodo
            if(aux.getEnlace()==null){
                this.hash[pos]=null;
            }else{
                this.hash[pos].setEnlace(aux.getEnlace());
            }
        }
        
        while(!encontrado && aux!=null){
            encontrado = aux.getEnlace().getElem().equals(elem);
            if(encontrado){
                aux.setEnlace(aux.getEnlace().getEnlace());
            }    
            aux=aux.getEnlace();
        }
        return encontrado;
    }
    public boolean esVacio(){
        boolean vacio=false;
        if(this.cant==0){
            vacio=true;
        }
        return vacio;
    }
    public Lista listar(){
        Lista ls=new Lista();
        int pos=0;
        Nodo aux = this.hash[pos];
        while(pos<=TAMANIO){
            while(aux!=null){
                ls.insertar(aux.getElem(),ls.longitud()+1);
                aux=aux.getEnlace();
            }
            pos++;
        }
        return ls;
    }
}
