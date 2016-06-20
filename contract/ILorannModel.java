package contract;

import java.awt.Image;
import java.io.IOException;

import java.util.concurrent.CopyOnWriteArrayList;


/**
 * interface implemented in LorannModel ( model ) and used in Controller and View
 * 
 *
 */
public interface ILorannModel {
	
	
	public IArea getArea();
	public void addMobile(final IMobile mobile);
	public void removeMobile(final IMobile mobile);
	public CopyOnWriteArrayList<IMobile> getMobiles();
	public void setMobilesHavesMoved();
	public IElement getElements( final int x, final int y);
	public IMobile getHero();
	public void addElement(final IElement element, final int x, final int y);
	public void addHeroMobile(final IMobile hero);
	public void setHero(IMobile hero);
	public void removeElement(int x,int y);
	public int getHeight();
	public int getWidth();
	public long getScore();
	public void setScore(long score);
	public void loadFile(final String fileName) throws IOException;
	  public void openGate();
	
		public boolean isFire();
		public void lauchFire();
		public int getMapHeight();
		public int getMapWidth();
		public int getElementHeight();
		public int getElementWidth();
		public IDoActionOnHeroes getElementAction(final int x, final int y);
		public Image getElementImage( final int x, final int y);
		public IElement[][] getAllElements();
		  public void closeGate();
		
}
