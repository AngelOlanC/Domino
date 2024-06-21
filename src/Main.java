package Proyecto3;

import Proyecto3.Controlador.Controlador;
import Proyecto3.Modelo.Modelo;
import Proyecto3.Utilidad.UtilidadFichas;
import Proyecto3.Vista.Vista;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        if (faltaAlgunaImagenDeAgregar())
            UtilidadFichas.generarFichas();
        new Controlador(new Modelo(), new Vista());
    }

    private static boolean faltaAlgunaImagenDeAgregar() {
        for (int i = 0; i <= 6; i++)
            for (int j = i; j <= 6; j++)
                if (!(new File("Proyecto3/Imagenes/Fichas/" + (i + "") + j + ".jpg")).exists())
                    return true;
        return false;
    }
}
