package gameshop;


public class GameInformation implements Cloneable {
    private String gamename;
    private String gamedetails;
    private double gameprice;

    public GameInformation(String name, String details, double price) {
        this.gamename = name;
        this.gamedetails = details;
        this.gameprice = price;
    }
    
    public String getName() {
        return gamename;
    }

    public void setName(String name) {
        if (name.length() == 0) {
            this.gamename = "Unnamed Ice Cream Menu";
        } else {
            this.gamename = name;
        }
    }
    
    public String getDetails() {
        return gamedetails;
    }

    public void setDetails(String details) {
        if (details.length() == 0) {
            this.gamedetails = "No details";
        } else {
            this.gamedetails = details;
        }
    }

    public double getPrice() {
        return gameprice;
    }

    public void setPrice(double price) {
        if (price <= 0) {
            this.gameprice = 200;
        } else {
            this.gameprice = price;
        }
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
