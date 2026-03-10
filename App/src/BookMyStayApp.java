import java.util.HashMap;

// Version 4.1 - Refactored Room class
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


// Version 4.1
class SingleRoom extends Room {
    public SingleRoom() {
        super(1, 250, 1500.0);
    }
}


// Version 4.1
class DoubleRoom extends Room {
    public DoubleRoom() {
        super(2, 400, 2500.0);
    }
}


// Version 4.1
class SuiteRoom extends Room {
    public SuiteRoom() {
        super(3, 750, 5000.0);
    }
}


// Version 4.1 - Inventory (State Holder)
class RoomInventory {

    private HashMap<String, Integer> inventory;

    public RoomInventory() {

        inventory = new HashMap<>();

        inventory.put("Single Room", 5);
        inventory.put("Double Room", 3);
        inventory.put("Suite Room", 2);
    }

    // Read-only access
    public int getAvailability(String roomType) {
        return inventory.getOrDefault(roomType, 0);
    }
}


// Version 4.0 - New Search Service
class RoomSearchService {

    public void searchRooms(Room single, Room dbl, Room suite, RoomInventory inventory) {

        System.out.println("Room Search\n");

        if (inventory.getAvailability("Single Room") > 0) {

            System.out.println("Single Room:");
            System.out.println("Beds: " + single.getBeds());
            System.out.println("Size: " + single.getSize() + " sqft");
            System.out.println("Price per night: " + single.getPrice());
            System.out.println("Available: " + inventory.getAvailability("Single Room") + "\n");
        }

        if (inventory.getAvailability("Double Room") > 0) {

            System.out.println("Double Room:");
            System.out.println("Beds: " + dbl.getBeds());
            System.out.println("Size: " + dbl.getSize() + " sqft");
            System.out.println("Price per night: " + dbl.getPrice());
            System.out.println("Available: " + inventory.getAvailability("Double Room") + "\n");
        }

        if (inventory.getAvailability("Suite Room") > 0) {

            System.out.println("Suite Room:");
            System.out.println("Beds: " + suite.getBeds());
            System.out.println("Size: " + suite.getSize() + " sqft");
            System.out.println("Price per night: " + suite.getPrice());
            System.out.println("Available: " + inventory.getAvailability("Suite Room"));
        }
    }
}


// Main Application
public class BookMyStayApp {

    public static void main(String[] args) {

        Room single = new SingleRoom();
        Room dbl = new DoubleRoom();
        Room suite = new SuiteRoom();

        RoomInventory inventory = new RoomInventory();

        RoomSearchService searchService = new RoomSearchService();

        searchService.searchRooms(single, dbl, suite, inventory);
    }
}