package es.uah.matcomp.teoria.gui.mvc.javafx.conquista.preguntas;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PreguntaTest {

    @Test
    void getPregunta() {
        Lista<String> lista = new Lista<>();
        lista.add("si");
        Pregunta pregunta = new Pregunta("Te gustan los videojuegos", lista);
        pregunta.getPregunta();
    }

    @Test
    void getRespuestas() {
        Lista<String> lista = new Lista<>();
        lista.add("si");
        Pregunta pregunta = new Pregunta("¿Te gustan los videojuegos?", lista);
        pregunta.getRespuestas();
    }

    @Test
    void setPregunta() {
        Lista<String> lista = new Lista<>();
        lista.add("si");
        Pregunta pregunta = new Pregunta("¿Te gustan los videojuegos?", lista);
        pregunta.setPregunta("¿Te gustan los macarrones?");
    }

    @Test
    void setRespuestas() {
        Lista<String> lista = new Lista<>();
        lista.add("si");
        Lista<String> respuestas = new Lista<>();
        respuestas.add("no");
        Pregunta pregunta = new Pregunta("¿Te gustan los videojuegos?", lista);
        pregunta.setRespuestas(respuestas);
    }
}