package model;

import contract.ActionOnHeroes;
import contract.Permeability;
/**
 * 
 *purse object extends MotionlessElement
 *
 */
public class purse extends MotionlessElement{

	public purse() {
		super(new Animator("P", "purse"), Permeability.PENETRABLE, 'P');
	}

	@Override
	public ActionOnHeroes getActionOnHeroes() {
		return ActionOnHeroes.MONEY;
	
}

}
