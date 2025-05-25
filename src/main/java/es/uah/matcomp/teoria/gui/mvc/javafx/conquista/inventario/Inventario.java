package es.uah.matcomp.teoria.gui.mvc.javafx.conquista.inventario;

import javafx.beans.property.IntegerProperty;

public abstract class Inventario {
    private String nombre;
    private int HP;
    private int Ataque;
    private int Defensa;
    private int Rango_movimiento;
    private int Rango_ataque;
    private int N_elementos;

    public Inventario() {
        nombre = "";
        HP = 0;
        Ataque = 0;
        Defensa = 0;
        Rango_movimiento = 0;
        Rango_ataque = 0;
        N_elementos = 0;
    }
    public Inventario(String nombre, int HP, int Ataque, int Defensa, int Rango_movimiento, int Rango_ataque) {
        this.nombre = nombre;
        this.HP = HP;
        this.Ataque = Ataque;
        this.Defensa = Defensa;
        this.Rango_movimiento = Rango_movimiento;
        this.Rango_ataque = Rango_ataque;
        this.N_elementos = 1;
    }
    public String getNombre() {
        return nombre;
    }
    public int getHP() {
        return HP;
    }
    public int getAtaque() {
        return Ataque;
    }
    public int getDefensa() {
        return Defensa;
    }
    public int getRango_movimiento() {
        return Rango_movimiento;
    }
    public int getRango_ataque() {
        return Rango_ataque;
    }
    public int getN_elementos() {
        return N_elementos;
    }
    public void usar(){
        N_elementos--;
    }
    public void añadir(){
        N_elementos++;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public void setAtaque(int ataque) {
        Ataque = ataque;
    }
    public void setHP(int HP) {
        this.HP = HP;
    }
    public void setDefensa(int defensa) {
        Defensa = defensa;
    }
    public void setRango_movimiento(int rango_movimiento) {
        Rango_movimiento = rango_movimiento;
    }
    public void setRango_ataque(int rango_ataque) {
        Rango_ataque = rango_ataque;
    }
    public void setN_elementos(int n_elementos) {
        N_elementos = n_elementos;
    }
}
