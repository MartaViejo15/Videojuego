package es.uah.matcomp.teoria.gui.mvc.javafx.conquista.unidades;

public class Poeta extends Unidad{
    public Poeta(String nombre, boolean profe) {
        super("l1",nombre,90,40,10,10,2,profe);
        this.setElementoEspecifico1(new ElementoEspecifico("Libro de sinónimos",0,-10,0,4,0));
        this.setElementoEspecifico2(new ElementoEspecifico("Pluma",0,0,-4,0,1));
    }

    public void evolucionar() {
        this.setHP(this.getHP()+45);
        this.setAtaque(this.getAtaque()+20);
        this.setDefensa(this.getDefensa()+5);
        this.setRango_Movimiento(this.getRango_Movimiento()+5);
        this.setProfe(true);
    }
}
