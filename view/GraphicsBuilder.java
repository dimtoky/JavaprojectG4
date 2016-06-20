package view;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Transparency;
import java.awt.image.BufferedImage;
import java.awt.image.ImageObserver;

import contract.ILorannModel;
import contract.IMobile;



/**
 * 
 * class which contain method to draw the panel Component from the Model
 *
 */
class GraphicsBuilder implements IGraphicsBuilder {
	private final ILorannModel	LorannModel;
	private BufferedImage					emptySky;

	public GraphicsBuilder(final ILorannModel LorannModel) {
		this.LorannModel = LorannModel;
		this.buildEmptySky();
	}

/**
 * translate the Model data into Graphic
 */
	public void applyModelToGraphic(final Graphics graphics, final ImageObserver observer) {
		graphics.drawImage(this.emptySky, 0, 0, observer);
      this.drawElements( graphics, observer);
		for (final IMobile mobile : this.LorannModel.getMobiles()) {
			this.drawMobile(mobile, graphics, observer);
		}
		
		String c = "Score : " + this.LorannModel.getScore();
		Font font = new Font(null, 30, 30);
		graphics.setFont(font);
		graphics.setColor(Color.YELLOW);
		graphics.drawString(c, 40, this.LorannModel.getHeight() - this.LorannModel.getElementHeight() + 20);
	}


	/**
	 * get the frame Width
	 */
	public int getGlobalWidth() {
		return this.LorannModel.getArea().getWidth();
	}

/**
 * get the frame Height
 */
	public int getGlobalHeight() {
		return this.LorannModel.getArea().getHeight();
	}

	/**
	 * build the Background image
	 */
	private void buildEmptySky() {
		this.emptySky = new BufferedImage(this.LorannModel.getArea().getWidth(), this.LorannModel.getArea().getHeight(), BufferedImage.TYPE_INT_RGB);
		final Graphics2D graphics = (Graphics2D) this.emptySky.getGraphics();
		
		
		graphics.drawImage(this.LorannModel.getArea().getImage(), 0, 0, this.LorannModel.getArea().getWidth(), this.LorannModel.getArea().getHeight(), null);
	}
    
	/**
	 * method to draw the Static elements from the model
	 * @param graphics
	 * the graphic used to draw the element usualy the Panel graphics
	 *  GamePanel
	 * @param observer
	 */
	private void drawElements( final Graphics graphics, final ImageObserver observer){
		BufferedImage ime ;
		Graphics graphicElem;

		for(int y = 0; y < this.LorannModel.getMapHeight(); y++){
			for(int x = 0; x < this.LorannModel.getMapWidth(); x++){
				ime = new BufferedImage(this.LorannModel.getElementWidth(), this.LorannModel.getElementHeight(), BufferedImage.TYPE_INT_ARGB);
				graphicElem = ime.getGraphics();
				graphicElem.drawImage(this.LorannModel.getElementImage(x, y), 0, 0,this.LorannModel.getElementWidth(), this.LorannModel.getElementHeight(), observer);
				graphics.drawImage(ime, x*(this.LorannModel.getElementWidth()), y*(this.LorannModel.getElementHeight()),this.LorannModel.getElementWidth(), this.LorannModel.getElementHeight(), observer);
			}
	}
	}
	
	
	
	/**
	 * method used to draw the mobile elements from the model
	 * @param mobile
	 * the model mobiles
	 *  Mobile
	 * @param graphics
	 * the graphics used to draw the mobile usualy the Panel graphics
	 *  GamePanel
	 * @param observer
	 */
	private void drawMobile(final IMobile mobile, final Graphics graphics, final ImageObserver observer) {
		final BufferedImage imageMobile = new BufferedImage(mobile.getWidth(), mobile.getHeight(), Transparency.TRANSLUCENT);
		final Graphics graphicsMobile = imageMobile.getGraphics();

		graphicsMobile.drawImage(mobile.getImage(), 0, 0, mobile.getWidth(), mobile.getHeight(), observer);
		graphics.drawImage(imageMobile, mobile.getPosition().getX()*mobile.getWidth(), mobile.getPosition().getY()*mobile.getHeight(), observer);

		
	}
}
