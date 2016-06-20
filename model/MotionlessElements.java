package model;

import contract.IMobile;
/**
 * class container of the static elemnt class and character to element Object static methods generators
 * @author wacim
 *
 */
public abstract class MotionlessElements {

	public static final MotionlessElement BONE = new bone();
	public static final MotionlessElement CRYSTAL = new Crystal();
	public static final MotionlessElement GATE = new Gate();
	public static final MotionlessElement HBONE = new HBone();
	public static final MotionlessElement VBONE = new VBone();
	public static final MotionlessElement VIDE = new vide();
	public static final MotionlessElement PURSE = new purse();
	
	private static MotionlessElement			motionlessElements[]	= {BONE, CRYSTAL, GATE, HBONE, VBONE, PURSE, VIDE};

	/**
	 * method which return a static element depending on the file symbol
	 * @param fileSymbol
	 * file symbol of an element
	 * @return
	 * a static element depending on its fileSymbole return Vide if no element match
	 */
	public static MotionlessElement getFromFileSymbol(final char fileSymbol) {
		for (final MotionlessElement motionlessElement : motionlessElements) {
			if (motionlessElement.getFileSymbol() == fileSymbol) {
				return motionlessElement;
			}
		}
		return VIDE;
	}

	/**
	 * method which return a mobile depend on its filesymbol
	 * @param string
	 * filesymbol
	 * @param int1
	 * x position
	 * @param int2
	 * y position
	 * @param int3
	 * dirx
	 * @param int4
	 * diry
	 * @param hero
	 * target of the mobile
	 * @return
	 * return the mobile or null if no mobile match
	 * @see Mobile
	 */
	public static IMobile getMobileFromFileSymbol(String string, int int1, int int2, int int3, int int4, Hero hero) {
	  
		if( string.equals("W")){
			return new One(new Direction(int3, int4), new Position(int1, int2), hero);
		}
		else if( string.equals("X")){
			return new Two(new Direction(int3, int4), new Position(int1, int2), hero);
		}
		else if( string.equals("Y")){
			return new Three(new Direction(int3, int4), new Position(int1, int2), hero);
		}
		else if( string.equals("Z")){
			return new Four(new Direction(int3, int4), new Position(int1, int2), hero);
		}
		else{
			return null;
		}
	}


}