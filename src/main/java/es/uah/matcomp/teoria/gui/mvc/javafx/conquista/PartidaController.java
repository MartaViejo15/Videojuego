package es.uah.matcomp.teoria.gui.mvc.javafx.conquista;

import es.uah.matcomp.teoria.gui.mvc.javafx.conquista.inventario.Inventario;
import es.uah.matcomp.teoria.gui.mvc.javafx.conquista.preguntas.Elemento;
import es.uah.matcomp.teoria.gui.mvc.javafx.conquista.preguntas.Lista;
import es.uah.matcomp.teoria.gui.mvc.javafx.conquista.tablero.Tablero;
import es.uah.matcomp.teoria.gui.mvc.javafx.conquista.unidades.Abogado;
import es.uah.matcomp.teoria.gui.mvc.javafx.conquista.unidades.UnidadProperty;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.util.Random;

public class PartidaController {
    @FXML
    private Label turnos;
    @FXML
    private Label informacion;
    @FXML
    private Label puntos;
    @FXML
    private GridPane Mapa;

    private Stage stage;

    private Tablero tablero = new Tablero();
    private String faccion;
    private Lista<UnidadProperty> Mis_unidades;
    private Lista<UnidadProperty> Enemigos = new Lista<>();
    private Lista<Inventario> inventarios;
    private int punto;
    private int ronda;
    private UnidadProperty seleccionado;
    private int mapa;

    @FXML
    public void initData() {
        punto = 2;
        ronda = 1;
        puntos.setText("TE QUEDAN " + punto + " PUNTOS");
        turnos.setText("RONDA " + ronda + " : TU TURNO");
        configurarMapa();
        configurarUnidades();
        informacion.setText("Selecciona una acción.");
    }
    @FXML
    private void configurarMapa() {
        //Configurar Mapa segun el identificador (atributo mapa)
        if(mapa == 1){
            mapa1();
        }
    }
    @FXML
    private void mapa1() {
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                //Parte Visual
                Image imagen = new Image(getClass().getResourceAsStream("/es/uah/matcomp/teoria/gui/mvc/javafx/conquista/Imagen/Logo.png"));
                ImageView imagenView = new ImageView(imagen);
                imagenView.setVisible(false);
                AnchorPane casilla = new AnchorPane(imagenView);
                casilla.setStyle("-fx-border-color: black;");
                casilla.setMinSize(60,60);
                casilla.setOnMouseClicked(onClicked(Mapa,j,i));
                Mapa.add(casilla, i, j);
                //Parte no visual
                tablero.addCasilla(i,j);
            }
        }
        //aristas
        for(int i = 0; i < 10; i++){
            for (int j = 0; j < 10; j++) {
                if(j+1 < 10){
                    tablero.addArista(2,tablero.getCasilla(i,j),tablero.getCasilla(i,j+1));
                    tablero.addArista(2,tablero.getCasilla(i,j+1),tablero.getCasilla(i,j));
                }if(i+1 < 10){
                    tablero.addArista(3,tablero.getCasilla(i,j),tablero.getCasilla(i+1,j));
                    tablero.addArista(3,tablero.getCasilla(i+1,j),tablero.getCasilla(i,j));
                }
            }
        }
        //casillas especiales
        tablero.cambiarDif_mov(tablero.getCasilla(2,4),4);
        tablero.cambiarDif_mov(tablero.getCasilla(7,5),4);
    }
    @FXML
    public EventHandler<MouseEvent> onClicked(GridPane grid, int fila, int columna) {
        return mouseEvent -> {
            UnidadProperty flotante = tablero.getCasilla(fila,columna).getUnidad();
            if( flotante != null){
                this.seleccionado = flotante;
            }else{
                informacion.setText("Seleccione unidad");
            }
        };
    }
    private Node Ocultar(GridPane grid, int fila, int columna) {
        for (Node nodo : grid.getChildren()) {
            Integer filaNodo = GridPane.getRowIndex(nodo);
            Integer columnaNodo = GridPane.getColumnIndex(nodo);
            if (filaNodo == fila && columnaNodo == columna) {
                AnchorPane casilla = (AnchorPane) nodo;
                Node hijo = casilla.getChildren().getFirst();
                hijo.setVisible(false);
                ImageView imagen = (ImageView) hijo;
                imagen.setImage(new Image(getClass().getResourceAsStream("/es/uah/matcomp/teoria/gui/mvc/javafx/conquista/Imagen/Logo.png")));
                return nodo;
            }
        }
        return null;
    }
    private void configurarUnidades() {
        //configurar unidades

        //Poner mis_unidades en Mapa y tablero

        //genero enemigos
        if(faccion.equals("c")){
            generarUnidadLetras(Enemigos,true);
            generarUnidadLetras(Enemigos,true);
        }else{
            generarUnidadCiencias(Enemigos,true);
            generarUnidadCiencias(Enemigos,true);
        }
        //Poner Enemigos en Mapa y tablero
    }
    private String generarUnidadLetras(Lista<UnidadProperty> unidades,boolean profe) {
        int rand = new Random().nextInt(4);
        String id = "";
        if(rand == 0){
            unidades.add(new UnidadProperty(new Abogado("Abogado" + getN_unidades(unidades,"l4"),profe)));
            id = "l4";
        }
        //falta resto de casos
        return id;
    }
    private void generarUnidadCiencias(Lista<UnidadProperty> unidades,boolean profe) {
        //similar a letras
    }
    private int getN_unidades(Lista<UnidadProperty> unidades,String id){
        int res = 0;
        if(unidades.getPrimero() == null){
            return res;
        }
        Elemento<UnidadProperty> aux = unidades.getPrimero();
        if(aux.getDato().getBase().getId().equals(id)){
            res ++;
        }while(aux.getSiguiente() != null){
            if(aux.getSiguiente().getDato().getBase().getId().equals(id)){
                res ++;
            }
            aux = aux.getSiguiente();
        }
        return res;
    }

    @FXML
    public void onClickAyuda(){
        Stage s = new Stage();
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("Ayuda-view.fxml"));
        try{
            Scene scene = new Scene(fxmlLoader.load(), 1050, 600);
            s.setTitle("Ayuda");
            s.setScene(scene);
            s.show();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    @FXML
    public void onClickVerEstados(){
        if(seleccionado == null){
            informacion.setText("Seleccione unidad");
        }else{
            Stage s = new Stage();
            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("Estados-view.fxml"));
            try{
                Scene scene = new Scene(fxmlLoader.load(), 350, 400);
                s.setTitle("Estados");
                s.setScene(scene);
                s.show();
            }catch(Exception e){
                e.printStackTrace();
            }
        }

    }
    @FXML
    public void onClickInventario(){
        if(seleccionado == null){
            informacion.setText("Seleccione unidad");
        }else{
            Stage s = new Stage();
            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("Inventario-view.fxml"));
            try{
                Scene scene = new Scene(fxmlLoader.load(), 350, 400);
                s.setTitle("Inventario");
                s.setScene(scene);
                InventarioController controller = fxmlLoader.getController();
                controller.setUnidad(seleccionado);
                controller.setstage(s);
                controller.initData();
                s.show();
            }catch(Exception e){
                e.printStackTrace();
            }
        }
    }

    @FXML
    protected boolean Pregunta(){
        int id = new Random().nextInt(5);
        while(id == 0){
            id = new Random().nextInt(5);
        }
        Stage s = new Stage();
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("Pregunta-view.fxml"));
        try{
            Scene scene = new Scene(fxmlLoader.load(), 600, 400);
            s.setTitle("Pregunta");
            s.setScene(scene);
        }catch(Exception e){
            e.printStackTrace();
        }
        PreguntaController controller = fxmlLoader.getController();
        controller.setStage(s);
        controller.setId(faccion + id);
        s.show();
        while(s.isShowing()){}
        //Otra forma de esperar a contestar la pregunta?
        //Si el usuario no contesta y hace alguna otra accion?
        return controller.aceptar();
    }

    protected void setFaccion(String faccion){
        this.faccion = faccion;
    }
    protected void setMis_unidades(Lista<UnidadProperty> Mis_unidades){
        this.Mis_unidades = Mis_unidades;
    }
    protected void setStage(Stage stage){
        this.stage = stage;
    }
    protected void setmapa(int mapa){
        this.mapa = mapa;
    }
}
