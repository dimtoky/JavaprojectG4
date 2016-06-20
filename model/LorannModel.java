package model;

import java.awt.Image;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.SQLException;
import java.util.Observable;
import java.util.concurrent.CopyOnWriteArrayList;

import contract.IArea;
import contract.IDoActionOnHeroes;
import contract.IElement;
import contract.ILorannModel;
import contract.IMobile;



/**
 * the Model class which contain all the game Data
 * 
 *
 */
public class LorannModel extends Observable implements ILorannModel {

	public MotionlessElement				elements[][];
	public final CopyOnWriteArrayList<IMobile>	mobiles;
	public IArea area;
	private int width, height;
	private Hero										hero;
	public Gate gate;
	public static lorannDAO dao;
	private long score;
	
	
	
/**
 * basic empty Model constructor
 * @param area
 * the class used to set the background
 *  Area
 */
	public LorannModel(IArea area) {
     mobiles = new CopyOnWriteArrayList<IMobile>();	
     this.area = area;
	}
	
	/**
	 * constructor which use a text file name to load game data into Model
	 * @param file
	 * txt file name in textmap folder
	 * @throws IOException
	 */
	public LorannModel(String file) throws IOException {
	     mobiles = new CopyOnWriteArrayList<IMobile>();	
	     loadFile(file);
	     this.area = new Sky(new Dimension(width*Element.WIDTH, height*Element.HEIGHT + Element.HEIGHT));
		this.gate = (Gate) MotionlessElements.GATE;
		try {
			dao = new lorannDAO();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		};
		this.closeGate();
	}

	
	/**
	 * Empty Model constructor which will contain an empty element table of width*height elements
	 * @param width
	 * model width ( maximum x for the element table )
	 * @param heigth
	 * model height ( maximum y for the element table )
	 * @param elements2
	 * the element table
	 */
	public LorannModel(int width, int heigth, MotionlessElement[][] elements2) {

		 mobiles = new CopyOnWriteArrayList<IMobile>();	
       elements = elements2;
       this.height = heigth;
       this.width = width;
       this.area = new Sky(new Dimension(width*Element.WIDTH, height*Element.HEIGHT + Element.HEIGHT));
       this.gate = (Gate) MotionlessElements.GATE;
       this.closeGate();
       
       
       
       
	}

/**
 * get the background class	
 */
	public IArea getArea() {
		return this.area;
	}

	/**
	 * set the Gate element
	 * @param gate
	 * Gate element
	 *  Gate
	 */
   public void setGate(Gate gate){
	   this.gate = gate;
   }

   /**
    * set the Gate boolean opened to true
    *  Gate
    */
   public void openGate(){
	   this.gate.opened = true;
	   this.gate.setSprite(new Animator("G", "gate_open"));
   }
   
   /**
    * set the gate boolean opened to false
    *  Gate
    */
   public void closeGate(){
	   this.gate.opened = false;
	   this.gate.setSprite(new Animator("G", "gate_closed"));
   }

   /**
    * add a mobile to the model
    *  Mobile
    */
	public void addMobile(final IMobile mobile) {
		mobile.setLorannModel(this);
		this.mobiles.add(mobile);

	}

/**
 * remove a mobile from the model
 *  Mobile
 */
	public void removeMobile(final IMobile mobile) {
		this.mobiles.remove(mobile);
	}

/**
 * get the Mobile CopyOnWriteArrayList
 *  Moblle
 */
	public CopyOnWriteArrayList<IMobile> getMobiles() {
		return this.mobiles;
	}


/**
 * notify the observers  ( usualy the Panel )
 *  GamePanel
 */
	public void setMobilesHavesMoved() {
		this.setChanged();
		this.notifyObservers();
	}

	/**
	 * get elements at parameter position
	 */
	public IElement getElements(final int x, final int y) {
		if ((x < 0) || (y < 0) || (x >= this.getMapWidth()) || (y >= this.getMapHeight())) {
			return null;
		}
		return this.elements[x][y];
	}
	
	/**
	 * get an element at the parameter position as an IDoActionOnHeroes
	 *  MotionlessElement
	 *  IDoActionOnHeroes
	 */
	public IDoActionOnHeroes getElementAction(final int x, final int y) {
		if ((x < 0) || (y < 0) || (x >= this.getMapWidth()) || (y >= this.getMapHeight())) {
			return null;
		}
		return this.elements[x][y];
	}
	
	/**
	 * get element table
	 */
	public MotionlessElement[][] getAllElements(){
		return elements;
	}
	public IMobile getHero() {
		return this.hero;
	}
	
	/**
	 * add element to table at parameter position
	 */
	public void addElement(final IElement element, final int x, final int y) {
		this.elements[x][y] = (MotionlessElement) element;
		if (element != null) {
			element.setLorannModel(this);
		}
		this.setChanged();
	}
	
	/**
	 * get Elements Width
	 *  ELement
	 */
	public int getElementWidth(){
		return Element.WIDTH;
	}
	
	/**
	 * get Element Height
	 *  Element
	 */
	public int getElementHeight(){
		return Element.HEIGHT;
	}
	
	/**
	 * add A player to the model
	 *  Hero
	 */
	public void addHeroMobile(final IMobile hero) {
		this.setHero(hero);
		this.addMobile((Mobile) hero);
	}
	
	
	/**
	 * set the player on the model
	 *  Hero
	 */
	public void setHero(IMobile hero){
		this.hero = (Hero) hero;
	}
	
	/**
	 * get frame Height
	 *  Area
	 */
	public int getHeight(){
		return this.area.getHeight();
	}
	
	/**
	 * get frame Height
	 *  Area
	 */
	public int getWidth(){
		return this.area.getWidth();
	}
	/**
	 * get map Width
	 */
	public int getMapWidth(){
		return width;
	}

	/**
	 * get Map Height
	 */
	public int getMapHeight(){
		return height;
	}
	
	/**
	 * get player current score
	 */
	public long getScore() {
		return score;
	}
	
	
/**
 * set player Current score
 */
	public void setScore(long score) {
		this.score = score;
	}
	
	/**
	 * load file into model ( get data into model )
	 */
	public void loadFile(final String fileName) throws IOException {
		final BufferedReader buffer = new BufferedReader(new InputStreamReader(new FileInputStream("Data/maptext/" + fileName)));
		String line;
		int numLine = 0;
		line = buffer.readLine();
		this.width = Integer.parseInt(line);
		line = buffer.readLine();
		this.height = Integer.parseInt(line);
		this.elements = new MotionlessElement[width][height];
		while ((line = buffer.readLine()) != null) {
			for (int x = 0; x < line.toCharArray().length; x++) {
				
				this.addElement(MotionlessElements.getFromFileSymbol(line.toCharArray()[x]), x, numLine);
		
			}
			numLine++;
		}
		buffer.close();
		this.setChanged();
	}

	
	/**
	 * remove an elemment from model on current parameter position by replacing vide VIDE
	 *  Vide
	 */
	public void removeElement(int x, int y) {
	    this.elements[x][y] = MotionlessElements.VIDE;
		
	}
	
	
	/**
	 * return false if there is no Fireball in the model else return true
	 *  FireBall
	 */
	public boolean isFire(){
		
		for(IMobile weapon : this.getMobiles()){
			if(weapon.isWeapon()){
				return true;
			}
		}
		return false;
	}
	
	/**
	 * instantiate a Fireball which had Hero Position
	 *  Fireball
	 *  Hero
	 */
	public void lauchFire() {
		
		if(isFire()){
			for(IMobile weapon : this.getMobiles()){
				if(weapon.isWeapon()){
                   FireBall fireball;
                   fireball = (FireBall) weapon;
                   fireball.findactivate = true;
                  
				}
				
			}
		
		}
		else  {
			this.addMobile(new FireBall(new Direction(-(this.getHero().getDirection().getDirX()), -(this.getHero().getDirection().getDirY())), 
					                                new Position(this.getHero().getlastposition()),
					                                this.getHero()));
		}
	}

	
	/**
	 * get the Image of the element with the parameter position
	 */
	public Image getElementImage(final int x, final int y) {
		if ((x < 0) || (y < 0) || (x >= this.getMapWidth()) || (y >= this.getMapHeight())) {
			return null;
		}
		return this.elements[x][y].getImage();
	}

	/**
	 * generate a lorannModel from the database which had the level in parameter
	 * @param level
	 * Model Label 
	 * @return
	 * a Model ( LorannModel )
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	public static LorannModel generateLorannModel( int level) throws ClassNotFoundException, SQLException{
		dao = new lorannDAO();
		if(dao.open()){
		LorannModel lorannModel;
			lorannModel = dao.getILorannModelByLevel(level);
		dao.close();
		lorannModel.closeGate();
		return lorannModel;}else return null;
	}
	
	
}
