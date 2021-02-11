
package filtro.rojo;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;

public class Imagen {
    public static final int anchoP=1080;
    public static final int altoP=1080;
    private Color arreglo[][];
    private int ancho;
    private int alto;
    public Imagen(String archivo) {
        arreglo = new Color[anchoP][anchoP];
        cargarImagen(archivo);
    }
    public void cargarImagen(String archivo){
        BufferedImage bf=null;
        try {
            bf = ImageIO.read(new File(archivo));
        } catch (IOException ex) {
            Logger.getLogger(Imagen.class.getName()).log(Level.SEVERE, null, ex);
        }
        if (bf.getWidth()<anchoP) {
            ancho=bf.getWidth();
        }else
            ancho=anchoP;
        if (bf.getHeight()<altoP) {
            alto=bf.getHeight();
        }else
            alto=altoP;
        int cont=0;
        for (int i = 0; i < alto; i++) {
            for (int j = 0; j < ancho; j++) {
                cont++;
                arreglo[i][j]= new Color(bf.getRGB(j, i));
                System.out.println(cont +":"+"RedGreenBlue:"+ bf.getRGB(j, i));
            }
        }
    }
    public BufferedImage redimensionar(String archivo, double porcentaje ){
        
        BufferedImage bf = null;
        try {
            bf = ImageIO.read(new File(archivo));
        } catch (IOException ex) {
            Logger.getLogger(Imagen.class.getName()).log(Level.SEVERE, null, ex);
        }
        int ancho = bf.getWidth();
        int alto = bf.getHeight();
        int escalaAncho = (int)(porcentaje* ancho);
        int escalaAlto = (int)(porcentaje*alto);
        BufferedImage bufim = new BufferedImage(escalaAncho, escalaAlto, bf.getType());
        Graphics2D g = bufim.createGraphics();
        g.setRenderingHint(RenderingHints.KEY_INTERPOLATION,RenderingHints.VALUE_INTERPOLATION_BILINEAR);
        g.drawImage(bf, 0,0, escalaAncho,escalaAlto, 0,0,ancho,alto, null);
        g.dispose();
        return bufim;
}
    public void binarizarImagen(double umbral){
        for (int i = 0; i < alto; i++) {
            for (int j = 0; j < ancho; j++) {
                Color pix= arreglo[i][j];
                int promedio =(pix.getBlue()+pix.getRed()+pix.getGreen())/3;
                if (promedio<umbral) 
                    arreglo[i][j]=Color.BLUE;
                else
                    arreglo[i][j] = Color.RED;
            }
        }
    }
    public BufferedImage imprimirImagen(){
        BufferedImage salida = new BufferedImage(ancho, alto, BufferedImage.TYPE_INT_RGB);
        for (int i = 0; i < alto; i++) {
            for (int j = 0; j < ancho; j++) {
                salida.setRGB(j, i, arreglo[i][j].getRGB());
            }
        }
        return salida;
    }
}