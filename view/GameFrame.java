package view;

import java.awt.HeadlessException;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Observable;

import javax.swing.JFrame;

import contract.IOrderPerformer;
import contract.LorannViewToControl;



/**
 * the game frame extends JFrame and implement a Keylistener and used in the lorannView to instantiate
 * the game view
 * 
 *
 */
public class GameFrame extends JFrame implements KeyListener {
	private static final long			serialVersionUID	= -1112124206501543946L;
	private final IOrderPerformer	orderPerformer;
/**
 * 
 * @param title
 * the frame title
 * @param orderPerformer
 * the controller
 *   LorannController
 * @param graphicsBuilder
 * the graphic builder which use the panel graphics
 *   graphicBuilder
 * @param observable
 * the Model
 *   LorannModel
 * @throws HeadlessException
 */
	public GameFrame(final String title, final IOrderPerformer orderPerformer, final IGraphicsBuilder graphicsBuilder, final Observable observable)
			throws HeadlessException {
		this.orderPerformer = orderPerformer;

		this.setTitle(title);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false);
		this.addKeyListener(this);
		this.setVisible(true);
		final GamePanel gamePanel = new GamePanel(graphicsBuilder);
		this.setContentPane(gamePanel);
		this.setSize(graphicsBuilder.getGlobalWidth() + this.getInsets().left + this.getInsets().right,
				graphicsBuilder.getGlobalHeight() + this.getInsets().top + this.getInsets().bottom);
		this.setLocationRelativeTo(null);
		observable.addObserver(gamePanel);

		this.setVisible(true);
	}

/**
 * action to perform when a key is pressed
 */
	public void keyPressed(final KeyEvent keyEvent) {
		this.orderPerformer.orderPerform(LorannViewToControl.pkeyCodeToUserOrder(keyEvent.getKeyCode()));
	}
/**
 * action to perform when a key is released
 */
	public void keyReleased(final KeyEvent keyEvent) {
		this.orderPerformer.orderPerform(LorannViewToControl.rkeyCodeToUserOrder(keyEvent.getKeyCode()));

	}

	/**
	 * action to perform when a key is typed
	 */
	public void keyTyped(final KeyEvent keyEvent) {
		// TODO Auto-generated method stub

	}

}
