package view;

import java.awt.Graphics;
import java.awt.image.ImageObserver;
/**
 * 
 * interface implemented by the graphicBuilder to be used by the Panel
 *
 */
public interface IGraphicsBuilder {
	public void applyModelToGraphic(Graphics graphics, ImageObserver observer);

	public int getGlobalWidth();

	public int getGlobalHeight();
}
