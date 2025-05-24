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

    private Tablero tablero;
    private String faccion;
    private Lista<UnidadProperty> Mis_unidades;
    private Lista<UnidadProperty> Enemigos;
    private Lista<Inventario> inventarios;
    private int punto;
    private int ronda;
    private UnidadProperty seleccionado;
    private int mapa;

    @FXML
    public void initData() {
        this.tablero = new Tablero();
        this.Enemigos = new Lista<>();
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
        //hacer el resto de mapas
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
                casilla.setOnMouseClicked(onClicked(j,i));
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
    public EventHandler<MouseEvent> onClicked(int fila, int columna) {
        return mouseEvent -> {
            UnidadProperty flotante = tablero.getCasilla(fila,columna).getUnidad();
            if( flotante != null){
                this.seleccionado = flotante;
            }else{
                informacion.setText("Seleccione unidad");
            }
        };
    }
    private void configurarUnidades() {
        //Poner mis_unidades en Mapa y tablero
        ponerUnidad(0,0,Mis_unidades.getPrimero().getDato());
        ponerUnidad(Mapa.getRowCount(),0,Mis_unidades.getPrimero().getSiguiente().getDato());
        //genero enemigos
        if(faccion.equals("c")){
            Enemigos.add(generarUnidadLetras(Enemigos,true));
            Enemigos.add(generarUnidadLetras(Enemigos,true));
        }else{
            Enemigos.add(generarUnidadCiencias(Enemigos,true));
            Enemigos.add(generarUnidadCiencias(Enemigos,true));
        }
        //Poner Enemigos en Mapa y tablero
        //hacer(similar a poner mis unidades
    }
    @FXML
    private void ponerUnidad(int fila, int columna, UnidadProperty unidad) {
        tablero.getCasilla(fila,columna).setUnidad(unidad);
        unidad.mover(fila,columna);
        Integer filaNodo = 0;
        Integer columnaNodo = 0;
        for (Node nodo : Mapa.getChildren()) {
            if (GridPane.getRowIndex(nodo) == null){
                filaNodo = 0;
            } else{
                filaNodo = GridPane.getRowIndex(nodo);
            }
            if (GridPane.getColumnIndex(nodo) == null){
                columnaNodo = 0;
            } else{
                columnaNodo = GridPane.getColumnIndex(nodo);
            }
            if (filaNodo == fila && columnaNodo == columna) {
                AnchorPane casilla = (AnchorPane) nodo;
                ImageView imagen = (ImageView) casilla.getChildren().getFirst();
                ponerImagen(unidad,imagen);
                imagen.setVisible(true);
            }
        }
    }
    @FXML
    private void ponerImagen(UnidadProperty unidad, ImageView imagen) {
        if(unidad.getBase().getId().equals("c1")){
            imagen.setImage(new Image(getClass().getResourceAsStream("/es/uah/matcomp/teoria/gui/mvc/javafx/conquista/Imagen/quimico.png")));
        }
        if(unidad.getBase().getId().equals("c2")){
            imagen.setImage(new Image(getClass().getResourceAsStream("/es/uah/matcomp/teoria/gui/mvc/javafx/conquista/Imagen/biólogo .png")));
        }
        //hacer(con el id, cambiando el imagen
    }
    private UnidadProperty generarUnidadLetras(Lista<UnidadProperty> unidades,boolean profe) {
        int rand = new Random().nextInt(4);
        UnidadProperty unidad = null;
        rand = 0; //para probar
        if(rand == 0){
            unidad = new UnidadProperty(new Abogado("Abogado" + getN_unidades(unidades,"l4"),profe));
        }
        //hacer(falta resto de casos
        return unidad;
    }
    private UnidadProperty generarUnidadCiencias(Lista<UnidadProperty> unidades,boolean profe) {
        return null;
        //hacer(similar a letras
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
    public void onClickSalir(){
        Stage s = new Stage();
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("PantallaPrincipal-view.fxml"));
        try{
            Scene scene = new Scene(fxmlLoader.load(), 1050, 600);
            s.setTitle("Conquista");
            s.setScene(scene);
            PantallaPrincipalController controller = fxmlLoader.getController();
            controller.setStagePrincipal(s);
            s.show();
            this.stage.close();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    @FXML
    public void onClickSaltarTurno(){
        punto = 0;
        puntos.setText("TE QUEDAN " + punto + " PUNTOS");
        actualizar();
    }

    @FXML
    public void actualizar(){
        //termina turno del jugador
        if(punto == 0){
            //pasa turno de ai
            turnos.setText("RONDA " + ronda + " : TURNO DE CONTRINCANTE");
            reestablecerPuntos();
            while(punto != 0){
                Contrario();
            }
            //termina turno de ai, empieza nueva ronda
            ronda ++;
            if(ronda % 3 == 0){
                //entrada unidad nueva con pregunta
                entraUnidad();
            }
            reestablecerPuntos();
            turnos.setText("RONDA " + ronda + " : TU TURNO");
            puntos.setText("TE QUEDAN " + punto + " PUNTOS");
        }
    }
    private void reestablecerPuntos(){
        if(ronda < 4){
            punto = 2;
        }else {
            punto = 3;
        }
    }
    protected void Contrario(){
        //movimiento de ai
    }

    protected void entraUnidad(){
        //para jugador
        UnidadProperty nueva = null;
        if(faccion.equals("c")){
            nueva = generarUnidadCiencias(Mis_unidades,false);
        }else{
            nueva = generarUnidadLetras(Mis_unidades,false);
        }
        if(Pregunta(nueva.getBase().getId())){
            informacion.setText("Respuesta correcta. Elige una casilla para poner tu unidad nueva.");
            Mis_unidades.add(nueva);
            //añadir la nueva en el tablero
            añadirUnidad(nueva);
        }else{
            informacion.setText("Respuesta incorrecta. No consiguiste unidad nueva.");
        }
        //para ai
        //hacer(diferente que el jugador
    }
    protected void añadirUnidad(UnidadProperty nueva){
        //falta
    }
    @FXML
    protected boolean Pregunta(String id){
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
        controller.setId(id);
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
