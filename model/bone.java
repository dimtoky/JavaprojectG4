package model;

import contract.ActionOnHeroes;
import contract.Permeability;
/**
 * 
 * Bone object extends MotionlessElement
 *
 */
public class bone extends MotionlessElement{
	public bone() {
		super(new Animator("B", "bonex"), Permeability.BLOCKING, 'B');
	}

	@Override
	public ActionOnHeroes getActionOnHeroes() {
		return ActionOnHeroes.NOP;
	
}
}
