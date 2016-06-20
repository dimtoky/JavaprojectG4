package controller;


import java.awt.CardLayout;

import javax.swing.JPanel;
import javax.swing.JWindow;

@SuppressWarnings("serial")

/**
 * 
 * 
 * the Menu Frame class which extends a JWindow
 *
 */
public class MenuWindow extends JWindow{
	
	SoundManager s;
	public boolean start = false;
	public int level = 0;
	
	
	public CardLayout cardL;
	public JPanel panneauP;
	public MenuPanel panneau1;
	public MenuPanel panneau2;
	public MenuPanel panneau3;
	public Controle controles;
	
	/**
	 * instantiate a menu
	 */
	public MenuWindow(){

	 controles = new Controle(this);	
	 cardL = new CardLayout();
	 panneauP = new JPanel();
	 panneau1 = new MenuPanel("Jouer","Quitter");
	 panneau2 = new MenuPanel("Niveau1","Niveau2","Niveau3","Niveau4","Niveau5","Retour");	
	 s = new SoundManager(){

		@Override
		public void initSounds() {
			sounds.add(new Sound("button", "Button.wav"));
			sounds.add(new Sound( "menu", "MenuSong.wav"));
			
		}
		 
	 };
	 
    pack();
	setSize(800, 600); 
	setLocationRelativeTo(null);
	//setResizable(false);
	//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	setVisible(true);
	this.toFront();
	this.repaint();
	this.setAlwaysOnTop(true);
	panneauP.setLayout(cardL);
	this.add(panneauP);
	panneauP.add(panneau1,"Panneaujeu");
	panneauP.add(panneau2,"Panneauniveau");
 
	for(int i = 0; i < 2; i++)
    {
		panneau1.bouts.get(i).addActionListener(controles);  
		
	
    }
	
	for(int i = 0; i < 6; i++)
    {
		 
		panneau2.bouts.get(i).addActionListener(controles);
	
    }
	
	
	s.loopSound("menu");
	
	}
	
	

	
	
}
