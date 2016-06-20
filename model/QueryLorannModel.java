package model;

import contract.ILorannModel;

public class QueryLorannModel {

	public QueryLorannModel() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * get select Model query by level
	 * @param level
	 * level of the lorannModel selected
	 * @return
	 * String of the query
	 */
	public static String getQuerySelectByLevel(int level)
	{
		return "call Map(" + level +");";
	}


/**
 * get insert query lorannModel
 * @param lorannModel
 * lorannModel to insert
 * @param level
 * level of the lorannModel ( used as a label )
 * @return
 * String of the query
 */
	public static String getQueryInsertLorannModel(ILorannModel lorannModel, int level) {
		return "INSERT INTO niveau (ID_Niveau, Hauteur, Largeur, Niveau) VALUES ( null," + lorannModel.getMapHeight() + "," + lorannModel.getMapWidth() + "," + level + ");";
			}

}
