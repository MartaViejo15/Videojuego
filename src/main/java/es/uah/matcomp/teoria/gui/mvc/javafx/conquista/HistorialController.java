package es.uah.matcomp.teoria.gui.mvc.javafx.conquista;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

import java.awt.event.ActionEvent;

public class HistorialController {
    @FXML
    private Stage stage;

    @FXML
    private Label labelLogs;

    @FXML
    protected void logs(){

    }

    @FXML
    protected void Aceptar() {
        stage.close();
    }

    public void setLabelLogs(Label text){
        labelLogs.textProperty().bind(text.textProperty());
    }
    public void setStage(Stage stage){
        this.stage = stage;
    }

}
