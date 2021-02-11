package practica;

import java.awt.image.*;
import java.io.*;
import javax.imageio.*;


public class LeerImagen {
    
    BufferedImage Imagen = null;
    
    public void leer_escribir()
    {
        try
        {
            File arcimg = new File("P1.bmp");
            Imagen = ImageIO.read(arcimg);
            System.out.println("Se ha copiado la imagen P1");
            ImageIO.write(Imagen, "bmp", new File ("P1Copia.bmp"));
            System.out.println("Se ha creado P1Copia");
        }catch(Exception e){}
    }

}
 