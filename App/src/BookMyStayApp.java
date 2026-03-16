import java.io.*;
import java.util.*;

class Reservation implements Serializable {
    String guestName;
    String roomType;

    Reservation(String guestName, String roomType) {
        this.guestName = guestName;
        this.roomType = roomType;
    }
}

public class BookMyStayApp {

    public static void main(String[] args) {

        String fileName = "bookingData.ser";
        List<Reservation> bookingHistory = new ArrayList<>();

        bookingHistory.add(new Reservation("Abhi", "Single"));
        bookingHistory.add(new Reservation("Subha", "Double"));
        bookingHistory.add(new Reservation("Vanmathi", "Suite"));

        try {
            ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(fileName));
            out.writeObject(bookingHistory);
            out.close();
            System.out.println("Booking data saved successfully.");
        } catch (IOException e) {
            System.out.println("Error saving booking data.");
        }

        try {
            ObjectInputStream in = new ObjectInputStream(new FileInputStream(fileName));
            List<Reservation> recoveredData = (List<Reservation>) in.readObject();
            in.close();

            System.out.println("Recovered Booking Data:");

            for (Reservation r : recoveredData) {
                System.out.println("Guest: " + r.guestName + ", Room Type: " + r.roomType);
            }

        } catch (IOException | ClassNotFoundException e) {
            System.out.println("No previous booking data found.");
        }
    }
}