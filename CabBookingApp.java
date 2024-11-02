import java.util.*;
import java.util.Map;
import java.util.Collections;
import java.util.HashMap;
import java.util.ArrayList;
class CabBookingApp {
    private Map<String, User> users = new HashMap<>();
    private Map<String, Driver> drivers = new HashMap<>();

    public void addUser(String userDetail) {
        String[] details = userDetail.split(", ");
        String name = details[0];
        String gender = details[1];
        int age = Integer.parseInt(details[2]);
        users.put(name, new User(name, gender, age));
    }

    public void addDriver(String driverDetail, String vehicleDetails, int[] currentLocation) {
        String[] details = driverDetail.split(", ");
        String name = details[0];
        String gender = details[1];
        int age = Integer.parseInt(details[2]);
        drivers.put(name, new Driver(name, gender, age, vehicleDetails, currentLocation));
    }

    public List<String> findRide(String username, int[] source) {
        if (!users.containsKey(username)) {
            System.out.println("User not found");
            return Collections.emptyList();
        }

        List<String> availableRides = new ArrayList<>();
        for (Driver driver : drivers.values()) {
            if (driver.isAvailable() && calculateDistance(driver.getCurrentLocation(), source) <= 5) {
                availableRides.add(driver.getName());
            }
        }

        return availableRides.isEmpty() ? Collections.singletonList("No ride found") : availableRides;
    }

    public String chooseRide(String username, String driverName) {
        if (!users.containsKey(username)) {
            return "User not found";
        }
        if (!drivers.containsKey(driverName)) {
            return "Driver not found";
        }

        Driver driver = drivers.get(driverName);
        if (!driver.isAvailable()) {
            return "Driver is not available";
        }

        driver.setAvailable(false); 
        return "Ride chosen with " + driverName;
    }

    private double calculateDistance(int[] location1, int[] location2) {
        return Math.sqrt(Math.pow(location1[0] - location2[0], 2) + Math.pow(location1[1] - location2[1], 2));
    }
}