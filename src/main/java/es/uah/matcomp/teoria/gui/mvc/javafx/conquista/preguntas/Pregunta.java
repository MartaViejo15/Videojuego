package es.uah.matcomp.teoria.gui.mvc.javafx.conquista.preguntas;

public class Pregunta {
    private String pregunta;
    private Lista<String> respuestas;

    protected Pregunta(String pregunta, Lista<String> respuestas) {
        this.pregunta = pregunta;
        this.respuestas = respuestas;
    }
}
