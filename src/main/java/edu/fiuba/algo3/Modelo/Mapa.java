package edu.fiuba.algo3.Modelo;

import edu.fiuba.algo3.Modelo.Casillas.Casilla;
import edu.fiuba.algo3.Modelo.Casillas.NadaOcupacion;
import edu.fiuba.algo3.Controlador.ManejarJson.DeserializadorJSON;

import java.util.List;

public class Mapa {
    private Casilla[][] mapa;
    private List<Casilla> camino;

    public void mapaTest() {
        DeserializadorJSON deserializadorJSON = new DeserializadorJSON();
        deserializadorJSON.extraerContenidoDeCadaCelda();
        List <Casilla>  listaDeCasillasJSON =  deserializadorJSON.obtenerListaCasillas();

        Casilla[][] matriz = new Casilla[18][10];

        for (int i = 0; i < 18; i++) {
            for (int j = 0; j < 10; j++) {
                String tipo = "";
                Casilla casilla = new Casilla(new NadaOcupacion(), new NadaOcupacion(),i,j,tipo);
                matriz[i][j] = casilla;
            }
        }

        this.mapa = matriz;
        this.camino = listaDeCasillasJSON;
    }

    //Este es el verdadero mapa de juego! el de arriba es solo para los test
    public void mapaReal(){
        DeserializadorJSON deserializadorJSON = new DeserializadorJSON();
        deserializadorJSON.extraerContenidoDeCadaCelda();
        List <Casilla>  listaDeCasillasJSON =  deserializadorJSON.obtenerListaCasillas();


        Casilla[][] matriz = new Casilla[18][10] ;

        for (int i = 0; i < 18; i++) {
            for (int j = 0; j < 10; j++) {
                String tipo = "";
                Casilla casilla = new Casilla(new NadaOcupacion(), new NadaOcupacion(),i,j,tipo);
                matriz[i][j] = casilla;
            }
        }
        for (Casilla casilla : listaDeCasillasJSON) {
            matriz[casilla.obtenerposicionEnX()][casilla.obtenerposicionEny()] = casilla;
        }

        this.mapa   = matriz;
        this.camino = listaDeCasillasJSON;
    }

    public Casilla siguienteCasilla(Gladiador unGladiador){
        return mapa[unGladiador.obtenerPosicionEnX()][unGladiador.obtenerPosicionEnY()];
    }
    public Casilla[][] obtenerMapa(){
        return mapa;
    }

    public List<Casilla> obtenereCamino(){return camino;}

}