package es.uah.matcomp.teoria.gui.mvc.javafx.conquista.tablero;

import com.fasterxml.jackson.annotation.*;

import es.uah.matcomp.teoria.gui.mvc.javafx.conquista.inventario.Inventario;
import es.uah.matcomp.teoria.gui.mvc.javafx.conquista.preguntas.Lista;
import es.uah.matcomp.teoria.gui.mvc.javafx.conquista.unidades.UnidadProperty;

@JsonIdentityInfo(generator=ObjectIdGenerators.IntSequenceGenerator.class, property = "@id")
public class Casilla {
    private int x;
    private int y;
    private UnidadProperty unidad;
    private Inventario inventario;
    private Lista<Arista> salida;
    private Lista<Arista> entrada;

    public Casilla(){
        this.x = 0;
        this.y = 0;
        this.unidad = null;
        this.inventario = null;
        salida = new Lista<>();
        entrada = new Lista<>();
    }
    public Casilla(int x, int y) {
        this.x = x;
        this.y = y;
        this.unidad = null;
        this.inventario = null;
        this.salida = new Lista<>();
        this.entrada = new Lista<>();
    }
    public boolean setUnidad(UnidadProperty unidad) {
        if (this.unidad == null) {
            this.unidad = unidad;
            this.unidad.mover(this.x, this.y);
            return true;
        }
        return false;
    }
    public void setInventario(Inventario inventario) {
        if (this.unidad != null) {
            unidad.cogerInventario(inventario);
        }else {
            this.inventario = inventario;
        }
    }

    public int getX() {
        return x;
    }
    public int getY() {
        return y;
    }
    public UnidadProperty getUnidad() {
        return unidad;
    }
    public Inventario getInventario() {
        return inventario;
    }
    public Lista<Arista> getSalida() {
        return salida;
    }
    public Lista<Arista> getEntrada() {
        return entrada;
    }
    public void setX(int x) {
        this.x = x;
    }
    public void setY(int y) {
        this.y = y;
    }
    public void setEntrada(Lista<Arista> entrada) {
        this.entrada = entrada;
    }
    public void setSalida(Lista<Arista> salida) {
        this.salida = salida;
    }
}
