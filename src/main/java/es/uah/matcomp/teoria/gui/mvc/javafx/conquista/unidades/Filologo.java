package es.uah.matcomp.teoria.gui.mvc.javafx.conquista.unidades;

public class Filologo extends Unidad{
    public Filologo(String nombre, boolean profe) {
        super("l2",nombre,200,30,26,8,4,profe);
        this.setElementoEspecifico1(new ElementoEspecifico("Diccionario",0,17,0,0,-2));
        this.setElementoEspecifico2(new ElementoEspecifico("Fonética",0,-12,0,3,0));
    }

    public void evolucionar() {
        this.setHP(this.getHP()+100);
        this.setAtaque(this.getAtaque()+15);
        this.setDefensa(this.getDefensa()+13);
        this.setRango_Movimiento(this.getRango_Movimiento()+4);
        this.setProfe(true);
    }
}
