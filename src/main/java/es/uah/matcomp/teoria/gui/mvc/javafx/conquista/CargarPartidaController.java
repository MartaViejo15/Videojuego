package es.uah.matcomp.teoria.gui.mvc.javafx.conquista;

import com.google.gson.Gson;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

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
    private Stage stage;

    @FXML
    protected void cargarPartida1(){
        if(checkBox1.isSelected()) {
            if (checkBox1.isSelected() && checkBox2.isSelected() || checkBox1.isSelected() && checkBox3.isSelected() || checkBox1.isSelected() && checkBox4.isSelected()) {
                checkBox1.setSelected(false);
            } else {
                try (FileReader reader = new FileReader("Partida1.json")) {
                    Gson gson = new Gson();
                    PartidaController partida1 = gson.fromJson(reader, PartidaController.class);
                    System.out.println("La partida 1 ha cargado");
                } catch (IOException e) {
                    e.printStackTrace();
                    System.out.println("Error al leer el fichero");
                }
            }
        }
    }

    @FXML
    protected void cargarPartida2(){
        if(checkBox2.isSelected()) {
            if (checkBox2.isSelected() && checkBox1.isSelected() || checkBox2.isSelected() && checkBox3.isSelected() || checkBox2.isSelected() && checkBox4.isSelected()) {
                checkBox2.setSelected(false);
            } else {
                try (FileReader reader = new FileReader("Partida2.json")) {
                    Gson gson = new Gson();
                    PartidaController partida2 = gson.fromJson(reader, PartidaController.class);
                    System.out.println("La partida 2 ha cargado");
                } catch (IOException e) {
                    e.printStackTrace();
                    System.out.println("Error al leer el fichero");
                }
            }
        }
    }

    @FXML
    protected void cargarPartida3(){
        if(checkBox3.isSelected()) {
            if (checkBox3.isSelected() && checkBox1.isSelected() || checkBox3.isSelected() && checkBox2.isSelected() || checkBox3.isSelected() && checkBox4.isSelected()) {
                checkBox3.setSelected(false);
            } else {
                try (FileReader reader = new FileReader("Partida3.json")) {
                    Gson gson = new Gson();
                    PartidaController partida3 = gson.fromJson(reader, PartidaController.class);
                    System.out.println("La partida 3 ha cargado");
                } catch (IOException e) {
                    e.printStackTrace();
                    System.out.println("Error al leer el fichero");
                }
            }
        }
    }

    @FXML
    protected void cargarPartida4(){
        if(checkBox4.isSelected()) {
            if (checkBox4.isSelected() && checkBox1.isSelected() || checkBox4.isSelected() && checkBox2.isSelected() || checkBox4.isSelected() && checkBox3.isSelected()) {
                checkBox4.setSelected(false);
            } else {
                try (FileReader reader = new FileReader("Partida4.json")) {
                    Gson gson = new Gson();
                    PartidaController partida4 = gson.fromJson(reader, PartidaController.class);
                    System.out.println("La partida 4 ha cargado");
                } catch (IOException e) {
                    e.printStackTrace();
                    System.out.println("Error al leer el fichero");
                }
            }
        }
    }


    @FXML
    protected void eliminarPartida1(){
        String Partida1 = "Partida1.json";

        try (FileWriter fw = new FileWriter(Partida1)) {
            fw.write("");  // Sobrescribe el contenido con vacío
            System.out.println("Partida 1 borrada.");
        } catch (IOException e) {
            e.printStackTrace();

        }
    }

    @FXML
    protected void eliminarPartida2(){
        String Partida2 = "Partida2.json";

        try (FileWriter fw = new FileWriter(Partida2)) {
            fw.write("");  // Sobrescribe el contenido con vacío
            System.out.println("Partida 2 borrada.");
        } catch (IOException e) {
            e.printStackTrace();

        }
    }

    @FXML
    protected void eliminarPartida3(){
        String Partida3 = "Partida3.json";

        try (FileWriter fw = new FileWriter(Partida3)) {
            fw.write("");  // Sobrescribe el contenido con vacío
            System.out.println("Partida 3 borrada.");
        } catch (IOException e) {
            e.printStackTrace();

        }
    }

    @FXML
    protected void eliminarPartida4(){
        String Partida4 = "Partida4.json";

        try (FileWriter fw = new FileWriter(Partida4)) {
            fw.write("");  // Sobrescribe el contenido con vacío
            System.out.println("Partida 4 borrada.");
        } catch (IOException e) {
            e.printStackTrace();

        }
    }

    @FXML
    protected void Aceptar(){
        stage.close();
    }

    protected void setStage(Stage stage){
        this.stage = stage;
    }
}
