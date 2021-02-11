/*          Práctica 1
Programa para copiar byte a byte o grupo de bytes
 */
package practica;

import java.awt.image.*;
import java.io.*;
import java.io.IOException;
import javax.imageio.*;

/*
 * @author Castillo Martínez Leonel Jafet
 */

public class Practica1{
    
    public static void main(String[] args) throws IOException{
        File image = new File("P1.bmp");
        //Read Image pixel by pixel
        LeerImagen h = new LeerImagen();
        new LeerImagen().leer_escribir();
        
        System.out.println("Lectura de imagen P1Copia pixel-pixel");
        BufferedImage imgBuffer = ImageIO.read(image);
        
        byte[] pixels = (byte[]) imgBuffer.getRaster().getDataElements(0, 0, imgBuffer.getWidth(), imgBuffer.getHeight(), null);
        String pix = new String(pixels);
        for (int i = 0; i <pixels.length; i=i+3)
        {
            //Convert Every pixel from integer to hex
            String r = Integer.toHexString(pixels[i]);
            if(r.equals("0")) r = "00";
            if(r.equals("1")) r = "01";
            if(r.equals("2")) r = "02";
            if(r.equals("3")) r = "03";
            if(r.equals("4")) r = "04";
            if(r.equals("5")) r = "05";
            if(r.equals("6")) r = "06";
            if(r.equals("7")) r = "07";
            if(r.equals("8")) r = "08";
            if(r.equals("9")) r = "09";
            //int x;
            //String[] rg =pixels.toString();
            //String[] rf = String(Integer.toHexString(pixels);
            
            String g = Integer.toHexString(pixels[i+1]);
            if(g.equals("0")) g = "00";
            if(g.equals("1")) g = "01";
            if(g.equals("2")) g = "02";
            if(g.equals("3")) g = "03";
            if(g.equals("4")) g = "04";
            if(g.equals("5")) g = "05";
            if(g.equals("6")) g = "06";
            if(g.equals("7")) g = "07";
            if(g.equals("8")) g = "08";
            if(g.equals("9")) g = "09";
            
            String b = Integer.toHexString(pixels[i+2]);
            if(b.equals("0")) b = "00";
            if(b.equals("1")) b = "01";
            if(b.equals("2")) b = "02";
            if(b.equals("3")) b = "03";
            if(b.equals("4")) b = "04";
            if(b.equals("5")) b = "05";
            if(b.equals("6")) b = "06";
            if(b.equals("7")) b = "07";
            if(b.equals("8")) b = "08";
            if(b.equals("9")) b = "09";
           
            //Get first two char from Every String
            r = String.format("%.02s ", r);
            g = String.format("%.02s ", g);
            b = String.format("%.02s", b);
            
            //Print final result
            System.out.println("#" + r + g + b);
            
        }
    }
}

