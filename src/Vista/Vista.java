package Proyecto3.Vista;

import Proyecto3.Vista.Centro.CentroInicio;
import Proyecto3.Vista.Centro.CentroJuego;

import javax.swing.*;
import java.awt.*;

public class Vista extends JFrame {
    ZonaJugador[] zonasJugadores;
    CentroInicio panelInicio;
    CentroJuego panelJuego;
    JLabel labelJugadorEnTurno;

    public Vista() {
        super("Juego de domino");
        inicializarInterfaz();
    }

    private void inicializarInterfaz() {
        setLayout(null);
        getContentPane().setBackground(Color.white);
        setIconImage(new ImageIcon("Proyecto3/Imagenes/Icono.jpg").getImage());
        getContentPane().setBackground(Color.decode("#eceeed"));
        setResizable(false);
        setExtendedState(getExtendedState() | JFrame.MAXIMIZED_BOTH);
        setVisible(true);

        add(panelInicio = new CentroInicio());
        agregarZonasJugadores();

        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    private void agregarZonasJugadores() {
        zonasJugadores = new ZonaJugador[4];
        String[] colores = {"#e0ada8", "#92c37e", "#baa6e2", "#7ca9e8"};
        for (int i = 0; i < 4; i++) {
            zonasJugadores[i] = new ZonaJugador(i);
            zonasJugadores[i].getZonaFichas().setBackground(Color.decode(colores[i]));
        }
        zonasJugadores[0].setLocation(20, 20);
        zonasJugadores[1].setLocation(getWidth() - ZonaJugador.ANCHURA_ZONA - 40, 20);
        zonasJugadores[2].setLocation(getWidth() - ZonaJugador.ANCHURA_ZONA - 40, getHeight() - ZonaJugador.ALTURA_ZONA - 60);
        zonasJugadores[3].setLocation(20, getHeight() - ZonaJugador.ALTURA_ZONA - 60);
        for (int i = 0; i < 4; i++)
            add(zonasJugadores[i]);
        actualizarPantalla();
    }

    public void destruirPanelInicio() {
        remove(panelInicio);
        panelInicio = null;
        actualizarPantalla();
    }

    public void inicializarValoresJuego() {
        add(labelJugadorEnTurno = new JLabel());
        labelJugadorEnTurno.setFont(new Font("Monospaced", Font.PLAIN, 40));
        labelJugadorEnTurno.setLocation(700, 50);
        labelJugadorEnTurno.setSize(500, 50);

        add(panelJuego = new CentroJuego());
    }
    public void actualizarPantalla() {
        revalidate();
        repaint();
    }

    public void asignarTextoDeJugadorEnTurno(int jugadorEnTurno) {
        labelJugadorEnTurno.setText("Jugador en turno: " + jugadorEnTurno);
    }
    public ZonaJugador[] getZonasJugadores() {
        return zonasJugadores;
    }

    public CentroInicio getPanelInicio() {
        return panelInicio;
    }

    public CentroJuego getPanelJuego() {
        return panelJuego;
    }
}