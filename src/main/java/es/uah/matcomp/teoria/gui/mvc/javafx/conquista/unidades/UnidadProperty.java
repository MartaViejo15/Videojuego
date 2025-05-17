package es.uah.matcomp.teoria.gui.mvc.javafx.conquista.unidades;
import es.uah.matcomp.teoria.gui.mvc.javafx.conquista.preguntas.Elemento;
import es.uah.matcomp.teoria.gui.mvc.javafx.conquista.preguntas.Lista;
import es.uah.matcomp.teoria.gui.mvc.javafx.conquista.inventario.Inventario;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;

import java.util.Random;

public class UnidadProperty {
    protected Unidad Base;

    private IntegerProperty HP = new SimpleIntegerProperty();
    private IntegerProperty Ataque = new SimpleIntegerProperty();
    private IntegerProperty Defensa = new SimpleIntegerProperty();
    private IntegerProperty Rango_Movimiento = new SimpleIntegerProperty();
    private IntegerProperty Rango_Ataque = new SimpleIntegerProperty();

    private Lista<Inventario> Inventario = new Lista<>();
    private int[] posicion;

    public UnidadProperty(Unidad Base) {
        this.Base = Base;
        rollback();
        this.posicion = new int[1];
    }

    public int atacar(UnidadProperty unidad){
        Random r = new Random();
        int random = r.nextInt(2);
        int daño = (random * Ataque.get()) - unidad.getDefensa().get();
        unidad.getHP().set(unidad.getHP().get() - daño);
        return daño;
    }
    public boolean UsarInventario(Inventario item) {
        Elemento<Inventario> it = Inventario.buscar(item);
        if(it != null){
            HP.set(HP.get() + item.getHP());
            Ataque.set(Ataque.get() + item.getAtaque());
            Defensa.set(Defensa.get() + item.getDefensa());
            Rango_Ataque.set(Rango_Ataque.get() + item.getRango_ataque());
            Rango_Movimiento.set(Rango_Movimiento.get() + item.getRango_movimiento());
            it.getDato().usar();
            if(it.getDato().getN_elementos() <= 0){
                Inventario.delete(item);
            }
            return true;
        }
        return false;
    }
    public void cogerInventario(Inventario item){
        if(!Inventario.add(item)){
            Inventario.buscar(item).getDato().añadir();
        }
    }

    public void commit(){
        Base.setHP(HP.get());
        Base.setAtaque(Ataque.get());
        Base.setDefensa(Defensa.get());
        Base.setRango_Movimiento(Rango_Movimiento.get());
        Base.setRango_Ataque(Rango_Ataque.get());
    }
    public void rollback(){
        HP.set(Base.getHP());
        Ataque.set(Base.getAtaque());
        Defensa.set(Base.getDefensa());
        Rango_Movimiento.set(Base.getRango_Movimiento());
        Rango_Ataque.set(Base.getRango_Ataque());
    }

    public void mover(int x, int y) {
        this.posicion[0] = x;
        this.posicion[1] = y;
    }
    public int[] getPosicion() {
        return posicion;
    }
    public Unidad getBase() {
        return Base;
    }
    public IntegerProperty getHP() {
        return HP;
    }
    public IntegerProperty getAtaque() {
        return Ataque;
    }
    public IntegerProperty getDefensa() {
        return Defensa;
    }
    public IntegerProperty getRango_Movimiento() {
        return Rango_Movimiento;
    }
    public IntegerProperty getRango_Ataque() {
        return Rango_Ataque;
    }
}
