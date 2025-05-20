package es.uah.matcomp.teoria.gui.mvc.javafx.conquista.unidades;

public class Medico extends Unidad{
    public Medico(String nombre, boolean profe) {
        super("c5",nombre,160,28,16,6,4,profe);
        this.setElementoEspecifico1(new ElementoEspecifico("Bisturí",-20,8,0,0,0));
        this.setElementoEspecifico2(new ElementoEspecifico("Estetoscopio",30,-2,0,0,0));
    }

    public void evolucionar() {
        this.setHP(this.getHP()+80);
        this.setAtaque(this.getAtaque()+14);
        this.setDefensa(this.getDefensa()+8);
        this.setRango_Movimiento(this.getRango_Movimiento()+3);
        this.setProfe(true);
    }
}
