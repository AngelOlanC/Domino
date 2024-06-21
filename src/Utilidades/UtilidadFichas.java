package Proyecto3.Utilidad;

import Proyecto3.Fichas.Ficha;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

public class UtilidadFichas {
    public static void generarFichas() throws IOException {
        final BufferedImage PLANTILLA = ImageIO.read(new File("Proyecto3/Imagenes/PlantillaDomino.jpg"));

        final int SEPARACION_HORIZONTAL = 96, SEPARACION_VERTICAL = 178, INICIO_X = 44, INICIO_Y = 30, ANCHURA_FICHA = 75, ALTURA_FICHA = 147;

        for (int r = 0; r < 4; r++) {
            int izq = 7 - r;
            for (int c = 0; c < 7; c++) {
                String valor = (c < r ? (izq + "") + (izq + c + "") : (r + "") + (c + ""));
                ImageIO.write(PLANTILLA.getSubimage(INICIO_X + c * SEPARACION_HORIZONTAL, INICIO_Y + r * SEPARACION_VERTICAL, ANCHURA_FICHA, ALTURA_FICHA),
                        "jpg", new File("Proyecto3/Imagenes/Fichas/" + valor + ".jpg"));
            }
        }
    }

    public static ArrayList<Ficha> crearFichas() {
        ArrayList<Ficha> fichas = new ArrayList<>(28);
        for (int i = 0; i <= 6; i++)
            for (int j = i; j <= 6; j++)
                fichas.add(new Ficha(i, j));
        return fichas;
    }

    public static ArrayList<Ficha> mezclarFichas(ArrayList<Ficha> fichas) {
        Random rnd = new Random();
        for (int k = 0; k < 50; k++) {
            int i = rnd.nextInt(0, fichas.size()), j = rnd.nextInt(0, fichas.size());
            Ficha aux = fichas.get(i);
            fichas.set(i, fichas.get(j));
            fichas.set(j, aux);
        }
        return fichas;
    }

    public static Ficha seleccionarFichaAleatoriamente(ArrayList<Ficha> fichas) {
        Random generadorAleatorios = new Random();
        return fichas.get(generadorAleatorios.nextInt(0, fichas.size()));
    }
}
