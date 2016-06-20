package contract;
import java.awt.Image;


/**
 * interface implemented in Area and used in Model
 *
 * 
 *
 */
public interface IArea {

	public IDimension getDimension();

	public int getWidth();

	public int getHeight();

	public Image getImage();
}