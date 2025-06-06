package es.uah.matcomp.teoria.gui.mvc.javafx.conquista;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("PantallaPrincipal-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 1050, 600);
        stage.setTitle("Conquista");
        stage.setScene(scene);
        PantallaPrincipalController controller = fxmlLoader.getController();
        controller.setStagePrincipal(stage);
        //stage.getIcons().add(new Image(HelloApplication.class.getResourceAsStream("/Imagen/Logo.png")));

        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}