package es.uah.matcomp.teoria.gui.mvc.javafx.conquista;

import javafx.fxml.FXML;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.stage.Stage;

public class InventarioController {
    @FXML
    private CheckBox esp1;
    @FXML
    private CheckBox esp2;

    @FXML
    private CheckBox g1;
    @FXML
    private CheckBox g2;
    @FXML
    private CheckBox g3;
    @FXML
    private CheckBox g4;
    @FXML
    private CheckBox g5;
    @FXML
    private CheckBox g6;

    @FXML
    private Label gn1;
    @FXML
    private Label gn2;
    @FXML
    private Label gn3;
    @FXML
    private Label gn4;
    @FXML
    private Label gn5;
    @FXML
    private Label gn6;

    private Stage stage;

    @FXML
    protected void esp1Clicked() {
        if (esp1.isSelected()) {
            esp2.setSelected(false);
        }
    }
    @FXML
    protected void esp2Clicked() {
        if (esp2.isSelected()) {
            esp1.setSelected(false);
        }
    }

    protected void setstage(Stage stage) {
        this.stage = stage;
    }
}
