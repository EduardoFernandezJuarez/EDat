/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package conjuntistas;

/**
 *
 * @author eduardo.fernandez
 */
public class ArbolBB {
    private NodoABB raiz;
    
    public ArbolBB(){
        this.raiz=null;
    }
    
    public boolean insertar(Comparable elem){
        boolean exito=true;
        if(raiz==null){
            this.raiz=new NodoABB(elem,null,null);
        }else{
            exito=insertarAux(this.raiz,elem);
        }
        return exito;
    }
    private boolean insertarAux(NodoABB n,Comparable elem){
        boolean exito=true;
        if((elem.compareTo(n.getElem())==0)){
            exito=false;
        }else if(elem.compareTo(n.getElem())==0){
            if(n.getIzquierdo()!=null){
                exito=insertarAux(n.getIzquierdo(),elem);
            }else{
                n.setIzquierdo(new NodoABB(elem,null,null));
            }
        }else if(n.getDerecho()!=null){
            exito=insertarAux(n.getDerecho(),elem);
        }else{
            n.setDerecho(new NodoABB(elem,null,null));
        }
        return exito;
    }
    
    public boolean eliminar(Comparable elem){
        boolean exito=false;
        if(!this.esVacio() && this.pertenece(elem)){
            exito=eliminarAux(this.raiz, elem);
        }
        return exito;
    }
    private boolean eliminarAux(NodoABB nodoP, Comparable elem){
        boolean exito=false;
        if(nodoP!=null){
            //Encontrar nodo
            if(elem.compareTo(nodoP.getIzquierdo().getElem())!=0 && elem.compareTo(nodoP.getDerecho().getElem())!=0 && elem.compareTo(nodoP.getElem())!=0){
                //Si no es la raiz y si ninguno de los hijos es el nodo buscado recorre el arbol
                if(elem.compareTo(nodoP.getElem())>0){
                    exito=eliminarAux(nodoP.getDerecho(),elem);
                }else{
                    exito=eliminarAux(nodoP.getIzquierdo(),elem);
                }
            }
            //Si encuentra nodo y todavia no fue eliminado
            if(exito=false){
                NodoABB nodo=null;
                if(elem.compareTo(nodoP.getDerecho().getElem())==0){
                    nodo=nodoP.getDerecho();
                }else if(elem.compareTo(nodoP.getIzquierdo().getElem())==0){
                    nodo=nodoP.getIzquierdo();
                }else{
                    nodo=nodoP;
                }
                if(nodo!=null){
                    if(nodo.getDerecho()==null && nodo.getIzquierdo()==null){//Caso 1: nodo buscado es una hoja
                        //Si el nodo esta a la derecha seteamos el HD de nodoP a null y si esta a la izquierda seteamos el HI de nodoP a null, sino, es la raiz y la seteamos a null
                        if(elem.compareTo(nodoP.getDerecho().getElem())==0){
                            nodoP.setDerecho(null);
                        }else if(elem.compareTo(nodoP.getIzquierdo().getElem())==0){
                            nodoP.setIzquierdo(null);
                        }else{
                            nodo=null;
                        }
                    }else if(nodo.getDerecho()!=null && nodo.getIzquierdo()==null){//Caso 2.1: nodo buscado tiene 1 hijo derecho
                        //Si el nodo esta a la derecha seteamos el HD de nodoP al HD de nodo y si esta a la izquierda seteamos el HI de nodoP al HD de nodo
                        if(elem.compareTo(nodoP.getDerecho().getElem())==0){
                            nodoP.setDerecho(nodo.getDerecho());
                        }else if(elem.compareTo(nodoP.getIzquierdo().getElem())==0){
                            nodoP.setIzquierdo(nodo.getDerecho());
                        }
                    }else if(nodo.getDerecho()==null && nodo.getIzquierdo()!=null){//Caso 2.2: nodo buscado tiene 1 hijo izquierdo
                        //Si el nodo esta a la derecha seteamos el HD de nodoP al HI de nodo y si esta a la izquierda seteamos el HI de nodoP al HI de nodo
                        if(elem.compareTo(nodoP.getDerecho().getElem())==0){
                            nodoP.setDerecho(nodo.getIzquierdo());
                        }else if(elem.compareTo(nodoP.getIzquierdo().getElem())==0){
                            nodoP.setIzquierdo(nodo.getIzquierdo());
                        }
                    }else if(nodo.getDerecho()!=null && nodo.getIzquierdo()!=null){//Caso 3: nodo buscado tiene 2 hijos
                        NodoABB candidato = nodo.getDerecho();//Obtengo el candidato
                        while(candidato.getIzquierdo()!=null){
                            candidato=candidato.getIzquierdo();
                        }
                        NodoABB aux=null;
                        if(candidato.getDerecho()!=null){//Guardo el hijo de candidato en caso de que tenga uno en aux
                            aux=candidato.getDerecho();
                        }
                        NodoABB candidatoPadre = nodo;//Obtengo el padre del candidato
                        if(candidatoPadre.getDerecho()!=candidato){
                            candidatoPadre=candidatoPadre.getDerecho();
                            while(candidatoPadre.getIzquierdo()!=candidato){
                            candidatoPadre=candidatoPadre.getIzquierdo();
                            }
                        }
                        nodo.setElem(candidato.getElem());//Reemplazo nodo por candidato
                        candidato=null;
                        if(aux!=null){//Si candidato tenia hijo lo uno al padre del candidato
                            //Lo uno como HI si candidatoPadre era distinto de nodo o HD si candidato padre es igual a nodo
                            if(candidatoPadre==nodo){
                                candidatoPadre.setDerecho(aux);
                            }else{
                                candidatoPadre.setIzquierdo(aux);
                            }
                        }
                    }
                }
                exito=true;
            }
            
        }
        return exito;
    }
    
    public boolean pertenece(Comparable elem){
        boolean pert=false;
        if(!this.esVacio()){
            pert=perteneceAux(this.raiz, elem);
        }
        return pert;
    }
    private boolean perteneceAux(NodoABB nodo, Comparable elem){
        boolean pert=false;
        if(nodo!=null){
            if(elem.compareTo(nodo.getElem())==0){
                pert=true;
            }else if(elem.compareTo(nodo.getElem())>0){
                pert=perteneceAux(nodo.getDerecho(),elem);
            }else{
                pert=perteneceAux(nodo.getIzquierdo(),elem);
            }
        }
        
        return pert;
    }
    
    public Comparable maximoElem(){
        NodoABB aux = this.raiz;
        while(aux.getDerecho()!=null){
            aux=aux.getDerecho();
        }
        Comparable max = aux.getElem();
        return max;
    }
    public Comparable minimoElem(){
        NodoABB aux = this.raiz;
        while(aux.getIzquierdo()!=null){
            aux=aux.getIzquierdo();
        }
        Comparable max = aux.getElem();
        return max;
    }
    
    public boolean esVacio(){
        boolean vacio=false;
        if(raiz==null){
            vacio=true;
        }
        return vacio;
    }
    public void vaciar(){
        this.raiz=null;
    }
}
