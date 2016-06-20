package model;

import contract.IDirection;
/**
 * class used to stock Mobiles Direction and Orientation
 * 
 *
 */
public class Direction implements IDirection {
	
	private int dirX, dirY;
    public Orientation orientation;
    /**
     * constructor of the Direction class which let us give an initial direction
     * @param x
     * initial x direction can be 0 1 or -1
     * @param y
     * initial y direction can be 0 1 or -1
     */
	public Direction(int x, int y) {
		this.setDirX(x);
		this.setDirY(y);
	}


/**
 * get the x direction
 */
	public int getDirX() {
		return dirX;
	}

/**
 * set the x direction
 * can be 1 0 or -1
 */
	public void setDirX(int dirX) {
		this.dirX = dirX;
		this.setOrientation();
	}


/**
 * get the y direction
 * 
 */
	public int getDirY() {
		return dirY;
	}

/**
 * set the y direction can be 1 0 or -1
 */
	public void setDirY(int dirY) {
		this.dirY = dirY;
		this.setOrientation();
	}
	
	
	/**
	 * set the Mobile orientation depending on it's direction
	 *  Orientation
	 */
	private void setOrientation(){
		if ( dirX == -1 && dirY == -1){
			orientation = Orientation.UP_L;
			
		}
		else if ( dirX == -1 && dirY == 0){
			orientation = Orientation.LEFT;
		}
		else if ( dirX == -1 && dirY == 1 ){
			orientation = Orientation.DOWN_L;
		}
		else if ( dirX == 0 && dirY == -1){
			orientation = Orientation.UP;
		}
		else  if ( dirX == 0 && dirY == 0){
			orientation = Orientation.STILL;
		}
		else if ( dirX == 0 && dirY == 1){
			orientation = Orientation.DOWN;
		}
		else if ( dirX == 1 && dirY == 1 ){
			orientation = Orientation.DOWN_R;
		}
		else if ( dirX == 1 && dirY == 0){
			orientation = Orientation.RIGHT;
		}
		else  if ( dirX == 1 && dirY == -1){
			orientation = Orientation.UP_R;
		}
	}

}
