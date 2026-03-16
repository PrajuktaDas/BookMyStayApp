import java.util.*;

public class BookMyStayApp {

    public static void main(String[] args) {

        System.out.println("Booking History and Reporting\n");
        System.out.println("Booking History Report");

        List<String[]> bookingHistory = new ArrayList<>();

        bookingHistory.add(new String[]{"Abhi", "Single"});
        bookingHistory.add(new String[]{"Subha", "Double"});
        bookingHistory.add(new String[]{"Vanmathi", "Suite"});

        for (String[] booking : bookingHistory) {
            System.out.println("Guest: " + booking[0] + ", Room Type: " + booking[1]);
        }
    }
}