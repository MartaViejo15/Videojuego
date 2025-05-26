package es.uah.matcomp.teoria.gui.mvc.javafx.conquista.unidades;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public abstract class Unidad {
    private String id;
    private StringProperty nombre;
    private Integer HP;
    private int Ataque;
    private int Defensa;
    private int Rango_Movimiento;
    private int Rango_Ataque;
    private boolean Profe;
    private ElementoEspecifico elementoEspecifico1;
    private ElementoEspecifico elementoEspecifico2;

    public Unidad() {
        id="";
        nombre=new SimpleStringProperty("");
        HP=0;
        Ataque=0;
        Defensa=0;
        Rango_Movimiento=0;
        Rango_Ataque=0;
        Profe=false;
        elementoEspecifico1=null;
        elementoEspecifico2=null;
    }
    public Unidad(String id, String nombre, int HP, int ataque, int Defensa, int Rango_Movimiento, int Rango_Ataque, boolean profe) {
        this.id = id;
        this.nombre.set(nombre);
        this.HP = HP;
        this.Ataque = ataque;
        this.Defensa = Defensa;
        this.Rango_Movimiento = Rango_Movimiento;
        this.Rango_Ataque = Rango_Ataque;
        this.Profe = profe;
        if(profe){
            evolucionar();
        }
    }

    abstract void evolucionar();
    public void usarElementoEspecifico(ElementoEspecifico especifico){
        if(especifico == null){
            noUsarElementoEspecifico2();
            noUsarElementoEspecifico1();
        }if(especifico == this.elementoEspecifico1){
            if(!this.elementoEspecifico1.uso()){
                noUsarElementoEspecifico2();
                this.HP = this.HP + this.elementoEspecifico1.getHP();
                this.Ataque = this.Ataque + this.elementoEspecifico1.getAtaque();
                this.Defensa = this.Defensa + this.elementoEspecifico1.getDefensa();
                this.Rango_Movimiento = this.Rango_Movimiento + this.elementoEspecifico1.getRango_movimiento();
                this.Rango_Ataque = this.Rango_Ataque + this.elementoEspecifico1.getRango_ataque();
                this.elementoEspecifico1.setUso(true);
            }
        }if(especifico == this.elementoEspecifico2){
            if(!this.elementoEspecifico2.uso()){
                noUsarElementoEspecifico1();
                this.HP = this.HP + this.elementoEspecifico2.getHP();
                this.Ataque = this.Ataque + this.elementoEspecifico2.getAtaque();
                this.Defensa = this.Defensa + this.elementoEspecifico2.getDefensa();
                this.Rango_Movimiento = this.Rango_Movimiento + this.elementoEspecifico2.getRango_movimiento();
                this.Rango_Ataque = this.Rango_Ataque + this.elementoEspecifico2.getRango_ataque();
                this.elementoEspecifico2.setUso(true);
            }
        }
    }
    private void noUsarElementoEspecifico1(){
        if(this.elementoEspecifico1.uso()){
            this.elementoEspecifico1.setUso(false);
            this.HP = this.HP - this.elementoEspecifico1.getHP();
            this.Ataque = this.Ataque - this.elementoEspecifico1.getAtaque();
            this.Defensa = this.Defensa - this.elementoEspecifico1.getDefensa();
            this.Rango_Movimiento = this.Rango_Movimiento-this.elementoEspecifico1.getRango_movimiento();
            this.Rango_Ataque = this.Rango_Ataque-this.elementoEspecifico1.getRango_ataque();
        }
    }
    private void noUsarElementoEspecifico2(){
        if (this.elementoEspecifico2.uso()) {
            this.elementoEspecifico2.setUso(false);
            this.HP = this.HP - this.elementoEspecifico2.getHP();
            this.Ataque = this.Ataque - this.elementoEspecifico2.getAtaque();
            this.Defensa = this.Defensa - this.elementoEspecifico2.getDefensa();
            this.Rango_Movimiento = this.Rango_Movimiento - this.elementoEspecifico2.getRango_movimiento();
            this.Rango_Ataque = this.Rango_Ataque - this.elementoEspecifico2.getRango_ataque();
        }
    }

    public void setHP(Integer HP) {
        this.HP = HP;
    }
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public StringProperty getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre.set(nombre);
    }
    public int getHP() {
        return HP;
    }
    public void setHP(int HP) {
        this.HP = HP;
    }
    public int getAtaque() {
        return Ataque;
    }
    public void setAtaque(int ataque) {
        Ataque = ataque;
    }
    public int getDefensa() {
        return Defensa;
    }
    public void setDefensa(int defensa) {
        Defensa = defensa;
    }
    public int getRango_Movimiento() {
        return Rango_Movimiento;
    }
    public void setRango_Movimiento(int rango_movimiento) {
        Rango_Movimiento = rango_movimiento;
    }
    public int getRango_Ataque() {
        return Rango_Ataque;
    }
    public void setRango_Ataque(int rango_ataque) {
        Rango_Ataque = rango_ataque;
    }
    public boolean isProfe() {
        return Profe;
    }
    public void setProfe(boolean profe) {
        Profe = profe;
    }
    protected void setElementoEspecifico1(ElementoEspecifico especifico) {
        elementoEspecifico1 = especifico;
    }
    public ElementoEspecifico getElementoEspecifico1() {
        return elementoEspecifico1;
    }
    protected void setElementoEspecifico2(ElementoEspecifico especifico) {
        elementoEspecifico2 = especifico;
    }
    public ElementoEspecifico getElementoEspecifico2() {
        return elementoEspecifico2;
    }
}
