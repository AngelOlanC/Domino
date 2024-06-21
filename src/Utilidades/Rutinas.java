package Proyecto3.Utilidad;

import Proyecto3.Fichas.Ficha;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

public class Rutinas {
    public static BufferedImage convertirImageIconABufferedImage(ImageIcon icono) {
        BufferedImage bi = new BufferedImage(
                icono.getIconWidth(),
                icono.getIconHeight(),
                BufferedImage.TYPE_INT_RGB);
        Graphics g = bi.createGraphics();
        icono.paintIcon(null, g, 0,0);
        g.dispose();
        return bi;
    }
    public static String getDireccionDeImagenDadaFicha(Ficha ficha) {
        return "Proyecto3/Imagenes/Fichas/" + ficha.getValor1() + ficha.getValor2() + ".jpg";
    }
    public static ImageIcon ajustarImagen(String ico, int Ancho, int Alto){
        ImageIcon tmpIconAux = new ImageIcon(ico);
        //Escalar Imagen
        ImageIcon tmpIcon = new ImageIcon(tmpIconAux.getImage().getScaledInstance(Ancho,
                Alto, Image.SCALE_SMOOTH));//SCALE_DEFAULT
        return tmpIcon;
    }
}
