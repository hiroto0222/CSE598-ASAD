public class Athlete {
  int minUserID = 1000;
  int maxUserID = 9999;

  int userID;
  String name;
  int age;
  String sport;
  String medicalPractitionerAdvice = "N/A";

  public Athlete(String name, int age, String sport) {
    this.userID = (int) (Math.random() * (maxUserID - minUserID + 1)) + minUserID;
    this.name = name;
    this.age = age;
    this.sport = sport;
  }
}
