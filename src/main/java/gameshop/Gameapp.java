package gameshop;
import java.util.ArrayList;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class Gameapp {
	public static ArrayList<String> Game = new ArrayList<String>();
	double price, pricecancle;
	String allgame = "You have buy  ", allgamebuy, gamecancle, gamedetails;
	int state = 0;
	
    public static void main(String[] args) {
        SpringApplication.run(Gameapp.class, args);
    }

    @RequestMapping("/")
    String home() {
        return "Smart Game Shop";
    }

    @RequestMapping("/game")
    GameInformation[] ShowAllgame() {
        return GameInventory.ShowAllgame();
    }

    @RequestMapping(value = "/game/buy/{select}")
    String BuyGame(@PathVariable int select) throws CloneNotSupportedException {
    	System.out.println(Game);
    	if(Game.contains(GameInventory.ShowGame(select-1).getName())) {
    		System.out.println(Game);
    		return "You have baught it.You can't buy again ^ ^?";
    	} else {
    		Game.add(GameInventory.ShowGame(select-1).getName());
        	price += GameInventory.ShowGame(select-1).getPrice();
        	System.out.println(Game);
            return "Buying  " + GameInventory.ShowGame(select-1).getName() + "  Price: " + GameInventory.ShowGame(select-1).getPrice() + " Bath Success";
            
    	}
    }
    
    @RequestMapping(value = "/game/cancle/{select}")
    String cancleGame(@PathVariable int select) throws CloneNotSupportedException {
    	System.out.println(Game);
    	if(Game.size() >= select) {
	    	pricecancle = GameInventory.getPriceofgame(Game.get(select-1));
	    	gamecancle = Game.get(select-1);
	    	price -= pricecancle;
	    	Game.remove(Game.get(select-1));
	    	System.out.println(Game);
    	} else {
    		System.out.println(Game);
    		return "You can't cancle this order";
    	}
    	return "Success Cancle Order  " + gamecancle + "  Price  " + pricecancle + " Bath";
    }
    
    @RequestMapping(value = "/watch")
    String busket() {
    	System.out.println(Game);
    	if(Game.size() > 0) {
    		allgamebuy = "";
        	for(int i = 0; i < Game.size(); i++) {
        		gamedetails = GameInventory.getDetail(Game.get(i));
        		pricecancle = GameInventory.getPriceofgame(Game.get(i));
        		String convert = Integer.toString(i+1);
        		allgamebuy += convert + ". " + Game.get(i) + "  Details:  " + gamedetails + "  Price: " + pricecancle + " Bath";
        		allgamebuy += "\n";
        	}
        	System.out.println(Game);
        	return allgamebuy;
    	} else {
    		System.out.println(Game);
    		return "Don't have any order";
    	}
    	
    }

    @RequestMapping("/exit")
    String exit() {
    	System.out.println(Game);
    	if(Game.size() > 0) {
    		allgame = "You have buy  ";
        	for(int i = 0; i < Game.size(); i++) {
        		allgame += Game.get(i);
        		if(i < Game.size()-1) {
        			allgame += ",  ";
        		}
        	}
        	String numberAsString = String.valueOf(price);
        	allgame += "\nAllprice is: " + numberAsString;
        	allgame += " Bath Thank you";
        	System.out.println(Game);
            return allgame;
    	} else {
    		System.out.println(Game);
    		return "You don't have any order";
    	}
    	
    }
}

