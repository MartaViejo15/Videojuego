package es.uah.matcomp.teoria.gui.mvc.javafx.conquista.unidades;

public class ElementoEspecifico {
    private String nombre;

    private int HP;
    private int Ataque;
    private int Defensa;
    private int Rango_movimiento;
    private int Rango_ataque;

    private boolean uso;

    public ElementoEspecifico(String nombre, int HP, int ataque, int Defensa, int Rango_Movimiento, int Rango_Ataque) {
        this.nombre = nombre;
        this.HP = HP;
        this.Ataque = ataque;
        this.Defensa = Defensa;
        this.Rango_movimiento = Rango_Movimiento;
        this.Rango_ataque = Rango_Ataque;
        this.uso = false;
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
    public boolean uso() {
        return uso;
    }
    public void setUso(boolean uso) {
        this.uso = uso;
    }
}
