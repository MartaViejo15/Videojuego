package es.uah.matcomp.teoria.gui.mvc.javafx.conquista;

import es.uah.matcomp.teoria.gui.mvc.javafx.conquista.preguntas.Lista;
import es.uah.matcomp.teoria.gui.mvc.javafx.conquista.unidades.Unidad;
import es.uah.matcomp.teoria.gui.mvc.javafx.conquista.unidades.UnidadProperty;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.stage.Stage;

public class PartidaNuevaController {
    private Stage stage;
    private Stage ciencias;
    private Stage letras;
    private Stage mapa_nueva;
    private Lista<UnidadProperty> unidades;

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
    private Label Mapa;
    @FXML
    private Label Faccion;

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
        if(mapa_nueva == null){
            mapa_nueva = new Stage();
            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("CrearMapa-view.fxml"));
            try{
                Scene scene = new Scene(fxmlLoader.load(), 1050, 600);
                mapa_nueva.setScene(scene);
                mapa_nueva.setTitle("Crear Mapa");
                CrearMapaController controller = fxmlLoader.getController();
                controller.setstage(mapa_nueva);
                controller.setAnteriorStage(stage);
                mapa_nueva.show();
            }catch(Exception e){
                e.printStackTrace();
            }
        }else{
            mapa_nueva.show();
        }
        this.stage.close();
    }

    @FXML
    protected void selecFaccion1(){
        letra.setSelected(false);
        if(letras != null){
            if(letras.isShowing()){
                unidades = new Lista<>();
                letras.close();
            }
        }
        Stage s = new Stage();
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("PersonajesCiencias-view.fxml"));
        try{
            Scene scene = new Scene(fxmlLoader.load(), 1050, 600);
            s.setTitle("Elegir Personajes Ciencias");
            s.setScene(scene);
            PersonajesCienciasController controller = fxmlLoader.getController();
            //controller.setStage(s);
            s.show();
            ciencias = s;
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    @FXML
    protected void selecFaccion2(){
        ciencia.setSelected(false);
        if(ciencias != null){
            if(ciencias.isShowing()){
                unidades = new Lista<>();
                ciencias.close();
            }
        }
        Stage s = new Stage();
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("PersonajesLetras-view.fxml"));
        try{
            Scene scene = new Scene(fxmlLoader.load(), 1050, 600);
            s.setTitle("Elegir Personajes Letras");
            s.setScene(scene);
            PersonajesLetrasController controller = fxmlLoader.getController();
            //controller.setStage(s);
            s.show();
            letras = s;
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    @FXML
    protected void guardar(){
        if(!letra.isSelected() && !ciencia.isSelected()){
            this.Faccion.setStyle("-fx-text-fill: red;");
        } else if (!t1.isSelected() && !t2.isSelected() && !t3.isSelected() && !t4.isSelected()) {
            this.Mapa.setStyle("-fx-text-fill: red;");
        }else {
            //stage.close();
            Stage s = new Stage();
            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("Partida-view.fxml"));
            try {
                Scene scene = new Scene(fxmlLoader.load(), 1050, 600);
                s.setTitle("Partida");
                s.setScene(scene);
                PartidaController controller = fxmlLoader.getController();
                controller.setStage(s);
                mandarFaccion(controller);
                controller.setMis_unidades(unidades);
                mandarMapa(controller);
                s.show();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
    private void mandarFaccion(PartidaController controller){
        if (letra.isSelected()) {
            controller.setFaccion("l");
        } else {
            controller.setFaccion("c");
        }
    }
    private void mandarMapa(PartidaController controller){
        if (t1.isSelected()) {
            controller.setmapa(1);
        }else if (t4.isSelected()) {
            controller.setStage(mapa_nueva);
            controller.setmapa(4);
        }else if (t3.isSelected()) {
            controller.setmapa(3);
        }else{
            controller.setmapa(2);
        }
    }

    protected void setStage(Stage stage) {
        this.stage = stage;
    }
    protected void setMapa_nueva(Stage mapa_nueva) {
        this.mapa_nueva = mapa_nueva;
    }
    protected void setUnidades(Lista<UnidadProperty> unidades) {
        this.unidades = unidades;
    }
}
