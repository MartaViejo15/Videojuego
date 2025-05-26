package es.uah.matcomp.teoria.gui.mvc.javafx.conquista;

import javafx.fxml.FXML;
import javafx.stage.Stage;

public class CargarPartidaErrorController {
    private Stage stage;
    @FXML
    public void aceptar() {
        stage.close();
    }
    public void setStage(Stage stage) {
        this.stage = stage;
    }
}
