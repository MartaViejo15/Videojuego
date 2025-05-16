package es.uah.matcomp.teoria.gui.mvc.javafx.conquista.preguntas;

public class Preguntas {
    private Lista<Pregunta> preguntas;
    private int id;

    public Preguntas(int id) {
        this.preguntas = new Lista<>();
        this.id = id;
    }

    public Lista<Pregunta> getPreguntas() {
        return preguntas;
    }
    public void cargarPreguntas() {
        if(id==1){
            generarPreguntasQuimico();
        } else if (id==2) {
            generarPreguntasBiologo();
        }
    }
    private void generarPreguntasQuimico() {
        Lista<String> res1= new Lista<>();
        Lista<String> res2= new Lista<>();
        Lista<String> res3= new Lista<>();
        Lista<String> res4= new Lista<>();
        Lista<String> res5= new Lista<>();
        Lista<String> res6= new Lista<>();
        Lista<String> res7= new Lista<>();
        Lista<String> res8= new Lista<>();
        Lista<String> res9= new Lista<>();
        Lista<String> res10= new Lista<>();
        res1.add("Sodio");
        res2.add("H2O");
        res3.add("Oxígeno");
        res4.add("Grafito");
        res4.add("Carbono");
        res5.add("Fusión");
        res6.add("Nitrógeno");
        res7.add("Oro");
        res7.add("Au");
        res8.add("Tabla periódica");
        res9.add("pH");
        res10.add("CO2");
        res10.add("Dióxido de carbono");
        this.preguntas.add(new Pregunta("¿A qué elemento corresponde el símbolo Na?",res1));
        this.preguntas.add(new Pregunta("¿Cuál es el símbolo químico del agua?",res2));
        this.preguntas.add(new Pregunta("¿Principalmente, qué gas necesitamos para respirar?",res3));
        this.preguntas.add(new Pregunta("¿De qué está compuesta la mina del lápiz?",res4));
        this.preguntas.add(new Pregunta("¿Cómo se llama el proceso en el que una sustancia cambia de estado sólido a  líquido?",res5));
        this.preguntas.add(new Pregunta("¿Cuál es el gas más abundante de la atmósfera terrestre?",res6));
        this.preguntas.add(new Pregunta("¿De qué elemento viene el nombre de la razón áurea?",res7));
        this.preguntas.add(new Pregunta("¿Qué nombre recibe la tabla que organiza los elementos químicos?",res8));
        this.preguntas.add(new Pregunta("¿Con qué se mide la acidez o basicidad de una sustancia?",res9));
        this.preguntas.add(new Pregunta("¿Cuál es el principal componente del aire que exhalamos?",res10));
    }
    private void generarPreguntasBiologo() {
        Lista<String> res1= new Lista<>();
        Lista<String> res2= new Lista<>();
        Lista<String> res3= new Lista<>();
        Lista<String> res4= new Lista<>();
        Lista<String> res5= new Lista<>();
        Lista<String> res6= new Lista<>();
        Lista<String> res7= new Lista<>();
        Lista<String> res8= new Lista<>();
        Lista<String> res9= new Lista<>();
        Lista<String> res10= new Lista<>();
        res1.add("ADN");
        res2.add("Mamíferos");
        res3.add("La estrella de mar");
        res3.add("Estrella de mar");
        res4.add("Fotosíntesis");
        res5.add("Virus");
        res6.add("Cerebelo");
        res7.add("Glóbulos blancos");
        res7.add("Leucocitos");
        res8.add("Ecología");
        res9.add("Estambre");
        res10.add("Calamar");
        res10.add("Pulpo");
        res10.add("Sepia");
        res10.add("Cefalópodo");
        this.preguntas.add(new Pregunta("¿Qué molécula contiene la información genética?",res1));
        this.preguntas.add(new Pregunta("¿Qué tipo de animales son los seres humanos?",res2));
        this.preguntas.add(new Pregunta("¿¿Qué animal tiene la capacidad de regenerar sus extremidades?",res3));
        this.preguntas.add(new Pregunta("¿Cómo se llama el proceso por el cuál las plantas obtienen su alimento?",res4));
        this.preguntas.add(new Pregunta("¿Qué organismo causa enfermedades como la gripe? ",res5));
        this.preguntas.add(new Pregunta("¿Qué parte del cerebro controla el equilibrio?",res6));
        this.preguntas.add(new Pregunta("¿Qué células se encargan de proteger el cuerpo frente a enfermedades?",res7));
        this.preguntas.add(new Pregunta("¿Cómo se llama la ciencia que estudia los ecosistemas?",res8));
        this.preguntas.add(new Pregunta("¿Qué parte de la flor produce el polen?",res9));
        this.preguntas.add(new Pregunta("¿Qué animal tiene 3 corazones?",res10));
    }
}
