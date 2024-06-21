package Proyecto3.Vista.Centro;

import Proyecto3.Fichas.Ficha;
import Proyecto3.Utilidad.RotarImagenes;
import Proyecto3.Utilidad.Rutinas;
import Proyecto3.Vista.ZonaJugador;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class CentroJuego extends JPanel {
    public static int IZQUIERDA = 0, DERECHA = 1;
    int[] ultima_x_medio = new int[2], ultima_y_medio = new int[2];
    public CentroJuego() {
        super();
        setLayout(null);
        setOpaque(true);
        setBackground(Color.decode("#a0e8c8"));
        setBounds(-500, ZonaJugador.ALTURA_ZONA + 50, 3000, 360);
    }

    public void mostrarPrimerFicha(Ficha ficha) {
        ficha.setEnabled(false);
        final int x = 1425, y = getHeight() / 2 - Ficha.ALTURA_FICHA / 2;
        ficha.setLocation(x, y);
        ficha.setDisabledIcon(ficha.getIcon());

        ultima_x_medio[IZQUIERDA] = x;
        ultima_y_medio[IZQUIERDA] = y + ficha.getHeight() / 2;
        ultima_x_medio[DERECHA] = x + ficha.getWidth();
        ultima_y_medio[DERECHA] = ultima_y_medio[IZQUIERDA];

        add(ficha);
    }

    public void mostrarFicha(Ficha ficha, int extremoDeColocacion, int ultimoValor) throws IOException {
        BufferedImage imagen = Rutinas.convertirImageIconABufferedImage((ImageIcon) ficha.getIcon());

        JLabel labelImagen = new JLabel();
        labelImagen.setSize(ficha.getWidth(), ficha.getHeight());
        add(labelImagen);
        if (extremoDeColocacion == IZQUIERDA) {
            int x = ultima_x_medio[IZQUIERDA] - (ficha.esMula() ? ficha.getWidth() : ficha.getHeight());
            int y = ultima_y_medio[IZQUIERDA] - (ficha.esMula() ? ficha.getHeight(): ficha.getWidth()) / 2;

            labelImagen.setLocation(x, y);

            if (!ficha.esMula()) {
                labelImagen.setSize(ficha.getHeight(), ficha.getWidth());
                BufferedImage imagenHorizontal = RotarImagenes.rotarImagen(imagen, ficha.getValor2() == ultimoValor ? -90.0 : 90.0);
                labelImagen.setIcon(new ImageIcon(imagenHorizontal));
                setLocation((int) (getLocation().getX() + ficha.getHeight() / 2), (int) getLocation().getY());
            }
            else {
                labelImagen.setIcon(new ImageIcon(imagen));
                setLocation((int) (getLocation().getX() + ficha.getWidth() / 2), (int) getLocation().getY());
            }

            ultima_x_medio[IZQUIERDA] = x;
            ultima_y_medio[IZQUIERDA] = y + (ficha.esMula() ? ficha.getHeight() : ficha.getWidth()) / 2;

            return;
        }
        int x = ultima_x_medio[DERECHA];
        int y = ultima_y_medio[DERECHA] - (ficha.esMula() ? ficha.getHeight() : ficha.getWidth()) / 2;

        labelImagen.setLocation(x, y);

        if (!ficha.esMula()) {
            labelImagen.setSize(ficha.getHeight(), ficha.getWidth());
            BufferedImage imagenHorizontal = RotarImagenes.rotarImagen(imagen, ficha.getValor1() == ultimoValor ? -90.0 : 90.0);
            setLocation((int) (getLocation().getX() - ficha.getHeight() / 2), (int) getLocation().getY());

            labelImagen.setIcon(new ImageIcon(imagenHorizontal));
        }
        else {
            labelImagen.setIcon(new ImageIcon(imagen));
            setLocation((int) (getLocation().getX() - ficha.getWidth() / 2), (int) getLocation().getY());
        }

        ultima_x_medio[DERECHA] = x + (ficha.esMula() ? ficha.getWidth() : ficha.getHeight());
        ultima_y_medio[DERECHA] = y + (ficha.esMula() ? ficha.getHeight() : ficha.getWidth()) / 2;
    }
}