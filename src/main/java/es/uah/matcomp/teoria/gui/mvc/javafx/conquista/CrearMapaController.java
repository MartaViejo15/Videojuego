package es.uah.matcomp.teoria.gui.mvc.javafx.conquista;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.Slider;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

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
    private ColorPicker color;
    @FXML
    private Slider tiempo;

    private Stage stage;

    protected void setstage(Stage stage) {
        this.stage = stage;
    }
}
