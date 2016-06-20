package model;

import contract.ActionOnHeroes;
import contract.Permeability;
/**
 * 
 * Gate object extends MotionlessElement
 *
 */
public class Gate extends MotionlessElement {

	public boolean opened = false;
	public Gate() {
		super(new Animator("G", "gate_closed"), Permeability.PENETRABLE, 'G');
	}

	@Override
	/**
	 * if openened is false return ActionOnHeroes KILL else return EXITs
	 */
	public ActionOnHeroes getActionOnHeroes() {
		if(!opened){
		return ActionOnHeroes.KILL;}
		else{
			return ActionOnHeroes.EXIT;
		}
		
}
}
