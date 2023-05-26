public class MedicalPractitioner {
  private final int minUserID = 1000;
  private final int maxUserID = 9999;

  private int userID;
  private String name;
  private int age;

  public MedicalPractitioner(String name, int age) {
    this.userID = (int) (Math.random() * (maxUserID - minUserID + 1)) + minUserID;
    this.name = name;
    this.age = age;
  }

  public void setAdvice(Athlete athlete, String text) {
    athlete.setMedicalPractitionerAdvice(text);
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
}
