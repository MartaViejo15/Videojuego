module es.uah.matcomp.teoria.gui.mvc.javafx.conquista {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires org.kordamp.bootstrapfx.core;
    requires com.google.gson;
    requires org.apache.logging.log4j;
    requires com.fasterxml.jackson.databind;
    requires java.desktop;

    opens es.uah.matcomp.teoria.gui.mvc.javafx.conquista to javafx.fxml;
    exports es.uah.matcomp.teoria.gui.mvc.javafx.conquista;
    exports es.uah.matcomp.teoria.gui.mvc.javafx.conquista.preguntas;
    opens es.uah.matcomp.teoria.gui.mvc.javafx.conquista.preguntas to javafx.fxml, com.google.gson;

    exports es.uah.matcomp.teoria.gui.mvc.javafx.conquista.ClasesAuxiliaresParaSerializacion to com.fasterxml.jackson.databind;
    exports es.uah.matcomp.teoria.gui.mvc.javafx.conquista.tablero to com.fasterxml.jackson.databind;
    exports es.uah.matcomp.teoria.gui.mvc.javafx.conquista.inventario to com.fasterxml.jackson.databind;
    exports es.uah.matcomp.teoria.gui.mvc.javafx.conquista.unidades to com.fasterxml.jackson.databind;

    opens es.uah.matcomp.teoria.gui.mvc.javafx.conquista.tablero to com.google.gson;
    opens es.uah.matcomp.teoria.gui.mvc.javafx.conquista.ClasesAuxiliaresParaSerializacion to com.google.gson;
    opens es.uah.matcomp.teoria.gui.mvc.javafx.conquista.unidades to com.google.gson;
    opens es.uah.matcomp.teoria.gui.mvc.javafx.conquista.inventario to com.google.gson;
}