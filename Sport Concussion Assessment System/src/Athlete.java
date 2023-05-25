import java.util.LinkedList;
import java.util.Queue;

public class Athlete {
  final int minUserID = 1000;
  final int maxUserID = 9999;

  int userID;
  String name;
  int age;
  String sport;
  String medicalPractitionerAdvice = "N/A";

  // queue to store 5 most recent game records
  Queue<GameRecord> gameRecords = new LinkedList<>();

  public Athlete(String name, int age, String sport) {
    this.userID = (int) (Math.random() * (maxUserID - minUserID + 1)) + minUserID;
    this.name = name;
    this.age = age;
    this.sport = sport;
  }

  public void addGameRecord(int[] symptomScores) {
    GameRecord gameRecord = new GameRecord(this.userID, symptomScores);
    gameRecords.add(gameRecord);
    if (gameRecords.size() > 5) {
      gameRecords.remove();
    }
  }

  public String toString() {
    return "User ID: " + this.userID + "\n" + "Name: " + this.name + "\n" + "Age: " + this.age + "\n" + "Sport: "
        + this.sport + "\n" + "Medical Practitioner Advice: " + this.medicalPractitionerAdvice;
  }
}
