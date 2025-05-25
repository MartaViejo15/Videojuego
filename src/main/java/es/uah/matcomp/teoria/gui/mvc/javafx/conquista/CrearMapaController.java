package es.uah.matcomp.teoria.gui.mvc.javafx.conquista;

import com.google.gson.Gson;
import es.uah.matcomp.teoria.gui.mvc.javafx.conquista.ClasesAuxiliaresParaSerializacion.Mapa;
import es.uah.matcomp.teoria.gui.mvc.javafx.conquista.tablero.Tablero;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.Slider;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.io.FileWriter;
import java.io.IOException;

public class CrearMapaController {
    @FXML
    private GridPane mapa;
    @FXML
    private Slider altura;
    @FXML
    private Slider longitud;
    @FXML
    private Slider dif_mov;
    @FXML
    private ColorPicker colorFondo;
    @FXML
    private ColorPicker colorBorde;

    private Stage stage;
    private Stage anteriorStage;

    private Tablero tablero;

    @FXML
    private void actualizarEstilo() {
        for (Node nodo : mapa.getChildren()) {
            AnchorPane casilla = (AnchorPane) nodo;
            casilla.setStyle("-fx-background-color: " + traducirColor(colorFondo.getValue()) + "; -fx-border-color: " + traducirColor(colorBorde.getValue()) + ";");
        }
    }
    private String traducirColor(Color color) {
        int r = (int) Math.round(color.getRed() * 255);
        int g = (int) Math.round(color.getGreen() * 255);
        int b = (int) Math.round(color.getBlue() * 255);
        return String.format("#%02x%02x%02x", r, g, b);
    }


    @FXML
    protected void guadar(){
        completarTablero();
        Gson gson = new Gson();
        Mapa datos = new Mapa(this.tablero,(int) this.altura.getValue(),(int) this.longitud.getValue(),this.traducirColor(this.colorFondo.getValue()),this.traducirColor(this.colorBorde.getValue()));
        try (FileWriter writer1 = new FileWriter("Mapa personalizada.json")) {
            gson.toJson(datos, writer1);
        } catch (IOException e) {
            e.printStackTrace();
        }
        stage.close();
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("PartidaNueva-view.fxml"));
        PartidaNuevaController controller = fxmlLoader.getController();
        controller.setMapa_nueva(this.stage);
        controller.setStage(anteriorStage);
        anteriorStage.show();
    }
    private void completarTablero(){
        for (int i = 0; i < ((int) altura.getValue()); i++) {
            for (int j = 0; j < ((int)longitud.getValue()); j++) {
                if(j+1 < ((int) longitud.getValue())){
                    tablero.addArista(getDif_mov(),tablero.getCasilla(i,j),tablero.getCasilla(i,j+1));
                    tablero.addArista(getDif_mov(),tablero.getCasilla(i,j+1),tablero.getCasilla(i,j));
                }if(i+1 < ((int) altura.getValue())){
                    tablero.addArista(getDif_mov(),tablero.getCasilla(i,j),tablero.getCasilla(i+1,j));
                    tablero.addArista(getDif_mov(),tablero.getCasilla(i+1,j),tablero.getCasilla(i,j));
                }
            }
        }
    }
    @FXML
    protected void Salir() {
        stage.close();
        anteriorStage.show();
    }

    @FXML
    public void initData() {
        mapa.getChildren().clear();
        tablero = new Tablero();
        System.out.println("Altura: " + altura.getValue() + ", Longitud: " + longitud.getValue());
        for (int i = 0; i < ((int)altura.getValue()); i++) {
            for (int j = 0; j < ((int)longitud.getValue()); j++) {
                Image imagen = new Image(getClass().getResourceAsStream("/es/uah/matcomp/teoria/gui/mvc/javafx/conquista/Imagen/Logo.png"));
                ImageView imagenView = new ImageView(imagen);
                imagenView.setFitHeight(20);
                imagenView.setFitWidth(20);
                imagenView.setVisible(false);
                AnchorPane casilla = new AnchorPane(imagenView);
                casilla.setStyle("-fx-background-color: " + traducirColor(colorFondo.getValue()) + "; -fx-border-color: " + traducirColor(colorBorde.getValue()) + ";");
                casilla.setMinSize(20,20);
                mapa.add(casilla, j, i);
                tablero.addCasilla(i, j);
            }
        }
    }

    public void setstage(Stage stage) {
        this.stage = stage;
    }
    public void setAnteriorStage(Stage anteriorStage) {
        this.anteriorStage = anteriorStage;
    }
    public int getDif_mov(){
        return ((int) dif_mov.getValue());
    }
}
