import java.util.*;
import java.util.Map;
import java.util.Collections;
import java.util.HashMap;
import java.util.ArrayList;
public class Demo {
    public static void main(String[] args) {
        CabBookingApp app = new CabBookingApp();

        app.addUser("Abhishek, M, 23");
        app.addUser("Rahul, M, 29");
        app.addUser("Nandini, F, 22");

        app.addDriver("Driver1, M, 22", "Swift, KA-01-12345", new int[]{10, 1});
        app.addDriver("Driver2, M, 29", "Swift, KA-01-12346", new int[]{11, 10});
        app.addDriver("Driver3, M, 24", "Swift, KA-01-12347", new int[]{5, 3});

        System.out.println(app.findRide("Abhishek", new int[]{0, 0}));  
        System.out.println(app.findRide("Rahul", new int[]{10, 0}));   
        System.out.println(app.findRide("Nandini", new int[]{15, 6}));  

        System.out.println(app.chooseRide("Rahul", "Driver1"));  
        System.out.println(app.findRide("Nandini", new int[]{15, 6}));  
    }
}

