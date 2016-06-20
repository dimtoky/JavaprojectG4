package view;

import java.awt.Graphics;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JPanel;
/**
 * 
 * @author wacim
 * the game Panel which extends JPanel used by the game frame where all the game image and graphics are drawn
 * using the GraphicBuilder class
 * 
 *
 */
class GamePanel extends JPanel implements Observer {
	private static final long				serialVersionUID	= 3987064896591403626L;
	private final IGraphicsBuilder	graphicsBuilder;
/**
 * 
 * @param graphicsBuilder
 * the class which contain the graphic method to draw the game graphics
 */
	public GamePanel(final IGraphicsBuilder graphicsBuilder) {
		this.graphicsBuilder = graphicsBuilder;
	}


	/**
	 * update the game panel
	 *  Observer
	 */
	public void update(final Observable arg0, final Object arg1) {
		this.repaint();
	}

	/**
	 * draw the component
	 *  JPanel
	 */
	@Override
	protected void paintComponent(final Graphics graphics) {
		this.graphicsBuilder.applyModelToGraphic(graphics, this);
	}

}
