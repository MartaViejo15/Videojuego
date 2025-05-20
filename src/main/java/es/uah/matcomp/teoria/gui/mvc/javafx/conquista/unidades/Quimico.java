package es.uah.matcomp.teoria.gui.mvc.javafx.conquista.unidades;

public class Quimico extends Unidad {
    public Quimico(String nombre, boolean profe) {
        super("c1",nombre,100,32,10,6,6,profe);
        this.setElementoEspecifico1(new ElementoEspecifico("Pipeta",0,-7,0,0,2));
        this.setElementoEspecifico2(new ElementoEspecifico("Erlenmeyer",0,10,0,-2,0));
    }

    public void evolucionar() {
        this.setHP(this.getHP()+50);
        this.setAtaque(this.getAtaque()+16);
        this.setDefensa(this.getDefensa()+5);
        this.setRango_Movimiento(this.getRango_Movimiento()+3);
        this.setProfe(true);
    }

}
