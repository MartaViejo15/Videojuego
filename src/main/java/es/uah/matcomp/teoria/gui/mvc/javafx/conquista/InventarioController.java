package es.uah.matcomp.teoria.gui.mvc.javafx.conquista;

import es.uah.matcomp.teoria.gui.mvc.javafx.conquista.inventario.CantarDeMioCid;
import es.uah.matcomp.teoria.gui.mvc.javafx.conquista.inventario.Inventario;
import es.uah.matcomp.teoria.gui.mvc.javafx.conquista.preguntas.Elemento;
import es.uah.matcomp.teoria.gui.mvc.javafx.conquista.unidades.UnidadProperty;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class InventarioController implements Initializable {
    @FXML
    private Label Nombre;
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

    private UnidadProperty unidad;

    @FXML
    protected void esp1Clicked() {
        if (esp1.isSelected()) {
            esp2.setSelected(false);
            unidad.getBase().usarElementoEspecifico(unidad.getBase().getElementoEspecifico1());
        } if (!esp1.isSelected() && !esp2.isSelected()) {
            unidad.getBase().usarElementoEspecifico(null);
        }
    }
    @FXML
    protected void esp2Clicked() {
        if (esp2.isSelected()) {
            esp1.setSelected(false);
            unidad.getBase().usarElementoEspecifico(unidad.getBase().getElementoEspecifico2());
        } if (!esp2.isSelected() && !esp1.isSelected()) {
            unidad.getBase().usarElementoEspecifico(null);
        }
    }
    @FXML
    protected void aceptarClicked() {
        CantarDeMioCid();
        stage.close();
    }
    private void CantarDeMioCid() {
        if(g1.isSelected()) {
            unidad.UsarInventario(new CantarDeMioCid());
        }
    }

    protected void setstage(Stage stage) {
        this.stage = stage;
    }
    protected void setUnidad(UnidadProperty unidad) {
        this.unidad = unidad;
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        esp1.setText(unidad.getBase().getElementoEspecifico1().getNombre());
        esp2.setText(unidad.getBase().getElementoEspecifico2().getNombre());
        Nombre.setText(unidad.getBase().getNombre());
        esp1.setSelected(unidad.getBase().getElementoEspecifico1().uso());
        esp2.setSelected(unidad.getBase().getElementoEspecifico2().uso());
        comprobarCantarDeMioCid();
    }
    private void comprobarCantarDeMioCid() {
        Elemento<Inventario> item1 = unidad.buscar(new CantarDeMioCid());
        if(item1 == null) {
            gn1.setVisible(false);
            g1.setVisible(false);
        }else{
            gn1.setText("x " + unidad.buscar(new CantarDeMioCid()).getDato().getN_elementos());
            gn1.setVisible(true);
            g1.setVisible(true);
        }
    }
}
