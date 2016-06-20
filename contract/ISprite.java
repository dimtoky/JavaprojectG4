package contract;

import java.awt.Image;
/**
 * interface Implemented in Animator and used in Element
 * 
 *
 */
public interface ISprite {

	Image getImage();
	public void update(long time);
	public void play();
	public void pause();
	public void resume();
	public void stop();
	public void setSpeed(long speed);
	public void setCurrentFrame(int frame );
}