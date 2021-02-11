/*
 * Filtro Sepia
 * Castillo Martínez Leonel Jafet
 */
package filtro.sepia;

import java.io.File;
import java.io.IOException;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;

public class FiltroSepia {
    public static void main(String[] args)throws IOException {
        BufferedImage img = null;
        File f = null;
        
        //Leer imagen
        try{
            f = new File("Logo.jpg");
            img = ImageIO.read(f);
        }catch(IOException e){
            System.out.println(e);
        }
        
        //obtener altura y anchura de imagen
        int alt = img.getHeight();
        int anc = img.getWidth();
        
        //convertir a sepia
        for(int y = 0; y < alt; y++){
            for(int x = 0; x < anc; x++){
                int p = img.getRGB(x, y);
                
                int a = (p>>24)&0xff;
                int r = (p>>16)&0xff;
                int g = (p>>8)&0xff;
                int b = p&0xff;
                
                //calcular tr tg tb
                int tr = (int)(0.393*r + 0.796*g + 0.189*g);
                int tg = (int)(0.349*r + 0.686*g + 0.168*g);
                int tb = (int)(0.272*r + 0.534*g + 0.131*g);
                
                //verificar condicion
                if(tr > 255){
                    r=255;
                }else{
                    r = tr;
                }
                
                if(tg > 255){
                    g=255;
                }else{
                    g = tg;
                }
                
                if(tb > 255){
                    b=255;
                }else{
                    b = tb;
                }
                
                //Asignar nuevos valores RGB
                p = (a<<24) | (r<<16) | (g<<8) | b;
                
                img.setRGB(x, y, p);
            }
        }
        
        //escribir imagen
        try{
            f = new File("Sepia.jpg");
            ImageIO.write(img, "jpg", f);
        //ImageIO.write(img, "jpg", new File("Logo Sepia.jpg"));
        }catch(IOException e){
            System.out.println(e);
        }
        
    }
    
}
