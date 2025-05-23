package es.uah.matcomp.teoria.gui.mvc.javafx.conquista;

import es.uah.matcomp.teoria.gui.mvc.javafx.conquista.preguntas.Lista;
import es.uah.matcomp.teoria.gui.mvc.javafx.conquista.unidades.*;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.stage.Stage;

public class PersonajesCienciasController{
    private Lista<UnidadProperty> unidades;

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
    private CheckBox CB1;
    @FXML
    private CheckBox CB2;
    @FXML
    private CheckBox CB3;
    @FXML
    private CheckBox CB4;
    @FXML
    private CheckBox CB5;

    @FXML
    private Stage stage;

    @FXML
    protected void selecPersonaje1(){
        if (CB1.isSelected()){
            if(CB2.isSelected() && CB3.isSelected() || CB2.isSelected() && CB4.isSelected() || CB2.isSelected() && CB5.isSelected() || CB3.isSelected() && CB4.isSelected() || CB3.isSelected() && CB5.isSelected() || CB4.isSelected() && CB5.isSelected()){
               CB1.setSelected(false);
            }else{
                unidades.add(new UnidadProperty(new Quimico("Químico1", true)) );
            }
        }else{
            unidades.delete(new UnidadProperty(new Quimico("Químico1", true)));
        }
    }

    @FXML
    protected void selecPersonaje2(){
        if (CB2.isSelected()){
            if(CB1.isSelected() && CB3.isSelected() ||CB1.isSelected() && CB4.isSelected() ||CB1.isSelected() && CB5.isSelected() || CB3.isSelected() && CB4.isSelected() || CB3.isSelected() && CB5.isSelected() || CB4.isSelected() && CB5.isSelected()){
                CB2.setSelected(false);
            }else{
                unidades.add(new UnidadProperty(new Biologo("Biologo1", true)) );
            }
        }else{
            unidades.delete(new UnidadProperty(new Biologo("Biologo1", true)));
        }
    }

    @FXML
    protected void selecPersonaje3(){
        if (CB3.isSelected()){
            if(CB1.isSelected() && CB2.isSelected() ||CB1.isSelected() && CB4.isSelected() ||CB1.isSelected() && CB5.isSelected() || CB2.isSelected() && CB4.isSelected() || CB2.isSelected() && CB5.isSelected() || CB4.isSelected() && CB5.isSelected()){
                CB3.setSelected(false);
            }else{
                unidades.add(new UnidadProperty(new Ingeniero("Ingeniero1", true)) );
            }
        }else{
            unidades.delete(new UnidadProperty(new Ingeniero("Ingeniero1", true)));
        }
    }

    @FXML
    protected void selecPersonaje4(){
        if (CB4.isSelected()){
            if(CB1.isSelected() && CB2.isSelected() ||CB1.isSelected() && CB3.isSelected() ||CB1.isSelected() && CB5.isSelected() || CB2.isSelected() && CB3.isSelected() || CB3.isSelected() && CB5.isSelected()){
                CB4.setSelected(false);
            }else{
                unidades.add(new UnidadProperty(new Matematico("Matemático1", true)));
            }
        }else{
            unidades.delete(new UnidadProperty(new Matematico("Matemático1", true)));
        }
    }

    @FXML
    protected void selecPersonaje5(){
        if (CB5.isSelected()){
            if(CB1.isSelected() && CB2.isSelected() ||CB1.isSelected() && CB3.isSelected() ||CB1.isSelected() && CB4.isSelected() || CB2.isSelected() && CB3.isSelected() || CB2.isSelected() && CB4.isSelected() || CB3.isSelected() && CB4.isSelected()){
                CB5.setSelected(false);
            }else{
                unidades.add(new UnidadProperty(new Medico("Médico1", true)));
            }
        }else{
            unidades.delete(new UnidadProperty(new Medico("Médico1", true)));
        }
    }

    @FXML
    protected void Aceptar(){
        FXMLLoader FL = new FXMLLoader(getClass().getResource("/fxml/PartidaNueva-view.fxml"));
        PartidaNuevaController controller = FL.getController();
        controller.setUnidades(unidades);
        stage.close();
    }

    @FXML
    protected void onQuimico(){
        label1.setText("HP: 100-150 \n Ataque: 32-48 \n Defensa: 10-15 \n Rango movimiento: 6-9 \n Rango ataque: 6 ");
    }
    @FXML
    protected void onBiologo(){
        label2.setText("HP: 200-300 \n Ataque: 40-60 \n Defensa: 24-36 \n Rango movimiento: 8-12 \n Rango ataque: 2 ");
    }
    @FXML
    protected void onIngeniero(){
        label3.setText("HP: 150-225 \n Ataque: 30-45 \n Defensa: 18-27 \n Rango movimiento: 8-12 \n Rango ataque: 3 ");
    }
    @FXML
    protected void onMatematico(){
        label4.setText("HP: 90-135 \n Ataque: 44-66 \n Defensa: 10-15 \n Rango movimiento: 12-18 \n Rango ataque: 1 ");
    }
    @FXML
    protected void onMedico(){
        label5.setText("HP: 160-240 \n Ataque: 28-42 \n Defensa: 16-24 \n Rango movimiento: 6-9 \n Rango ataque: 4 ");
    }

    @FXML
    protected void offQuimico(){
        label1.setText(null);
    }
    @FXML
    protected void offBiologo(){
        label2.setText(null);
    }
    @FXML
    protected void offIngeniero(){
        label3.setText(null);
    }
    @FXML
    protected void offMatematico(){
        label4.setText(null);
    }
    @FXML
    protected void offMedico(){
        label5.setText(null);
    }
}
