import java.util.HashMap;

// Version 3.1 - Refactored Room class
abstract class Room {

    protected int beds;
    protected int size;
    protected double price;

    public Room(int beds, int size, double price) {
        this.beds = beds;
        this.size = size;
        this.price = price;
    }

    public int getBeds() {
        return beds;
    }

    public int getSize() {
        return size;
    }

    public double getPrice() {
        return price;
    }
}


// Version 3.1
class SingleRoom extends Room {

    public SingleRoom() {
        super(1, 250, 1500.0);
    }
}


// Version 3.1
class DoubleRoom extends Room {

    public DoubleRoom() {
        super(2, 400, 2500.0);
    }
}


// Version 3.1
class SuiteRoom extends Room {

    public SuiteRoom() {
        super(3, 750, 5000.0);
    }
}


// Version 3.0 - New Inventory Class
class RoomInventory {

    private HashMap<String, Integer> inventory;

    public RoomInventory() {
        inventory = new HashMap<>();

        inventory.put("Single Room", 5);
        inventory.put("Double Room", 3);
        inventory.put("Suite Room", 2);
    }

    public int getAvailability(String roomType) {
        return inventory.get(roomType);
    }

    public void updateAvailability(String roomType, int count) {
        inventory.put(roomType, count);
    }
}


// Main Application Class
public class BookMyStayApp {

    public static void main(String[] args) {

        Room single = new SingleRoom();
        Room dbl = new DoubleRoom();
        Room suite = new SuiteRoom();

        RoomInventory inventory = new RoomInventory();

        System.out.println("Hotel Room Inventory Status\n");

        System.out.println("Single Room:");
        System.out.println("Beds: " + single.getBeds());
        System.out.println("Size: " + single.getSize() + " sqft");
        System.out.println("Price per night: " + single.getPrice());
        System.out.println("Available Rooms: " + inventory.getAvailability("Single Room") + "\n");

        System.out.println("Double Room:");
        System.out.println("Beds: " + dbl.getBeds());
        System.out.println("Size: " + dbl.getSize() + " sqft");
        System.out.println("Price per night: " + dbl.getPrice());
        System.out.println("Available Rooms: " + inventory.getAvailability("Double Room") + "\n");

        System.out.println("Suite Room:");
        System.out.println("Beds: " + suite.getBeds());
        System.out.println("Size: " + suite.getSize() + " sqft");
        System.out.println("Price per night: " + suite.getPrice());
        System.out.println("Available Rooms: " + inventory.getAvailability("Suite Room"));
    }
}