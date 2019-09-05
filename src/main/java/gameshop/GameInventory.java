package gameshop;


public class GameInventory {
	    public static final GameInformation[] Gamemenu = new GameInformation[]{
	            new GameInformation("Mario", "adventure", 800),
	            new GameInformation("Scoobydoo", "horror", 250),
	            new GameInformation("StreetFighting", "fighting", 100),
	            new GameInformation("Kurby", "adventure", 220),
	            new GameInformation("Hon", "Moba", 50),
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
	    
	    public static String getDetail(String game) {
	    	String details = "";
	    	for(int i = 0; i < Gamemenu.length; i++) {
	    		if(game.equals(Gamemenu[i].getName())) {
	    			details = Gamemenu[i].getDetails();
	    			
	    		} 
	    	}
	    	return details;
	    }
}


