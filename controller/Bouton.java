package controller;

import java.awt.Color;
import java.awt.FontMetrics;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JButton;
 
@SuppressWarnings("serial")
public class Bouton extends JButton implements MouseListener{
  private String name;
  private Image img;

  public Bouton(String str){
    super(str);
    this.name = str;
    try {
      img = ImageIO.read(new File("Data/images/base.png"));
    } catch (IOException e) {
      e.printStackTrace();
    }
    this.addMouseListener(this);
  }

  public void paintComponent(Graphics g){ 
    Graphics2D g2d = (Graphics2D)g;
   GradientPaint gp = new GradientPaint(0, 0, Color.blue, 0, 20, Color.cyan, true);
    g2d.setPaint(gp);
    g2d.drawImage(this.img, 0, 0, this.getWidth(), this.getHeight(), this);
    g.drawImage(img, 0, 0, this.getWidth(), this.getHeight(), this);
    g2d.setColor(Color.black);
 
    FontMetrics fm = g2d.getFontMetrics();
    int height = fm.getHeight();
     int width = fm.stringWidth(this.name);

    g2d.drawString(this.name, this.getWidth() / 2 - (width / 2), (this.getHeight() / 2) + (height / 4));     
  }

  public void mouseClicked(MouseEvent event) {
    }

  
  /**
   * change the button image if the mouse  enters it
   */
  public void mouseEntered(MouseEvent event) {    
     try {
      img = ImageIO.read(new File("Data/images/hover.png"));   
    } catch (IOException e) {
      e.printStackTrace();
    }    
  }
/**
 * change the button image when the mouse exits it
 */
  public void mouseExited(MouseEvent event) {
     try {
      img = ImageIO.read(new File("Data/images/base.png"));
    } catch (IOException e) {
      e.printStackTrace();
    }    
  }

  /**
   * change the bouton image when the mouse presses it
   */
  public void mousePressed(MouseEvent event) {
    try {
      img = ImageIO.read(new File("Data/images/click.png"));
    } catch (IOException e) {
      e.printStackTrace();
    }    
  }

  /**
   * change the bouton image when the mouse releases it
   */
  public void mouseReleased(MouseEvent event) {
    if((event.getY() > 0 && event.getY() < this.getHeight()) && (event.getX() > 0 && event.getX() < this.getWidth())){
      try {
        img = ImageIO.read(new File("Data/images/hover.png"));
      } catch (IOException e) {
        e.printStackTrace();
      }
    }  else{
      try {
        img = ImageIO.read(new File("Data/images/base.png")); 
      } catch (IOException e) {
        e.printStackTrace();
      }
    }   
  }   
}