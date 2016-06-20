package model;
import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.io.StringWriter;


import javax.imageio.ImageIO;

import contract.ISprite;


/**
 * 
 * a sprite Manager used to return an Image depending on the orientation or the object
 *
 */
public class Animator extends StringWriter implements ISprite {
	
public	Image[] frames;

public	Image sprite;

	private volatile boolean running = false;
	private long previousTime, speed = 200;
	private int frameAtPause, currentFrame = 0;
	
	/**
	 * 
	 * @param c
	 * a symobole ( deprecated )
	 * @param image
	 * the Image prefix in the Image Folder
	 */
	public Animator(String c, String image){
		this.write(c);
	
		buildAllImage(image);
	
	}
	
	public Animator(String c){
      this(c, "noimage");
	}
	
	/**
	 * build all the image of an element from the Image folder
	 * @param name
	 * the image prefix
	 * 
	 */
	public void buildAllImage(String name) {
		frames = new Image[9];
		try {
			frames[Orientation.UP.ordinal()] = ImageIO.read(new File( "Data/images/" + name + "_UP.png"));
			frames[Orientation.DOWN.ordinal()] = ImageIO.read(new File( "Data/images/" + name + "_DOWN.png"));
			frames[Orientation.LEFT.ordinal()] = ImageIO.read(new File( "Data/images/" + name + "_LEFT.png"));
			frames[Orientation.RIGHT.ordinal()] = ImageIO.read(new File( "Data/images/" + name + "_RIGHT.png"));
			frames[Orientation.UP_L.ordinal()] = ImageIO.read(new File( "Data/images/" + name + "_UPL.png"));
			frames[Orientation.UP_R.ordinal()] = ImageIO.read(new File( "Data/images/" + name + "_UPR.png"));
			frames[Orientation.DOWN_L.ordinal()] = ImageIO.read(new File( "Data/images/" + name + "_DOWNL.png"));
			frames[Orientation.DOWN_R.ordinal()] = ImageIO.read(new File( "Data/images/" + name + "_DOWNR.png"));
			frames[Orientation.STILL.ordinal()] = ImageIO.read(new File( "Data/images/" + name + "_STILL.png"));

		
		} catch (IOException e) {
			for(int x = 0; x < frames.length; x ++){
				try {
					frames[x] = ImageIO.read(new File( "Data/images/" + name + ".png"));
				} catch (IOException e1) {
					try {
						frames[x] = ImageIO.read(new File( "Data/images/" + "noimage" + ".png"));
					} catch (IOException e2) {
						e2.printStackTrace();
					}
				
				}
				
			}
	
		}
		
	}
	

	/**
	 * change the current Image returned in the getImage method
	 *  getImage()
	 */
	public void setCurrentFrame(int frame ){
		this.currentFrame = frame;
	}
	
	
	public void update(long time){
		
		if (running){
			if(time - previousTime >= speed){
				
				
				//update animation
				currentFrame++;
				try{
					sprite = frames[currentFrame];
				}catch(IndexOutOfBoundsException e){
					currentFrame = 0;
					
				}
				previousTime = time;
			}
			
		}
		
		
	}
	
	
	/**
	 * play the animation which will update the current frame
	 */
	public void play(){
		running = true;
		currentFrame = 0;
		previousTime = 0;
		frameAtPause = 0;
		

	}

	/**
	 * pause the animation
	 */
	public void pause(){
		if(running == true){
		frameAtPause = currentFrame;
		running = false;
		}
		
	}
	
	/**
	 * resume the animation
	 */
	public void resume(){
		if(running == false)
		{
		currentFrame = frameAtPause;
		running = true;
		}
		
	}
	
	/**
	 * stop the animation
	 */
	public void stop(){
		running = false;
		currentFrame = 0;
		previousTime = 0;
		frameAtPause = 0;
		
	}

/**
 * set the animation speed ( frame switching speed )
 */
	public void setSpeed(long speed) {
		this.speed = speed;
	}
	
	/**
	 * get the current Frame ( Image )
	 *  Image
	 * 
	 */
	public Image getImage(){
		try{
			sprite = frames[currentFrame];
		}catch(IndexOutOfBoundsException e){
			currentFrame = 0;	
		}
		return sprite;
	}

}

