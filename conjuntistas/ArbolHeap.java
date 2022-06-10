/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package conjuntistas;

/**
 *
 * @author eduardo fernandez juarez
 */
public class ArbolHeap {
    private static final int TAMANIO = 20;
    private Comparable[] heap;
    private int ultimo;
    
    public ArbolHeap(){
        this.heap = new Comparable[this.TAMANIO];
        this.ultimo=0;
    }
    
    public boolean insertar(Comparable nuevoElem){
        boolean exito=false;
        if(this.ultimo+1<this.TAMANIO){ //Si no esta lleno
            this.heap[this.ultimo+1]=nuevoElem;
            this.ultimo++;
            
            insertarAux(this.ultimo);
            exito=true;
        }
        return exito;
    }
    private void insertarAux(int posNuevoElem){
        int posP;
        Comparable temp = this.heap[posNuevoElem];
        boolean salir = false;
        
        while(!salir){
            posP=posNuevoElem/2;
            if(posNuevoElem<=1){
                salir=true;
            }else{
                if(temp.compareTo(this.heap[posP])<0){//Si nuevo elemento es menor los intercambia
                    this.heap[posNuevoElem]=this.heap[posP];
                    this.heap[posP]=temp;
                    posNuevoElem=posP;
                }else{
                    salir=true;
                }
            }
            
        }
    }
    public boolean eliminarCima(){
        boolean exito;
        if(this.ultimo==0){
            //estructura vacia
            exito=false;
        }else{
            //saca la raiz y pone la ultimo hoja en su lugar
            this.heap[1] = this.heap[ultimo];
            this.ultimo--;
            //restablece la propiedad de heap minimo
            hacerBajar(1);
            exito=true;
        }
        return exito;
    }
    private void hacerBajar(int posPadre){
        int posH;
        Comparable temp = this.heap[posPadre];
        boolean salir = false;
        
        while(!salir) {
            posH = posPadre*2;
            if(posH<=this.ultimo){
                //temp tiene al menos un hijo (izq) y lo considera menor
                
                if(posH < this.ultimo){
                    //hijoMenor tiene hermano derecho
                    
                    if(this.heap[posH+1].compareTo(this.heap[posH]) < 0){
                        //el hijo derecho es el menor de los dos
                        posH++;
                    }
                }
                
                //compara el hijo menor con el padre
                if(this.heap[posH].compareTo(temp) < 0){
                    //el hijo es menor que el padre, los intercambia
                    this.heap[posPadre]=this.heap[posH];
                    this.heap[posH]=temp;
                    posPadre=posH;
                }else{
                    //el padre es menor que sus hijos, esta bien ubicado
                    salir=true;
                }
            }else{
                //el temp es hoja, esta bien ubicado
                salir=true;
            }
        }
    }
    public Comparable recuperarCima(){
        Comparable cima;
        return this.heap[1];
    }
    public String toString(){
        String s="";
        int pos=1;
        while(pos<=this.ultimo){
            s+=this.heap[pos]+"  HijoIzq:" ;
            if(pos*2<=this.ultimo){
                s+=this.heap[pos*2] + "  ";
            }else{
                s+="-  ";
            }
            s+="HijoDer:";
            if(pos*2+1<=this.ultimo){
                s+=this.heap[pos*2+1];
            }else{
                s+="-";
            }
            pos++;
            s+="\n";
        }
        return s;
    }
    public boolean esVacio(){
        boolean vacio=false;
        if(this.ultimo==0){
            vacio=true;
        }
        return vacio;
    }
    public void vaciar(){
        int i=1;
        while(i<=this.ultimo){
            this.heap[i]=null;
            i++;
        }
        this.ultimo=0;
    }
    public ArbolHeap clone(){
        
        ArbolHeap clon= new ArbolHeap();
        clon.heap= this.heap.clone();
        clon.ultimo= this.ultimo;
        return clon;
    }
}
