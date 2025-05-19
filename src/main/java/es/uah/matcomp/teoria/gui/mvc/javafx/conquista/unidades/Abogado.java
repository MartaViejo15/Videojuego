package es.uah.matcomp.teoria.gui.mvc.javafx.conquista.unidades;

public class Abogado extends Unidad {
    public Abogado(String nombre, boolean profe) {
        super("l4",nombre,150,30,18,8,3,profe);
        this.setElementoEspecifico1(new ElementoEspecifico("Leyes",0,0,0,0,0));
        this.setElementoEspecifico2(new ElementoEspecifico("Contitución",0,0,0,0,0));
    }

    public void evolucionar() {
        this.setHP(this.getHP()+75);
        this.setAtaque(this.getAtaque()+15);
        this.setDefensa(this.getDefensa()+9);
        this.setRango_Movimiento(this.getRango_Movimiento()+4);
        this.setProfe(true);
    }
}
