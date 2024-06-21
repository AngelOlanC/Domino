package Proyecto3.Vista.Centro;

import Proyecto3.Fichas.Ficha;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class CentroInicio extends JPanel {
    private JButton mezclar, repartir, mostrar;
    private JPanel panelBotones, panelFichas;
    private ArrayList<Ficha> fichasPorRepartir;
    public CentroInicio() {
        hazInterfazPanel();
    }

    public void hazInterfazPanel() {
        setLayout(new BorderLayout());
        setBounds(600, 320, 700, 400);

        add(panelFichas = new JPanel(new FlowLayout(FlowLayout.CENTER, 60, 20)));

        panelBotones = new JPanel(new FlowLayout(FlowLayout.CENTER, 20, 0));
        panelBotones.add(mezclar = new JButton("MEZCLAR"));
        panelBotones.add(repartir = new JButton("REPARTIR"));
        panelBotones.add(mostrar = new JButton("MOSTRAR"));
        add(panelBotones, BorderLayout.SOUTH);
    }

    public void actualizarPanel() {
        revalidate();
        repaint();
    }

    public JButton getMezclar() {
        return mezclar;
    }


    public JButton getRepartir() {
        return repartir;
    }


    public JButton getMostrar() {
        return mostrar;
    }


    public ArrayList<Ficha> getFichasPorRepartir() {
        return fichasPorRepartir;
    }

    public void setFichasPorRepartir(ArrayList<Ficha> fichasPorRepartir) {
        panelFichas.removeAll();
        this.fichasPorRepartir = fichasPorRepartir;
        for (Ficha f : fichasPorRepartir)
            panelFichas.add(f);
        panelFichas.revalidate();
        panelFichas.repaint();
    }

    public void sacarFicha(Ficha ficha) {
        panelFichas.remove(ficha);
        fichasPorRepartir.remove(ficha);
        panelFichas.revalidate();
        panelFichas.repaint();
        actualizarPanel();
    }
}