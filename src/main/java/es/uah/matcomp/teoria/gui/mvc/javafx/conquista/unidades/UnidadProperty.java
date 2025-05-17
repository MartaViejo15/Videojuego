package es.uah.matcomp.teoria.gui.mvc.javafx.conquista.unidades;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;

public class UnidadProperty {
    protected Unidad Base;

    private IntegerProperty HP = new SimpleIntegerProperty();
    private IntegerProperty Ataque = new SimpleIntegerProperty();
    private IntegerProperty Defensa = new SimpleIntegerProperty();
    private IntegerProperty Rango_Movimiento = new SimpleIntegerProperty();
    private IntegerProperty Rango_Ataque = new SimpleIntegerProperty();

    //private Lista<Inventario> Inventario;

    public UnidadProperty(Unidad Base) {
        this.Base = Base;
        rollback();
    }

    public boolean atacar(Unidad unidad){
        return false;
    }
    public boolean UsarInventario() { //con entrada Inventario
        return false;
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

    public Unidad getBase() {
        return Base;
    }
    public void setBase(Unidad Base) {
        this.Base = Base;
    }
    public IntegerProperty getHP() {
        return HP;
    }
    public void setHP(IntegerProperty HP) {
        this.HP = HP;
    }
    public IntegerProperty getAtaque() {
        return Ataque;
    }
    public void setAtaque(IntegerProperty ataque) {
        Ataque = ataque;
    }
    public IntegerProperty getDefensa() {
        return Defensa;
    }
    public void setDefensa(IntegerProperty defensa) {
        Defensa = defensa;
    }
    public IntegerProperty getRango_Movimiento() {
        return Rango_Movimiento;
    }
    public void setRango_Movimiento(IntegerProperty rango_Movimiento) {
        Rango_Movimiento = rango_Movimiento;
    }
    public IntegerProperty getRango_Ataque() {
        return Rango_Ataque;
    }
    public void setRango_Ataque(IntegerProperty rango_Ataque) {
        Rango_Ataque = rango_Ataque;
    }
}
