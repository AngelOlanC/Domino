package Proyecto3.Vista;

import Proyecto3.Fichas.Ficha;

import javax.swing.*;
import java.awt.*;

public class ZonaJugador extends JPanel {
    public static int ANCHURA_ZONA = 400, ALTURA_ZONA = 300;
    private JPanel zonaFichas;
    private JButton botonPasar;
    public ZonaJugador(int numeroDeJugador) {
        super();
        setLayout(new BorderLayout());

        add(botonPasar = new JButton("PASAR"), BorderLayout.NORTH);
        botonPasar.setEnabled(false);
        add(zonaFichas = new JPanel(new FlowLayout(FlowLayout.CENTER, 60, 20)));
        JLabel jugador = new JLabel("Jugador " + (numeroDeJugador + 1), JLabel.CENTER);
        jugador.setFont(new Font("Monospaced", Font.PLAIN, 20));
        add(jugador, BorderLayout.SOUTH);
        setSize(ANCHURA_ZONA, ALTURA_ZONA);
        setVisible(true);
    }

    public void agregarFicha(Ficha ficha) {
        zonaFichas.add(ficha);
        revalidate();
        repaint();
    }

    public void removerFicha(Ficha ficha) {
        zonaFichas.remove(ficha);
        revalidate();
        repaint();
    }

    public JButton getBotonPasar() {
        return botonPasar;
    }

    public JPanel getZonaFichas() {
        return zonaFichas;
    }
}
