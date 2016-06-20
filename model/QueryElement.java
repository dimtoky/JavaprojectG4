package model;

/**
 * 
 * class used for to return element queries for the database
 *
 */
public class QueryElement {

	public QueryElement() {
		// TODO Auto-generated constructor stub
	}

/**
 * get select element query by level
 * @param level
 * level of the model
 *  LorannModel
 * @return
 * String of the query
 */
	public static String getQuerySelectByLevel(int level) {

		return "call GET_Elements(" + level + ");";
	}


/**
 * get insert Element query
 * @param i
 * Element ID
 * @param x
 * x position of the element
 * @param y
 * y position of the element
 * @param idnettleworld
 * Model ID
 * @return
 * String of the query
 */
	public static String getQueryInsertElement(int i, int x, int y, int idnettleworld) {
		
		return "call SET_Elements("+ idnettleworld + "," + i + "," + x + "," + y + ");";
	}












}
