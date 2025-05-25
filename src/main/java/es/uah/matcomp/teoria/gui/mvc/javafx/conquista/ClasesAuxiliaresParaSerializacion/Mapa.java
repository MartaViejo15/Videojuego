package es.uah.matcomp.teoria.gui.mvc.javafx.conquista.ClasesAuxiliaresParaSerializacion;

import es.uah.matcomp.teoria.gui.mvc.javafx.conquista.tablero.Tablero;

public class Mapa {
    private Tablero tablero;
    private int alturaGrid;
    private int LongitudGrid;
    private String colorFondo;
    private String colorBorde;

    public Mapa() {
        tablero = new Tablero();
        alturaGrid = 2;
        LongitudGrid = 2;
        colorFondo = "White";
        colorBorde = "black";
    }
    public Mapa(Tablero tablero, int alturaGrid, int LongitudGrid, String colorFondo, String colorBorde) {
        this.tablero = tablero;
        this.alturaGrid = alturaGrid;
        this.LongitudGrid = LongitudGrid;
        this.colorFondo = colorFondo;
        this.colorBorde = colorBorde;
    }

    public Tablero getTablero() {
        return tablero;
    }
    public int getLongitudGrid() {
        return LongitudGrid;
    }
    public int getAlturaGrid() {
        return alturaGrid;
    }
    public String getColorFondo() {
        return colorFondo;
    }
    public String getColorBorde() {
        return colorBorde;
    }
    public void setTablero(Tablero tablero) {
        this.tablero = tablero;
    }
    public void setLongitudGrid(int longitudGrid) {
        LongitudGrid = longitudGrid;
    }
    public void setAlturaGrid(int alturaGrid) {
        this.alturaGrid = alturaGrid;
    }
    public void setColorFondo(String colorFondo) {
        this.colorFondo = colorFondo;
    }
    public void setColorBorde(String colorBorde) {
        this.colorBorde = colorBorde;
    }
}
