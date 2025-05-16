package es.uah.matcomp.teoria.gui.mvc.javafx.conquista;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.util.Random;

public class PreguntaController {
    private Stage stage;

    @FXML
    private Label pregunta;

    @FXML
    private TextField res;

    private int random = new Random().nextInt(10);

    protected void setStage(Stage stage) {
        this.stage = stage;
    }
}
