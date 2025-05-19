package es.uah.matcomp.teoria.gui.mvc.javafx.conquista.unidades;

public class Matematico extends Unidad{
    public Matematico(String nombre, boolean profe) {
        super("c4",nombre,90,44,10,12,1,profe);
        this.setElementoEspecifico1(new ElementoEspecifico("Calculadora",0,0,0,0,0));
        this.setElementoEspecifico2(new ElementoEspecifico("Transportador",0,0,0,0,0));
    }

    public void evolucionar() {
        this.setHP(this.getHP()+45);
        this.setAtaque(this.getAtaque()+22);
        this.setDefensa(this.getDefensa()+5);
        this.setRango_Movimiento(this.getRango_Movimiento()+6);
        this.setProfe(true);
    }
}
