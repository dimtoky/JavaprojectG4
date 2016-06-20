package controller;


import java.util.ArrayList;

import contract.ILorannModel;
import contract.IMobile;
import contract.IOrderPerformer;
import contract.IViewSystem;
import contract.UserOrder;
import contract.IDoActionOnHeroes;

/**
 * 
 *
 * class used as a controller between the view and the Model
 */
public class LorannController implements IOrderPerformer{

	private static int						TIME_SLEEP	= 100;
	private final ILorannModel	    lorannModel;
	boolean								isGameOver	= false;
	private boolean								isWin	= false;
	private IViewSystem						viewSystem;
	private SoundManager s;

	/**
	 * constructor of the controller used in the main class to instantiate a new controller
	 *  Main
	 * @param lorannModel
	 * the Model controlled by the Controller
	 */
	public LorannController(final ILorannModel lorannModel) {
		this.lorannModel = lorannModel;
		s = new SoundManager(){
		
			/**
			 * init all Ingame sounds and use the manager to play sounds
			 *  SoundManager
			 */
			@Override
			public void initSounds() {
			
				  sounds.add(new Sound( "Fire", "fire_fireball.wav"));
				  sounds.add(new Sound( "catchFire", "catch_fireball.wav"));
				  sounds.add(new Sound( "deathdoor", "death_door.wav"));
				  sounds.add(new Sound("deathmonster", "death_monster.wav"));
				  sounds.add(new Sound("dooropen", "door_open.wav"));
				  sounds.add(new Sound("heroescape", "hero_escape.wav"));
				  sounds.add(new Sound("monsterdeath", "monster_death.wav"));
				  sounds.add(new Sound("getpurse", "get_purse.wav"));
				  sounds.add(new Sound("ingame", "ingame.wav"));
			}
		};
   this.s.loopSound("ingame");
		
	}
/**
 * method which tell which action the model has to perform depending on the userOrder
 * @param userOrder
 * the user order
 *  UserOrder
 */

	public void orderPerform(final UserOrder userOrder) {

				switch (userOrder) {
					case UP:
						lorannModel.getHero().getDirection().setDirY(-1);;
						break;
					case RIGHT:
						lorannModel.getHero().getDirection().setDirX(1);
						break;
					case DOWN:
						lorannModel.getHero().getDirection().setDirY(1);
						break;
					case LEFT:
						lorannModel.getHero().getDirection().setDirX(-1);
						break;
                    case STILLX:
						lorannModel.getHero().getDirection().setDirX(0);
						break;
                    case STILLY:
                    	lorannModel.getHero().getDirection().setDirY(0);
	                  break;
					case SHOOT:
							this.lorannModel.lauchFire();
							s.playSound("Fire");
							
							
							break;
					case NOP:
					default:
						break;
						
				}	
				
				
				
		
	}


	/**
	 * method to manage the collision of the player on monsters
	 * @param player
	 * the player
	 *  Hero
	 * 
	 */

	private void manageCollisionPlayerMonster(final IMobile player) {
		for( IMobile monster : this.lorannModel.getMobiles()){
			if(monster.isMonster()){
				if( (player.getPosition().getX() == monster.getPosition().getX()) && (player.getPosition().getY() == monster.getPosition().getY())){
					player.monsterHit();
					s.playSound("deathmonster");
					s.stopSound("ingame");
					this.isGameOver = true;
				}
			}
		}	
	}
	
	/**
	 * method used to manage collision of the weapon on the player
	 * @param weapon
	 * the weapon
	 *  FireBall
	 * 
	 */
	private void manageCollisionWeaponPlayer(final IMobile weapon) {
	  if( weapon.getPosition().getX() == this.lorannModel.getHero().getPosition().getX() && weapon.getPosition().getY() == this.lorannModel.getHero().getPosition().getY()){
		  weapon.monsterHit();
	  }
	}
	
	
	/**
	 * method used to manage collision of the weapon on monsters
	 * @param weapon
	 * the weapon
	 *  FireBall
	 * 
	 */

	private void manageCollisionWeaponMonster(final IMobile weapon){
		for( IMobile monster : this.lorannModel.getMobiles()){
			if(monster.isMonster()){
				if( (weapon.getPosition().getX() == monster.getPosition().getX()) && (weapon.getPosition().getY() == monster.getPosition().getY())){
					 s.playSound("monsterdeath");
					weapon.monsterHit();
					monster.hit();
				}
			}
		}
	}
	
	/**
	 * method used to manage collision of the player on the weapon
	 * @param Player
	 * the player
	 *  Hero
	 * 
	 */
	private void manageCollisionPlayerWeapon(final IMobile Player){
		for( IMobile weapon : this.lorannModel.getMobiles()){
			if(weapon.isWeapon()){
				if( weapon.getPosition().getX() == Player.getPosition().getX() && weapon.getPosition().getY() == Player.getPosition().getY()){
					weapon.monsterHit();
				}
			}
		}
	}
	
	/**
	 * method used to manage collision of monsters on the player
	 * @param monster
	 * the monster
	 *  AI
	 * 
	 */
	private void manageCollisionMonsterPlayer(IMobile monster){
	if(monster.getPosition().getX() == this.lorannModel.getHero().getPosition().getX() &&
			monster.getPosition().getY() == this.lorannModel.getHero().getPosition().getY())
	{
		s.playSound("deathmonster");
		s.stopSound("ingame");
		this.lorannModel.getHero().monsterHit();
		this.isGameOver = true;
	}
	}
	/**
	 * method used to manage collision of monsters on the weapon
	 * @param monster
	 * the monster
	 *  AI
	 * 
	 */
	private void manageCollisionMonsterWeapon(IMobile monster){
       for(IMobile weapon : this.lorannModel.getMobiles()){
    	   if( weapon.isWeapon()){
    		   if( weapon.getPosition().getX() == monster.getPosition().getX() && 
    			   weapon.getPosition().getY() == monster.getPosition().getY()){
    				 s.playSound("monsterdeath");
    			   weapon.monsterHit();
    				   monster.hit();
    			   }
    	   }
       }
		
	}
    /**
     * 
     * method used to start the game loop and controls
     */
	public void play() {
		this.gameLoop();
		if(isWin){
			viewSystem.displayMessage("You Win !");
		}else{
		this.viewSystem.displayMessage("Game Over !");
		}
		this.viewSystem.closeAll();
	}

	
	/**
	 * game loop method used by the play method to loop the controls
	 * and which use all the Managecollision and resolveanswer methods
	 *  play()
	 */
	private void gameLoop() {
		while (!this.isGameOver) {
			try {
				Thread.sleep(TIME_SLEEP);
			} catch (final InterruptedException ex) {
				Thread.currentThread().interrupt();
			}

			final ArrayList<IMobile> initialMobiles = new ArrayList<IMobile>();
			for (final IMobile mobile : this.lorannModel.getMobiles()) {
				initialMobiles.add(mobile);
			}
			for (final IMobile mobile : initialMobiles) {
				  mobile.move();
				if (mobile.isWeapon()) {
					this.manageCollisionWeaponMonster(mobile);
					this.manageCollisionWeaponPlayer(mobile);
				}
				if(mobile.isPlayer()){
					this.manageCollisionPlayerMonster(mobile);
				    this.manageCollisionPlayerWeapon(mobile);
				}
				if(mobile.isMonster()){
				this.manageCollisionMonsterPlayer(mobile);
				this.manageCollisionMonsterWeapon(mobile);
				}
			}
			this.getWorldAnswer();
			this.lorannModel.setMobilesHavesMoved();
		}
	}

	public void setViewSystem(final IViewSystem viewSystem) {
		this.viewSystem = viewSystem;
	}
	
	/**
	 * method used to manage collision between the player and static objects
	 * and which is used by the loop method
	 *  gameLoop()
	 */
	private void getWorldAnswer(){

		final int x = this.lorannModel.getHero().getPosition().getX();
		final int y = this.lorannModel.getHero().getPosition().getY();
		final IDoActionOnHeroes element = this.lorannModel.getElementAction(x, y);

		switch (element.getActionOnHeroes()) {
		case EXIT:
			this.lorannModel.removeMobile(this.lorannModel.getHero());
			this.resolveExit();
			break;
		case KILL:
			this.resolveKill();
			break;
		case MONEY:
			this.lorannModel.removeElement(x, y);
			this.resolveMoney();
			break;
		case UNLOCK:
			this.lorannModel.removeElement(x, y);
			this.resolveUnlock();
			break;
		case NOP:
		default:
			break;}
		
		
		
		
		}
	
	

/**
 * method used to manage collision of the player with a Crystal
 * and which is used by the getworldanswer method
 *  Crystal
 *  getWorldAnswer
 * 
 */
	private void resolveUnlock() {
		s.playSound("dooropen");
		this.lorannModel.openGate();
		
	}

	/**
	 * method used to manage collision of the player with a Purse
	 * and which is used by the getworldanswer method
	 *  Purse
	 *  getWorldAnswer
	 * 
	 */
	private void resolveMoney() {
		s.playSound("getpurse");
    this.lorannModel.setScore(this.lorannModel.getScore() + 500);
		
	}

	/**
	 * method used to manage collision of the player with a closedgate
	 * and which is used by the getworldanswer method
	 *  Gate
	 *  getWorldAnswer
	 * 
	 */
	private void resolveKill() {
		s.playSound("deathdoor");
		s.stopSound("ingame");
		this.isGameOver = true;
		this.lorannModel.getHero().hit();
		
	}
	/**
	 * method used to manage collision of the player with an openedGate
	 * and which is used by the getworldanswer method
	 *  Gate
	 *  getWorldAnswer
	 * 
	 */
	private void resolveExit() {
		s.playSound("heroescape");
		s.stopSound("ingame");
		this.isWin = true;
     this.isGameOver = true;
		
		
	}
}
