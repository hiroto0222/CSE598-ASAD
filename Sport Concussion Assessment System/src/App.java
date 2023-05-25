import java.util.ArrayList;
import java.util.Scanner;

public class App {
    final static String[] symptoms = new String[] { "Headache", "Pressure in Head", "Neck Pain", "Nausea or Vomiting",
            "Dizziness", "Blurred vision", "Balance problems", "Sensitivity to light", "Sensitivity to noise",
            "Feeling slowed down", "Feeling like 'in a fog'", "Don't feel right",
            "Difficulty concentrating", "Difficulty remembering", "Fatigue or low energy",
            "Confusion", "Drowsiness", "Trouble falling asleep", "More emotional",
            "Irritability", "Sadness", "Nervous or Anxious" };

    public static SystemManager systemManager = new SystemManager();
    public static Scanner scanner = new Scanner(System.in);
    // logged in user info
    static int userID;
    static Athlete athlete;

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
                System.out.println();
                System.out.println("Invalid choice, please try again!");
                scanner.nextLine();
                continue;
            }
            int userChoice = scanner.nextInt();

            switch (userChoice) {
                case 1: // login as athlete
                    System.out.println();
                    if (!loginAthlete()) {
                        System.out.println();
                        System.out.println("Invalid user ID, please try again!");
                        break;
                    }
                    displayAthleteMenu();
                    break;

                case 2: // TODO: login as medical practitioner
                    break;

                case 3: // register as athlete
                    System.out.println();
                    systemManager.addAthlete();
                    break;

                case 4: // TODO: register as medical practitioner
                    break;

                case 5: // exit
                    System.out.println();
                    System.out.println("Thank you for using Sport Concussion Assessment System!");
                    System.exit(0);
                    break;

                default:
                    System.out.println();
                    System.out.println("Invalid choice, please try again!");
                    break;
            }
        } while (true);
    }

    public static void displayAthleteMenu() {
        do {
            System.out.println();
            System.out.println("Welcome back, " + athlete.name + "!");
            System.out.println("----------------------------------------------");
            System.out.println("Please select one of the following options (1-6): ");
            System.out.println();
            System.out.println("1. Add a new game record for symptoms");
            System.out.println("2. View your symptoms summary");
            System.out.println("3. Am I at Risk?");
            System.out.println("4. View your medical practioner's advice");
            System.out.println("5. Back");
            System.out.println("6. Exit");
            System.out.println();
            System.out.println("Enter your choice: ");

            if (!scanner.hasNextInt()) {
                System.out.println();
                System.out.println("Invalid choice, please try again!");
                scanner.nextLine();
                continue;
            }
            int userChoice = scanner.nextInt();

            switch (userChoice) {
                case 1: // add a new game record for symptoms
                    System.out.println();
                    int[] symptomScores = displaySymptomScoresForm();
                    athlete.addGameRecord(symptomScores);
                    break;

                case 2: // view your symptoms summary
                    ArrayList<GameRecord> gameRecords = athlete.getGameRecordsList();

                    System.out.println();
                    if (gameRecords.size() == 0) {
                        System.out.println("No game records found");
                        break;
                    }

                    System.out.println("Dislaying Symptoms Summary for 5 most recent games recorded:");
                    System.out.println("---------");
                    for (GameRecord gameRecord : gameRecords) {
                        System.out.println(gameRecord.getSymptomSummary());
                        System.out.println("---------");
                    }
                    break;

                case 3: // TODO: am I at risk?
                    break;

                case 4: // TODO: view your medical practioner's advice
                    break;

                case 5: // TODO: back
                    return;

                case 6: // exit
                    System.out.println();
                    System.out.println("Thank you for using Sport Concussion Assessment System!");
                    System.exit(0);
                    break;

                default:
                    System.out.println();
                    System.out.println("Invalid choice, please try again!");
                    break;
            }
        } while (true);
    }

    private static boolean loginAthlete() {
        System.out.println("Enter your user ID: ");
        if (!scanner.hasNextInt()) {
            scanner.nextLine();
            return false;
        }
        userID = scanner.nextInt();
        athlete = systemManager.getAthlete(userID);

        if (athlete == null) {
            scanner.nextLine();
            return false;
        }

        return true;
    }

    private static int[] displaySymptomScoresForm() {
        int[] symptomScores = new int[symptoms.length];

        System.out.println("Enter your level of pain (0-6): none(0), mild(1-2), moderate(3-4), severe(5-6)");
        for (int i = 0; i < symptoms.length; i++) {
            System.out.println();
            System.out.println(symptoms[i] + ": ");
            if (!scanner.hasNextInt()) {
                System.out.println();
                System.out.println("Invalid choice, please try again!");
                scanner.nextLine();
                i--;
                continue;
            }
            int score = scanner.nextInt();
            if (score < 0 || score > 6) {
                System.out.println();
                System.out.println("Invalid choice, please try again!");
                scanner.nextLine();
                i--;
                continue;
            }
            symptomScores[i] = score;
        }

        return symptomScores;
    }
}
