package model;

import contract.ActionOnHeroes;
import contract.Permeability;
/**
 * 
 * Void object extends MotionlessElement used to return an empty Image ( transparent ) and a
 * Penetrable Permeability
 *
 */
public class vide extends MotionlessElement{
	
	public vide() {
		super(new Animator(" ", "vide"), Permeability.PENETRABLE, ' ');
	}

	@Override
	public ActionOnHeroes getActionOnHeroes() {
		return ActionOnHeroes.NOP;
	
}
	


}
