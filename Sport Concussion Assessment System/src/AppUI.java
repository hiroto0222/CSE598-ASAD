import java.util.Scanner;

public class AppUI {
    public static SystemManager systemManager = new SystemManager();
    public static Scanner scanner = new Scanner(System.in);
    static int userID;

    public static void main(String[] args) {
        displayMainMenu();
    }

    public static void displayMainMenu() {
        do {
            System.out.println();
            System.out.println("Welcome to Sport Concussion Assessment System ");
            System.out.println("----------------------------------------------");
            System.out.println("Please select one of the following options (1-5): ");
            System.out.println();
            System.out.println("1. Athlete Login");
            System.out.println("2. Medical Practitioner Login");
            System.out.println("3. Register as an Athlete");
            System.out.println("4. Register as a Medical Practitioner");
            System.out.println("5. Exit");
            System.out.println();
            System.out.println("Enter your choice: ");

            if (!scanner.hasNextInt()) {
                System.out.println("Invalid choice, please try again!");
                scanner.nextLine();
                continue;
            }
            int userChoice = scanner.nextInt();

            switch (userChoice) {
                case 1: // login as athlete
                    System.out.println("Enter your user ID: ");
                    userID = scanner.nextInt();
                    System.out.println("Successfully logged, welcome back!");
                    break;

                case 2: // login as medical practitioner
                    break;

                case 3: // register as athlete
                    systemManager.addAthlete();
                    break;

                default:
                    System.out.println("Invalid choice, please try again!");
                    break;
            }
        } while (true);
    }
}
