package contract;


import java.awt.Image;


/**
 * interface implemented in Element and used in Model and GraphicBuilder ( view )
 * 
 * 
 * 
 *
 */
public interface IElement {

	ISprite getSprite();

	int getWidth();

	int getHeight();

	void setSprite(ISprite sprite);

	Permeability getPermeability();

	void setPermeability(Permeability permeability);

	void setLorannModel(ILorannModel lorannModel);
	ILorannModel getLorannModel();
	Image getImage();

}