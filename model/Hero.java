package model;

import java.awt.Image;

import contract.IPosition;
/**
 * Hero class extends Mobile
 *
 */
public class Hero extends Mobile {
	

	public static String IMAGE = "lorann";

	public Hero(IPosition position) {
		super(new Direction(0, 0), position, IMAGE, 'L');
		this.lastposition = new Position(this.getPosition());

    
	}
	
	/**
	 * return true
	 */
	public boolean isPlayer(){
		return true;
	}
	
	/**
	 * remove player from model and instantiate Dead on its position
	 *  Dead
	 *  LorannModel
	 */
	public boolean monsterHit(){
		this.getLorannModel().addMobile(new Dead((this.position)));
		this.getLorannModel().removeMobile(this);
		return true;
	}
	
	/**
	 * remove player from model and instantiate Dead on its last position
	 *  Dead
	 * LorannModel
	 */
	public boolean hit() {
		this.getLorannModel().addMobile(new Dead((this.lastposition)));
		this.getLorannModel().removeMobile(this);
		return true;
	}
	
	/**
	 * get current frame from the Animator depending on Orientation
	 *  Direction
	 *  Animator
	 *  Orientation
	 */
	public Image getImage(){
		switch (direction.orientation){
		case STILL :
			this.getSprite().update(System.currentTimeMillis());
			return this.getSprite().getImage();
		case UP :
			System.out.println("up");
			this.getSprite().setCurrentFrame(Orientation.UP.ordinal());
			break;
		case DOWN :
			System.out.println("down");
			this.getSprite().setCurrentFrame(Orientation.DOWN.ordinal());
			break;
		case LEFT :
			System.out.println("left");
			this.getSprite().setCurrentFrame(Orientation.LEFT.ordinal());
			break;
		case RIGHT :
			System.out.println("right");
			this.getSprite().setCurrentFrame(Orientation.RIGHT.ordinal());
			break;
		case UP_L :
			System.out.println("up left");
			this.getSprite().setCurrentFrame(Orientation.UP_L.ordinal());
			break;
		case UP_R :
			System.out.println("up right");
			this.getSprite().setCurrentFrame(Orientation.UP_R.ordinal());
			break;
		case DOWN_L :
			System.out.println("down left");
			this.getSprite().setCurrentFrame(Orientation.DOWN_L.ordinal());
			break;
		case DOWN_R :
			System.out.println("down right");
			this.getSprite().setCurrentFrame(Orientation.DOWN_R.ordinal());
			break;
			default :
				this.getSprite().setCurrentFrame(Orientation.STILL.ordinal());
				break;
			
		}
		
		return this.getSprite().getImage();
	}
	
	/**
	 * change the player position depending on its current direction
	 *  Direction
	 *  Position
	 */
	public void move(){

		lastposition.setX(this.lorannModel.getHero().getPosition().getX());
		lastposition.setY(this.position.getY());
		super.move();
		
	}

}
