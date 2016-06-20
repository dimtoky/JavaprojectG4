package model;

import contract.ActionOnHeroes;
import contract.IDoActionOnHeroes;
import contract.ISprite;
import contract.Permeability;
/**
 * abstract class extended by all the static elements, extend Element
 * 
 *
 */
public abstract class MotionlessElement extends Element implements IDoActionOnHeroes {
	private final char fileSymbol;
/**
 * constructor of a static element
 * @param sprite
 * Animator of the element
 *  Animator
 * @param permeability
 * permeability of the lement
 *  Permeability
 * @param fileSymbol
 * fileSymbol of the element used in the database and the loadfile method of the model
 *  lorannDAO
 *  LorannModel
 */
	public MotionlessElement(final ISprite sprite, final Permeability permeability, final char fileSymbol) {
		super(sprite, permeability);
		this.fileSymbol = fileSymbol;
	}
/**
 * get the file symbol used in the database
 *  lorannDAO
 * @return
 * the character filesymbol of the element
 */
	public char getFileSymbol() {
		return this.fileSymbol;
	}

	/**
	 * overwrite in the child static element class to know which action it perform on the hero
	 *  ActionOnHeroes
	 *  Hero
	 */
	public ActionOnHeroes getActionOnHeroes() {
		return ActionOnHeroes.NOP;
	}
}