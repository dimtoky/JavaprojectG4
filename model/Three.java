package model;
import contract.IMobile;
import contract.IPosition;
/**
 * 
 * Monster one Class extends AI
 */
public class Three extends AI{
	
	  private static String IMAGE = "monster_3";
		public Three(Direction direction, IPosition position, IMobile target){
			super(direction, position, IMAGE, target, 'Y');
	           
		}

		
		
		/**
		 * @return
		 * return true
		 */
		public boolean isMonster(){
			return true;
		}
		/**
		 * remove from Model and instantiate Dead on its position
		 *  Dead
		 *  LorannModel
		 */
		public boolean hit(){
			this.getLorannModel().addMobile(new Dead((this.position)));
			this.getLorannModel().removeMobile(this);
			return true;
		}
	}

