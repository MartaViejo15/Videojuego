package es.uah.matcomp.teoria.gui.mvc.javafx.conquista;

import es.uah.matcomp.teoria.gui.mvc.javafx.conquista.unidades.UnidadProperty;
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

    private UnidadProperty unidad;

    public void setEstados() {
        this.nombreUnidadLabel.setText(unidad.getBase().getNombre());
        if (unidad.getBase().isProfe()) {
            rangoUnidadLabel.setText("Profe");
        } else {
            rangoUnidadLabel.setText("Alumno");
        }
        this.hpLabel.textProperty().bind(unidad.getHP().asString());
        this.ataqueLabel.textProperty().bind(unidad.getAtaque().asString());
        this.defensaLabel.textProperty().bind(unidad.getDefensa().asString());
        this.rMovimientoLabel.textProperty().bind(unidad.getRango_Movimiento().asString());
        this.rAtaqueLabel.textProperty().bind(unidad.getRango_Ataque().asString());
    }

    public void setUnidad(UnidadProperty unidad) {
        this.unidad = unidad;
    }
}
