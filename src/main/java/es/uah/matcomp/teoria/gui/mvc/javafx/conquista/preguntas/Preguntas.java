package es.uah.matcomp.teoria.gui.mvc.javafx.conquista.preguntas;

import java.util.Objects;

public class Preguntas {
    private Lista<Pregunta> preguntas;
    private String id;

    public Preguntas(String id) {
        this.preguntas = new Lista<>();
        this.id = id;
    }

    public Lista<Pregunta> getPreguntas() {
        return preguntas;
    }
    public void cargarPreguntas() {
        if(Objects.equals(id, "c1")){
            generarPreguntasQuimico();
        } else if (Objects.equals(id, "c2")) {
            generarPreguntasBiologo();
        } else if (Objects.equals(id, "c3")) {
            generarPreguntasIngeniero();
        } else if (Objects.equals(id, "c4")) {
            generarPreguntasMatemático();
        } else if (Objects.equals(id, "c5")) {
            generarPreguntasMédico();
        } else if (Objects.equals(id, "l1")) {
            generarPreguntasPoeta();
        } else if (Objects.equals(id, "l2")) {
            generarPreguntasFilólogo();
        } else if (Objects.equals(id, "l3")) {
            generarPreguntasHistoriador();
        } else if (Objects.equals(id, "l4")) {
            generarPreguntasAbogado();
        } else if (Objects.equals(id, "l5")) {
            generarPreguntasMaestro();
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
        this.preguntas.add(new Pregunta("¿Qué organismo causa enfermedades como la gripe?",res5));
        this.preguntas.add(new Pregunta("¿Qué parte del cerebro controla el equilibrio?",res6));
        this.preguntas.add(new Pregunta("¿Qué células se encargan de proteger el cuerpo frente a enfermedades?",res7));
        this.preguntas.add(new Pregunta("¿Cómo se llama la ciencia que estudia los ecosistemas?",res8));
        this.preguntas.add(new Pregunta("¿Qué parte de la flor produce el polen?",res9));
        this.preguntas.add(new Pregunta("¿Qué animal tiene 3 corazones?",res10));
    }
    private void generarPreguntasIngeniero() {
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
        res1.add("Procesador");
        res1.add("CPU");
        res2.add("Binario");
        res3.add("Python");
        res4.add("Error");
        res4.add("Fallo");
        res5.add("Inteligencia Artificial");
        res6.add("USB");
        res7.add(".exe");
        res7.add("exe");
        res8.add("Internet");
        res9.add("HTTP");
        res9.add("HTTPS");
        res10.add("Linux");
        this.preguntas.add(new Pregunta("¿Qué componente es considerado el “cerebro” de la computadora?",res1));
        this.preguntas.add(new Pregunta("¿Qué sistema numérico usa la computadora para procesar datos?",res2));
        this.preguntas.add(new Pregunta("¿Qué lenguaje de programación es conocido por su simplicidad y uso en ciencia de datos?",res3));
        this.preguntas.add(new Pregunta("¿Qué es un “bug” en programación?",res4));
        this.preguntas.add(new Pregunta("¿Qué significan las siglas IA?",res5));
        this.preguntas.add(new Pregunta("¿Cómo se conoce comúnmente al “Universal Serial Bus”?",res6));
        this.preguntas.add(new Pregunta("¿Qué extensión tienen los archivos ejecutables en Windows?",res7));
        this.preguntas.add(new Pregunta("¿Qué red conecta computadoras a nivel mundial?",res8));
        this.preguntas.add(new Pregunta("¿Qué protocolo se usa para navegar por páginas web?",res9));
        this.preguntas.add(new Pregunta("¿Qué sistema operativo está basado en Unix y es libre?",res10));
    }
    private void generarPreguntasMatemático(){
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
        res1.add("30");
        res2.add("3,1415");
        res2.add("3,1416");
        res3.add("Triángulo");
        res4.add("Primo");
        res5.add("0,75");
        res5.add("3/4");
        res6.add("16 cm²");
        res6.add("16");
        res7.add("90º");
        res7.add("90");
        res8.add("11");
        res9.add("Ecuación");
        res10.add("i");
        this.preguntas.add(new Pregunta("¿Cuánto es 5 × 6?",res1));
        this.preguntas.add(new Pregunta("¿Cuál es el número pi con cuatro decimales?",res2));
        this.preguntas.add(new Pregunta("¿Cómo se llama un polígono de tres lados?",res3));
        this.preguntas.add(new Pregunta("¿Qué número solo se divide por 1 y por sí mismo?",res4));
        this.preguntas.add(new Pregunta("¿Cuánto es ½ + ¼?",res5));
        this.preguntas.add(new Pregunta("¿Cuál es el área de un cuadrado con lados de 4 cm?",res6));
        this.preguntas.add(new Pregunta("¿Cuántos grados tiene un ángulo recto?",res7));
        this.preguntas.add(new Pregunta("¿Cuál es la raíz cuadrada de 121?",res8));
        this.preguntas.add(new Pregunta("¿Qué es una igualdad con una incógnita que se debe resolver?",res9));
        this.preguntas.add(new Pregunta("¿Cuál es el valor de la raíz de -1?",res10));
    }
    private void generarPreguntasMédico(){
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
        res1.add("Corazón");
        res2.add("Riñón");
        res3.add("Glucosa");
        res4.add("Fémur");
        res5.add("Páncreas");
        res6.add("Dermatólogo");
        res7.add("Diabetes");
        res8.add("D");
        res8.add("Vitamina D");
        res9.add("Hepatitis");
        res10.add("Pulmones");
        this.preguntas.add(new Pregunta("¿Cuál es el principal órgano del sistema circulatorio?",res1));
        this.preguntas.add(new Pregunta("¿Qué órgano filtra los desechos de la sangre?",res2));
        this.preguntas.add(new Pregunta("¿Qué nombre recibe el azúcar en sangre?",res3));
        this.preguntas.add(new Pregunta("¿Cómo se llama el hueso más largo del cuerpo humano?",res4));
        this.preguntas.add(new Pregunta("¿Dónde se produce la insulina?",res5));
        this.preguntas.add(new Pregunta("¿Qué especialista trata las enfermedades de la piel?",res6));
        this.preguntas.add(new Pregunta("¿Qué enfermedad se asocia con niveles altos de glucosa en sangre?",res7));
        this.preguntas.add(new Pregunta("¿Qué vitamina se obtiene principalmente del sol?",res8));
        this.preguntas.add(new Pregunta("¿Cómo se llama la inflamación del hígado?",res9));
        this.preguntas.add(new Pregunta("¿Qué órgano se ve afectado por el asma?",res10));
    }
    private void generarPreguntasPoeta(){
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
        res1.add("Poema");
        res2.add("Rima");
        res2.add("Aliteración");
        res3.add("Figura literaria");
        res3.add("Recurso literario");
        res4.add("García Lorca");
        res4.add("Federico García Lorca");
        res4.add("Lorca");
        res5.add("Antonio Machado");
        res5.add("Machado");
        res6.add("Oda");
        res7.add("Alejandrino");
        res8.add("Sinalefa");
        res9.add("Sin métrica");
        res9.add("Sin rima");
        res10.add("Romance");
        this.preguntas.add(new Pregunta("¿Qué tipo de texto es un soneto?",res1));
        this.preguntas.add(new Pregunta("¿Cómo se llama la repetición de sonidos en un poema?",res2));
        this.preguntas.add(new Pregunta("¿Qué es una metáfora?",res3));
        this.preguntas.add(new Pregunta("¿Quién escribió “Romancero Gitano”?",res4));
        this.preguntas.add(new Pregunta("¿Qué poeta escribió “Soledades”?",res5));
        this.preguntas.add(new Pregunta("¿Cómo se llama un poema que ensalza a algo o a alguien?",res6));
        this.preguntas.add(new Pregunta("¿Cómo se llama un verso de catorce sílabas?",res7));
        this.preguntas.add(new Pregunta("¿Cómo se llama a la unión en una única sílaba de dos o más vocales contiguas pertenecientes a palabras distintas?",res8));
        this.preguntas.add(new Pregunta("¿Qué es un verso libre?",res9));
        this.preguntas.add(new Pregunta("¿Cómo se llama una combinación métrica caracterizada por sus versos octosílabos y rima en los versos pares, con los impares libres?",res10));
    }
    private void generarPreguntasFilólogo(){
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
        res1.add("Lengua y literatura");
        res1.add("Lengua");
        res1.add("Literatura");
        res2.add("Etimología");
        res3.add("Cervantes");
        res3.add("Miguel de Cervantes");
        res3.add("Miguel de Cervantes Saavedra");
        res4.add("Latín");
        res5.add("Lexema");
        res6.add("Fernando de Rojas");
        res7.add("Latín");
        res8.add("Fonética");
        res9.add("Clásica");
        res9.add("Filología clásica");
        res10.add("El Cantar de mio Cid");
        res10.add("El Cantar del mio Cid");
        res10.add("El Cid");
        res10.add("El Mio Cid");
        this.preguntas.add(new Pregunta("¿Qué estudia la filología?",res1));
        this.preguntas.add(new Pregunta("¿Qué rama estudia el origen de las palabras?",res2));
        this.preguntas.add(new Pregunta("¿Qué autor escribió “El Quijote”?",res3));
        this.preguntas.add(new Pregunta("¿Qué lengua dio origen al español?",res4));
        this.preguntas.add(new Pregunta("¿Cómo se llama a la raíz de una palabra?",res5));
        this.preguntas.add(new Pregunta("¿Qué autor usó la lengua española clásica en “La Celestina”?",res6));
        this.preguntas.add(new Pregunta("¿Qué lengua fue hablada en el Imperio romano?",res7));
        this.preguntas.add(new Pregunta("¿Qué palabra describe el cambio de sonido en una lengua?",res8));
        this.preguntas.add(new Pregunta("¿Qué tipo de filología estudia textos antiguos?",res9));
        this.preguntas.add(new Pregunta("¿Qué obra inicia la literatura española?",res10));
    }
    private void generarPreguntasHistoriador(){
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
        res1.add("1453");
        res2.add("Primera Guerra Mundial");
        res3.add("1492");
        res4.add("1492");
        res5.add("Romano");
        res5.add("Imperio Romano");
        res6.add("1789");
        res7.add("Pompeya");
        res8.add("Sistema medieval");
        res9.add("EEUU");
        res9.add("Estados Unidos");
        res10.add("Militar francés");
        this.preguntas.add(new Pregunta("¿En qué año cayó Constantinopla?",res1));
        this.preguntas.add(new Pregunta("¿Qué guerra inició en 1914?",res2));
        this.preguntas.add(new Pregunta("¿En qué año se descubrió América?",res3));
        this.preguntas.add(new Pregunta("¿En qué año cayó el Reino nazarí de Granada?",res4));
        this.preguntas.add(new Pregunta("¿Qué imperio cayó en 476 d.C.?",res5));
        this.preguntas.add(new Pregunta("¿En qué año ocurrió la Revolución Francesa?",res6));
        this.preguntas.add(new Pregunta("¿Qué ciudad fue destruida por el Vesubio?",res7));
        this.preguntas.add(new Pregunta("¿Qué fue el feudalismo?",res8));
        this.preguntas.add(new Pregunta("¿Qué país usó armas nucleares en 1945?",res9));
        this.preguntas.add(new Pregunta("¿Quién fue Napoleón?",res10));
    }
    private void generarPreguntasAbogado(){
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
        res1.add("Penal");
        res2.add("Ley suprema");
        res3.add("Fiscal");
        res4.add("Civil");
        res5.add("Escritura");
        res6.add("Laboral");
        res7.add("Abogado defensor");
        res7.add("Abogado");
        res8.add("Demanda");
        res8.add("Denuncia");
        res9.add("Juez");
        res10.add("Legislativo");
        this.preguntas.add(new Pregunta("¿Qué rama regula los delitos?",res1));
        this.preguntas.add(new Pregunta("¿Qué es una constitución?",res2));
        this.preguntas.add(new Pregunta("¿Quién representa al Estado en un juicio penal?",res3));
        this.preguntas.add(new Pregunta("¿Qué tipo de derecho regula los contratos?",res4));
        this.preguntas.add(new Pregunta("¿Qué documento identifica una propiedad?",res5));
        this.preguntas.add(new Pregunta("¿Qué rama regula el trabajo?",res6));
        this.preguntas.add(new Pregunta("¿Qué profesional defiende a una persona acusada?",res7));
        this.preguntas.add(new Pregunta("¿Qué documento inicia un juicio?",res8));
        this.preguntas.add(new Pregunta("¿Qué persona dicta una sentencia?",res9));
        this.preguntas.add(new Pregunta("¿Qué poder del Estado crea las leyes?",res10));
    }
    private void generarPreguntasMaestro(){
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
        res1.add("Pedagogía");
        res2.add("16 años");
        res2.add("16");
        res3.add("Rúbrica");
        res4.add("Lengua");
        res4.add("Lectoescritura");
        res5.add("Comportamiento");
        res6.add("Aprendizaje");
        res6.add("Conocimientos");
        res7.add("Secundaria");
        res8.add("Diploma");
        res8.add("Título");
        res9.add("Virtual");
        res9.add("Online");
        res10.add("Ciencias naturales");
        res10.add("Naturales");
        this.preguntas.add(new Pregunta("¿Cómo se llama a la ciencia de la educación?",res1));
        this.preguntas.add(new Pregunta("¿Hasta qué edad es obligatoria la educación en España?",res2));
        this.preguntas.add(new Pregunta("¿Qué instrumento se utiliza para evaluar los trabajos del alumno?",res3));
        this.preguntas.add(new Pregunta("¿Qué área enseña leer y escribir?",res4));
        this.preguntas.add(new Pregunta("¿Qué se evalúa al revisar la conducta del alumno?",res5));
        this.preguntas.add(new Pregunta("¿Qué debe evaluar un examen?",res6));
        this.preguntas.add(new Pregunta("¿Qué ciclo educativo sigue a primaria?",res7));
        this.preguntas.add(new Pregunta("¿Qué documento oficial certifica estudios?",res8));
        this.preguntas.add(new Pregunta("¿Qué tipo de enseñanza se da a través de internet?",res9));
        this.preguntas.add(new Pregunta("¿Qué área fomenta el conocimiento del entorno?",res10));
    }
}
