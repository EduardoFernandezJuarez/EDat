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
public class ArbolGen {
    private NodoGen raiz;
    
    public ArbolGen(){
        this.raiz=null;
    }
    public boolean esVacio(){
        boolean vacio=false;
        if(this.raiz==null){
            vacio=true;
        }
        return vacio;
    }
    public void vaciar(){
        this.raiz=null;
    }
    public boolean insertar(Object elemNuevo, Object elemPadre){
        boolean exito=false;
        if(this.esVacio()){
            //si es vacio lo inserta como la raiz del arbol vacio
            this.raiz=new NodoGen(elemNuevo,null,null);
        }else{
            //si no es vacio busca al padre
            NodoGen padre = obtenerNodo(this.raiz,elemPadre);
            //si encuentra al padre lo inserta como hijo
            if(padre!=null){
                NodoGen nuevo=new NodoGen(elemNuevo,null,null);
                //si tiene un hijo
                if(padre.getHijoIzquierdo()!=null){
                    nuevo.setHermanoDerecho(padre.getHijoIzquierdo());
                }
                padre.setHijoIzquierdo(nuevo);
                exito=true;
            }
        }
        return exito;
    }
    private NodoGen obtenerNodo(NodoGen nodo, Object elem){
        NodoGen resultado = null;
        if(nodo!= null){
            if(nodo.getElem().equals(elem)){
                resultado = nodo;
            }else{
                NodoGen hijo=nodo.getHijoIzquierdo();
                while(hijo!=null && resultado==null){
                    resultado=obtenerNodo(hijo,elem);
                    hijo=hijo.getHermanoDerecho();
                }
            }
        }
        return resultado;
    }
    public boolean pertenece(Object elem){
        boolean encontrado=false;
        NodoGen aux=obtenerNodo(this.raiz,elem);
        if(aux!=null){
            encontrado=true;
        }
        return encontrado;
    }
    public String toString(){
        return toStringAux(this.raiz);
    }
    private String toStringAux(NodoGen n){
        String s="";
        if(n!=null){
            s+=n.getElem().toString() + "-> ";
            NodoGen hijo=n.getHijoIzquierdo();
            while(hijo!=null){
                s+=hijo.getElem().toString() + ", ";
                hijo = hijo.getHermanoDerecho();
            }
            hijo=n.getHijoIzquierdo();
            while(hijo!=null){
                s+="\n" + toStringAux(hijo);
                hijo=hijo.getHermanoDerecho();
            }
        }
        return s;
    }
    public Lista listarPreorden(){
        Lista ls=new Lista();
        listarPreordenAux(ls,this.raiz);
        return ls;
    }
    private void listarPreordenAux(Lista ls,NodoGen nodo){
        if(nodo!=null){
            ls.insertar(nodo.getElem(),ls.longitud()+1);
            if(nodo.getHijoIzquierdo()!=null){
                NodoGen hijo=nodo.getHijoIzquierdo();
                while(hijo!=null){
                    listarPreordenAux(ls,hijo);
                    hijo=hijo.getHermanoDerecho();
                }
            }
        }
    }
    public Lista listarInorden(){
        Lista ls=new Lista();
        listarInordenAux(this.raiz,ls);
        return ls;
    }
    private void listarInordenAux(NodoGen n, Lista ls){
        if(n!=null){
            if(n.getHijoIzquierdo()!=null){
                listarInordenAux(n.getHijoIzquierdo(),ls);
            }
            ls.insertar(n.getElem(), ls.longitud()+1);
            if(n.getHijoIzquierdo()!=null){
                NodoGen hijo = n.getHijoIzquierdo().getHermanoDerecho();
                while(hijo!=null){
                    listarInordenAux(hijo,ls);
                    hijo=hijo.getHermanoDerecho();
                }
            }
        }
    }
    public Lista listarPosorden(){
        Lista ls=new Lista();
        listarPosordenAux(this.raiz,ls);
        return ls;
    }
    private void listarPosordenAux(NodoGen nodo, Lista ls){
        if(nodo!=null){
            NodoGen hijo=nodo.getHijoIzquierdo();
            while(hijo!=null){
                listarPosordenAux(hijo,ls);
                hijo=hijo.getHermanoDerecho();
            }
            ls.insertar(nodo.getElem(), ls.longitud()+1);
        }
    }
    public Object padre(Object elem){
        Object padre;
        padre=padreAux(this.raiz, elem);
        return padre;
    }
    private Object padreAux(NodoGen nodo, Object elem){
        Object padre=null;
        if(nodo!=null){
            NodoGen hijo = nodo.getHijoIzquierdo();
            while(hijo!=null && padre==null){
                if(hijo.getElem().equals(elem)){
                    padre=nodo.getElem();
                }
                hijo=hijo.getHermanoDerecho();
            }
            hijo = nodo.getHijoIzquierdo();
            while(hijo!=null && padre==null){
                padre=padreAux(hijo,elem);
                hijo=hijo.getHermanoDerecho();
            }
        }
        return padre;
    }
    public int altura(){
        int alt=0,i=-1;
        if(!this.esVacio()){
            alt=alturaAux(this.raiz,i);
        }
        return alt;
    }
    private int alturaAux(NodoGen nodo,int i){
        int resIzq, resDer;
        if(nodo!=null){
            resIzq=alturaAux(nodo.getHijoIzquierdo(),i+1);
            resDer=alturaAux(nodo.getHermanoDerecho(),i);
            i=resDer;
            if(resIzq>resDer){
                i=resIzq;
            }
        }
        return i;
    }
    public int nivel(Object elem){
        int nivel=-1,i=-1;
        if(!this.esVacio()){
            nivel=nivelAux(this.raiz,elem,i);
        }
        return nivel;
    }
    private int nivelAux(NodoGen nodo,Object elem,int i){
        if(nodo!=null){
            if(nodo.getElem().equals(elem)){
                i++;
            }else{
                i=nivelAux(nodo.getHijoIzquierdo(),elem,i);
                if(i!=-1){
                    i++;
                }else{
                    i=nivelAux(nodo.getHermanoDerecho(),elem,i);
                }
            }
        }
        return i;
    }
    public boolean sonFrontera(Lista unaLista){
        Lista lClon= unaLista.clone();
        boolean verif= false;
        verif= sonFronteraAux(this.raiz, lClon);
        return verif;

    }

    
    private boolean sonFronteraAux(NodoGen n, Lista lClon){
        boolean verif=false;
        int a;
        if(lClon.esVacia()){
            verif=true;
        }else{
            if(n!= null){
                if(n.getHijoIzquierdo()== null){
                    if(lClon.localizar(n.getElem())!= -1){
                        a= lClon.localizar(n.getElem());
                        lClon.eliminar(a);

                    }

                }
                verif= sonFronteraAux(n.getHijoIzquierdo(), lClon);
                if(!verif){
                    verif= sonFronteraAux(n.getHermanoDerecho(), lClon);
                }
            }
        }
        
        
        return verif;
    }
    public ArbolGen clone(){
        return null;
    }
    public Lista ancestros(){
        return null;
    }
    public Lista listarPorNiveles(){
        return null;
    }
    public int grado(){
        return 0;
    }
    public int gradoSubarbol(){
        return 0;
    }
}
