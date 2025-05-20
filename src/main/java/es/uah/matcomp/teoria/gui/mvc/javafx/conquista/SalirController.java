package es.uah.matcomp.teoria.gui.mvc.javafx.conquista;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.stage.Stage;


public class SalirController {

    private Stage stage;
    @FXML
    private Button botonNo;

    public void setStage(Stage stage) {
        this.stage = stage;
    }

    @FXML
    private void salirJuego(){
        System.exit(0);
    }

    @FXML
    private void cerrarVentana(){
        Stage stage = (Stage) botonNo.getScene().getWindow();
        stage.close();
    }
}
