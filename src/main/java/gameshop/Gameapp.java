package gameshop;
import java.util.ArrayList;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import main.IceCreamMenu;
import main.SpringBootApp;

@SpringBootApplication
@RestController
public class Gameapp {
	public static ArrayList<String> Game = new ArrayList<String>();
	double price, pricecancle;
	String allgame = "You have buy  ", allgamebuy, gamecancle;
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
    	if(Game.contains(GameInventory.ShowGame(select).getName())) {
    		return "You have baught it.Are you want to buy again ^ ^?";
    	} else {
    		Game.add(GameInventory.ShowGame(select).getName());
        	price += GameInventory.ShowGame(select).getPrice();
            return "Buying  " + GameInventory.ShowGame(select).getName() + "  Success";
    	}
    }
    
    @RequestMapping(value = "/game/cancle/{select}")
    String cancleGame(@PathVariable int select) throws CloneNotSupportedException {
    	pricecancle = GameInventory.getPriceofgame(Game.get(select-1));
    	gamecancle = Game.get(select-1);
    	price -= pricecancle;
    	Game.remove(select-1);
    	return "Success Cancle Order  " + gamecancle;
    }
    
    @RequestMapping(value = "/watch")
    String busket() {
    	allgamebuy = "";
    	for(int i = 0; i < Game.size(); i++) {
    		String convert = Integer.toString(i+1);
    		allgamebuy += convert + ". " + Game.get(i);
    		if(i < Game.size()-1) {
    			allgamebuy += "\n";
    		}
    	}
    	return allgamebuy;
    }

    @RequestMapping("/exit")
    String exit() {
    	allgame = "You have buy  ";
    	for(int i = 0; i < Game.size(); i++) {
    		allgame += Game.get(i);
    		if(i < Game.size()-1) {
    			allgame += ", ";
    		}
    	}
    	String numberAsString = String.valueOf(price);
    	allgame += "  " + numberAsString;
    	allgame += " Bath Thank you";
        return allgame;
    }
}
