package es.uah.matcomp.teoria.gui.mvc.javafx.conquista;

import es.uah.matcomp.teoria.gui.mvc.javafx.conquista.preguntas.Elemento;
import es.uah.matcomp.teoria.gui.mvc.javafx.conquista.preguntas.Lista;
import es.uah.matcomp.teoria.gui.mvc.javafx.conquista.preguntas.Pregunta;
import es.uah.matcomp.teoria.gui.mvc.javafx.conquista.preguntas.Preguntas;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.util.Random;

public class PreguntaController {
    private Stage stage;
    private String id;
    private Lista<String> respuestas;

    @FXML
    private Label pregunta;

    @FXML
    private TextField res;

    @FXML
    protected boolean aceptar() {
        Elemento<String> respuesta = respuestas.getPrimero();
        if (respuesta.getDato().equalsIgnoreCase(res.getText())) {
            return true;
        }else {
            while(respuesta.getSiguiente()!=null){
                if(respuesta.getSiguiente().getDato().equalsIgnoreCase(res.getText())){
                    return true;
                }
                respuesta = respuesta.getSiguiente();
            }
        }
        stage.close();
        return false;
    }

    public void initData() {
        Preguntas p = new Preguntas(id);
        p.cargarPreguntas();
        int r = new Random().nextInt(9);
        Elemento<Pregunta> pregunta = p.getPreguntas().getPrimero();
        for(int i = 0; i<r; i++){
            pregunta = pregunta.getSiguiente();
        }
        this.pregunta.setText(pregunta.getDato().getPregunta());
        this.respuestas = pregunta.getDato().getRespuestas();
    }

    protected void setStage(Stage stage) {
        this.stage = stage;
    }
    protected void setId(String id) {
        this.id = id;
    }
}
