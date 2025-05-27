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

    public UnidadProperty() {
        Base = null;
        HP = new SimpleIntegerProperty();
        Ataque = new SimpleIntegerProperty();
        Defensa = new SimpleIntegerProperty();
        Rango_Movimiento = new SimpleIntegerProperty();
        Rango_Ataque = new SimpleIntegerProperty();
        Inventario = new Lista<>();
        posicion = new int[2];
    }
    public UnidadProperty(Unidad Base) {
        this.Base = Base;
        rollback();
        this.posicion = new int[2];
    }

    public int atacar(UnidadProperty unidad){
        Random r = new Random();
        int random = r.nextInt(3);
        int daño = (random * Ataque.get()) - unidad.getDefensa().get();
        if(daño < 0){
            daño = 0;
        }
        unidad.getBase().setHP(unidad.getBase().getHP() - daño);
        unidad.getHP().set(unidad.getBase().getHP());
        return daño;
    }
    public Elemento<Inventario> buscar(Inventario inventario){
        Elemento<Inventario> aux = Inventario.getPrimero();
        if(aux == null){
            return null;
        }if(aux.getDato().getNombre().equals(inventario.getNombre())){
            return aux;
        }while(aux.getSiguiente() != null){
            if(aux.getSiguiente().getDato().getNombre().equals(inventario.getNombre())){
                return aux.getSiguiente();
            }
            aux = aux.getSiguiente();
        }return null;
    }
    public boolean UsarInventario(Inventario item) {
        Elemento<Inventario> it = this.buscar(item);
        if(it != null){
            HP.set(HP.get() + item.getHP());
            Ataque.set(Ataque.get() + item.getAtaque());
            Defensa.set(Defensa.get() + item.getDefensa());
            Rango_Ataque.set(Rango_Ataque.get() + item.getRango_ataque());
            Rango_Movimiento.set(Rango_Movimiento.get() + item.getRango_movimiento());
            it.getDato().usar();
            if(it.getDato().getN_elementos() <= 0){
                this.Inventario.delete(item);
            }
            return true;
        }
        return false;
    }
    public void cogerInventario(Inventario item){
        Elemento<Inventario> it = this.buscar(item);
        if(it == null){
            this.Inventario.add(item);
        }else{
            it.getDato().añadir();
        }
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
    public int getPosicionX() {
        return posicion[0];
    }
    public int getPosicionY() {
        return posicion[1];
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
    public Lista<Inventario> getInventario() {
        return Inventario;
    }
    public int[] getPosicion() {
        return posicion;
    }
    public void setRango_Movimiento(int rango_Movimiento) {
        this.Rango_Movimiento.set(rango_Movimiento);
    }
    public void setRango_Ataque(int rango_Ataque) {
        this.Rango_Ataque.set(rango_Ataque);
    }
    public void setPosicion(int[] posicion) {
        this.posicion = posicion;
    }
    public void setInventario(Lista<Inventario> inventario) {
        Inventario = inventario;
    }
    public void setHP(int HP) {
        this.HP.set(HP);
    }
    public void setDefensa(int defensa) {
        this.Defensa.set(defensa);
    }
    public void setAtaque(int ataque) {
        this.Ataque.set(ataque);
    }
    public void setBase(Unidad base) {
        Base = base;
    }
}
