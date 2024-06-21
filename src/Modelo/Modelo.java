package Proyecto3.Modelo;

import Proyecto3.Fichas.Ficha;

import java.util.ArrayList;

public class Modelo {
    private ArrayList<Ficha>[] fichasJugadores;
    public Modelo() {
        fichasJugadores = new ArrayList[4];
        for (int i = 0; i < 4; i++)
            fichasJugadores[i] = new ArrayList<>();
    }

    public int calcularPuntos(int jugador) {
        int puntos = 0;
        for (Ficha ficha : fichasJugadores[jugador])
            puntos += ficha.getValor1() + ficha.getValor2();
        return puntos;
    }

    public ArrayList<Ficha>[] getFichasJugadores() {
        return fichasJugadores;
    }
}
