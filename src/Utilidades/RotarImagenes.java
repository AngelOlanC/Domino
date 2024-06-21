package Proyecto3.Utilidad;

import java.awt.*;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;

public class RotarImagenes {
    public static BufferedImage rotarImagen(BufferedImage image, Double grados) {
        double radians = Math.toRadians(grados);
        double sin = Math.abs(Math.sin(radians));
        double cos = Math.abs(Math.cos(radians));
        int nuevaAnchura = (int) Math.round(image.getWidth() * cos + image.getHeight() * sin);
        int nuevaAltura = (int) Math.round(image.getWidth() * sin + image.getHeight() * cos);

        BufferedImage imagenRotada = new BufferedImage(nuevaAnchura, nuevaAltura, BufferedImage.TYPE_INT_ARGB);
        Graphics2D g2d = imagenRotada.createGraphics();

        int x = (nuevaAnchura - image.getWidth()) / 2;
        int y = (nuevaAltura - image.getHeight()) / 2;

        AffineTransform at = new AffineTransform();
        at.setToRotation(radians, x + (image.getWidth() / 2), y + (image.getHeight() / 2));
        at.translate(x, y);
        g2d.setTransform(at);

        g2d.drawImage(image, 0, 0, null);
        g2d.dispose();

        return imagenRotada;
    }
}