package es.uah.matcomp.teoria.gui.mvc.javafx.conquista.inventario;

public abstract class Inventario {
    private String nombre;
    private int HP;
    private int Ataque;
    private int Defensa;
    private int Rango_movimiento;
    private int Rango_ataque;
    private int N_elementos;

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
}
