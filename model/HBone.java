package model;

import contract.ActionOnHeroes;
import contract.Permeability;
/**
 * 
 * Horizontale bone object extends MotionlessElement
 *
 */
public class HBone extends MotionlessElement {
	
	public HBone() {
		super(new Animator("H", "horizontal_bone"), Permeability.BLOCKING, 'H');
	}

	@Override
	public ActionOnHeroes getActionOnHeroes() {
		return ActionOnHeroes.NOP;
	
}

}
