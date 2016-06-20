package model;

import contract.IPosition;
/**
 * class used to stock Mobile Position ( x and y )
 * 
 *
 */
public class Position implements IPosition  {
	private int	x;
	private int	y;

/**
 * constructor of the position with 2 int parameters
 * @param x
 * x position
 * @param y
 * y position
 */
	public Position(final int x, final int y) {
		this.x = x;
		this.y = y;
	}

/**
 * constructor of a Position with a Position parameter
 * @param position
 * a position
 */
	public Position(final IPosition position) {
		this(position.getX(), position.getY());
	}

	
	/**
	 * get x position
	 */
	
	public int getX() {
		return this.x;
	}

	/**
	 * set x position
	 */
	
	public void setX(final int x) {
		this.x = x;
	}


	/**
	 * get y position
	 */
	
	public int getY() {
		return this.y;
	}

	
	/**
	 * set y position
	 */
	
	public void setY(final int y) {
		this.y = y;
	}

}
