package view;

import java.util.Observable;

import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;

import contract.ILorannModel;
import contract.IOrderPerformer;
import contract.IViewSystem;


/**
 * The game View used to interact with the user ( the user interface ) implement Runnable
 * 
 *
 */
public class LorannView implements IViewSystem, Runnable {
	 final GraphicsBuilder	graphicsBuilder;
	 final IOrderPerformer	orderPerformer;
	 final Observable			observable;
	 GameFrame							gameFrame;

	/**
	 * constructor of the Game View used  in the main class to instantiate a new view and run a new thread
	 * to run it
	 *  Main
	 * @param orderPerformer
	 * the Controller
	 *  LorannController
	 * @param lorannModel
	 * The Model
	 *  LorannModel
	 * @param observable
	 * The Model which imlement Observable
	 *  LorannModel
	 *  Observable
	 */
	public LorannView(final IOrderPerformer orderPerformer, final ILorannModel lorannModel, final Observable observable) {
		this.observable = observable;
		this.graphicsBuilder = new GraphicsBuilder(lorannModel);
		this.orderPerformer = orderPerformer;
		SwingUtilities.invokeLater(this);
	}

   /**
    * run the Game Frame
    */
	public void run() {
		this.gameFrame = new GameFrame("Lorann", this.orderPerformer, this.graphicsBuilder, this.observable);
	}

   /**
    * display messages
    */
	public void displayMessage(final String message) {
		JOptionPane.showMessageDialog(null, message);
	}


	/**
	 * close the game frame
	 */
	public void closeAll() {
		this.gameFrame.dispose();
	}
}
