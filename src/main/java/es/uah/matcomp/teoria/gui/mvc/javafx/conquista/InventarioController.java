package es.uah.matcomp.teoria.gui.mvc.javafx.conquista;

import es.uah.matcomp.teoria.gui.mvc.javafx.conquista.inventario.*;
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

    @FXML
    private Label NoHay;

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
        CommitInventario();
        ReaccionQuimica();
        Multiplicacion();
        Teorema();
        Babi();
        Juicio();
        TAC();
        Dinosaurio();
        RocaSedimentaria();
        stage.close();
    }
    private void LaCelestina() {
        if(g1.isSelected()) {
            unidad.UsarInventario(new LaCelestina());
        }
    }
    private void CommitInventario() {
        if(g2.isSelected()) {
            unidad.UsarInventario(new Commit());
        }
    }
    private void ReaccionQuimica() {
        if(g3.isSelected()) {
            unidad.UsarInventario(new ReacciónQuímica());
        }
    }
    private void Multiplicacion() {
        if(g4.isSelected()) {
            unidad.UsarInventario(new Multiplicación());
        }
    }
    private void Teorema() {
        if(g5.isSelected()) {
            unidad.UsarInventario(new Teorema());
        }
    }
    private void Babi() {
        if(g6.isSelected()) {
            unidad.UsarInventario(new Babi());
        }
    }
    private void Juicio() {
        if(g7.isSelected()) {
            unidad.UsarInventario(new Juicio());
        }
    }
    private void TAC() {
        if(g8.isSelected()) {
            unidad.UsarInventario(new TAC());
        }
    }
    private void Dinosaurio() {
        if(g9.isSelected()) {
            unidad.UsarInventario(new Dinosaurio());
        }
    }
    private void RocaSedimentaria() {
        if(g10.isSelected()) {
            unidad.UsarInventario(new RocaSedimentaria());
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
        comprobarCommit();
        comprobarReaccionQuimica();
        comprobarMultiplicacion();
        comprobarTeorema();
        comprobarBabi();
        comprobarJuicio();
        comprobarTAC();
        comprobarDinosaurio();
        comprobarRocaSedimentaria();
        NoHay.setVisible(!g1.isVisible() && !g2.isVisible() && !g3.isVisible() && !g4.isVisible() && !g5.isVisible() && !g6.isVisible() && !g7.isVisible() && !g8.isVisible() && !g9.isVisible() && !g10.isVisible());
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
    private void comprobarCommit() {
        Elemento<Inventario> item2 = unidad.buscar(new Commit());
        if(item2 == null) {
            gn2.setVisible(false);
            g2.setVisible(false);
        }else{
            gn2.setText("x " + unidad.buscar(new Commit()).getDato().getN_elementos());
            gn2.setVisible(true);
            g2.setVisible(true);
        }
    }
    private void comprobarReaccionQuimica() {
        Elemento<Inventario> item3 = unidad.buscar(new ReacciónQuímica());
        if(item3 == null) {
            gn3.setVisible(false);
            g3.setVisible(false);
        }else{
            gn3.setText("x " + unidad.buscar(new ReacciónQuímica()).getDato().getN_elementos());
            gn3.setVisible(true);
            g3.setVisible(true);
        }
    }
    private void comprobarMultiplicacion() {
        Elemento<Inventario> item4 = unidad.buscar(new Multiplicación());
        if(item4 == null) {
            gn4.setVisible(false);
            g4.setVisible(false);
        }else{
            gn4.setText("x " + unidad.buscar(new Multiplicación()).getDato().getN_elementos());
            gn4.setVisible(true);
            g4.setVisible(true);
        }
    }
    private void comprobarTeorema() {
        Elemento<Inventario> item5 = unidad.buscar(new Teorema());
        if(item5 == null) {
            gn5.setVisible(false);
            g5.setVisible(false);
        }else {
            gn5.setText("x " + unidad.buscar(new Teorema()).getDato().getN_elementos());
            gn5.setVisible(true);
            g5.setVisible(true);
        }
    }
    private void comprobarBabi() {
        Elemento<Inventario> item6 = unidad.buscar(new Babi());
        if(item6 == null) {
            gn6.setVisible(false);
            g6.setVisible(false);
        }else {
            gn6.setText("x " + unidad.buscar(new Babi()).getDato().getN_elementos());
            gn6.setVisible(true);
            g6.setVisible(true);
        }
    }
    private void comprobarJuicio() {
        Elemento<Inventario> item7 = unidad.buscar(new Juicio());
        if(item7 == null) {
            gn7.setVisible(false);
            g7.setVisible(false);
        }else {
            gn7.setText("x " + unidad.buscar(new Juicio()).getDato().getN_elementos());
            gn7.setVisible(true);
            g7.setVisible(true);
        }
    }
    private void comprobarTAC() {
        Elemento<Inventario> item8 = unidad.buscar(new TAC());
        if(item8 == null) {
            gn8.setVisible(false);
            g8.setVisible(false);
        }else {
            gn8.setText("x " + unidad.buscar(new TAC()).getDato().getN_elementos());
            gn8.setVisible(true);
            g8.setVisible(true);
        }
    }
    private void comprobarDinosaurio() {
        Elemento<Inventario> item9 = unidad.buscar(new Dinosaurio());
        if(item9 == null) {
            gn9.setVisible(false);
            g9.setVisible(false);
        }else {
            gn9.setText("x " + unidad.buscar(new Dinosaurio()).getDato().getN_elementos());
            gn9.setVisible(true);
            g9.setVisible(true);
        }
    }
    private void comprobarRocaSedimentaria() {
        Elemento<Inventario> item10 = unidad.buscar(new RocaSedimentaria());
        if(item10 == null) {
            gn10.setVisible(false);
            g10.setVisible(false);
        }else {
            gn10.setText("x " + unidad.buscar(new RocaSedimentaria()).getDato().getN_elementos());
            gn10.setVisible(true);
            g10.setVisible(true);
        }
    }
}
