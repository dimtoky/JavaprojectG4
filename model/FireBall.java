package model;

import java.awt.Image;

import contract.IMobile;
import contract.IPosition;
import contract.Permeability;
/**
 * Fireball class extends IA
 * 
 *
 */
public class FireBall extends AI {
 private static String IMAGE = "fireball";
 public boolean findactivate = false;
 /**
  * 
  * @param direction
  *  Direction
  * @param position
  *  Position
  * @param target
  * fireball target usually the player
  */
	public FireBall(Direction direction, IPosition position, IMobile target) {
		super(direction, position, IMAGE, target, 'F');
	}
/**
 * return true
 */
	public boolean isWeapon(){
		return true;
	}
	
	/**
	 * method used to remove Weapon from model when hit a monster
	 */
	public boolean monsterHit(){
		this.lorannModel.removeMobile(this);
		return true;
	}
	
	public void move(){
		
		if(findactivate){
		if(tryfind){
			 this.findPathToTarget();
			switch (direction.orientation){
			case UP :
				if(isMovePossible(position.getX(), this.position.getY() + direction.getDirY()))
				{
		     position.setX( position.getX() + direction.getDirX());
		     position.setY(position.getY() + direction.getDirY());}
				else{
		    	 tryfind = !tryfind; findactivate = false;
		 		this.getDirection().setDirX(-(this.getDirection().getDirX()));
				this.getDirection().setDirY(-(this.getDirection().getDirY()));
		     }
		break;
			case DOWN :
				if(isMovePossible(position.getX(), this.position.getY() + direction.getDirY()))
				{
		     position.setX( position.getX() + direction.getDirX());
		     position.setY(position.getY() + direction.getDirY());}
				else{
		    	 tryfind = !tryfind; findactivate = false;
		 		this.getDirection().setDirX(-(this.getDirection().getDirX()));
				this.getDirection().setDirY(-(this.getDirection().getDirY()));
		     }
	       	break;
			case LEFT :
				if(isMovePossible(position.getX() + direction.getDirX(), this.position.getY()))
				{
		     position.setX( position.getX() + direction.getDirX());
		     position.setY(position.getY() + direction.getDirY());}
				else{
			    	 tryfind = !tryfind; findactivate = false;
			 		this.getDirection().setDirX(-(this.getDirection().getDirX()));
					this.getDirection().setDirY(-(this.getDirection().getDirY()));
			     }
				break;
			case RIGHT :
				if(isMovePossible(position.getX() + direction.getDirX(), this.position.getY()))
				{
		     position.setX( position.getX() + direction.getDirX());
		     position.setY(position.getY() + direction.getDirY());}
				else{
			    	 tryfind = !tryfind;	findactivate = false;
			 		this.getDirection().setDirX(-(this.getDirection().getDirX()));
					this.getDirection().setDirY(-(this.getDirection().getDirY()));
			     }
				break;
			case UP_L :
				if(isMovePossible(position.getX() + direction.getDirX(), this.position.getY() + direction.getDirY()))
				{
		     position.setX( position.getX() + direction.getDirX());
		     position.setY(position.getY() + direction.getDirY());}
				else if(isMovePossible(position.getX() + direction.getDirX(), this.position.getY())){
					 position.setX( position.getX() + direction.getDirX());	 tryfind = !tryfind; findactivate = false;
				}
				else if(isMovePossible(position.getX(), this.position.getY() + direction.getDirY())){
					 position.setY(position.getY() + direction.getDirY()); 	 tryfind = !tryfind; findactivate = false;
				}
				else{
			    	 tryfind = !tryfind; findactivate = false;
			 		this.getDirection().setDirX(-(this.getDirection().getDirX()));
					this.getDirection().setDirY(-(this.getDirection().getDirY()));
			     }
				break;
			case UP_R :
				if(isMovePossible(position.getX() + direction.getDirX(), this.position.getY() + direction.getDirY()))
				{
		     position.setX( position.getX() + direction.getDirX());
		     position.setY(position.getY() + direction.getDirY());}
				else if(isMovePossible(position.getX() + direction.getDirX(), this.position.getY())){
					 position.setX( position.getX() + direction.getDirX()); 	 tryfind = !tryfind; findactivate = false;
				}
				else if(isMovePossible(position.getX(), this.position.getY() + direction.getDirY())){
					 position.setY(position.getY() + direction.getDirY()); 	 tryfind = !tryfind; findactivate = false;
				}
				else{
			    	 tryfind = !tryfind; findactivate = false;
			 		this.getDirection().setDirX(-(this.getDirection().getDirX()));
					this.getDirection().setDirY(-(this.getDirection().getDirY()));
			     }
				break;
			case DOWN_L :
				if(isMovePossible(position.getX() + direction.getDirX(), this.position.getY() + direction.getDirY()))
				{
		     position.setX( position.getX() + direction.getDirX());
		     position.setY(position.getY() + direction.getDirY());}
				else if(isMovePossible(position.getX() + direction.getDirX(), this.position.getY())){
					 position.setX( position.getX() + direction.getDirX()); 	 tryfind = !tryfind; findactivate = false;
				}
				else if(isMovePossible(position.getX(), this.position.getY() + direction.getDirY())){
					 position.setY(position.getY() + direction.getDirY()); 	 tryfind = !tryfind; findactivate = false;
				}
				else{
			    	 tryfind = !tryfind; findactivate = false;
			 		this.getDirection().setDirX(-(this.getDirection().getDirX()));
					this.getDirection().setDirY(-(this.getDirection().getDirY()));
			     }
				break;
			case DOWN_R :
				if(isMovePossible(position.getX() + direction.getDirX(), this.position.getY() + direction.getDirY()))
				{
		     position.setX( position.getX() + direction.getDirX());
		     position.setY(position.getY() + direction.getDirY());}
				else if(isMovePossible(position.getX() + direction.getDirX(), this.position.getY())){
					 position.setX( position.getX() + direction.getDirX()); 	 tryfind = !tryfind; findactivate = false;
				}
				else if(isMovePossible(position.getX(), this.position.getY() + direction.getDirY())){
					 position.setY(position.getY() + direction.getDirY()); 	 tryfind = !tryfind; findactivate = false;
				}
				else{
			   	 tryfind = !tryfind; findactivate = false;
					this.getDirection().setDirX(-(this.getDirection().getDirX()));
					this.getDirection().setDirY(-(this.getDirection().getDirY()));
			     }
				break;
				default :
					break;
			}}
		 else{
				switch (direction.orientation){
				case UP :
					if(isMovePossible(position.getX(), this.position.getY() + direction.getDirY()))
					{
			     position.setX( position.getX() + direction.getDirX());
			     position.setY(position.getY() + direction.getDirY());}
					else{
			    	 tryfind = !tryfind;
			 		this.getDirection().setDirX(-(this.getDirection().getDirX()));
					this.getDirection().setDirY(-(this.getDirection().getDirY()));
			     }
			break;
				case DOWN :
					if(isMovePossible(position.getX(), this.position.getY() + direction.getDirY()))
					{
			     position.setX( position.getX() + direction.getDirX());
			     position.setY(position.getY() + direction.getDirY());}
					else{
			    	 tryfind = !tryfind;
			 		this.getDirection().setDirX(-(this.getDirection().getDirX()));
					this.getDirection().setDirY(-(this.getDirection().getDirY()));
			     }
		       	break;
				case LEFT :
					if(isMovePossible(position.getX() + direction.getDirX(), this.position.getY()))
					{
			     position.setX( position.getX() + direction.getDirX());
			     position.setY(position.getY() + direction.getDirY());}
					else{
				    	 tryfind = !tryfind;
				 		this.getDirection().setDirX(-(this.getDirection().getDirX()));
						this.getDirection().setDirY(-(this.getDirection().getDirY()));
				     }
					break;
				case RIGHT :
					if(isMovePossible(position.getX() + direction.getDirX(), this.position.getY()))
					{
			     position.setX( position.getX() + direction.getDirX());
			     position.setY(position.getY() + direction.getDirY());}
					else{
				    	 tryfind = !tryfind;	
				 		this.getDirection().setDirX(-(this.getDirection().getDirX()));
						this.getDirection().setDirY(-(this.getDirection().getDirY()));
				     }
					break;
				case UP_L :
					if(isMovePossible(position.getX() + direction.getDirX(), this.position.getY() + direction.getDirY()))
					{
			     position.setX( position.getX() + direction.getDirX());
			     position.setY(position.getY() + direction.getDirY());}
					else if(isMovePossible(position.getX() + direction.getDirX(), this.position.getY())){
						 position.setX( position.getX() + direction.getDirX());
					}
					else if(isMovePossible(position.getX(), this.position.getY() + direction.getDirY())){
						 position.setY(position.getY() + direction.getDirY());
					}
					else{
				    	 tryfind = !tryfind;
				 		this.getDirection().setDirX(-(this.getDirection().getDirX()));
						this.getDirection().setDirY(-(this.getDirection().getDirY()));
				     }
					break;
				case UP_R :
					if(isMovePossible(position.getX() + direction.getDirX(), this.position.getY() + direction.getDirY()))
					{
			     position.setX( position.getX() + direction.getDirX());
			     position.setY(position.getY() + direction.getDirY());}
					else if(isMovePossible(position.getX() + direction.getDirX(), this.position.getY())){
						 position.setX( position.getX() + direction.getDirX());
					}
					else if(isMovePossible(position.getX(), this.position.getY() + direction.getDirY())){
						 position.setY(position.getY() + direction.getDirY());
					}
					else{
				    	 tryfind = !tryfind;	
				 		this.getDirection().setDirX(-(this.getDirection().getDirX()));
						this.getDirection().setDirY(-(this.getDirection().getDirY()));
				     }
					break;
				case DOWN_L :
					if(isMovePossible(position.getX() + direction.getDirX(), this.position.getY() + direction.getDirY()))
					{
			     position.setX( position.getX() + direction.getDirX());
			     position.setY(position.getY() + direction.getDirY());}
					else if(isMovePossible(position.getX() + direction.getDirX(), this.position.getY())){
						 position.setX( position.getX() + direction.getDirX());
					}
					else if(isMovePossible(position.getX(), this.position.getY() + direction.getDirY())){
						 position.setY(position.getY() + direction.getDirY());
					}
					else{
				    	 tryfind = !tryfind;
				 		this.getDirection().setDirX(-(this.getDirection().getDirX()));
						this.getDirection().setDirY(-(this.getDirection().getDirY()));
				     }
					break;
				case DOWN_R :
					if(isMovePossible(position.getX() + direction.getDirX(), this.position.getY() + direction.getDirY()))
					{
			     position.setX( position.getX() + direction.getDirX());
			     position.setY(position.getY() + direction.getDirY());}
					else if(isMovePossible(position.getX() + direction.getDirX(), this.position.getY())){
						 position.setX( position.getX() + direction.getDirX());
					}
					else if(isMovePossible(position.getX(), this.position.getY() + direction.getDirY())){
						 position.setY(position.getY() + direction.getDirY());
					}
					else{
				   	 tryfind = !tryfind;
						this.getDirection().setDirX(-(this.getDirection().getDirX()));
						this.getDirection().setDirY(-(this.getDirection().getDirY()));
				     }
					break;
					default :
						break;
				}
	}}
		
		
		
		else{
			switch (direction.orientation){
			case UP :
				if(isMovePossible(position.getX(), this.position.getY() + direction.getDirY()))
				{
		     position.setX( position.getX() + direction.getDirX());
		     position.setY(position.getY() + direction.getDirY());}	else{
		    	 this.direction.setDirX(-(this.direction.getDirX()));
		    	 this.direction.setDirY(this.direction.getDirY());
		     }	
		break;
			case DOWN :
				if(isMovePossible(position.getX(), this.position.getY() + direction.getDirY()))
				{
		     position.setX( position.getX() + direction.getDirX());
		     position.setY(position.getY() + direction.getDirY());}else{
		    	 this.direction.setDirX(-(this.direction.getDirX()));
		    	 this.direction.setDirY(this.direction.getDirY());
		     }
	       	break;
			case LEFT :
				if(isMovePossible(position.getX() + direction.getDirX(), this.position.getY()))
				{
		     position.setX( position.getX() + direction.getDirX());
		     position.setY(position.getY() + direction.getDirY());}else{
		    	 this.direction.setDirX(-(this.direction.getDirX()));
		    	 this.direction.setDirY(this.direction.getDirY());
		     }
				break;
			case RIGHT :
				if(isMovePossible(position.getX() + direction.getDirX(), this.position.getY()))
				{
		     position.setX( position.getX() + direction.getDirX());
		     position.setY(position.getY() + direction.getDirY());}else{
		    	 this.direction.setDirX(-(this.direction.getDirX()));
		    	 this.direction.setDirY(this.direction.getDirY());
		     }
				break;
			case UP_L :
				if(isMovePossible(position.getX() + direction.getDirX(), this.position.getY() + direction.getDirY()))
				{
		     position.setX( position.getX() + direction.getDirX());
		     position.setY(position.getY() + direction.getDirY());}
				else if(isMovePossible(position.getX() + direction.getDirX(), this.position.getY())){
					 position.setX( position.getX() + direction.getDirX());
				}
				else if(isMovePossible(position.getX(), this.position.getY() + direction.getDirY())){
					 position.setY(position.getY() + direction.getDirY());
				}else{
			    	 this.direction.setDirX(-(this.direction.getDirX()));
			    	 this.direction.setDirY(this.direction.getDirY());
			     }
				break;
			case UP_R :
				if(isMovePossible(position.getX() + direction.getDirX(), this.position.getY() + direction.getDirY()))
				{
		     position.setX( position.getX() + direction.getDirX());
		     position.setY(position.getY() + direction.getDirY());}
				else if(isMovePossible(position.getX() + direction.getDirX(), this.position.getY())){
					 position.setX( position.getX() + direction.getDirX());
				}
				else if(isMovePossible(position.getX(), this.position.getY() + direction.getDirY())){
					 position.setY(position.getY() + direction.getDirY());
				}else{
			    	 this.direction.setDirX(-(this.direction.getDirX()));
			    	 this.direction.setDirY(this.direction.getDirY());
			     }
				break;
			case DOWN_L :
				if(isMovePossible(position.getX() + direction.getDirX(), this.position.getY() + direction.getDirY()))
				{
		     position.setX( position.getX() + direction.getDirX());
		     position.setY(position.getY() + direction.getDirY());}
				else if(isMovePossible(position.getX() + direction.getDirX(), this.position.getY())){
					 position.setX( position.getX() + direction.getDirX());
				}
				else if(isMovePossible(position.getX(), this.position.getY() + direction.getDirY())){
					 position.setY(position.getY() + direction.getDirY());
				}else{
			    	 this.direction.setDirX(-(this.direction.getDirX()));
			    	 this.direction.setDirY(this.direction.getDirY());
			     }
				break;
			case DOWN_R :
				if(isMovePossible(position.getX() + direction.getDirX(), this.position.getY() + direction.getDirY()))
				{
		     position.setX( position.getX() + direction.getDirX());
		     position.setY(position.getY() + direction.getDirY());}
				else if(isMovePossible(position.getX() + direction.getDirX(), this.position.getY())){
					 position.setX( position.getX() + direction.getDirX());
				}
				else if(isMovePossible(position.getX(), this.position.getY() + direction.getDirY())){
					 position.setY(position.getY() + direction.getDirY());
				}else{
			    	 this.direction.setDirX(-(this.direction.getDirX()));
			    	 this.direction.setDirY(this.direction.getDirY());
			     }
				break;
				default :
					break;
			}
		}
	

	}
	/**
	 * method to manage collision with static elements
	 * @return
	 * true if there is no collision
	 */
	protected boolean isMovePossible(int x, int y) {
	       if(( lorannModel.getElements(x, y).getPermeability() != Permeability.BLOCKING )){
	    	   return true;
	       }
	       return false;
	}
	/**
	 * get current frame from the animator
	 */
	public Image getImage(){
		this.getSprite().update(System.currentTimeMillis());
		return this.getSprite().getImage();
	}
	
}
