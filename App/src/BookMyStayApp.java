import java.util.*;

class BookingProcessor extends Thread {

    private Queue<String> bookingQueue;
    private static int roomCounter = 1;

    public BookingProcessor(Queue<String> bookingQueue) {
        this.bookingQueue = bookingQueue;
    }

    public void run() {
        processBooking();
    }

    public synchronized void processBooking() {

        if (!bookingQueue.isEmpty()) {

            String guest = bookingQueue.poll();
            String roomId = "Room-" + roomCounter++;

            System.out.println("Booking confirmed for Guest: " + guest + ", Room ID: " + roomId);
        }
    }
}

public class BookMyStayApp {

    public static void main(String[] args) {

        System.out.println("Concurrent Booking Simulation");

        Queue<String> bookingQueue = new LinkedList<>();

        bookingQueue.add("Abhi");
        bookingQueue.add("Subha");
        bookingQueue.add("Vanmathi");

        BookingProcessor t1 = new BookingProcessor(bookingQueue);
        BookingProcessor t2 = new BookingProcessor(bookingQueue);
        BookingProcessor t3 = new BookingProcessor(bookingQueue);

        t1.start();
        t2.start();
        t3.start();
    }
}