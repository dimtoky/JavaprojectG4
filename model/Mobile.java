package model;

import java.awt.Image;

import contract.IDimension;
import contract.IDirection;
import contract.ILorannModel;
import contract.IMobile;
import contract.IPosition;
import contract.Permeability;

/**
 * abstract class extended by all the Mobile elements, extend Element
 * 
 * 
 *
 */
public class Mobile extends Element implements IMobile {
	protected Direction				direction;
	   public IPosition lastposition;
	protected final IPosition	position;
	protected final IDimension	dimension;
	protected ILorannModel	lorannModel;
	protected Image						images[];
    protected char fileSymbol;

    /**
     * constructor of a Mobile
     * @param direction
     * direction of the mobile 
     *  Direction
     * @param position
     * position of the mobile
     *  Position
     * @param image
     * prefix of the mobile image used in the mobile Animator
     *  Animator
     * @param fileSymbol
     * file Symbol of the mobile used by the database
     *  lorannDAO
     */
	public Mobile(final Direction direction, final IPosition position,  final String image, char fileSymbol) {
		super(new Animator("K", image), Permeability.BLOCKING);
		this.direction = direction;
		this.position = position;
		this.dimension = new Dimension(WIDTH, HEIGHT);
		this.fileSymbol = fileSymbol;
      
		this.getSprite().play();

	}

/**
 * get the mobile Direction
 *  Direction
 */
	public IDirection getDirection() {
		return this.direction;
	}


/**
 * set the mobile direction
 *  Direction
 */
	public void setDirection(final IDirection direction) {
		this.direction = (Direction) direction;
	}

/**
 * get the mobile Position
 *  Position
 */

	public IPosition getPosition() {
		return this.position;
	}


	/**
	 * get the mobile dimension
	 *  Dimension
	 */
	public IDimension getDimension() {
		return this.dimension;
	}




/**
 * method used to make the mobile move ( change position ) depending on its direction
 *  Position
 *  Direction
 * 
 */
	public void move() {
		switch (direction.orientation){
		case UP :
			if(isMovePossible(position.getX(), this.position.getY() + direction.getDirY()))
			{
	     position.setX( position.getX() + direction.getDirX());
	     position.setY(position.getY() + direction.getDirY());}		
	break;
		case DOWN :
			if(isMovePossible(position.getX(), this.position.getY() + direction.getDirY()))
			{
	     position.setX( position.getX() + direction.getDirX());
	     position.setY(position.getY() + direction.getDirY());}
       	break;
		case LEFT :
			if(isMovePossible(position.getX() + direction.getDirX(), this.position.getY()))
			{
	     position.setX( position.getX() + direction.getDirX());
	     position.setY(position.getY() + direction.getDirY());}
			break;
		case RIGHT :
			if(isMovePossible(position.getX() + direction.getDirX(), this.position.getY()))
			{
	     position.setX( position.getX() + direction.getDirX());
	     position.setY(position.getY() + direction.getDirY());}
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
			break;
			default :
				break;
		}}

/**
 * manage mobile collision with a static element
 *  MotionlessElement
 * @param x
 * mobile next x position
 * @param y
 * mobile next y position
 * @return
 * return true if element on next position has a PENETRABLE permeability, else return false
 *  Permeability
 */
	protected boolean isMovePossible(int x, int y) {
       if(( lorannModel.getElements(x, y).getPermeability() != Permeability.BLOCKING )){
    	   return true;
       }
       
       else return false;
	}


/**
 * overwrite in Hero class to return true
 *  Hero
 * @return
 * return false
 */
	public boolean isPlayer() {
		return false;
	}

/**
 * overwrite in monster class to return true
 *  One
 *  Two
 *  Three
 *  Four
 * @return
 * return false
 */
public boolean isMonster(){
	return false;
    }

/**
 * get the Model which use the mobile
 *  LorannModel
 */
	public ILorannModel getLorannModel() {
		return this.lorannModel;
	}

	
/**
 * set the model of the mobile
 *  LorannModel
 */
	public void setLorannModel(final ILorannModel lorannModel) {
		this.lorannModel = lorannModel;
	}


/**
 * overwrite in child class to do actions on hit
 *  AI
 *  Hero
 *  FireBall
 *
 */
	public boolean hit() {
		return false;
	}

	/**
	 * overwrite in child class to do actions on monsterhit
	 *  Hero
	 *  FireBall
	 *
	 */
public boolean monsterHit(){
	return false;
}

/**
 * overwrite in Weapon class to return true
 *  FireBall
 * @return
 * return false
 */
	public boolean isWeapon() {
		return false;
	}


/**
 * get Mobile Width
 */
	public int getWidth() {
				return this.getDimension().getWidth();
	}


/**
 * get Mobile Height
 */
	public int getHeight() {
	
				return this.getDimension().getHeight();
	}


	
/**
 * get Image ( currentFrame ) from animator depending on direction ( Orientation )
 *  Animator
 *  Direction
 *  Orientation
 */
	@Override
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
 * get Mobile Position
 *  Position
 */
	public IPosition getlastposition() {
		return lastposition;
	}

/**
 * set mobile last Position
 * @param lastposition
 * last Position
 */
	public void setLastposition(IPosition lastposition) {
		this.lastposition = lastposition;
	}


	/**
	 * get the fileSymbol used in the database
	 *  lorannDAO
	 */
	
	public char getFileSymbol() {
		
		return fileSymbol;
	}






}
