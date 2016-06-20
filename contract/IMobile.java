package contract;

import java.awt.Image;
/**
 * interface implemented in Mobile and used in Model View Controller
 *
 *
 */
public interface IMobile {

	IDirection getDirection();

	void setDirection(IDirection direction);

	IPosition getPosition();

	IDimension getDimension();

	void move();

	boolean isPlayer();

	boolean isMonster();

	ILorannModel getLorannModel();

	void setLorannModel(ILorannModel lorannModel);

	boolean hit();

	boolean monsterHit();

	boolean isWeapon();

	int getWidth();

	int getHeight();

	Image getImage();
	
	IPosition getlastposition();
	char getFileSymbol();

}