package gameshop;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class Gameapp {
	// the Singleton Alternative
	public static ArrayList<Game> gamelist = new ArrayList<Game>();
	String gamename, allgamebuy, allgame;
	int pricegame, priceall;

	@Autowired
	private GameRepository gameRepository;

	public static void main(String[] args) {
		SpringApplication.run(Gameapp.class, args);
	}

	@GetMapping("/game")
	public List<Game> showAllGame() {
		return gameRepository.findAll();
	}

	@GetMapping("/game/{id}")
	public Game showGame(@PathVariable long id) {
		Optional<Game> game = gameRepository.findById(id);
		return game.get();
	}

	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public void addGame(@RequestBody Game game) {
		gameRepository.save(game);
	}
	
	@GetMapping(value = "/delete/{id}")
	public void addGame(@PathVariable long id) {
		gameRepository.deleteById(id);
	}

	@GetMapping(value = "/game/buy/{id}")
	String BuyGame(@PathVariable long id) throws CloneNotSupportedException {
		Optional<Game> game = gameRepository.findById(id);
		if (gamelist.contains(game.get())) {
			return "You have baught it.You can't buy again ^ ^?";
		} else {
			gamelist.add(game.get());
			gameRepository.deleteById(id);
			System.out.println(gamelist);
			return "Buying  " + game.get().getName() + "  Price: " + game.get().getPrice() + " Bath Success";

		}
	}
	//id-1 because when you watch you will see item list and number 1, 2, 3 but in array index begin at 0
	@RequestMapping(value = "/game/cancle/{id}")
	String cancleGame(@PathVariable int id) throws CloneNotSupportedException {
		if (gamelist.size() >= (id-1)) {
			gamename = gamelist.get(id-1).getName();
			pricegame = gamelist.get(id-1).getPrice();
			gameRepository.save(gamelist.get(id-1));
			gamelist.remove(id-1);
			System.out.println(gamelist);
		} else {
			return "You can't cancle this order";
		}
		return "Success Cancle Order  " + gamename + "  Price  " + pricegame + " Bath";
	}
  
    @RequestMapping(value = "/watch")
    String busket() {
    	if(gamelist.size() > 0) {
    		allgamebuy = "";
        	for(int i = 0; i < gamelist.size(); i++) {
        		String convert = Integer.toString(i+1);
        		allgamebuy += convert + ". " + gamelist.get(i).getName() + "  Price: " + gamelist.get(i).getPrice() + " Bath";
        		allgamebuy += "\n";
        	}
        	return allgamebuy;
    	} else {
    		return "Don't have any order";
    	}
    	
    }    
    @RequestMapping("/exit")
    String exit() {
    	priceall = 0;
    	allgame = "";
    	if(gamelist.size() > 0) {
        	for(int i = 0; i < gamelist.size(); i++) {
        		if(gamelist.get(i).getName().length() > 0) {
        			allgame += gamelist.get(i).getName();
            		priceall += gamelist.get(i).getPrice();
        		}
        		if(i < gamelist.size()-1) {
        			allgame += ",  ";
        		}
        	}
        	allgame += "\nAllprice is: " + priceall;
        	allgame += " Bath Thank you";
            return "You have buy  " + allgame ;
    	} else {
    		return "You don't have any order";
    	}
    	
    }
}
