package model;

import contract.IMobile;

public class QueryMobile {


/**
 * get select Mobile query ( minus Hero ) by level
 * @param level
 * level of the lorannModel
 *  LorannModel
 * @return
 * String of the query
 */
	public static String getQuerySelectByLevel(int level) {

         return "call GET_mobile("+ level + ");" ;
	}

	/**
	 * get insert Mobile query
	 * @param mobile
	 * mobile to insert
	 *  Mobile
	 * @param i
	 * mobile ID
	 * @param idnettleworld
	 * Model ID
	 * @return
	 * String of the query
	 */
	public static String getQueryInsertMobile(IMobile mobile, int i, int idnettleworld) {
		
    return "call SET_Mobile(" + idnettleworld + "," + i + "," + mobile.getPosition().getX() + "," + mobile.getPosition().getY() + "," + mobile.getDirection().getDirY() + "," + mobile.getDirection().getDirX() + ");" ;
	}

	/**
	 * get Select Hero query by level
	 * @param level
	 * level of the lorannModel
	 *  LorannModel
	 * @return
	 * String of the query
	 */
	public static String getQueryHeroSelectByLevel(int level) {

		return "call GET_Hero("+ level + ");";
	}




}
