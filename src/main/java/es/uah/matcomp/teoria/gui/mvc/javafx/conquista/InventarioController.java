package es.uah.matcomp.teoria.gui.mvc.javafx.conquista;

import es.uah.matcomp.teoria.gui.mvc.javafx.conquista.inventario.LaCelestina;
import es.uah.matcomp.teoria.gui.mvc.javafx.conquista.inventario.Inventario;
import es.uah.matcomp.teoria.gui.mvc.javafx.conquista.preguntas.Elemento;
import es.uah.matcomp.teoria.gui.mvc.javafx.conquista.unidades.UnidadProperty;
import javafx.fxml.FXML;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.stage.Stage;

public class InventarioController {
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
    private CheckBox g7;
    @FXML
    private CheckBox g8;
    @FXML
    private CheckBox g9;
    @FXML
    private CheckBox g10;

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
    @FXML
    private Label gn7;
    @FXML
    private Label gn8;
    @FXML
    private Label gn9;
    @FXML
    private Label gn10;

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
        unidad.rollback();
    }
    @FXML
    protected void esp2Clicked() {
        if (esp2.isSelected()) {
            esp1.setSelected(false);
            unidad.getBase().usarElementoEspecifico(unidad.getBase().getElementoEspecifico2());
        } if (!esp2.isSelected() && !esp1.isSelected()) {
            unidad.getBase().usarElementoEspecifico(null);
        }
        unidad.rollback();
    }
    @FXML
    protected void aceptarClicked() {
        LaCelestina();
        /*Commit();
        ReaccionQuimica();
        Multiplicacion();
        Teorema();
        Babi();
        Juicio();
        TAC();
        Dinosaurio();
        RocaSedimentaria();*/
        stage.close();
    }
    private void LaCelestina() {
        if(g1.isSelected()) {
            unidad.UsarInventario(new LaCelestina());
        }
    }

    protected void setstage(Stage stage) {
        this.stage = stage;
    }
    protected void setUnidad(UnidadProperty unidad) {
        this.unidad = unidad;
    }

    public void initData() {
        esp1.setText(unidad.getBase().getElementoEspecifico1().getNombre());
        esp2.setText(unidad.getBase().getElementoEspecifico2().getNombre());
        Nombre.setText(unidad.getBase().getNombre());
        esp1.setSelected(unidad.getBase().getElementoEspecifico1().uso());
        esp2.setSelected(unidad.getBase().getElementoEspecifico2().uso());
        comprobarLaCelestina();
        /*comprobarCommit();
        comprobarReaccionQuimica();
        comprobarMultiplicacion();
        comprobarTeorema();
        comprobarBabi();
        comprobarJuicio();
        comprobarTAC();
        comprobarDinosaurio();
        comprobarRocaSedimentaria*/

    }
    private void comprobarLaCelestina() {
        Elemento<Inventario> item1 = unidad.buscar(new LaCelestina());
        if(item1 == null) {
            gn1.setVisible(false);
            g1.setVisible(false);
        }else{
            gn1.setText("x " + unidad.buscar(new LaCelestina()).getDato().getN_elementos());
            gn1.setVisible(true);
            g1.setVisible(true);
        }
    }
}
