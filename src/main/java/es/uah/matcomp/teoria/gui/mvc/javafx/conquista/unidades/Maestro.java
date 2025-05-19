package es.uah.matcomp.teoria.gui.mvc.javafx.conquista.unidades;

public class Maestro extends Unidad{
    public Maestro(String nombre, boolean profe) {
        super("l5",nombre,100,30,10,4,7,profe);
        this.setElementoEspecifico1(new ElementoEspecifico("Tiza",0,0,0,0,0));
        this.setElementoEspecifico2(new ElementoEspecifico("Notas",0,0,0,0,0));
    }

    public void evolucionar() {
        this.setHP(this.getHP()+50);
        this.setAtaque(this.getAtaque()+15);
        this.setDefensa(this.getDefensa()+5);
        this.setRango_Movimiento(this.getRango_Movimiento()+2);
        this.setProfe(true);
    }
}
