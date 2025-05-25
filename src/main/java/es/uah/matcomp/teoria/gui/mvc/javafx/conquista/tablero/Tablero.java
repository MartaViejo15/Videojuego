package es.uah.matcomp.teoria.gui.mvc.javafx.conquista.tablero;

import es.uah.matcomp.teoria.gui.mvc.javafx.conquista.preguntas.Elemento;
import es.uah.matcomp.teoria.gui.mvc.javafx.conquista.preguntas.Lista;

import java.util.Map;
import java.util.HashMap;

public class Tablero {
    private Lista<Casilla> casillas;
    private Lista<Arista> aristas;

    public Tablero() {
        this.casillas = new Lista<>();
        this.aristas = new Lista<>();
    }

    public void addCasilla(int x, int y) {
        this.casillas.add(new Casilla(x, y));
    }
    public void addArista(int dif_mov, Casilla origen, Casilla destino) {
        Arista arista = new Arista(dif_mov, origen, destino);
        arista.getOrigen().getSalida().add(arista);
        arista.getDestino().getEntrada().add(arista);
        aristas.add(arista);
    }
    public void cambiarDif_mov(Casilla casilla, int dif_mov) {
        Elemento<Arista> aux = aristas.getPrimero();
        if(aux.getDato().getDestino() == casilla) {
            aux.getDato().setDificultadDeMovimiento(dif_mov);
        }
        while(aux.getSiguiente() != null) {
            if(aux.getSiguiente().getDato().getDestino() == casilla) {
                aux.getSiguiente().getDato().setDificultadDeMovimiento(dif_mov);
            }
            aux = aux.getSiguiente();
        }
    }

    public Map<Casilla,Camino> dijkstra(Casilla origen) {
        Map<Casilla, Integer> distancias = new HashMap<>();
        Cola<Casilla> colaPendientes = new Cola<>();
        Map<Casilla, Casilla> casillasAnteriores = new HashMap<>();

        this.dijkstra_init(origen,distancias,colaPendientes);
        this.dijkstra_calcula(distancias,colaPendientes,casillasAnteriores);
        return this.dijkstra_procesaResultados(distancias,casillasAnteriores);
    }
    protected void dijkstra_init(Casilla origen, Map<Casilla, Integer> distancias, Cola<Casilla> colaPendientes){
        Elemento<Casilla> aux = casillas.getPrimero();
        while(aux.getDato() != null){
            distancias.put(aux.getDato(), Integer.MAX_VALUE);
            aux = aux.getSiguiente();
        }
        distancias.put(origen, 0);
        colaPendientes.enqueue(origen);
    }
    protected void dijkstra_calcula(Map<Casilla, Integer> distancias, Cola<Casilla> colaPendientes, Map<Casilla, Casilla> casillasAnteriores){
        while (colaPendientes.getLista().getNumElementos() != 0) {
            Casilla casillaActual = colaPendientes.dequeue();
            Elemento<Arista> aux = casillaActual.getSalida().getPrimero();
            while(aux.getDato() != null){
                Casilla casillaVecino = aux.getDato().getDestino();
                Integer nuevoDistancia = distancias.get(casillaActual) + aux.getDato().getDificultadDeMovimiento();
                if(nuevoDistancia < distancias.get(casillaVecino)){
                    distancias.put(casillaActual, nuevoDistancia);
                    casillasAnteriores.put(casillaVecino, casillaActual);
                    colaPendientes.enqueue(casillaVecino);
                }
                aux = aux.getSiguiente();
            }
        }
    }
    protected Map<Casilla,Camino>  dijkstra_procesaResultados(Map<Casilla, Integer> distancias, Map<Casilla, Casilla> casillasAnteriores){
        Map<Casilla,Camino> caminos = new HashMap<>();

        for (Casilla verticeDestino : casillasAnteriores.keySet()) {
            Lista<Casilla> caminoCalculado = new Lista<>();
            Casilla aux = verticeDestino;
            while (aux != null) {
                caminoCalculado.add(aux);
                aux = casillasAnteriores.get(aux);
            }
            caminoCalculado = caminoCalculado.reverse();
            caminos.put(verticeDestino,new Camino(caminoCalculado,distancias.get(verticeDestino)));
        }
        return caminos;
    }

    public Lista<Casilla> getCasillasAlcanzable(Casilla origen, int anchura) {
        Lista<Casilla> res = new Lista<>();
        Map<Casilla,Camino> caminos = dijkstra(origen);
        for (Casilla casilla : caminos.keySet()) {
            if(caminos.get(casilla).getCoste() <= anchura){
                res.add(casilla);
            }
        }
        return res;
    }

    /* Mal.
    public Lista<Casilla> BusquedaDeAnchura(Casilla origen, int anchura){
        Lista<Casilla> res = new Lista<>();
        Lista<Arista> AristaPorVisitar = origen.getSalida();
        res.add(origen);
        sigue(AristaPorVisitar, res, anchura);
        return res;
    }
    private void sigue(Lista<Arista> AristaPorVisitar, Lista<Casilla> res, int anchura) {
        int nuevaAnchura = anchura - AristaPorVisitar.getPrimero().getDato().getDificultadDeMovimiento();
        if(nuevaAnchura >= 0){
            res.add(AristaPorVisitar.getPrimero().getDato().getDestino());
            Elemento<Arista> aux = AristaPorVisitar.getPrimero().getDato().getDestino().getSalida().getPrimero();
            while(aux.getDato() != null) {
                if(res.buscar(aux.getDato().getDestino()) == null){
                    AristaPorVisitar.add(aux.getDato());
                }
                aux = aux.getSiguiente();
            }
            AristaPorVisitar.delete(AristaPorVisitar.getPrimero().getDato());
            sigue(AristaPorVisitar, res, nuevaAnchura); //Falla aquí.
        }else {
            AristaPorVisitar.delete(AristaPorVisitar.getPrimero().getDato());
            if (AristaPorVisitar.getNumElementos() != 0){
                sigue(AristaPorVisitar, res, anchura);
            }
        }
    }*/

    public Casilla getCasilla(int x, int y) {
        Elemento<Casilla> aux = casillas.getPrimero();
        if(aux.getDato().getX() == x && aux.getDato().getY() == y) {
            return aux.getDato();
        }
        while (aux.getSiguiente() != null) {
            if(aux.getSiguiente().getDato().getX() == x && aux.getSiguiente().getDato().getY() == y) {
                return aux.getSiguiente().getDato();
            }
            aux = aux.getSiguiente();
        }
        return null;
    }

    public Lista<Casilla> getCasillas() {
        return casillas;
    }
    public Lista<Arista> getAristas() {
        return aristas;
    }
    public void setCasillas(Lista<Casilla> casillas) {
        this.casillas = casillas;
    }
    public void setAristas(Lista<Arista> aristas) {
        this.aristas = aristas;
    }
}
