/*
 * Filtro Rojo y Azul
 * Castillo Martínez Leonel Jafet
 */
package filtro.rojo;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

public class FiltroRojo {

 
    public static void main(String[] args) throws IOException {
        // TODO code application logic here
        Imagen obj = new Imagen("Logo.jpg");
        obj.binarizarImagen(100);
        BufferedImage img = obj.imprimirImagen();
        ImageIO.write(img, "jpg", new File("LogoRyA.jpg"));
        
        
    }
}