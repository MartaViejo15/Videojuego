package es.uah.matcomp.teoria.gui.mvc.javafx.conquista;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import javafx.event.ActionEvent;
import java.io.IOException;

public class PantallaPrincipalController {

    private Stage stagePrincipal;

    @FXML
    private void partidaNueva(ActionEvent event) {
        abrirVentanaYCerrarPP("PartidaNueva-view.fxml", "Partida nueva", event);
    }

    @FXML
    private void cargarPartida(ActionEvent event) {
        abrirVentanaYCerrarPP("CargarPartida-view.fxml", "CargarPartida", event);
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
            //stage.getIcons().add(new Image(getClass().getResourceAsStream("/Imagen/Conquista_logo.png")));
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
            //stage.getIcons().add(new Image(getClass().getResourceAsStream("/Imagen/Conquista_logo.png")));
            stage.show();
        } catch (IOException e){
            e.printStackTrace();
        }
    }

}