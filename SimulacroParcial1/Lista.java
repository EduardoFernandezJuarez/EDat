/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SimulacroParcial1;
import lineales.dinamicas.Nodo;

/**
 *
 * @author eduardo.fernandez
 */
public class Lista {
    private Nodo cabecera;
    private int longitud;
    
    public Lista(){
        this.cabecera=null;
        this.longitud=0;
    }
    
    public int longitud(){
        return this.longitud;
    }
    public boolean insertar(Object nuevoElem, int pos){
        boolean exito=true;
        if(pos<1 || pos>this.longitud()+1){
            exito=false;
        }else{
            if(pos==1){
                this.cabecera=new Nodo(nuevoElem, this.cabecera);
            }else{
                Nodo aux = this.cabecera;
                int i=1;
                while(i<pos-1){
                    aux = aux.getEnlace();
                    i++;
                }
                Nodo nuevo = new Nodo(nuevoElem, aux.getEnlace());
                aux.setEnlace(nuevo);
            }
            longitud++;
        }
        return exito;
    }
    
    public boolean eliminar(int pos){
        boolean exito;
        if(pos > longitud || pos < 1){
            exito=false;
        }else{
            if(pos==1){
                this.cabecera = cabecera.getEnlace();
            }else{
                Nodo aux = this.cabecera;
                int i=1;
                while(i<pos-1){
                    aux=aux.getEnlace();
                    i++;
                }
                aux.setEnlace(aux.getEnlace().getEnlace());
            }
            this.longitud--;
            exito=true;
        }
        return exito;
    }
    
    public Object recuperar(int pos){
        Object retornado = null;
        if(pos<=this.longitud && pos>=1){
            if(pos==1){
                retornado = this.cabecera.getElem();
                }
            Nodo aux = this.cabecera;
            int i=1;
            while(i!=pos){
                aux=aux.getEnlace();
                i++;
            }
            retornado=aux.getElem();
        }
        return retornado;
    }
    
    public int localizar(Object elem){
        int ubicacion=-1;
        int i=1;
        Nodo aux=this.cabecera;
        while(aux!=null){
            if(aux.getElem()==elem){
                aux=null;
                ubicacion=i;
            }else{
                aux = aux.getEnlace();
                i++;
            }
        }
        return ubicacion;
    }
    
    public void vaciar(){
        this.cabecera = null;
        this.longitud = 0;
    }
    
    public boolean esVacia(){
        boolean vacio=false;
        if(this.cabecera==null){
            vacio=true;
        }
        return vacio;
    }
    
    public Lista clone(){
        Lista clon = new Lista();
        clon.longitud = this.longitud;
        
        if(!this.esVacia()){
            Nodo aux = this.cabecera;
            Nodo aux2 = new Nodo(aux.getElem(), null);
            
            clon.cabecera = aux2;
            
            Nodo aux3;
            aux = aux.getEnlace();
            
            while(aux != null){
                
                aux3 = new Nodo(aux.getElem(), null);
                
                aux2.setEnlace(aux3);
                aux2 = aux2.getEnlace();
                aux=aux.getEnlace();
            }
        }
        return clon;
    }
    
    public String toString(){
        String s="";
        if(this.cabecera == null){
            s="Lista vacia";
        }else{
            Nodo aux = this.cabecera;
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
