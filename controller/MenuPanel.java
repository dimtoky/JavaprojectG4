package controller;



import java.awt.Graphics;
import java.awt.Image;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JPanel;

/** 
 *
 * 
 * the Menu Panel class
 *
 */

@SuppressWarnings("serial")
public class MenuPanel extends JPanel {
	
	ArrayList<JButton> bouts = new ArrayList<JButton>();
	 public void paintComponent(Graphics g){
		    try {
		      Image img = ImageIO.read(new File("Data/images/MenuLorann.jpg"));
		      
		      g.drawImage(img, 0, 0, this.getWidth(), this.getHeight(), this);
		    } catch (IOException e) {
		      e.printStackTrace();
		    }                
		  }    

	public MenuPanel(String p1,String p2){
		
		super();
		
		this.setLayout(null);
		
		bouts.add(new Bouton(p1));
		bouts.add(new Bouton(p2));
		
		
		this.add(bouts.get(0)); 
		this.add(bouts.get(1)); 
		bouts.get(0).setBounds(250, 220, 300, 100); 
		bouts.get(1).setBounds(500, 470, 250, 70);  
			
        
	}
		
	
	public MenuPanel(String p1,String p2,String p3,String p4,String p5,String p6){
			
			super();
			this.setLayout(null);
			bouts.add(new Bouton(p1));
			bouts.add(new Bouton(p2));
			bouts.add(new Bouton(p3));
			bouts.add(new Bouton(p4));
			bouts.add(new Bouton(p5));
			bouts.add(new Bouton(p6));
			int h = 0;
			
			
			
			for(int i = 0; i < 5; i++)
	        {
				h = h +90;
				this.add(bouts.get(i)); 
				bouts.get(i).setBounds(100, 50+h, 250, 70);   
				
	        }
			this.add(bouts.get(5)); 
			bouts.get(5).setBounds(500, 470, 250, 70);  
		
	}
	
	

}
