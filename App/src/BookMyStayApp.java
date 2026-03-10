import java.util.LinkedList;
import java.util.Queue;

// Version 5.0 - Reservation class
class Reservation {

    private String guestName;
    private String roomType;

    public Reservation(String guestName, String roomType) {
        this.guestName = guestName;
        this.roomType = roomType;
    }

    public String getGuestName() {
        return guestName;
    }

    public String getRoomType() {
        return roomType;
    }
}


// Version 5.0 - Booking Request Queue
class BookingRequestQueue {

    private Queue<Reservation> queue;

    public BookingRequestQueue() {
        queue = new LinkedList<>();
    }

    // Add request
    public void addRequest(Reservation reservation) {
        queue.add(reservation);
    }

    // Check pending requests
    public boolean hasPendingRequests() {
        return !queue.isEmpty();
    }

    // Process next request (FIFO)
    public Reservation processNextRequest() {
        return queue.poll();
    }
}


// Main Application
public class BookMyStayApp {

    public static void main(String[] args) {

        // Display header
        System.out.println("Booking Request Queue");

        // Initialize booking queue
        BookingRequestQueue bookingQueue = new BookingRequestQueue();

        // Create booking requests
        Reservation r1 = new Reservation("Abhi", "Single");
        Reservation r2 = new Reservation("Subha", "Double");
        Reservation r3 = new Reservation("Vanmathi", "Suite");

        // Add requests to queue
        bookingQueue.addRequest(r1);
        bookingQueue.addRequest(r2);
        bookingQueue.addRequest(r3);

        // Process requests in FIFO order
        while (bookingQueue.hasPendingRequests()) {

            Reservation current = bookingQueue.processNextRequest();

            System.out.println(
                    "Processing booking for Guest: "
                            + current.getGuestName()
                            + ", Room Type: "
                            + current.getRoomType()
            );
        }
    }
}