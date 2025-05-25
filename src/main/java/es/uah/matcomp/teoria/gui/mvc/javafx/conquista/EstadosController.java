package es.uah.matcomp.teoria.gui.mvc.javafx.conquista;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class EstadosController {
    @FXML
    private Label nombreUnidadLabel;
    @FXML
    private Label rangoUnidadLabel;
    @FXML
    private Label hpLabel;
    @FXML
    private Label ataqueLabel;
    @FXML
    private Label defensaLabel;
    @FXML
    private Label rMovimientoLabel;
    @FXML
    private Label rAtaqueLabel;

    public void setEstados(String nombreUnidad, String rangoUnidad, int hp, int ataque, int defensa, int rMovimiento, int rAtaque) {
        this.nombreUnidadLabel.setText(nombreUnidad);
        this.rangoUnidadLabel.setText(rangoUnidad);
        this.hpLabel.setText("• Puntos de vida (HP):  " + hp);
        this.ataqueLabel.setText("• Ataque:  " + ataque);
        this.defensaLabel.setText("• Defensa:  " + defensa);
        this.rMovimientoLabel.setText("• Rango de movimiento:  " + rMovimiento);
        this.rAtaqueLabel.setText("• Rango de ataque:  " + rAtaque);
    }
}
