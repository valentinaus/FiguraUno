/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package figuritauno;

import java.net.URL;
import java.util.LinkedList;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.paint.Color;
import modelo.Figura;

/**
 *
 * @author Valentina
 */
public class FXMLDocumentController implements Initializable {
    
    @FXML
    private Canvas canvas;
    
    @FXML
    private Button crear;
    
    @FXML
    private Button agregar;
    
    @FXML
    private Button guardar;
    
    private GraphicsContext g;
    
    LinkedList <Figura> Figuras;
    
    
    
   
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        Figuras = new LinkedList<>();

        g= canvas.getGraphicsContext2D();

        double w= canvas.getWidth();
        double h= canvas.getHeight();
        
        g.setStroke(Color.BLUEVIOLET);
        g.setLineWidth(10);
        g.strokeRect(0, 0, w, h);
        // TODO
    }  
    
     @FXML
    private void crearFigura(ActionEvent event) {
    
        
         g= canvas.getGraphicsContext2D();
         
       
         
        System.out.println("funciona!");
        
        
       double X []= {172.2,335.9,306.8,133,101.7,264.6,352.5,220.1,86.3,};

        double Y [] = {186.6,245,416.3,417.4,245.9,186,335.9,448.5,337.7};
        
            
        g.setStroke(Color.CORAL);
        g.setLineWidth(3);
        g.strokePolygon(X, Y, 9);
        
    }
    
    @FXML
    private void AgregarFigura(ActionEvent event) {
        System.out.println("You clicked me!");

        double puntosX []= {172.2,335.9,306.8,133,101.7,264.6,352.5,220.1,86.3,};
        double puntosY[] = {186.6,245,416.3,417.4,245.9,186,335.9,448.5,337.7};
        
        Figura objF = new Figura(puntosX, puntosY);
        Figuras.add(objF);
        
    }
    
    @FXML
    private void guardarXML(ActionEvent event) {
        
       Figura objeV= new Figura();
        
        boolean guardar = objeV.crearArchivoXML(Figuras);
        
        
        
    }
    
    
}
