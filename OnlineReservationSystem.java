import java.util.Scanner;

class User {
    private String username;
    private String password;

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }
}

class ReservationSystem {
    private static final String TRAIN_NUMBER = "12345";
    private static final String TRAIN_NAME = "Sample Train";

    public static void makeReservation(String name, String trainClass, String date, String from, String to) {
        System.out.println("Reservation created successfully!");
        System.out.println("Name: " + name);
        System.out.println("Train Number: " + TRAIN_NUMBER);
        System.out.println("Train Name: " + TRAIN_NAME);
        System.out.println("Class: " + trainClass);
        System.out.println("Date: " + date);
        System.out.println("From: " + from);
        System.out.println("To: " + to);
        System.out.println("Your reservation has been confirmed.");
    }

    public static void cancelReservation(String pnrNumber) {
        System.out.println("Reservation with PNR number " + pnrNumber + " canceled successfully!");
    }
}

public class OnlineReservationSystem {
    private static final User[] USERS = {
            new User("saiganesh", "123456"),
            new User("tonystark", "123456"),
    };

    private static User loggedInUser;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Login Form
        System.out.println("=== Login Form ===");
        boolean isLoggedIn = false;
        while (!isLoggedIn) {
            System.out.print("Username: ");
            String username = scanner.nextLine();
            System.out.print("Password: ");
            String password = scanner.nextLine();

            isLoggedIn = login(username, password);
            if (!isLoggedIn) {
                System.out.println("Invalid username or password. Please try again.");
            }
        }

        System.out.println("\n=== Reservation System ===");
        System.out.print("Enter your name: ");
        String name = scanner.nextLine();
        System.out.print("Enter class type: ");
        String trainClass = scanner.nextLine();
        System.out.print("Date of journey: ");
        String date = scanner.nextLine();
        System.out.print("From: ");
        String from = scanner.nextLine();
        System.out.print("To: ");
        String to = scanner.nextLine();

        ReservationSystem.makeReservation(name, trainClass, date, from, to);

        System.out.print("Do you want to cancel the reservation? (Y/N): ");
        String cancelConfirmation = scanner.nextLine();
        if (cancelConfirmation.equalsIgnoreCase("Y")) {
            // Cancellation Form
            System.out.println("\n=== Cancellation Form ===");
            System.out.print("Enter your PNR number: ");
            String pnrNumber = scanner.nextLine();
            System.out.print("Are you sure you want to cancel the reservation? (Y/N): ");
            String confirmation = scanner.nextLine();
            if (confirmation.equalsIgnoreCase("Y")) {
                ReservationSystem.cancelReservation(pnrNumber);
            } else {
                System.out.println("Cancellation of your ticket is cancelledSA.");
            }
        } else {
            System.out.println("Thank you. Please visit again!");
        }

        scanner.close();
    }

    private static boolean login(String username, String password) {
        for (User user : USERS) {
            if (user.getUsername().equals(username) && user.getPassword().equals(password)) {
                loggedInUser = user;
                return true;
            }
        }
        return false;
    }
}
