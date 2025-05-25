package es.uah.matcomp.teoria.gui.mvc.javafx.conquista.preguntas;

public class Pregunta {
    private String pregunta;
    private Lista<String> respuestas;

    public Pregunta() {
        pregunta = "";
        respuestas = new Lista<>();
    }
    protected Pregunta(String pregunta, Lista<String> respuestas) {
        this.pregunta = pregunta;
        this.respuestas = respuestas;
    }

    public String getPregunta() {
        return pregunta;
    }
    public Lista<String> getRespuestas() {
        return respuestas;
    }
    public void setPregunta(String pregunta) {
        this.pregunta = pregunta;
    }
    public void setRespuestas(Lista<String> respuestas) {
        this.respuestas = respuestas;
    }
}
