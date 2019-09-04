package gameshop;


public class GameInventory {
	    public static final GameInformation[] Gamemenu = new GameInformation[]{
	            new GameInformation("Mario", "adventure", 800000),
	            new GameInformation("Scoobydoo", "horror", 250000),
	            new GameInformation("StreetFighting", "fighting", 100000000),
	            new GameInformation("Kurby", "adventure", 220),
	            new GameInformation("Hon", "Moba", 1),
	    };

	    public static GameInformation[] ShowAllgame() {
	        return Gamemenu;
	    }
	    
	    public static GameInformation ShowGame(int select) {
	        return (GameInformation) Gamemenu[select];
	    }
	    
	    public static GameInformation getGamemenu(int select) throws CloneNotSupportedException {
	        return (GameInformation) Gamemenu[select].clone();
	    }
	     
	    public static double getPriceofgame(String game) {
	    	double price1 = 0;
	    	for(int i = 0; i < Gamemenu.length; i++) {
	    		if(game.equals(Gamemenu[i].getName())) {
	    			price1 = Gamemenu[i].getPrice();
	    			
	    		} 
	    	}
	    	return price1;
	    }
}
