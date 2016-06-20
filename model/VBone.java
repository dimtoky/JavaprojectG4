package model;

import contract.ActionOnHeroes;
import contract.Permeability;
/**
 * 
 * Vertical Bone object extends MotionlessElement
 *
 */
public class VBone extends MotionlessElement {

	public VBone() {
		super(new Animator("V", "vertical_bone"), Permeability.BLOCKING, 'V');
	}

	@Override
	public ActionOnHeroes getActionOnHeroes() {
		return ActionOnHeroes.NOP;
	
}
}
