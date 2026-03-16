import java.util.*;

public class BookMyStayApp {

    public static void main(String[] args) {

        System.out.println("Room Allocation Processing");

        Queue<String[]> bookingQueue = new LinkedList<>();

        bookingQueue.add(new String[]{"Abhi", "Single"});
        bookingQueue.add(new String[]{"Subha", "Single"});
        bookingQueue.add(new String[]{"Vanmathi", "Suite"});

        Map<String, Set<String>> allocatedRooms = new HashMap<>();

        while (!bookingQueue.isEmpty()) {

            String[] request = bookingQueue.poll();
            String guestName = request[0];
            String roomType = request[1];

            allocatedRooms.putIfAbsent(roomType, new HashSet<>());

            Set<String> rooms = allocatedRooms.get(roomType);

            String roomId = roomType + "-" + (rooms.size() + 1);

            rooms.add(roomId);

            System.out.println("Booking confirmed for Guest: " + guestName + ", Room ID: " + roomId);
        }
    }
}