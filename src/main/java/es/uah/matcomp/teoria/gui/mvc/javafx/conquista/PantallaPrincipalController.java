package es.uah.matcomp.teoria.gui.mvc.javafx.conquista;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import javafx.event.ActionEvent;

import java.io.File;
import java.io.IOException;

public class PantallaPrincipalController {

    private Stage stagePrincipal;

    @FXML
    private void partidaNueva(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("PartidaNueva-view.fxml"));
            Parent root = loader.load();
            Stage stage = new Stage();
            stage.setTitle("Partida nueva");
            stage.setScene(new Scene(root));
            PartidaNuevaController controller = loader.getController();
            controller.setStage(stage);
            //stage.getIcons().add(new Image(getClass().getResourceAsStream("/Imagen/Conquista_logo.png")));
            stage.show();
            stagePrincipal.close();
        } catch (IOException e){
            e.printStackTrace();
        }
    }

    @FXML
    private void cargarPartida(ActionEvent event) {
        String Partida1 = "src/main/resources/es/uah/matcomp/teoria/gui/mvc/javafx/conquista/Partida1.json";
        String Partida2 = "src/main/resources/es/uah/matcomp/teoria/gui/mvc/javafx/conquista/Partida2.json";
        String Partida3 = "src/main/resources/es/uah/matcomp/teoria/gui/mvc/javafx/conquista/Partida3.json";
        String Partida4 = "src/main/resources/es/uah/matcomp/teoria/gui/mvc/javafx/conquista/Partida4.json";

        File Archivo1 = new File(Partida1);
        File Archivo2 = new File(Partida2);
        File Archivo3 = new File(Partida3);
        File Archivo4 = new File(Partida4);
        if(!Archivo1.exists() && !Archivo2.exists() && !Archivo3.exists() && !Archivo4.exists()) {
            try {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("CargarPartidaError-view.fxml"));
                Parent root = loader.load();
                Stage stage = new Stage();
                stage.setTitle("No hay partidas inicializadas");
                stage.setScene(new Scene(root));
                CargarPartidaErrorController controller = loader.getController();
                controller.setStage(stage);
                //stage.getIcons().add(new Image(getClass().getResourceAsStream("/Imagen/Logo.png")));
                stage.show();
            } catch (IOException e){
                e.printStackTrace();
            }
        }else{
            abrirVentanaYCerrarPP("CargarPartida-view.fxml", "CargarPartida", event);
        }

    }

    @FXML
    private void ayuda(ActionEvent event) {
        abrirVentana("Ayuda-view.fxml", "Ayuda");
    }

    @FXML
    private void créditos(ActionEvent event) {
        abrirVentana("Créditos-view.fxml", "Créditos");
    }

    @FXML
    private void salir(ActionEvent event) {
        abrirVentana("Salir-view.fxml", "Salir");
        stagePrincipal.close();
    }

    private void abrirVentanaYCerrarPP(String fxml, String titulo, ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource(fxml));
            Parent root = loader.load();
            Stage stage = new Stage();
            stage.setTitle(titulo);
            stage.setScene(new Scene(root));
            CargarPartidaController controller = loader.getController();
            controller.setStage(stage);
            //stage.getIcons().add(new Image(getClass().getResourceAsStream("/Imagen/Logo.png")));
            stage.show();
            stagePrincipal.close();
        } catch (IOException e){
            e.printStackTrace();
        }
    }

    private void abrirVentana(String fxml, String titulo) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource(fxml));
            Parent root = loader.load();
            Stage stage = new Stage();
            stage.setTitle(titulo);
            stage.setScene(new Scene(root));
            //stage.getIcons().add(new Image(getClass().getResourceAsStream("/Imagen/Logo.png")));
            stage.show();
        } catch (IOException e){
            e.printStackTrace();
        }
    }

    protected void setStagePrincipal(Stage stagePrincipal) {
        this.stagePrincipal = stagePrincipal;
    }

}