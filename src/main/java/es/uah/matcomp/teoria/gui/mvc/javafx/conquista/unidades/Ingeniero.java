package es.uah.matcomp.teoria.gui.mvc.javafx.conquista.unidades;

public class Ingeniero extends Unidad {
    public Ingeniero(String nombre, boolean profe) {
        super("c3",nombre,150,30,18,8,3,profe);
        this.setElementoEspecifico1(new ElementoEspecifico("Circuito Combinacional",0,0,-5,2,0));
        this.setElementoEspecifico2(new ElementoEspecifico("Java",-20,0,0,0,2));
    }

    public void evolucionar() {
        this.setHP(this.getHP()+75);
        this.setAtaque(this.getAtaque()+15);
        this.setDefensa(this.getDefensa()+9);
        this.setRango_Movimiento(this.getRango_Movimiento()+4);
        this.setProfe(true);
    }
}
