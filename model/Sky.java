package model;

import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import contract.IArea;
import contract.IDimension;
/**
 * back ground class extends Area
 * 
 *
 */
class Sky implements IArea {
	private static String		IMAGE	= "sky.png";
	private final IDimension	dimension;
	private Image						image;
/**
 * constructor of the background
 * @param dimension
 * background dimension ( which will be used in the frame dimension )
 *  Dimension
 */
	public Sky(IDimension dimension) {
		this.dimension = dimension;
		try {
			this.image = ImageIO.read(new File("Data/images/" + IMAGE));
		} catch (final IOException e) {
			e.printStackTrace();
		}
	}

/**
 * get dimension
 *  Dimension
 */
	public IDimension getDimension() {
		return this.dimension;
	}

/**
 * get Width Dimension
 *  Dimension
 */
	public int getWidth() {
		return this.getDimension().getWidth();
	}

/**
 * get height dimension
 *  Dimension
 */
	public int getHeight() {
		return this.getDimension().getHeight();
	}

/**
 * get the background Image
 *  Image
 */
	public Image getImage() {
		return this.image;
	}
}
