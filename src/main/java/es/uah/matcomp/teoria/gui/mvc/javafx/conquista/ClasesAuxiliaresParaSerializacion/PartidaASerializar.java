package es.uah.matcomp.teoria.gui.mvc.javafx.conquista.ClasesAuxiliaresParaSerializacion;


import es.uah.matcomp.teoria.gui.mvc.javafx.conquista.inventario.Inventario;
import es.uah.matcomp.teoria.gui.mvc.javafx.conquista.preguntas.Lista;
import es.uah.matcomp.teoria.gui.mvc.javafx.conquista.unidades.UnidadProperty;

public class PartidaASerializar {
    private Mapa mapa;

    private String faccion;
    private Lista<UnidadProperty> Mis_unidades;
    private Lista<UnidadProperty> Enemigos;
    private Lista<Inventario> inventarios;
    private int punto;
    private int ronda;
    private UnidadProperty seleccionado;
    private int identificadorMapa;

    private boolean atacar;
    private boolean mover;

    private String log;

    public PartidaASerializar(){
        this.mapa = new Mapa();
        this.Mis_unidades = new Lista<>();
        this.Enemigos = new Lista<>();
        this.inventarios = new Lista<>();
        this.punto = 0;
        this.ronda = 0;
        this.seleccionado = null;
        this.identificadorMapa = 0;
        this.atacar = false;
        this.mover = false;
        this.log = "";
    }

    public PartidaASerializar(Mapa mapa, String faccion, Lista<UnidadProperty> unidades, Lista<UnidadProperty> enemigos, Lista<Inventario> inventario, int punto, int ronda, UnidadProperty seleccionado, int identificadorMapa, boolean atacar, boolean mover, String log) {
        this.mapa = mapa;
        this.faccion = faccion;
        this.Mis_unidades = unidades;
        this.Enemigos = enemigos;
        this.inventarios = inventario;
        this.punto = punto;
        this.ronda = ronda;
        this.seleccionado = seleccionado;
        this.identificadorMapa = identificadorMapa;
        this.atacar = atacar;
        this.mover = mover;
        this.log = log;
    }

    public Mapa getMapa() {
        return mapa;
    }
    public void setMapa(Mapa mapa) {
        this.mapa = mapa;
    }
    public String getFaccion() {
        return faccion;
    }
    public void setFaccion(String faccion) {
        this.faccion = faccion;
    }
    public Lista<UnidadProperty> getMis_unidades() {
        return Mis_unidades;
    }
    public void setMis_unidades(Lista<UnidadProperty> Mis_unidades) {
        this.Mis_unidades = Mis_unidades;
    }
    public Lista<UnidadProperty> getEnemigos() {
        return Enemigos;
    }
    public void setEnemigos(Lista<UnidadProperty> Enemigos) {
        this.Enemigos = Enemigos;
    }
    public Lista<Inventario> getInventarios() {
        return inventarios;
    }
    public void setInventarios(Lista<Inventario> inventarios) {
        this.inventarios = inventarios;
    }
    public int getPunto() {
        return punto;
    }
    public void setPunto(int punto) {
        this.punto = punto;
    }
    public int getRonda() {
        return ronda;
    }
    public void setRonda(int ronda) {
        this.ronda = ronda;
    }
    public UnidadProperty getSeleccionado() {
        return seleccionado;
    }
    public void setSeleccionado(UnidadProperty seleccionado) {
        this.seleccionado = seleccionado;
    }
    public int getIdentificadorMapa() {
        return identificadorMapa;
    }
    public void setIdentificadorMapa(int identificadorMapa) {
        this.identificadorMapa = identificadorMapa;
    }
    public boolean isAtacar() {
        return atacar;
    }
    public void setAtacar(boolean atacar) {
        this.atacar = atacar;
    }
    public boolean isMover() {
        return mover;
    }
    public void setMover(boolean mover) {
        this.mover = mover;
    }
    public String getLog() {
        return log;
    }
    public void setLog(String log) {
        this.log = log;
    }
}
