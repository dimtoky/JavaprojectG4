package controller;



import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
/**
 * 
 * 
 *class used to listen to users input on the menu
 */
public class Controle implements ActionListener{

	MenuWindow menu;
	public static boolean launch;
	Controle(MenuWindow menu)
	{
		this.menu = menu;
	}
	
	/**
	 * method used to  control users action performed on the Menu
	 * @param e
	 * the action event triggered  by the user
	 */
	public void actionPerformed(ActionEvent e) {
	      Object source = e.getSource();
	      if (source==menu.panneau1.bouts.get(0))
	      {
	    	  menu.s.playSound("button");
	    	  menu.cardL.next(menu.panneauP);}
	      else if (source==menu.panneau1.bouts.get(1))
	      {
	    	  menu.s.playSound("button");
	    	  System.exit(0);
	      }
	      else if (source==menu.panneau2.bouts.get(0)) 
	      { 
	    	  menu.s.playSound("button");
	    	  menu.s.stopAllSound();
	    	  menu.start = true;

	      menu.level = 1;
			menu.dispose();}
	      else if (source==menu.panneau2.bouts.get(1))
	      {menu.s.playSound("button");
		  menu.s.stopAllSound();
	    	  menu.start = true;
	      menu.level = 2;
			menu.dispose();}
	      else if (source==menu.panneau2.bouts.get(2)) 
	      {
	    	  menu.s.playSound("button");
	    	  menu.s.stopAllSound();
	    	  menu.start = true;
	      menu.level = 3;
			menu.dispose();}
	      else if (source==menu.panneau2.bouts.get(3)) 
	      {
	    	  menu.s.playSound("button");
	    	  menu.s.stopAllSound();
	    	  menu.start = true;
	      menu.level = 4;
			menu.dispose();}
	      else if (source==menu.panneau2.bouts.get(4)) 
	      {
	    	  menu.s.playSound("button");
	    	  menu.s.stopAllSound();
	    	  menu.start = true;
	      menu.level = 5;
			menu.dispose();}
	      else if (source==menu.panneau2.bouts.get(5)) 
	    	  {
	    	  menu.s.playSound("button");
	    	  menu.cardL.first(menu.panneauP);
	    	  }
	      
	     
	    }
	
	
}
