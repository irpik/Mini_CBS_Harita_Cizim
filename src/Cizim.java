
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Polygon;
import javax.swing.JPanel;
import java.util.*;
import java.awt.geom.Line2D;

public class Cizim extends JPanel{
    ArrayList<Cizgi> cizgiArrayList = new ArrayList<Cizgi>();
    ArrayList<Nokta> noktaArrayList = new ArrayList<Nokta>();
    ArrayList<Poligon> poligonArrayList = new ArrayList<Poligon>();
   
    
    private Polygon poly;
    public Cizim() {
        this.setBackground(Color.WHITE);
        this.setVisible(true);
    }
    
    
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g); 
        
        Graphics2D g2 = (Graphics2D)g;
        
            int x[];
        int y[];
        for (Cizgi cizgi : cizgiArrayList) {
            x=cizgi.getX();
            y=cizgi.getY();
             g2.setStroke(new BasicStroke(cizgi.getKalinlik()));
            for (int i = 0; i < cizgi.getX().length-1; i++) {
             //g2.drawLine(x[i], y[i], x[i+1], y[i+1]);
                  g2.draw(new Line2D.Float(x[i], y[i], x[i+1], y[i+1]));
                  
            }
        }
        
        
        
             
        for (Nokta nokta : noktaArrayList) {
            g2.setStroke(new BasicStroke(nokta.getKalinlik()));
            //g2.setBackground(Color.red);
            
            g2.drawRoundRect(nokta.getX(), nokta.getY(), nokta.getKalinlik(), nokta.getKalinlik(), nokta.getKalinlik(), nokta.getKalinlik());  
        }
        
         
         
          
              int renk = -1;
        for (Poligon p: poligonArrayList) {
           
            renk = p.getTip();
            
        if (renk == 1) {
             g2.setStroke(new BasicStroke(1));
            poly = new Polygon(p.getX(), p.getY(), p.getX().length);
            
            g2.setColor(Color.BLACK);
            g2.drawPolygon(poly);
        }
        else if (renk == 2) {
            g2.setStroke(new BasicStroke(1));
            poly = new Polygon(p.getX(), p.getY(), p.getX().length);
            g2.setColor(Color.LIGHT_GRAY);
            g2.fillPolygon(poly);
            g2.drawPolygon(poly);
        }
        else if(renk == 3){
            g2.setStroke(new BasicStroke(1));
            poly = new Polygon(p.getX(), p.getY(), p.getX().length);
            g2.setColor(Color.BLACK);
            g2.fillPolygon(poly);
            g2.drawPolygon(poly);
        }
            
       }
        
        
       
        
        
       
      
        
        
    } 
}
