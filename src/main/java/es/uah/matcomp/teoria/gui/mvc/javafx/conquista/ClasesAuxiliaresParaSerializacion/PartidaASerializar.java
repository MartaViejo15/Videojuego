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

    public PartidaASerializar(Mapa mapa, String faccion, Lista<UnidadProperty> unidades, Lista<UnidadProperty> enemigos, Lista<Inventario> inventario, int punto, int ronda, UnidadProperty seleccionado, int identificadorMapa, boolean atacar, boolean mover) {
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
    }

}
