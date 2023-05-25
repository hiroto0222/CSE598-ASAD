import java.util.ArrayList;
import java.util.Scanner;

public class SystemManager {
  Scanner scanner = new Scanner(System.in);
  // all athletes
  ArrayList<Athlete> athletes = new ArrayList<>();
  // all medical practitioners
  ArrayList<MedicalPractitioner> medicalPractitioners = new ArrayList<>();

  // add a new athlete
  public void addAthlete() {
    System.out.println();

    System.out.println("Enter your full name: ");
    String name = scanner.nextLine();

    System.out.println("Enter your age: ");
    int age = Integer.parseInt(scanner.nextLine());

    System.out.println("Enter your sport: ");
    String sport = scanner.nextLine();

    Athlete athlete = new Athlete(name, age, sport);
    athletes.add(athlete);

    System.out.println(athletes);
  }
}
