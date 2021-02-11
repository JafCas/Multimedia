/*
 Filtro blanco y negro
Castillo Martínez Leonel Jafet
 */
package filtro.byn;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

public class FiltroByN {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        // TODO code application logic here
        imagen obj = new imagen("Logo.jpg");
        obj.binarizarImagen(100);
        BufferedImage img = obj.imprimirImagen();
        ImageIO.write(img, "jpg", new File("LogoByN.jpg"));
        
        
    }
}