import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class GameRecord {
  final int minGameID = 1000;
  final int maxGameID = 9999;

  public int userID;
  public int gameID;
  public String createdAt;
  public int[] symptomScores;

  DateTimeFormatter dateFmt = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");

  public GameRecord(int userID, int[] symptomScores) {
    this.userID = userID;
    this.gameID = (int) (Math.random() * (maxGameID - minGameID + 1)) + minGameID;
    this.symptomScores = symptomScores;
    this.createdAt = LocalDateTime.now().format(dateFmt);
  }

  public String toString() {
    return "User ID: " + this.userID + "Game ID: " + this.gameID + "\n" + "Created at: " + this.createdAt;
  }
}
