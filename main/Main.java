package main;



import java.io.IOException;
import java.sql.SQLException;

import controller.LorannController;
import controller.MenuWindow;
import model.Direction;
import model.Four;
import model.Hero;
import model.LorannModel;
import model.One;
import model.Position;
import model.Three;
import model.Two;
import view.LorannView;

/**
 * main class which use the Model View Controller
 * first show the menu and choose a Model ( using its level as a label ) then
 * instantiate the selected model from the database ( add it into database if the result is null )
 * then instantiate the controller by adding the Model in its constructor parameter
 * then instantiate the view by adding both the model and the controller
 * and then use the play method from the controller to start the game
 * @see LorannModel
 * @see LorannController
 * @see LorannView
 * 
 */
public class Main {


	@SuppressWarnings("static-access")
	public static void main(String[] args) throws ClassNotFoundException, SQLException, IOException {
	
	
		
		
		boolean exit= false;
		do
		{
		
		MenuWindow menu = new MenuWindow();
     LorannModel lorannModel;
     
     while( !menu.start){
    	System.out.println(menu.start);
    	 if( menu.start){
    	
    		lorannModel = LorannModel.generateLorannModel(menu.level);
    		if( lorannModel == null)
    		{
    		lorannModel = new LorannModel("level" + menu.level + ".txt");
    		Hero hero;
    		switch (menu.level) {
			case 1:
				 hero = new Hero(new Position(2, 2));
       		  lorannModel.addHeroMobile(hero);
               hero.lastposition.setX(lorannModel.getHero().getPosition().getX());
               lorannModel.addMobile(new One(new Direction(0,1), new Position(3,10), hero));
               lorannModel.addMobile(new Two(new Direction(0,1), new Position(10,3), hero));
                break;
            case 2:
            	 hero = new Hero(new Position(2, 2));
       		  lorannModel.addHeroMobile(hero);
               hero.lastposition.setX(lorannModel.getHero().getPosition().getX());
               lorannModel.addMobile(new One(new Direction(0,1), new Position(6,6), hero));
                lorannModel.addMobile(new Two(new Direction(0,1), new Position(3,10), hero));
                lorannModel.addMobile(new Three(new Direction(0,1), new Position(10,3), hero));
                break;
            case 3:
            	 hero = new Hero(new Position(2, 2));
       		  lorannModel.addHeroMobile(hero);
               hero.lastposition.setX(lorannModel.getHero().getPosition().getX());
               lorannModel.addMobile(new One(new Direction(0,1), new Position(6,6), hero));
                lorannModel.addMobile(new Two(new Direction(0,1), new Position(11,10), hero));
                lorannModel.addMobile(new Three(new Direction(0,1), new Position(18,3), hero));
                lorannModel.addMobile(new Four( new Direction(0, -1), new Position( 18, 4), hero));
				break;
            case 4:
             hero = new Hero(new Position(18, 5));
        		  lorannModel.addHeroMobile(hero);
                hero.lastposition.setX(lorannModel.getHero().getPosition().getX());
                lorannModel.addMobile(new One(new Direction(0,1), new Position(1,3), hero));
                 lorannModel.addMobile(new Two(new Direction(0,1), new Position(1,5), hero));
                 lorannModel.addMobile(new Three(new Direction(0,1), new Position(1,7), hero));
				break;
             case 5:
            	 hero = new Hero(new Position(18, 5));
       		  lorannModel.addHeroMobile(hero);
               hero.lastposition.setX(lorannModel.getHero().getPosition().getX());
               lorannModel.addMobile(new One(new Direction(0,1), new Position(6,9), hero));
                lorannModel.addMobile(new Two(new Direction(0,1), new Position(2,2), hero));
                lorannModel.addMobile(new Three(new Direction(0,1), new Position(3,5), hero));
                lorannModel.addMobile(new Four( new Direction(0, -1), new Position( 4, 2), hero));
				break; 
			default:
				break;
		
    		}
    		if(lorannModel.dao.open()){
     lorannModel.dao.insertLorannModel(lorannModel, menu.level);
      lorannModel.dao.close();}
    		
    		}
    		
    		
		final LorannController LorannController = new LorannController(lorannModel);
		
		final LorannView LorannView = new LorannView(LorannController, lorannModel, lorannModel);
		
		LorannController.setViewSystem(LorannView);
		LorannController.play();
		
       }}
     menu.start = false;
	}while(!exit);

	}}
