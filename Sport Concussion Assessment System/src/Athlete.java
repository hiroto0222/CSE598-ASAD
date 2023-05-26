import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;

public class Athlete {
  private final int minUserID = 1000;
  private final int maxUserID = 9999;

  private int userID;
  private String name;
  private int age;
  private String sport;
  private String medicalPractitionerAdvice = "N/A";

  // queue to store 5 most recent game records
  private Deque<GameRecord> gameRecords = new LinkedList<>();

  public Athlete(String name, int age, String sport) {
    this.userID = (int) (Math.random() * (maxUserID - minUserID + 1)) + minUserID;
    this.name = name;
    this.age = age;
    this.sport = sport;
  }

  public void addGameRecord(int[] symptomScores) {
    GameRecord prevGameRecord = gameRecords.peekLast();
    GameRecord gameRecord = new GameRecord(symptomScores, prevGameRecord);
    gameRecords.add(gameRecord);
    if (gameRecords.size() > 5) {
      gameRecords.remove();
    }
  }

  public String getCurrentRiskIndicator() {
    GameRecord mostRecentGameRecord = this.gameRecords.peekLast();
    if (mostRecentGameRecord == null) {
      return "No game records found";
    }
    return mostRecentGameRecord.getOverallRating();
  }

  public int getUserID() {
    return this.userID;
  }

  public String getName() {
    return this.name;
  }

  public int getAge() {
    return this.age;
  }

  public String getSport() {
    return this.sport;
  }

  public String getMedicalPractitionerAdvice() {
    return this.medicalPractitionerAdvice;
  }

  public void setMedicalPractitionerAdvice(String text) {
    this.medicalPractitionerAdvice = text;
  }

  public ArrayList<GameRecord> getGameRecordsList() {
    return new ArrayList<>(this.gameRecords);
  }
}
