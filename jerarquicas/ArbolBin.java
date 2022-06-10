/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jerarquicas;
import lineales.dinamicas.Lista;

/**
 *
 * @author Eduardo Fernandez Juarez
 */
public class ArbolBin {
    private NodoArbol raiz;
    
    public ArbolBin(){
        this.raiz = null;
    }
    //METODOS PARA LISTAR
    public Lista listarPreorden(){
        Lista lis = new Lista();
        listarPreordenAux(this.raiz, lis);
        return lis;
    }
    private void listarPreordenAux(NodoArbol nodo, Lista lis){
        //metodo recursivo PRIVADO porque su parametro es de tipo NodoArbol
        if(nodo != null){
            //visita el elemento en el nodo
            lis.insertar(nodo.getElem(), lis.longitud()+1);
            
            //recorre a sus hijos en preorden
            listarPreordenAux(nodo.getIzquierdo(),lis);
            listarPreordenAux(nodo.getDerecho(), lis);
        }
    }
    public Lista listarInorden(){
        Lista lis = new Lista();
        listarInordenAux(this.raiz, lis);
        return lis;
    }
    private void listarInordenAux(NodoArbol nodo, Lista lis){
        if(nodo != null){
            listarInordenAux(nodo.getIzquierdo(), lis);
            lis.insertar(nodo.getElem(), lis.longitud()+1);
            listarInordenAux(nodo.getDerecho(), lis);
        }
    }
    
    public Lista listarPosorden(){
        Lista lis = new Lista();
        listarPosordenAux(this.raiz, lis);
        return lis;
    }
    private void listarPosordenAux(NodoArbol nodo, Lista lis){
        if(nodo != null){
            listarPosordenAux(nodo.getIzquierdo(), lis);
            listarPosordenAux(nodo.getDerecho(), lis);
            lis.insertar(nodo.getElem(), lis.longitud()+1);
            
        }
    }
    
    //OTROS METODOS
    public boolean insertar(Object elemNuevo, Object elemPadre, char lugar){
        boolean exito=true;
        
        if(this.raiz == null){
            //si el arbol esta vacio, pone elem nuevo en raiz
            this.raiz = new NodoArbol(elemNuevo, null, null);
        }else{
            //si arbol no esta vacio busca al padre
            NodoArbol nPadre = obtenerNodo(this.raiz, elemPadre);
            
            //si existe y lugar no esta ocupado lo pone sino da false
            if(nPadre != null){
                if(lugar == 'I' && nPadre.getIzquierdo()==null){
                    nPadre.setIzquierdo(new NodoArbol(elemNuevo, null, null));
                }else if(lugar == 'D' && nPadre.getDerecho()==null){
                    nPadre.setDerecho(new NodoArbol(elemNuevo, null, null));
                }else{
                    exito=false;
                }
            }else{
                exito=false;
            }
        }
        return exito;
    } 
    private NodoArbol obtenerNodo(NodoArbol n, Object buscado){
        /*metodo privado busca un elemento y devuelve el nodo que
        lo contiene, si no se encuentra buscado devuelve null*/
        NodoArbol resultado = null;
        if(n!=null){
            if(n.getElem().equals(buscado)){
                resultado=n;
            }else{
                resultado = obtenerNodo(n.getIzquierdo(),buscado);
                if(resultado==null){
                    resultado=obtenerNodo(n.getDerecho(),buscado);
                }
            }
        }
        return resultado;
    }
    public boolean esVacio(){
        boolean res=false;
        if(this.raiz==null){
            res=true;
        }
        return res;
    }
    public void vaciar(){
        this.raiz=null;
    }
    
    public Object padre(Object elem){
        Object padre;
        padre=padreAux(this.raiz, elem);
        return padre;
    }
    private Object padreAux(NodoArbol nodo, Object elem){
        Object padre=null;
        if(nodo!=null){ //si el arbol no esta vacio
            if(nodo.getElem().equals(elem)){ //Si pregunta por el padre de la raiz retorna null
                padre=null;
            }
            if(nodo.getIzquierdo()!=null){
                if(nodo.getIzquierdo().getElem().equals(elem)){ //revisa el hijo izquierdo
                    padre=nodo.getElem();
                }
            }
            if(nodo.getDerecho()!=null){
                if(nodo.getDerecho().getElem().equals(elem)){ //revisa el hijo derecho
                    padre=nodo.getElem();
                }
            }
            if(padre==null){
                padre=padreAux(nodo.getIzquierdo(),elem);
                if(padre==null){
                    padre=padreAux(nodo.getDerecho(),elem);
                }
            }
        }
        return padre;
    }
    
    
    public int altura(){
        int altura;
        altura=alturaAux(this.raiz);
        return altura;
    }
    private int alturaAux(NodoArbol nodo){
        int altura, alturaIzq=0, alturaDer=0;
        if(nodo==null){
            altura=-1;
        }else{
            alturaIzq+=alturaAux(nodo.getIzquierdo())+1;
            alturaDer+=alturaAux(nodo.getDerecho())+1;
            if(alturaIzq>=alturaDer){
            altura=alturaIzq;
            }else{
            altura=alturaDer;
            }
        }
        return altura;
    }
    /*public int nivel(Object elem){
        int nivel;
        if(obtenerNodo(this.raiz,elem)==null){
            nivel=-1;
        }else{
            nivel=nivelAux(obtenerNodo(this.raiz,elem), elem);
        }
        return nivel;
    }
    private int nivelAux(NodoArbol nodo, Object elem){
        int nivel=0;
        Object temp;
        if(nodo == null){   //arbol vacio
            nivel=-1;
        }else{
            if(nodo.getElem()!=elem){
                nivel+=nivelAux(nodo.getIzquierdo(),elem)+1;
                if(nivel==-1){
                    nivel+=nivelAux(nodo.getDerecho(),elem)+1;
                }
            }
        }
        return nivel;
    }*/
    public int nivel(Object elem){
        int nivel = -1;
        if(!this.esVacio()){
            nivel = nivelAux(this.raiz,elem,0);
        }
        return nivel;
    }
    private int nivelAux(NodoArbol nodo, Object elem, int i){
        int nivel = -1;
        if(nodo != null){
            if(nodo.getElem().equals(elem)){
                nivel=i;
            }
        }else{
            nivel=nivelAux(nodo.getIzquierdo(),elem,i+1);
            if(nivel==-1){
                nivel=nivelAux(nodo.getDerecho(),elem,i+1);
            }
        }
        return nivel;
    }
    public Lista listarPorNiveles(){
        return null;
    }
    public ArbolBin clone(){
        return null;
    }
    public Lista frontera(){
        return null;
    }
}
