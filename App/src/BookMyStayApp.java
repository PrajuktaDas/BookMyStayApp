import java.util.Scanner;

class InvalidRoomTypeException extends Exception {
    public InvalidRoomTypeException(String message) {
        super(message);
    }
}

public class BookMyStayApp {

    public static void validateRoomType(String roomType) throws InvalidRoomTypeException {
        if (!roomType.equals("Single") && !roomType.equals("Double") && !roomType.equals("Suite")) {
            throw new InvalidRoomTypeException("Booking failed: Invalid room type selected.");
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("Booking Validation");

        System.out.print("Enter guest name: ");
        String guestName = sc.nextLine();

        System.out.print("Enter room type (Single/Double/Suite): ");
        String roomType = sc.nextLine();

        try {
            validateRoomType(roomType);
            System.out.println("Booking confirmed for " + guestName + " with room type " + roomType);
        }
        catch (InvalidRoomTypeException e) {
            System.out.println(e.getMessage());
        }

        sc.close();
    }
}