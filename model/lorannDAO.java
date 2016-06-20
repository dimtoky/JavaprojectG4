package model;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import contract.IMobile;

/**
 * 
 * Database manager class used in the model
 */

public class lorannDAO {
	 private Connection connection;
	   private java.sql.Statement statement;
	   public static String URL = "jdbc:mysql://localhost/lorannbdd";
	   public static String LOGIN = "root";
	   public static String PASSWORD = "";
		public lorannDAO() throws ClassNotFoundException {
			 this.connection = null;
			 this.statement = null;
			 }
		
		/**
		 * establish connection with database
		 * @return
		 * return true if connection worked
		 */
		public Boolean open() {
		try {
		Class.forName("com.mysql.jdbc.Driver");
		this.connection = DriverManager.getConnection(lorannDAO.URL,
		lorannDAO.LOGIN, lorannDAO.PASSWORD);
		this.statement = this.connection.createStatement();
		} catch (final ClassNotFoundException e) {
		e.printStackTrace();
		return false;
		} catch (final SQLException e) {
			
		e.printStackTrace();
		System.out.println("ERROR : Connection � la base de donn�e impossible");
		return false;
		}
		return true;
		} 
			/**
			 * end connection with database
			 */
		public void close(){
				
				try {
					this.connection.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		
		/**
		 * execute a query in the database
		 * @param query
		 * the query to execute
		 * @return
		 *  Statment
		 */
		public ResultSet executeQuery(String query){
			try {
				return this.statement.executeQuery(query);
			} catch (SQLException e) {
				e.printStackTrace();
			 return null;
			}}
		/**
		 * execute an update query in the database
		 * @param query
		 * the update to execute
		 * @return
		 *  Statment
		 */
		@SuppressWarnings("static-access")
		public int executeUpdate(String query){
			try {
				return this.statement.executeUpdate(query, statement.RETURN_GENERATED_KEYS);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return -1;
			}}
		
		

		/**
		 * get the last inserted autoincrement ID
		 * @return
		 * the last autoincrement ID or 0 if it failed
		 */
		 private int getLastId() {
			 try {
			 ResultSet resultSet = this.statement.getGeneratedKeys();
			 if (resultSet.next()) {
			 return resultSet.getInt(1);
			 }
			 } catch (SQLException e) {
			 e.printStackTrace();
			 }
			 return 0;
			 } 
		 
		 
		 /**
		  * get the Model by the inserted level from the database
		  * @param level
		  * the level of the map
		  * @return
		  * return the Model
		  *  LorannModel
		  * @throws SQLException
		  */
		 public LorannModel getILorannModelByLevel(int level) throws SQLException 
		 {
			 ResultSet resultworld = this.executeQuery(QueryLorannModel.getQuerySelectByLevel(level));
			
			 if (resultworld.next())
			 {
			 int width = resultworld.getInt("Largeur"), heigth = resultworld.getInt("Hauteur");
			 MotionlessElement elements[][] = new MotionlessElement[width][heigth];
			 LorannModel lorannModel = new LorannModel(width, heigth, elements);
			 ResultSet resultelement = this.executeQuery(QueryElement.getQuerySelectByLevel(level));
			 for ( ; resultelement.next() ;)
			 {
			 lorannModel.addElement(MotionlessElements.getFromFileSymbol(resultelement.getString("Char_elements").charAt(0)), resultelement.getInt("elements_x"), resultelement.getInt("elements_y"));
			 }
			 
			 for ( int x = 0; x < width; x++){
				 for(int y = 0; y < heigth ; y++){
					 if( elements[x][y] == null){
						 lorannModel.addElement(MotionlessElements.VIDE, x, y);
					 }
				 }
			 }
			 Hero hero;
			 resultelement = this.executeQuery(QueryMobile.getQueryHeroSelectByLevel(level));
			if(resultelement.next()){
			 hero = new Hero(new Position(resultelement.getInt("mobile_x"), resultelement.getInt("mobile_y")));
			lorannModel.addHeroMobile(hero);
			resultelement = this.executeQuery(QueryMobile.getQuerySelectByLevel(level));
			 for( ; resultelement.next(); ){
			 lorannModel.addMobile(MotionlessElements.getMobileFromFileSymbol(resultelement.getString("Char_mobile"), resultelement.getInt("mobile_x"), resultelement.getInt("mobile_y"), resultelement.getInt("direction_x"), resultelement.getInt("direction_y"), hero));
				
			 }
			 
			}
			 return lorannModel;}
			 
			 else {return null;}
		 }
		 
		 
		 /**
		  * insert the Model into database
		  * @param lorannModel
		  * the Model
		  *  LorannModel
		  * @param level
		  * the level ( used as a label in the database )
		  */
		 public void insertLorannModel(LorannModel lorannModel, int level)
		 {
			int bool =  this.executeUpdate(QueryLorannModel.getQueryInsertLorannModel(lorannModel, level));
			if (bool != -1){
			 int idnettleworld = this.getLastId();
			 int x = 0, y = 0;
			 for (  MotionlessElement[] elements : lorannModel.getAllElements()){
				 for ( MotionlessElement element : elements )
				 {
					 System.out.println(getIdFromFileSymbole(element.getFileSymbol()) + " " + x  + " " + y + " " + idnettleworld);
					 this.executeUpdate(QueryElement.getQueryInsertElement(getIdFromFileSymbole(element.getFileSymbol()), x, y, idnettleworld));
					 y++;
				 }
				 x++;
				 y = 0;
			 }
			 for( IMobile mobile : lorannModel.getMobiles()){
				 System.out.println(mobile);
				 this.executeUpdate(QueryMobile.getQueryInsertMobile(mobile, getMobIdFromFileSymbol(mobile.getFileSymbol()), idnettleworld));}
				
				
				}
			 
			}
		 /**
		  * get the Element ID of the database from the element character
		  *  MotionlessElement
		  * @param c
		  * element character
		  * @return
		  * Element ID or -1 if it failed
		  */
		 public static int getIdFromFileSymbole(char c){
			 if( c == 'B'){
				 return 3;
			 }
			 else if( c == 'V'){
				 return 1;
			 }
			 else if ( c == 'H'){
				 return 2;
			 }
			 else if ( c == 'C'){
				 return 4;
			 }
			 else if ( c == 'G'){
				 return 5;
			 }
			 else if ( c == ' '){
				 return 6;
			 }
			 else if ( c == 'P'){
				 return 7;
			 }else return -1;
		 }
		 
		 /**
		  * get the Mobile ID from the character
		  *  Mobile
		  * @param c
		  * Mobile character
		  * @return
		  * Mobile ID or -1 if it failed
		  */
		 public static int getMobIdFromFileSymbol(char c){
			 if ( c == 'L') return 1;
			 else if (c == 'W') return 2;
			 else if ( c == 'X') return 3;
			 else if ( c == 'Y') return 4;
			 else if ( c == 'Z') return 5;
			 else return -1;
			 
		 }
}
