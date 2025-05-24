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
        this.posicion = new int[2];
    }

    public int atacar(UnidadProperty unidad){
        Random r = new Random();
        int random = r.nextInt(2);
        int daño = (random * Ataque.get()) - unidad.getDefensa().get();
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
    public Lista<Inventario> getInventario() {
        return Inventario;
    }
}
