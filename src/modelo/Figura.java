package modelo;

import java.io.FileWriter;
import java.io.IOException;
import java.util.LinkedList;
import org.jdom2.Attribute;
import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.output.Format;
import org.jdom2.output.XMLOutputter;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Valentina
 */
public class Figura {

   
    
    private double puntosX [];
    private double puntosY [];
    
    
    public Figura() {
        
    }

    public Figura(double[] puntosX, double[] puntosY) {
        this.puntosX = puntosX;
        this.puntosY = puntosY;
    }

    

    public double[] getPuntosX() {
        return puntosX;
    }

    public void setPuntosX(double[] puntosX) {
        this.puntosX = puntosX;
    }

    public double[] getPuntosY() {
        return puntosY;
    }

    public void setPuntosY(double[] puntosY) {
        this.puntosY = puntosY;
    }

    @Override
    public String toString() {
        return "Figura{" + "puntosX=" + puntosX + ", puntosY=" + puntosY + '}';
    }
    
    public boolean crearArchivoXML(LinkedList<Figura> Figuras) {

        boolean g = false;

        try {

            Element FigurasGeometricas = new Element("FigurasGeometricas");

            Document doc = new Document(FigurasGeometricas);

            for (int i = 0; i < Figuras.size(); i++) {
                Element figura = new Element("figura");
                
                

                figura.addContent(new Element("puntosX").setText(String.valueOf(Figuras.get(i).puntosX)));
                figura.addContent(new Element("puntosY").setText(String.valueOf(Figuras.get(i).puntosY)));

                

                doc.getRootElement().addContent(figura);

            }
            XMLOutputter xmlOutput = new XMLOutputter();
            xmlOutput.setFormat(Format.getPrettyFormat());
            xmlOutput.output(doc, new FileWriter("FigurasGeometricas.xml"));

            g = true;

           

        } catch (IOException io) {
            System.out.println(io.getMessage());
            g = false;
        }

        return g;

    }

 
    

  
    
    
    
}
