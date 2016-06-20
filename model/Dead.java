package model;

import contract.IPosition;

/**
 * 
 *Dead mobile extends Mobile
 *
 */
public class Dead extends Mobile {
private static String IMAGE = "dead";
private int timer;
	public Dead(IPosition position) {

		super(new Direction(0,0), position, IMAGE, 'D');
		timer = 0;
	}
	/**
	 * move the dead class can be used up to 20 time before being removed from the game frame
	 * his direction is x 0 y 0
	 */
  public void move(){
	  timer += 5;
	  if(timer == 100){
		  this.lorannModel.removeMobile(this);
	  }else{super.move();}
	  
	  
  }

}
