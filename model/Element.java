package model;
import java.awt.Image;

import contract.IElement;
import contract.ILorannModel;
import contract.ISprite;
import contract.Permeability;

/**
 * abstract class extended by all the game elements
 * 
*
 *
 */
public abstract class Element implements IElement  {
	private ISprite				sprite;
	private Permeability	permeability;
	protected ILorannModel	lorannModel;
	
	public static int WIDTH = 64, HEIGHT = 64;

	/**
	 * 
	 * @param sprite
	 * the Element animator
	 *  Animator
	 * @param permeability
	 * the Element permeability
	 *  Permeability
	 */
	public Element(final ISprite sprite, final Permeability permeability) {
		this.setSprite(sprite);
		this.setPermeability(permeability);
	}
	


/**
 * get the element Animator
 */
	public ISprite getSprite() {
		return this.sprite;
	}

	/**
	 * get elements width
	 */
	public int getWidth(){
		return WIDTH;
	}
/**
 * get elements height
 */
public int getHeight(){
	   return HEIGHT;
   }

/**
 * set the element animmator
 */
	public void setSprite(final ISprite sprite) {
		this.sprite = sprite;
	}

/**
 * get the element permeability
 */
	public Permeability getPermeability() {
		return this.permeability;
	}

/**
 * set the element permeability
 */
	public void setPermeability(final Permeability permeability) {
		this.permeability = permeability;
	}

	
	/**
	 * get in which Model the element is used
	 *  LorannModel
	 */
	public ILorannModel getLorannModel() {
		return this.lorannModel;
	}

/**
 * set the element Model
 *  LorannModel
 */
	public void setLorannModel(final ILorannModel lorannModel) {
		this.lorannModel = lorannModel;
	}


/**
 * get the current element frame from the animator
 *  Animator
 */
	public Image getImage() {
		return this.getSprite().getImage();
	}
}
