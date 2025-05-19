package es.uah.matcomp.teoria.gui.mvc.javafx.conquista.unidades;

public class Historiador extends Unidad{
    public Historiador(String nombre, boolean profe) {
        super("l3",nombre,160,28,16,6,4,profe);
        this.setElementoEspecifico1(new ElementoEspecifico("Línea temporal",0,0,0,0,0));
        this.setElementoEspecifico2(new ElementoEspecifico("Jeroglífico",0,0,0,0,0));
    }

    public void evolucionar() {
        this.setHP(this.getHP()+80);
        this.setAtaque(this.getAtaque()+14);
        this.setDefensa(this.getDefensa()+8);
        this.setRango_Movimiento(this.getRango_Movimiento()+3);
        this.setProfe(true);
    }
}
