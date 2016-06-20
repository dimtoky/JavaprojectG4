package controller;
import java.applet.Applet;
import java.applet.AudioClip;
import java.io.File;


/**
 * 
 *
 * the Sound class which is used to stock sounds and use them
 */
public class Sound {
	
	@SuppressWarnings("unused")
	private static Sound staticSound = new Sound();
	
	public String name;
	public AudioClip sound;
	
	
	
	public Sound(){}
	/**
	 * 
	 * @param name
	 *  name of the sound
	 * @param filename
	 *  name of the file in the sounds folder
	 */
	public Sound(String name, String filename){
		this.name = name;
		try{
		
			sound = Applet.newAudioClip(new File("Data/Sounds/" + filename).toURI().toURL());
			System.out.println("coucou");
			
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	/**
	 * play the sound
	 */
	public void play(){
		new Thread(new Runnable(){

			
			public void run() {
				if(sound != null){ 
					sound.play();
				}
			}
			
			
		}).start();
	}
	
	/**
	 * loop a sound
	 */
	public void loop(){
		new Thread(new Runnable(){

			
			public void run() {
				if(sound != null){ 
					sound.loop();
				}
			}	
		}).start();
	}
	/**
	 * stop a sound
	 */
	public void stop(){
		if(sound !=null){
			sound.stop();
		}
	}
	
	
			

}
