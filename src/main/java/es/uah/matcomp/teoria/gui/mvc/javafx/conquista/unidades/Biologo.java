package es.uah.matcomp.teoria.gui.mvc.javafx.conquista.unidades;

public class Biologo extends Unidad{
    public Biologo(String nombre, boolean profe) {
        super("c2",nombre,200,40,24,8,2,profe);
        this.setElementoEspecifico1(new ElementoEspecifico("Cultivo microbiano",-25,7,0,0,0));
        this.setElementoEspecifico2(new ElementoEspecifico("Bata",0,-8,6,0,0));
    }

    public void evolucionar() {
        this.setHP(this.getHP()+100);
        this.setAtaque(this.getAtaque()+20);
        this.setDefensa(this.getDefensa()+12);
        this.setRango_Movimiento(this.getRango_Movimiento()+4);
        this.setProfe(true);
    }
}
