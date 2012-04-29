package Modele;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;
import java.io.*;
 
 
public class ImagePanel extends JPanel implements Serializable {
    Image image = null;
    int height;
    int width;
   
    public ImagePanel(Image image) {
        this.image = image;
    }
    
    public ImagePanel(Image image, int w, int h) {
        this.image = image;
        this.height = h;
        this.width = w;
        repaint();

    }
    public ImagePanel(int h, int w){
        // this.image = image;
         this.width = w;
         this.height = h;

     }
    public ImagePanel() {
       
    }
    public void setImage(Image image){
        this.image = image;

    }
    public void setImage(Image image, int h, int w){
        this.image = image;
        this.width = w;
        this.height = h;
        this.repaint();
    }

   
    public Image getImage(Image image){
        return image;
    }
   
    public void paintComponent(Graphics g) {
        super.paintComponent(g); //paint background
        if (image != null) { //there is a picture: draw it
            //int height = this.getSize().height;
            //int width = this.getSize().width;
            //g.drawImage(image, 0, 0, this); //use image size       
        	image.getScaledInstance(width, height, Image.SCALE_DEFAULT);
            g.drawImage(image,0,0, width, height, null);
        }
    }

	
}