import java.util.*;

public class BookMyStayApp {

    public static void main(String[] args) {

        System.out.println("Booking Cancellation Processing");

        Map<String, String> reservations = new HashMap<>();
        reservations.put("Single-1", "Single");
        reservations.put("Double-1", "Double");

        Stack<String> rollbackStack = new Stack<>();

        String reservationId = "Single-1";

        if (reservations.containsKey(reservationId)) {

            rollbackStack.push(reservationId);

            String roomType = reservations.remove(reservationId);

            System.out.println("Booking cancelled for Reservation ID: " + reservationId);
            System.out.println("Room type restored to inventory: " + roomType);

        } else {
            System.out.println("Cancellation failed: Reservation does not exist.");
        }

        System.out.println("Rollback Stack: " + rollbackStack);
    }
}