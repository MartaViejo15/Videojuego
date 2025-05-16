package es.uah.matcomp.teoria.gui.mvc.javafx.conquista.preguntas;

public class Elemento<v> {
    //atributo
    protected v dato;
    protected Elemento<v> siguiente;

    //constructor
    protected Elemento(v dato) {
        this.dato = dato;
    }

    public v getDato() {
        return dato;
    }
    public void setDato(v dato) {
        this.dato = dato;
    }
    public Elemento<v> getSiguiente() {
        return siguiente;
    }
    public void setSiguiente(Elemento<v> siguiente) {
        this.siguiente = siguiente;
    }
}
