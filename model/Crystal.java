package model;

import contract.ActionOnHeroes;
import contract.Permeability;
/**
 * 
 * Crystal object extends MotionlessElement
 *
 */
public class Crystal extends MotionlessElement {

	public Crystal() {
		super(new Animator("C", "crystal"), Permeability.PENETRABLE, 'C');
	}

	@Override
	public ActionOnHeroes getActionOnHeroes() {
		return ActionOnHeroes.UNLOCK;
	
}
}
