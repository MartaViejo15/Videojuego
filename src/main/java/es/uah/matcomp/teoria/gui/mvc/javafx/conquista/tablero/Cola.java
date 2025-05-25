package es.uah.matcomp.teoria.gui.mvc.javafx.conquista.tablero;

import es.uah.matcomp.teoria.gui.mvc.javafx.conquista.preguntas.Lista;

public class Cola<T> {
    //atributo
    private Lista<T> lista;

    //constructor
    public Cola() {
        this.lista = new Lista<>();
    }
    public Cola(Lista<T> lista) {
        this.lista = lista;
    }

    //metodo
    public void enqueue(T elemento) {
        this.lista.add(elemento);
    }
    public T dequeue() {
        T temporal = lista.getPrimero().getDato();
        lista.delete(lista.getPrimero().getDato());
        return temporal;
    }
    public Lista<T> getLista() {
        return lista;
    }
    public void setLista(Lista<T> lista) {
        this.lista = lista;
    }
}
