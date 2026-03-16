import java.util.*;

public class BookMyStayApp {

    public static void main(String[] args) {

        System.out.println("Add-On Service Selection");

        String reservationId = "Single-1";

        Map<String, List<Double>> addOnServices = new HashMap<>();

        List<Double> services = new ArrayList<>();
        services.add(500.0);
        services.add(1000.0);

        addOnServices.put(reservationId, services);

        double totalCost = 0;

        for(double cost : addOnServices.get(reservationId)) {
            totalCost += cost;
        }

        System.out.println("Reservation ID: " + reservationId);
        System.out.println("Total Add-On Cost: " + totalCost);
    }
}