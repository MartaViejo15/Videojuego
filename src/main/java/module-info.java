module es.uah.matcomp.teoria.gui.mvc.javafx.conquista {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires org.kordamp.bootstrapfx.core;
    requires java.desktop;
    requires com.google.gson;
    requires org.apache.logging.log4j;

    opens es.uah.matcomp.teoria.gui.mvc.javafx.conquista to javafx.fxml;
    exports es.uah.matcomp.teoria.gui.mvc.javafx.conquista;
    exports es.uah.matcomp.teoria.gui.mvc.javafx.conquista.preguntas;
    opens es.uah.matcomp.teoria.gui.mvc.javafx.conquista.preguntas to javafx.fxml;
}