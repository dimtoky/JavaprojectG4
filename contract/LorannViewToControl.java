package contract;

import java.awt.event.KeyEvent;

import javax.swing.JOptionPane;

/**
 * abstract class used as a key to userOrder translator
 * 
 *
 */
public abstract class LorannViewToControl {
	/**
	 * translate user inpute into UserOrder
	 * @param keyCode
	 * keycode ( user input )
	 * @return
	 * return UserOrder
	 * @see UserOrder
	 */
	public static UserOrder pkeyCodeToUserOrder(final int keyCode) {
		switch (keyCode) {
			case KeyEvent.VK_UP:
				return UserOrder.UP;
			case KeyEvent.VK_RIGHT:
				return UserOrder.RIGHT;
			case KeyEvent.VK_DOWN:
				return UserOrder.DOWN;
			case KeyEvent.VK_LEFT:
				return UserOrder.LEFT;
			case KeyEvent.VK_SPACE:
				return UserOrder.SHOOT;
			default:
				return UserOrder.NOP;
		}
	}

	/**
	 * translate user inpute into UserOrder
	 * @param keyCode
	 * keycode ( user input )
	 * @return
	 * return UserOrder
	 * @see UserOrder
	 */
	public static UserOrder rkeyCodeToUserOrder(final int keyCode) {
		switch (keyCode) {
			case KeyEvent.VK_UP: case KeyEvent.VK_DOWN:
				return UserOrder.STILLY;
			case KeyEvent.VK_RIGHT: case KeyEvent.VK_LEFT:
				return UserOrder.STILLX;
			default:
				return UserOrder.NOP;
		}
	}
	
	/**
	 * display a message on screen
	 * @param message
	 * message to show
	 */
	public static void displayMessage(final String message) {
		JOptionPane.showMessageDialog(null, message);
	}

}
