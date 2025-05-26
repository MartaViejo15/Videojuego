package es.uah.matcomp.teoria.gui.mvc.javafx.conquista;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import es.uah.matcomp.teoria.gui.mvc.javafx.conquista.ClasesAuxiliaresParaSerializacion.PartidaASerializar;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;

public class CargarPartidaController{
    @FXML
    private CheckBox checkBox1;
    @FXML
    private CheckBox checkBox2;
    @FXML
    private CheckBox checkBox3;
    @FXML
    private CheckBox checkBox4;

    @FXML
    private Stage stageCargar;

    @FXML
    protected void cargarPartida1(){
        if(checkBox1.isSelected()) {
            if (checkBox2.isSelected() || checkBox3.isSelected() || checkBox4.isSelected()) {
                checkBox1.setSelected(false);
            }
        }
    }

    @FXML
    protected void cargarPartida2(){
        if(checkBox2.isSelected()) {
            if (checkBox1.isSelected() || checkBox3.isSelected() || checkBox4.isSelected()) {
                checkBox2.setSelected(false);
            }
        }
    }

    @FXML
    protected void cargarPartida3(){
        if(checkBox3.isSelected()) {
            if (checkBox1.isSelected() || checkBox2.isSelected() || checkBox4.isSelected()) {
                checkBox3.setSelected(false);
            }
        }
    }

    @FXML
    protected void cargarPartida4(){
        if(checkBox4.isSelected()) {
            if (checkBox1.isSelected() || checkBox2.isSelected() || checkBox3.isSelected()) {
                checkBox4.setSelected(false);
            }
        }
    }


    @FXML
    protected void eliminarPartida1(){
        String Partida1 = "src/main/resources/es/uah/matcomp/teoria/gui/mvc/javafx/conquista/Partida1.json";

        try (FileWriter fw = new FileWriter(Partida1)) {
            fw.write("");  // Sobrescribe el contenido con vacío
            System.out.println("Partida 1 borrada.");
        } catch (IOException e) {
            e.printStackTrace();

        }
    }

    @FXML
    protected void eliminarPartida2(){
        String Partida2 = "src/main/resources/es/uah/matcomp/teoria/gui/mvc/javafx/conquista/Partida2.json";

        try (FileWriter fw = new FileWriter(Partida2)) {
            fw.write("");  // Sobrescribe el contenido con vacío
            System.out.println("Partida 2 borrada.");
        } catch (IOException e) {
            e.printStackTrace();

        }
    }

    @FXML
    protected void eliminarPartida3(){
        String Partida3 = "src/main/resources/es/uah/matcomp/teoria/gui/mvc/javafx/conquista/Partida3.json";

        try (FileWriter fw = new FileWriter(Partida3)) {
            fw.write("");  // Sobrescribe el contenido con vacío
            System.out.println("Partida 3 borrada.");
        } catch (IOException e) {
            e.printStackTrace();

        }
    }

    @FXML
    protected void eliminarPartida4(){
        String Partida4 = "src/main/resources/es/uah/matcomp/teoria/gui/mvc/javafx/conquista/Partida4.json";

        try (FileWriter fw = new FileWriter(Partida4)) {
            fw.write("");  // Pone el contenido como vacío
            System.out.println("Partida 4 borrada.");
        } catch (IOException e) {
            e.printStackTrace();

        }
    }

    @FXML
    protected void Aceptar(){
        String nombreArchivo = "";
        if(checkBox1.isSelected()) {
            nombreArchivo = "Partida1.json";
        }else if(checkBox2.isSelected()) {
            nombreArchivo = "Partida2.json";
        }else if(checkBox3.isSelected()) {
            nombreArchivo = "Partida3.json";
        }else if(checkBox4.isSelected()) {
            nombreArchivo = "Partida4.json";
        }
        try{
            ObjectMapper mapper = new ObjectMapper();
            PartidaASerializar partida = mapper.readValue(nombreArchivo, PartidaASerializar.class);
            FXMLLoader loader = new FXMLLoader(getClass().getResource("Patida-view.fxml"));
            Parent root = loader.load();
            Stage stage = new Stage();
            stage.setTitle("Partida");
            stage.setScene(new Scene(root));
            PartidaController partidaController = loader.getController();
            partidaController.cargarMapa(partida);
            partidaController.setStage(stage);
            //stage.getIcons().add(new Image(getClass().getResourceAsStream("/Imagen/Logo.png")));
            stage.show();
            stageCargar.close();
        }catch(JsonProcessingException e){
            throw new RuntimeException(e);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    protected void setStage(Stage stage){
        this.stageCargar = stage;
    }
}
