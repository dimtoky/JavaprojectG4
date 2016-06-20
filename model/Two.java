package model;
import contract.IMobile;
import contract.IPosition;
/**
 * 
 * Monster one Class extends AI
 *
 */
public class Two extends AI{
	
	  private static String IMAGE = "monster_2";
		public Two(Direction direction, IPosition position, IMobile target){
			super(direction, position, IMAGE, target, 'X');
	           
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
