package es.uah.matcomp.teoria.gui.mvc.javafx.conquista;

import es.uah.matcomp.teoria.gui.mvc.javafx.conquista.preguntas.Lista;
import es.uah.matcomp.teoria.gui.mvc.javafx.conquista.unidades.*;
import javafx.fxml.FXML;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.stage.Stage;

public class PersonajesLetrasController{
    Lista<UnidadProperty> unidades;
    private PartidaNuevaController partidaNuevaController;

    @FXML
    private Label label1;
    @FXML
    private Label label2;
    @FXML
    private Label label3;
    @FXML
    private Label label4;
    @FXML
    private Label label5;

    @FXML
    private CheckBox LB1;
    @FXML
    private CheckBox LB2;
    @FXML
    private CheckBox LB3;
    @FXML
    private CheckBox LB4;
    @FXML
    private CheckBox LB5;

    @FXML
    private Stage stage;

    @FXML
    protected void selecPersonaje1(){
        if (LB1.isSelected()){
            if(LB2.isSelected() && LB3.isSelected() || LB2.isSelected() && LB4.isSelected() || LB2.isSelected() && LB5.isSelected() || LB3.isSelected() && LB4.isSelected() || LB3.isSelected() && LB5.isSelected() || LB4.isSelected() && LB5.isSelected()){
                LB1.setSelected(false);
            }else{
                unidades.add(new UnidadProperty(new Poeta("Poeta0", true)));
            }
        }else{
            unidades.delete(new UnidadProperty(new Poeta("Poeta0", true)));
        }
    }

    @FXML
    protected void selecPersonaje2(){
        if (LB2.isSelected()){
            if(LB1.isSelected() && LB3.isSelected() ||LB1.isSelected() && LB4.isSelected() ||LB1.isSelected() && LB5.isSelected() || LB3.isSelected() && LB4.isSelected() || LB3.isSelected() && LB5.isSelected() || LB4.isSelected() && LB5.isSelected()){
                LB2.setSelected(false);
            }else{
                unidades.add(new UnidadProperty(new Filologo("Filólogo0", true)));
            }
        }else{
            unidades.delete(new UnidadProperty(new Filologo("Filólogo0", true)));
        }
    }

    @FXML
    protected void selecPersonaje3(){
        if (LB3.isSelected()){
            if(LB1.isSelected() && LB2.isSelected() ||LB1.isSelected() && LB4.isSelected() ||LB1.isSelected() && LB5.isSelected() || LB2.isSelected() && LB4.isSelected() || LB2.isSelected() && LB5.isSelected() || LB4.isSelected() && LB5.isSelected()){
                LB3.setSelected(false);
            }else{
                unidades.add(new UnidadProperty(new Historiador("Historiador0", true)));
            }
        }else{
            unidades.delete(new UnidadProperty(new Historiador("Historiador0", true)));
        }
    }

    @FXML
    protected void selecPersonaje4(){
        if (LB4.isSelected()){
            if(LB1.isSelected() && LB2.isSelected() ||LB1.isSelected() && LB3.isSelected() ||LB1.isSelected() && LB5.isSelected() || LB2.isSelected() && LB3.isSelected() || LB3.isSelected() && LB5.isSelected()){
                LB4.setSelected(false);
            }else{
                unidades.add(new UnidadProperty(new Abogado("Abogado0", true)));
            }
        }else{
            unidades.delete(new UnidadProperty(new Abogado("Abogado0", true)));
        }
    }

    @FXML
    protected void selecPersonaje5(){
        if (LB5.isSelected()){
            if(LB1.isSelected() && LB2.isSelected() ||LB1.isSelected() && LB3.isSelected() ||LB1.isSelected() && LB4.isSelected() || LB2.isSelected() && LB3.isSelected() || LB2.isSelected() && LB4.isSelected() || LB3.isSelected() && LB4.isSelected()){
                LB5.setSelected(false);
            }else{
                unidades.add(new UnidadProperty(new Maestro("Maestro0", true)));
            }
        }else{
            unidades.delete(new UnidadProperty(new Maestro("Maestro0", true)));
        }
    }

    @FXML
    protected void Aceptar(){
        partidaNuevaController.setUnidades(unidades);
        stage.close();
    }

    @FXML
    protected void onPoeta(){
        label1.setText("HP: 90-135 \n Ataque: 40-60 \n Defensa: 10-15 \n Rango movimiento: 10-15 \n Rango ataque: 2 ");
    }
    @FXML
    protected void onFilologo(){
        label2.setText("HP: 200-300 \n Ataque: 30-45 \n Defensa: 26-39 \n Rango movimiento: 8-12 \n Rango ataque: 4 ");
    }
    @FXML
    protected void onHistoriador(){
        label3.setText("HP: 160-240 \n Ataque: 28-42 \n Defensa: 16-24 \n Rango movimiento: 6-9 \n Rango ataque: 4 ");
    }
    @FXML
    protected void onAbogado(){
        label4.setText("HP: 150-225 \n Ataque: 30-45 \n Defensa: 18-27 \n Rango movimiento: 8-12 \n Rango ataque: 3 ");
    }
    @FXML
    protected void onMaestro(){
        label5.setText("HP: 100-150 \n Ataque: 30-45 \n Defensa: 10-15 \n Rango movimiento: 4-6 \n Rango ataque: 7 ");
    }

    @FXML
    protected void offPoeta(){
        label1.setText(null);
    }
    @FXML
    protected void offFilologo(){
        label2.setText(null);
    }
    @FXML
    protected void offHistoriador(){
        label3.setText(null);
    }
    @FXML
    protected void offAbogado(){
        label4.setText(null);
    }
    @FXML
    protected void offMaestro(){
        label5.setText(null);
    }

    protected void setUnidades(Lista<UnidadProperty> unidades){
        this.unidades = unidades;
    }
    protected void setStage(Stage stage){
        this.stage = stage;
    }
    protected void setPartidaNuevaController(PartidaNuevaController partidaNuevaController){
        this.partidaNuevaController = partidaNuevaController;
    }
}
