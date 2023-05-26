import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class GameRecord {
  private int gameID;
  private String createdAt;
  private int[] symptomScores;
  private int totalSymptomCount;
  private int symptomSeverityScore;
  private String overallRating;

  private DateTimeFormatter dateFmt = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");

  public GameRecord(int[] symptomScores, GameRecord prevGameRecord) {
    this.symptomScores = symptomScores;
    this.createdAt = LocalDateTime.now().format(dateFmt);
    this.totalSymptomCount = calcTotalSymptomCount();
    this.symptomSeverityScore = calcSymptomSeverityScore();
    this.gameID = prevGameRecord == null ? 1 : prevGameRecord.getGameID() + 1;
    this.overallRating = prevGameRecord == null ? "N/A" : calcOverallRating(prevGameRecord);
  }

  private int calcTotalSymptomCount() {
    int totalSymptomCount = 0;
    for (int score : this.symptomScores) {
      if (score > 0) {
        totalSymptomCount++;
      }
    }
    return totalSymptomCount;
  }

  private int calcSymptomSeverityScore() {
    int symptomSeverityScore = 0;
    for (int score : this.symptomScores) {
      symptomSeverityScore += score;
    }
    return symptomSeverityScore;
  }

  private String calcOverallRating(GameRecord prevGameRecord) {
    int totalSymptomDifference = this.totalSymptomCount - prevGameRecord.getTotalSymptomCount();
    int symptomSeverityDifference = this.symptomSeverityScore - prevGameRecord.getSymptomSeverityScore();

    if (totalSymptomDifference < 3 && symptomSeverityDifference < 10) {
      return "No Difference";
    } else if (totalSymptomDifference < 3 && symptomSeverityDifference >= 10) {
      return "Unsure";
    } else {
      return "Very different";
    }
  }

  public int getGameID() {
    return this.gameID;
  }

  public int getTotalSymptomCount() {
    return this.totalSymptomCount;
  }

  public int getSymptomSeverityScore() {
    return this.symptomSeverityScore;
  }

  public String getOverallRating() {
    return this.overallRating;
  }

  public String getSymptomSummary() {
    return "Game: " + this.gameID + "\n" +
        "Date: " + this.createdAt + "\n" +
        "Total number of symptoms: " + this.totalSymptomCount + "\n" +
        "Symptom severity score: " + this.symptomSeverityScore + "\n" +
        "Overall rating: " + getColoredOverallRating(this.overallRating);
  }

  public static String getColoredOverallRating(String overallRating) {
    switch (overallRating) {
      case "No Difference":
        return App.ANSI_GREEN_BACKGROUND + App.ANSI_WHITE + overallRating + App.ANSI_RESET;
      case "Unsure":
        return App.ANSI_YELLOW_BACKGROUND + App.ANSI_WHITE + overallRating + App.ANSI_RESET;
      case "Very different":
        return App.ANSI_RED_BACKGROUND + App.ANSI_WHITE + overallRating + App.ANSI_RESET;
      default:
        return overallRating;
    }
  }
}
