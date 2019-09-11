package gameshop;
public class GameInventory {
	    public static final Game[] Gamemenu = new Game[]{
	            new Game((long) 1, "Mario", 800),
	            new Game((long) 2, "Scoobydoo", 250),
	            new Game((long) 3, "StreetFighting", 100),
	            new Game((long) 4, "Kurby", 220),
	            new Game((long) 5, "Hon", 50),
	    };

	    public static Game[] ShowAllgame() {
	        return Gamemenu;
	    }
	    
	    public static Game ShowGame(int select) {
	        return (Game) Gamemenu[select];
	    }
	    
	    public static Game getGamemenu(int select) throws CloneNotSupportedException {
	        return (Game) Gamemenu[select];
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
	    
//	    public static String getDetail(String game) {
//	    	String details = "";
//	    	for(int i = 0; i < Gamemenu.length; i++) {
//	    		if(game.equals(Gamemenu[i].getName())) {
//	    			details = Gamemenu[i].getDetails();
//	    			
//	    		} 
//	    	}
//	    	return details;
//	    }
}

