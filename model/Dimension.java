package model;

import contract.IDimension;
/**
 * 
 * class used to stock the element dimensions
 *
 */
public class Dimension implements IDimension {
	private int	width;
	private int	height;
/**
 * 
 * @param width
 * element width
 * @param height
 * element height
 */
	public Dimension(final int width, final int height) {
		this.width = width;
		this.height = height;
	}

	public Dimension(final IDimension dimension) {
		this(dimension.getWidth(), dimension.getHeight());
	}


/**
 * get the width
 */
	public int getWidth() {
		return this.width;
	}


/**
 * set the width
 */
	public void setWidth(final int width) {
		this.width = width;
	}


/**
 * get the height
 */
	public int getHeight() {
		return this.height;
	}

/**
 * set the height
 */
	public void setHeight(final int height) {
		this.height = height;
	}

}
