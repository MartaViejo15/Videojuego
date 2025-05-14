package es.uah.matcomp.teoria.gui.mvc.javafx.conquista;

import javafx.fxml.FXML;
import javafx.scene.control.CheckBox;
import javafx.stage.Stage;

public class PartidaNuevaController {
    private Stage stage;
    @FXML
    private CheckBox t1;
    @FXML
    private CheckBox t2;
    @FXML
    private CheckBox t3;
    @FXML
    private CheckBox t4;
    @FXML
    private CheckBox ciencia;
    @FXML
    private CheckBox letra;

    @FXML
    protected void selecMap1(){
        t2.setSelected(false);
        t3.setSelected(false);
        t4.setSelected(false);
    }
    @FXML
    protected void selecMap2(){
        t3.setSelected(false);
        t4.setSelected(false);
        t1.setSelected(false);
    }
    @FXML
    protected void selecMap3(){
        t4.setSelected(false);
        t1.setSelected(false);
        t2.setSelected(false);
    }
    @FXML
    protected void selecMap4(){
        t1.setSelected(false);
        t2.setSelected(false);
        t3.setSelected(false);
    }

    @FXML
    protected void selecFaccion1(){
        letra.setSelected(false);
    }
    @FXML
    protected void selecFaccion2(){
        ciencia.setSelected(false);
    }

    @FXML
    protected void guardar(){
        stage.close();
    }

    protected void setStage(Stage stage) {
        this.stage = stage;
    }
}
