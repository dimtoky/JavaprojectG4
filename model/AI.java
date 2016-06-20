package model;

import contract.IMobile;
import contract.IPosition;
import contract.Permeability;
/**
 * Mother of all the AI Mobile extends Mobile
 *
 */
public class AI extends Mobile{

	public IMobile target;
	public boolean tryfind = false;
	/**
	 * 
	 * @param direction
	 * the AI Direction
	 *  Direction
	 * @param position
	 * the AI Position
	 *  Position
	 * @param image
	 * the AI Image
	 * @param target
	 * the AI target which he will Focus usually the player
	 * @param fileSymbol
	 * the file symbole used by the Database
	 */
	public AI(Direction direction, IPosition position, String image,IMobile target, char fileSymbol ) {
		super(direction, position, image, fileSymbol);
		this.target = target;
		
	}
	/**
	 * set the target
	 * @param target
	 * the AI target  which is a Mobile
	 *  Mobile
	 */
	public void setTaget(IMobile target){
		this.target = target;
	}
	
	
	/**
	 * method used to make the AI move
	 */
	public void move(){
		

	 if(tryfind){
		 this.findPathToTarget();
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
				 position.setX( position.getX() + direction.getDirX());	 tryfind = !tryfind;
			}
			else if(isMovePossible(position.getX(), this.position.getY() + direction.getDirY())){
				 position.setY(position.getY() + direction.getDirY()); 	 tryfind = !tryfind;
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
				 position.setX( position.getX() + direction.getDirX()); 	 tryfind = !tryfind;
			}
			else if(isMovePossible(position.getX(), this.position.getY() + direction.getDirY())){
				 position.setY(position.getY() + direction.getDirY()); 	 tryfind = !tryfind;
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
				 position.setX( position.getX() + direction.getDirX()); 	 tryfind = !tryfind;
			}
			else if(isMovePossible(position.getX(), this.position.getY() + direction.getDirY())){
				 position.setY(position.getY() + direction.getDirY()); 	 tryfind = !tryfind;
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
				 position.setX( position.getX() + direction.getDirX()); 	 tryfind = !tryfind;
			}
			else if(isMovePossible(position.getX(), this.position.getY() + direction.getDirY())){
				 position.setY(position.getY() + direction.getDirY()); 	 tryfind = !tryfind;
			}
			else{
		   	 tryfind = !tryfind;
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
	 }		
	}
	
	
	/**
	 * method used to manage collision with static Elements
	 */
	protected boolean isMovePossible(int x, int y) {
	       if(( lorannModel.getElements(x, y).getPermeability() != Permeability.BLOCKING ) && !(isAIonPosition(x,y))){
	    	   return true;
	       }
	       return false;
	}
	 
	 
	/**
	 * 
	 * @param x
	 * position x of the AI
	 * @param y
	 * position y of the AI
	 * @return
	 * return true if there will be collision with another Mobile which isn't a player
	 */
	private boolean isAIonPosition(int x, int y){
		for(IMobile mobile : this.lorannModel.getMobiles()){
			if( mobile.isWeapon()){
				if(mobile.getPosition().getX() == x && mobile.getPosition().getY() == y){
					return true;
				}
			}
			else if( mobile.isMonster()){
				if(mobile.getPosition().getX() == x && mobile.getPosition().getY() == y){
					return true;
				}
			}
		}
		return false;
		
	}
	/**
	 * Pathfinding method used by move
	 *  move()
	 */
	public void findPathToTarget(){
		if( this.position.getX() < target.getPosition().getX()){
			this.getDirection().setDirX(1);
		}
		if( this.position.getX() > target.getPosition().getX()){
			this.getDirection().setDirX(-1);
		}
		if( this.position.getY() < target.getPosition().getY()){
			this.getDirection().setDirY(1);
		}
		if( this.position.getY() > target.getPosition().getY()){
			this.getDirection().setDirY(-1);
		}
	}



}
