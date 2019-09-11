package gameshop;

import javax.persistence.*;

@Entity
public class Game {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	private String gamename;
	private int gameprice;
	
	public Game() {
		super();
	}

	public Game(Long id, String name, int price) {
		super();
		this.id = id;
		this.gamename = name;
		this.gameprice = price;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return gamename;
	}
	public void setName(String name) {
		this.gamename = name;
	}
	public int getPrice() {
		return gameprice;
	}
	public void setPrice(int price) {
		this.gameprice = price;
	}
		
}