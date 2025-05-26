package es.uah.matcomp.teoria.gui.mvc.javafx.conquista;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.google.gson.Gson;
import es.uah.matcomp.teoria.gui.mvc.javafx.conquista.ClasesAuxiliaresParaSerializacion.Mapa;
import com.fasterxml.jackson.databind.ObjectMapper;
import es.uah.matcomp.teoria.gui.mvc.javafx.conquista.ClasesAuxiliaresParaSerializacion.PartidaASerializar;
import es.uah.matcomp.teoria.gui.mvc.javafx.conquista.inventario.Inventario;
import es.uah.matcomp.teoria.gui.mvc.javafx.conquista.preguntas.Elemento;
import es.uah.matcomp.teoria.gui.mvc.javafx.conquista.preguntas.Lista;
import es.uah.matcomp.teoria.gui.mvc.javafx.conquista.tablero.Casilla;
import es.uah.matcomp.teoria.gui.mvc.javafx.conquista.tablero.Tablero;
import es.uah.matcomp.teoria.gui.mvc.javafx.conquista.unidades.*;
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
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
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

    private Label Logs;

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

    private boolean atacar;
    private boolean mover;

    private static final Logger log = LogManager.getLogger(PartidaController.class);

    @FXML
    public void initData() {
        this.tablero = new Tablero();
        this.Enemigos = new Lista<>();
        punto = 2;
        ronda = 1;
        puntos.setText("TE QUEDAN " + punto + " PUNTOS");
        turnos.setText("RONDA " + ronda + " : TU TURNO");
        String info = "Ronda: " + ronda;
        log.info(info);
        Logs.setText(info + "\n");
        configurarMapa();
        configurarUnidades();
        informacion.setText("Selecciona una acción.");
        atacar = false;
        mover = false;
    }
    @FXML
    private void configurarMapa() {
        //Configurar Mapa según el identificador (atributo mapa)
        if(mapa == 1){
            mapa1();
        }
        if (mapa == 2){
            mapa2();
        }
        if(mapa == 3){
            mapa3();
        }
        if(mapa == 4){
            mapa4();
        }
        //hacer el resto de mapas
    }
    @FXML
    private void mapa1() {
        Mapa.getChildren().clear();
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                //Parte Visual
                Image imagen = new Image(getClass().getResourceAsStream("/es/uah/matcomp/teoria/gui/mvc/javafx/conquista/Imagen/Logo.png"));
                ImageView imagenView = new ImageView(imagen);
                imagenView.setFitHeight(60);
                imagenView.setFitWidth(60);
                imagenView.setVisible(false);
                AnchorPane casilla = new AnchorPane(imagenView);
                casilla.setStyle("-fx-border-color: black;-fx-background-color: white");
                casilla.setMinSize(60,60);
                casilla.setOnMouseClicked(onClicked(i,j));
                Mapa.add(casilla, j, i);
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
    private void mapa2() {
        Mapa.getChildren().clear();
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                Image imagen = new Image(getClass().getResourceAsStream("/es/uah/matcomp/teoria/gui/mvc/javafx/conquista/Imagen/Logo.png"));
                ImageView imagenView = new ImageView(imagen);
                imagenView.setFitHeight(60);
                imagenView.setFitWidth(60);
                imagenView.setVisible(false);
                AnchorPane casilla = new AnchorPane(imagenView);
                casilla.setStyle("-fx-border-color: black; -fx-background-color: white");
                casilla.setMinSize(60,60);
                casilla.setOnMouseClicked(onClicked(j,i));
                Mapa.add(casilla, i, j);
                //Parte no visual
                tablero.addCasilla(i,j);
            }
        }
        //Aristas
        for(int i = 0; i < 8; i++){
            for (int j = 0; j < 8; j++) {
                if(j+1 < 8){
                    tablero.addArista(2,tablero.getCasilla(i,j),tablero.getCasilla(i,j+1));
                    tablero.addArista(2,tablero.getCasilla(i,j+1),tablero.getCasilla(i,j));
                }if(i+1 < 8){
                    tablero.addArista(1,tablero.getCasilla(i,j),tablero.getCasilla(i+1,j));
                    tablero.addArista(1,tablero.getCasilla(i+1,j),tablero.getCasilla(i,j));
                }
            }
        }
        //Casillas especiales
        tablero.cambiarDif_mov(tablero.getCasilla(3,6),3);
        tablero.cambiarDif_mov(tablero.getCasilla(2,3),3);
        tablero.cambiarDif_mov(tablero.getCasilla(6,2),3);
        tablero.cambiarDif_mov(tablero.getCasilla(7,7),3);
    }

    @FXML
    private void mapa3() {
        Mapa.getChildren().clear();
        for (int i = 0; i < 7; i++) {
            for (int j = 0; j < 10; j++) {
                //Parte Visual
                Image imagen = new Image(getClass().getResourceAsStream("/es/uah/matcomp/teoria/gui/mvc/javafx/conquista/Imagen/Logo.png"));
                ImageView imagenView = new ImageView(imagen);
                imagenView.setFitHeight(60);
                imagenView.setFitWidth(60);
                imagenView.setVisible(false);
                AnchorPane casilla = new AnchorPane(imagenView);
                casilla.setStyle("-fx-border-color: black;");
                casilla.setMinSize(60,60);
                casilla.setOnMouseClicked(onClicked(i,j));
                Mapa.add(casilla, j, i);
                //Parte no visual
                tablero.addCasilla(i,j);
            }
        }
        //aristas
        for(int i = 0; i < 7; i++){
            for (int j = 0; j < 10; j++) {
                if(j+1 < 10){
                    tablero.addArista(3,tablero.getCasilla(i,j),tablero.getCasilla(i,j+1));
                    tablero.addArista(3,tablero.getCasilla(i,j+1),tablero.getCasilla(i,j));
                }if(i+1 < 7){
                    tablero.addArista(1,tablero.getCasilla(i,j),tablero.getCasilla(i+1,j));
                    tablero.addArista(1,tablero.getCasilla(i+1,j),tablero.getCasilla(i,j));
                }
            }
        }
        //casillas especiales
        tablero.cambiarDif_mov(tablero.getCasilla(3,4),4);
        tablero.cambiarDif_mov(tablero.getCasilla(1,3),4);
        tablero.cambiarDif_mov(tablero.getCasilla(1,5),4);
        tablero.cambiarDif_mov(tablero.getCasilla(7,3),4);
        tablero.cambiarDif_mov(tablero.getCasilla(7,5),4);
        tablero.cambiarDif_mov(tablero.getCasilla(4,4),4);
    }

    @FXML
    public EventHandler<MouseEvent> onClicked(int fila, int columna) {
        return mouseEvent -> {
            UnidadProperty flotante = tablero.getCasilla(fila,columna).getUnidad();
            if(seleccionado == null && flotante == null){
                informacion.setText("Seleccione unidad");
            } else if (seleccionado == null) {
                if(comprobarEquipo(Mis_unidades,flotante)){
                    this.seleccionado = flotante;
                    informacion.setText("Seleccionada unidad: " + seleccionado.getBase().getNombre());
                }else{
                    informacion.setText("Unidad seleccionada no es de tu equipo.");
                }
            } else if (mover){
                int disx = Math.abs(seleccionado.getPosicionX() - fila);
                int disy = Math.abs(seleccionado.getPosicionY() - columna);
                int distancia = disx + disy;
                if(flotante != null){
                    informacion.setText("Casilla ocupada");
                }else if (distancia > seleccionado.getBase().getRango_Movimiento()){
                    //no (hacer
                    informacion.setText("Casilla fuera del rango de movimiento");
                }else {
                    accionMover(fila,columna);
                    informacion.setText(seleccionado.getBase().getNombre() + " mueve a la casilla " + fila + ", " + columna);
                    log.info(informacion);
                    Logs.setText(Logs.getText() + informacion +"\n");
                    onClickMover();
                    seleccionado = null;
                    punto--;
                    actualizar();
                }
            } else if (atacar) {
                int disx = Math.abs(seleccionado.getPosicionX() - fila);
                int disy = Math.abs(seleccionado.getPosicionY() - columna);
                int distancia = disx + disy;
                if(flotante == null){
                    informacion.setText("Elige unidad a que quiere atacar.");
                } else if (distancia > seleccionado.getBase().getRango_Ataque()){
                    informacion.setText("Unidad fuera del rango de ataque");
                } else if (!comprobarEquipo(Enemigos,flotante)) {
                    informacion.setText("No puedes atacar unidad de tu equipo.");
                } else {
                    informacion.setText(seleccionado.getBase().getNombre() + " ataca a " + flotante.getBase().getNombre() + ", con daño: " + accionAtacar(flotante));
                    comprobarMuerte(flotante);
                    onClickAtacar();
                    seleccionado = null;
                    punto--;
                    actualizar();
                }
            } else {
                this.seleccionado = flotante;
                informacion.setText("Seleccionada unidad: " + seleccionado.getBase().getNombre());
            }
        };
    }
    @FXML
    private void mapa4() {
        ObjectMapper mapper = new ObjectMapper();
        Mapa.getChildren().clear();
        try{
            Mapa m = mapper.readValue("Mapa personalizada",Mapa.class);
            for (int i = 0; i < m.getAlturaGrid(); i++) {
                for (int j = 0; j < m.getLongitudGrid(); j++) {
                    Image imagen = new Image(getClass().getResourceAsStream("/es/uah/matcomp/teoria/gui/mvc/javafx/conquista/Imagen/Logo.png"));
                    ImageView imagenView = new ImageView(imagen);
                    int mayor = 0;
                    if(m.getAlturaGrid()<m.getLongitudGrid()){
                        mayor = m.getLongitudGrid();
                    }else {
                        mayor = m.getAlturaGrid();
                    }
                    double tamaño = Math.round((float) 600 /mayor);
                    imagenView.setFitHeight(tamaño);
                    imagenView.setFitWidth(tamaño);
                    imagenView.setVisible(false);
                    AnchorPane casilla = new AnchorPane(imagenView);
                    casilla.setStyle("-fx-border-color: " + m.getColorBorde() + "; -fx-background-color: " + m.getColorFondo() + ";");
                    casilla.setMinSize(tamaño,tamaño);
                    casilla.setOnMouseClicked(onClicked(j,i));
                    Mapa.add(casilla, i, j);
                }
            }
            this.tablero = m.getTablero();
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }
    @FXML
    public void accionMover(int fila, int columna) {
        //parte visual
        for (Node nodo : Mapa.getChildren()) {
            Integer filaNodo = 0;
            Integer columnaNodo = 0;
            if(GridPane.getRowIndex(nodo) != null){
                filaNodo = GridPane.getRowIndex(nodo);
            }if(GridPane.getColumnIndex(nodo) != null){
                columnaNodo = GridPane.getColumnIndex(nodo);
            }
            if(filaNodo ==seleccionado.getPosicionX() && columnaNodo ==seleccionado.getPosicionY()){
                AnchorPane casilla = (AnchorPane) nodo;
                ImageView imagen = (ImageView) casilla.getChildren().getFirst();
                imagen.setVisible(false);
            } else if (filaNodo == fila && columnaNodo == columna) {
                AnchorPane casilla = (AnchorPane) nodo;
                ImageView imagen = (ImageView) casilla.getChildren().getFirst();
                ponerImagen(seleccionado,imagen);
                imagen.setVisible(true);
            }
        }
        //parte no visual
        tablero.getCasilla(seleccionado.getPosicionX(),seleccionado.getPosicionY()).setUnidad(null);
        Casilla destino = tablero.getCasilla(fila,columna);
        if(destino.getInventario() != null){
            seleccionado.cogerInventario(destino.getInventario());
            destino.setInventario(null);
        }
        destino.setUnidad(seleccionado);
    }
    private int accionAtacar(UnidadProperty flotante) {
        String info = seleccionado.getBase().getNombre() + " ha atacado a " + flotante.getBase().getNombre();
        log.info(info);
        Logs.setText(Logs.getText() + info +"\n");
        return this.seleccionado.atacar(flotante);
    }
    @FXML
    private void comprobarMuerte(UnidadProperty flotante) {
        if(flotante.getHP().get() <= 0){
            //parte visual
            for (Node nodo : Mapa.getChildren()) {
                Integer filaNodo = 0;
                Integer columnaNodo = 0;
                if(GridPane.getRowIndex(nodo) != null){
                    filaNodo = GridPane.getRowIndex(nodo);
                }if(GridPane.getColumnIndex(nodo) != null){
                    columnaNodo = GridPane.getColumnIndex(nodo);
                }
                if(filaNodo == flotante.getPosicionX() && columnaNodo == flotante.getPosicionY()){
                    AnchorPane casilla = (AnchorPane) nodo;
                    ImageView imagen = (ImageView) casilla.getChildren().getFirst();
                    imagen.setVisible(false);
                }
            }
            //parte no visual
            if(comprobarEquipo(Enemigos,flotante)){
                Enemigos.delete(flotante);
                String info = "La unidad enemiga" + flotante.getBase().getNombre() + " ha sido eliminada";
                log.info(info);
                Logs.setText(Logs.getText() + info +"\n");
            }else {
                Mis_unidades.delete(flotante);
                String info = "Tu unidad" + flotante.getBase().getNombre() + " ha sido eliminada";
                log.info(info);
                Logs.setText(Logs.getText() + info +"\n");
            }
        }
    }
    private boolean comprobarEquipo(Lista<UnidadProperty> equipo, UnidadProperty unidad) {
        return equipo.buscar(unidad).equals(unidad);
    }
    private void configurarUnidades() {
        //Poner mis_unidades en Mapa y tablero
        ponerUnidad(0,0,Mis_unidades.getPrimero().getDato());
        ponerUnidad(Mapa.getRowCount()-1,0,Mis_unidades.getPrimero().getSiguiente().getDato());
        //genero enemigos
        if(faccion.equals("c")){
            Enemigos.add(generarUnidadLetras(Enemigos,true));
            Enemigos.add(generarUnidadLetras(Enemigos,true));
        }else{
            Enemigos.add(generarUnidadCiencias(Enemigos,true));
            Enemigos.add(generarUnidadCiencias(Enemigos,true));
        }
        //Poner Enemigos en Mapa y tablero
        ponerUnidad(0,Mapa.getColumnCount()-1,Enemigos.getPrimero().getDato());
        ponerUnidad(Mapa.getRowCount()-1,Mapa.getColumnCount()-1,Enemigos.getPrimero().getSiguiente().getDato());
    }
    @FXML
    private void ponerUnidad(int fila, int columna, UnidadProperty unidad) {
        tablero.getCasilla(fila,columna).setUnidad(unidad);
        for (Node nodo : Mapa.getChildren()) {
            Integer filaNodo = 0;
            Integer columnaNodo = 0;
            if(GridPane.getRowIndex(nodo) != null){
                filaNodo = GridPane.getRowIndex(nodo);
            }if(GridPane.getColumnIndex(nodo) != null){
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
            imagen.setImage(new Image(getClass().getResourceAsStream("/es/uah/matcomp/teoria/gui/mvc/javafx/conquista/Imagen/químico.png")));
        }
        if(unidad.getBase().getId().equals("c2")){
            imagen.setImage(new Image(getClass().getResourceAsStream("/es/uah/matcomp/teoria/gui/mvc/javafx/conquista/Imagen/biólogo.png")));
        }
        if(unidad.getBase().getId().equals("c3")){
            imagen.setImage(new Image(getClass().getResourceAsStream("/es/uah/matcomp/teoria/gui/mvc/javafx/conquista/Imagen/ingeniero.png")));
        }
        if(unidad.getBase().getId().equals("c4")){
            imagen.setImage(new Image(getClass().getResourceAsStream("/es/uah/matcomp/teoria/gui/mvc/javafx/conquista/Imagen/mates.png")));
        }
        if(unidad.getBase().getId().equals("c5")){
            imagen.setImage(new Image(getClass().getResourceAsStream("/es/uah/matcomp/teoria/gui/mvc/javafx/conquista/Imagen/médico.png")));
        }
        if(unidad.getBase().getId().equals("l1")){
            imagen.setImage(new Image(getClass().getResourceAsStream("/es/uah/matcomp/teoria/gui/mvc/javafx/conquista/Imagen/poeta_rojo.png")));
        }
        if(unidad.getBase().getId().equals("l2")){
            imagen.setImage(new Image(getClass().getResourceAsStream("/es/uah/matcomp/teoria/gui/mvc/javafx/conquista/Imagen/filólogo_rojo.png")));
        }
        if(unidad.getBase().getId().equals("l3")){
            imagen.setImage(new Image(getClass().getResourceAsStream("/es/uah/matcomp/teoria/gui/mvc/javafx/conquista/Imagen/historiador_rojo.png")));
        }
        if(unidad.getBase().getId().equals("l4")){
            imagen.setImage(new Image(getClass().getResourceAsStream("/es/uah/matcomp/teoria/gui/mvc/javafx/conquista/Imagen/abogado_rojo.png")));
        }
        if(unidad.getBase().getId().equals("l5")){
            imagen.setImage(new Image(getClass().getResourceAsStream("/es/uah/matcomp/teoria/gui/mvc/javafx/conquista/Imagen/maestro_rojo.png")));
        }
    }
    private UnidadProperty generarUnidadLetras(Lista<UnidadProperty> unidades,boolean profe) {
        int rand = new Random().nextInt(4);
        UnidadProperty unidad = null;
        if(rand == 0){
            unidad = new UnidadProperty(new Poeta("Poeta" + getN_unidades(unidades,"l1"),profe));
        }
        if (rand == 1){
            unidad = new UnidadProperty(new Filologo("Filólogo" + getN_unidades(unidades,"l2"),profe));
        }
        if (rand == 2){
            unidad = new UnidadProperty(new Historiador("Historiador" + getN_unidades(unidades,"l3"),profe));
        }
        if (rand == 3){
            unidad = new UnidadProperty(new Abogado("Abogado" + getN_unidades(unidades,"l4"),profe));
        }
        if (rand == 4){
            unidad = new UnidadProperty(new Maestro("Maestro" + getN_unidades(unidades,"l5"),profe));
        }
        return unidad;
    }
    private UnidadProperty generarUnidadCiencias(Lista<UnidadProperty> unidades,boolean profe) {
        int rand = new Random().nextInt(4);
        UnidadProperty unidad = null;
        if(rand == 0){
            unidad = new UnidadProperty(new Quimico("Químico" + getN_unidades(unidades,"c1"),profe));
        }
        if (rand == 1){
            unidad = new UnidadProperty(new Biologo("Biólogo" + getN_unidades(unidades,"c2"),profe));
        }
        if (rand == 2){
            unidad = new UnidadProperty(new Ingeniero("Ingeniero" + getN_unidades(unidades,"c3"),profe));
        }
        if (rand == 3){
            unidad = new UnidadProperty(new Matematico("Matemático" + getN_unidades(unidades,"c4"),profe));
        }
        if (rand == 4){
            unidad = new UnidadProperty(new Medico("Médico" + getN_unidades(unidades,"c5"),profe));
        }
        return unidad;
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
    public void onClickAtacar() {
        if(seleccionado == null){
            informacion.setText("Seleccione unidad");
        } else if (!comprobarEquipo(Mis_unidades,seleccionado)) {
            informacion.setText("Unidad seleccionada no es de tu equipo");
        }else{
            if(atacar){
                atacar = false;
                verRangoAta(new Lista<>());
            }else{
                atacar = true;
                mover = false;
                informacion.setText("Seleccione unidad para atacar");
                //buscar rango ataque
                //falta por hacer(no es getCasillaAlcanzable como el mover, ya que no hay dif_mov
            }

        }
    }
    @FXML
    public void onClickMover() {
        if(seleccionado == null){
            informacion.setText("Seleccione unidad");
        }else if (!comprobarEquipo(Mis_unidades,seleccionado)) {
            informacion.setText("Unidad seleccionada no es de tu equipo");
        }else{
            if(mover){
                mover = false;
                verRangoMov(new Lista<>());
            }else{
                mover = true;
                atacar = false;
                informacion.setText("Seleccione casilla para mover");
                Lista<Casilla> casillasAlcanzables = tablero.getCasillasAlcanzable(tablero.getCasilla(seleccionado.getPosicionX(),seleccionado.getPosicionY()),seleccionado.getRango_Movimiento().get());
                verRangoMov(casillasAlcanzables);
            }
        }
    }
    private void verRangoMov(Lista<Casilla> casillasAlcanzables) {
        for (Node nodo : Mapa.getChildren()) {
            Integer filaNodo = 0;
            Integer columnaNodo = 0;
            if(GridPane.getRowIndex(nodo) != null){
                filaNodo = GridPane.getRowIndex(nodo);
            }if(GridPane.getColumnIndex(nodo) != null){
                columnaNodo = GridPane.getColumnIndex(nodo);
            }
            AnchorPane casilla = (AnchorPane) nodo;
            casilla.setStyle("-fx-background-color: white");
            if(mover && casillasAlcanzables.buscar(tablero.getCasilla(filaNodo,columnaNodo)) != null){
                casilla.setStyle("-fx-background-color: #243673");
            }
        }
    }
    private void verRangoAta(Lista<Casilla> casillasAlcanzables) {
        for (Node nodo : Mapa.getChildren()) {
            Integer filaNodo = 0;
            Integer columnaNodo = 0;
            if(GridPane.getRowIndex(nodo) != null){
                filaNodo = GridPane.getRowIndex(nodo);
            }if(GridPane.getColumnIndex(nodo) != null){
                columnaNodo = GridPane.getColumnIndex(nodo);
            }
            AnchorPane casilla = (AnchorPane) nodo;
            casilla.setStyle("-fx-background-color: white");
            if(atacar && casillasAlcanzables.buscar(tablero.getCasilla(filaNodo,columnaNodo)) != null){
                casilla.setStyle("-fx-background-color: rgba(188,94,94);");
            }
        }
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
    public void onClickHistorial(){
        Stage StageHistorial = new Stage();
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("Historial-view.fxml"));
        try{
            Scene sceneHistorial = new Scene(fxmlLoader.load(), 350, 400);
            StageHistorial.setTitle("Historial");
            StageHistorial.setScene(sceneHistorial);
            HistorialController controller = fxmlLoader.getController();
            controller.setLabelLogs(Logs);
            controller.setStage(StageHistorial);
            StageHistorial.show();
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
        if(Enemigos.getNumElementos() == 0){
            String info = "El jugador ha ganado la partida";
            log.info(info);
            Logs.setText(Logs.getText() + info +"\n");
            //gana jugador
            //falta por hacer
        }
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
            String info = "Ronda: " + ronda;
            log.info(info);
            Logs.setText(Logs.getText() + info +"\n");
            //refrescar unidad
            Elemento<UnidadProperty> aux = Mis_unidades.getPrimero();
            while(aux != null){
                aux.getDato().rollback();
                comprobarMuerte(aux.getDato());
                aux = aux.getSiguiente();
            }
            refrescarInventario();
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
        //falta por hacer
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
            String info = "Ha entrado la unidad: " + nueva.getBase().getNombre();
            log.info(info);
            Logs.setText(Logs.getText() + info +"\n");
            //añadir la nueva en el tablero
            añadirUnidad(nueva);
        }else{
            informacion.setText("Respuesta incorrecta. No conseguiste la unidad nueva.");
        }
        //para ai
        //hacer(diferente que el jugador
    }
    protected void añadirUnidad(UnidadProperty nueva){
        //falta por hacer
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
        controller.initData();
        s.show();
        while(s.isShowing()){}
        //Otra forma de esperar a contestar la pregunta?
        //Si el usuario no contesta y hace alguna otra accion?
        return controller.aceptar();
    }
    protected void refrescarInventario(){
        if(mapa == 1){
            refrescarInventario1();
        }
    }
    protected void refrescarInventario1(){
        if(ronda % 2 == 0){
            //genero inventario
            //falta por hacer
        }
    }

    @FXML
    protected void guardar(){
        String Partida1 = "src/main/resources/es/uah/matcomp/teoria/gui/mvc/javafx/conquista/Partida1.json";
        String Partida2 = "src/main/resources/es/uah/matcomp/teoria/gui/mvc/javafx/conquista/Partida2.json";
        String Partida3 = "src/main/resources/es/uah/matcomp/teoria/gui/mvc/javafx/conquista/Partida3.json";
        String Partida4 = "src/main/resources/es/uah/matcomp/teoria/gui/mvc/javafx/conquista/Partida4.json";

        File Archivo1 = new File(Partida1);
        File Archivo2 = new File(Partida2);
        File Archivo3 = new File(Partida3);
        File Archivo4 = new File(Partida4);

        String colorFondo = "White";
        String colorBorde = "Black";

        if(mapa == 4){
            ObjectMapper mapper = new ObjectMapper();
            try{
                Mapa m = mapper.readValue("Mapa personalizada",Mapa.class);
                colorFondo = m.getColorFondo();
                colorBorde = m.getColorBorde();
            } catch (JsonProcessingException e) {
                throw new RuntimeException(e);
            }
        }

        PartidaASerializar datosPartida = new PartidaASerializar(new Mapa(tablero, Mapa.getRowCount() - 1, Mapa.getColumnCount() - 1, colorFondo  , colorBorde), faccion, Mis_unidades, Enemigos, inventarios, punto, ronda, seleccionado, mapa, atacar, mover);

        if(Archivo1.length() == 0){
            ObjectMapper mapper1 = new ObjectMapper();
            try (FileWriter writer1 = new FileWriter(Partida1)) {
                mapper1.writeValue(Archivo1, datosPartida);
                System.out.println("Guardado en partida 1");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }else if(Archivo2.length() == 0){
            ObjectMapper mapper2 = new ObjectMapper();
            try (FileWriter writer2 = new FileWriter(Partida2)) {
                mapper2.writeValue(Archivo2, datosPartida);
                System.out.println("Guardado en partida 2");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }else if(Archivo3.length() == 0){
            ObjectMapper mapper3 = new ObjectMapper();
            try (FileWriter writer3 = new FileWriter(Partida3)) {
                mapper3.writeValue(Archivo3, datosPartida);
                System.out.println("Guardado en partida 3");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }else if(Archivo4.length() == 0){
            ObjectMapper mapper4 = new ObjectMapper();
            try (FileWriter writer4 = new FileWriter(Partida4)) {
                mapper4.writeValue(Archivo4, datosPartida);
                System.out.println("Guardado en partida 4");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
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
