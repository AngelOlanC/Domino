package Proyecto3.Fichas;

import Proyecto3.Utilidad.Rutinas;

import javax.swing.*;
import java.awt.*;

public class Ficha extends JButton {
    public static int ANCHURA_FICHA = 30, ALTURA_FICHA = 70;

    public static final ImageIcon IMAGEN_FICHA_TAPADA =
            Rutinas.ajustarImagen("Proyecto3/Imagenes/FichaTapada.jpg", ANCHURA_FICHA, ALTURA_FICHA);
    private ImageIcon imagenFichaMostrada;
    private final int valor1, valor2;

    public Ficha(int valor1, int valor2) {
        super();
        this.valor1 = valor1;
        this.valor2 = valor2;
        imagenFichaMostrada =
                Rutinas.ajustarImagen("Proyecto3/Imagenes/Fichas/" + valor1 + valor2 + ".jpg", ANCHURA_FICHA, ALTURA_FICHA);
        setIcon(imagenFichaMostrada);
        setDisabledIcon(IMAGEN_FICHA_TAPADA);
        setEnabled(false);
        setPreferredSize(new Dimension(ANCHURA_FICHA, ALTURA_FICHA));
    }

    public void intercambiarImagenDeBotonDesactivado() {
        if (getDisabledIcon() == IMAGEN_FICHA_TAPADA) {
            setDisabledIcon(imagenFichaMostrada);
            return;
        }
        setDisabledIcon(IMAGEN_FICHA_TAPADA);
    }

    public boolean esMula() {
        return valor1 == valor2;
    }

    public int getValor1() {
        return valor1;
    }

    public int getValor2() {
        return valor2;
    }

    public ImageIcon getImagenFichaMostrada() {
        return imagenFichaMostrada;
    }

}
