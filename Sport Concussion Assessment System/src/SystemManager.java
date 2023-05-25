import java.util.ArrayList;
import java.util.Scanner;

public class SystemManager {
  Scanner scanner = new Scanner(System.in);
  // all athletes
  ArrayList<Athlete> athletes = new ArrayList<>();
  // all medical practitioners
  ArrayList<MedicalPractitioner> medicalPractitioners = new ArrayList<>();

  public void addAthlete() {
    System.out.println("Enter your full name: ");
    while (!scanner.hasNext("[A-Za-z]+")) {
      System.out.println("Invalid name, please try again!");
      scanner.nextLine();
    }
    String name = scanner.nextLine();

    System.out.println("Enter your age: ");
    while (!scanner.hasNextInt()) {
      System.out.println("Invalid age, please try again!");
      scanner.nextLine();
    }
    int age = Integer.parseInt(scanner.nextLine());

    System.out.println("Enter your sport: ");
    while (!scanner.hasNext("[A-Za-z]+")) {
      System.out.println("Invalid sport, please try again!");
      scanner.nextLine();
    }
    String sport = scanner.nextLine();

    Athlete athlete = new Athlete(name, age, sport);
    athletes.add(athlete);

    System.out.println();
    System.out.println("Successfully registered, your user ID is " + athlete.userID);
  }

  public Athlete getAthlete(int userID) {
    for (Athlete athlete : athletes) {
      if (athlete.userID == userID) {
        return athlete;
      }
    }
    return null;
  }
}