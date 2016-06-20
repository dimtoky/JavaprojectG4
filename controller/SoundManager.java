package controller;
import java.util.ArrayList;

/**
 * 
 * 
 *class used to manage a group of sounds
 */
public abstract class SoundManager {
	
	public ArrayList<Sound> sounds = new ArrayList<Sound>();
	/**
	 * constructor of a sound manager which init all the added sounds
	 */
	public SoundManager(){
		
		initSounds();
		
	}
	/**
	 * init all the sound by adding them with the addSound Method
	 *  addSound(Sound sound)
	 */
	public abstract void initSounds();
	
	/**
	 * add a sound to the manager
	 * @param sound
	 * a sound from the Sound class
	 *  Sound
	 */
	public void addSound(Sound sound){
		
		sounds.add(sound);
	}

	
	/**
	 * remove a sound from the manager
	 * @param sound
	 * a sound from the Sound class
	 *  Sound
	 */
	public void removeSound(Sound sound){
		
		sounds.remove(sound);
	}
	
	/**
	 * play a sound
	 * @param name
	 * the sound name
	 *  Sound
	 */
	public void playSound(String name){
		
		for( Sound s : sounds){
			if(s.name.equals(name)){
				s.play();
			}
		}
	}
	
	/**
	 * loop a sound
	 * @param name
	 * the sound name
	 *  Sound
	 */
	public void loopSound(String name){
		
		for( Sound s : sounds){
			if(s.name.equals(name)){
				s.loop();
			}
		}
	}
	
	/**
	 * stop a sound
	 * @param name
	 * the sound name
	 *  Sound
	 */
	public void stopSound(String name){
		
		for( Sound s : sounds){
			if(s.name.equals(name)){
				s.stop();
			}
		}
	}
	/**
	 * stop all the sound added to the sound manager
	 */
	public void stopAllSound(){
		
		for(Sound s : sounds){
			s.stop();
		}
	}
	
}
