package es.uah.matcomp.teoria.gui.mvc.javafx.conquista.preguntas;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@JsonIdentityInfo(generator= ObjectIdGenerators.IntSequenceGenerator.class, property = "@id")
public class Lista<v> {
    //atributos
    protected Elemento<v> primero;
    protected int N_elementos;

    //constructor
    public Lista() {
        primero = null;
        N_elementos = 0;
    }

    //metodo
    public boolean add(v elemento) {
        Elemento<v> temporal = new Elemento<>(elemento);
        if (primero == null) {
            primero = temporal;
            N_elementos ++;
            return true;
        }if (primero.dato.equals(elemento)) {
            return false;
        }
        Elemento<v> aux = primero;
        while(aux.siguiente != null) {
            if (aux.siguiente.dato.equals(elemento)) {
                return false;
            }
            aux = aux.siguiente;
        }
        aux.siguiente=temporal;
        N_elementos++;
        return true;
    }

    public boolean delete(v elemento) {
        Elemento<v> aux = primero;
        if (aux == null) {
            return false;
        }
        if (aux.dato == elemento) {
            primero = aux.siguiente;
            N_elementos--;
            return true;
        }
        while(aux.siguiente != null) {
            if (aux.siguiente.dato == elemento) {
                aux.siguiente = aux.siguiente.siguiente;
                this.N_elementos--;
                return true;
            }
            aux = aux.siguiente;
        }
        return false;
    }
    public v buscar(v elemento) {
        Elemento<v> aux = primero;
        if(aux == null) {
            return null;
        }if (aux.dato.equals(elemento)) {
            return aux.dato;
        }
        while(aux.siguiente != null) {
            if (aux.siguiente.dato.equals(elemento)) {
                return aux.siguiente.dato;
            }
            aux = aux.siguiente;
        }
        return null;
    }
    public Lista<v> reverse() {
        Lista<v> res = new Lista<>();
        rev(primero, res);
        return res;
    }
    private void rev(Elemento<v> aux, Lista<v> res) {
        if(aux != null) {
            rev(aux.siguiente, res);
            res.add(aux.dato);
        }
    }

    public int getNumElementos() {
        return N_elementos;
    }
    public Elemento<v> getPrimero() {
        return primero;
    }
    public void setPrimero(Elemento<v> primero) {
        this.primero = primero;
    }
    public int getN_elementos() {
        return N_elementos;
    }
    public void setN_elementos(int N_elementos) {
        this.N_elementos = N_elementos;
    }
}
