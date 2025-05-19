package es.uah.matcomp.teoria.gui.mvc.javafx.conquista;

import es.uah.matcomp.teoria.gui.mvc.javafx.conquista.preguntas.Lista;
import es.uah.matcomp.teoria.gui.mvc.javafx.conquista.unidades.Unidad;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.CheckBox;
import javafx.stage.Stage;

public class PartidaNuevaController {
    private Stage stage;
    private Stage ciencias;
    private Stage letras;
    private Stage mapa_nueva;
    private Lista<Unidad> unidades;
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
        Stage s = mapa_nueva;
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("CrearMapa-view.fxml"));
        try{
            Scene scene = new Scene(fxmlLoader.load(), 1050, 600);
            s.setTitle("CrearMapa");
            s.setScene(scene);
            CrearMapaController controller = fxmlLoader.getController();
            controller.setstage(s);
            controller.setAnteriorStage(stage);
            s.show();
        }catch(Exception e){
            e.printStackTrace();
        }
        this.stage.close();
    }

    @FXML
    protected void selecFaccion1(){
        letra.setSelected(false);
        if(letras.isShowing()){
            unidades = new Lista<>();
            letras.close();
        }
        Stage s = ciencias;
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("PersonajesCiencias-view.fxml"));
        try{
            Scene scene = new Scene(fxmlLoader.load(), 1050, 600);
            s.setTitle("Elegir Personajes Ciencias");
            s.setScene(scene);
            PersonajesCienciasController controller = fxmlLoader.getController();
            s.show();
            ciencias = s;
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    @FXML
    protected void selecFaccion2(){
        ciencia.setSelected(false);
        if(ciencias.isShowing()){
            unidades = new Lista<>();
            ciencias.close();
        }
        Stage s = letras;
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("PersonajesLetras-view.fxml"));
        try{
            Scene scene = new Scene(fxmlLoader.load(), 1050, 600);
            s.setTitle("Elegir Personajes Letras");
            s.setScene(scene);
            PersonajesLetrasController controller = fxmlLoader.getController();
            s.show();
            letras = s;
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    @FXML
    protected void guardar(){
        stage.close();
        Stage s = new Stage();
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("Partida-view.fxml"));
        try{
            Scene scene = new Scene(fxmlLoader.load(), 1050, 600);
            s.setTitle("Partida");
            s.setScene(scene);
            PartidaController controller = fxmlLoader.getController();
            if(letra.isSelected()){
                controller.setFaccion("l");
            }else{
                controller.setFaccion("c");
            }
            controller.setMis_unidades(unidades);
            if(t4.isSelected()){
                controller.setStage(mapa_nueva);
            }
            s.show();
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    protected void setStage(Stage stage) {
        this.stage = stage;
    }
    protected void setMapa_nueva(Stage mapa_nueva) {
        this.mapa_nueva = mapa_nueva;
    }
    protected void setUnidades(Lista<Unidad> unidades) {
        this.unidades = unidades;
    }
}
