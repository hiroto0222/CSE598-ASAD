public class PersonnelFactory {
  public Person createPersonnel(String type, String last, String first, String middle) {
    switch (type) {
      case "Person":
        return new Person(last, first, middle);
      case "Volunteer":
        return new Volunteer(last, first, middle);
      default:
        return null;
    }
  }

  public Employee createPersonnel(String type, String last, String first, String middle, int id, double sal) {
    switch (type) {
      case "Employee":
        return new Employee(last, first, middle, id, sal);
      case "Executive":
        return new Executive(last, first, middle, id, sal);
      case "Security":
        return new Security(last, first, middle, id, sal);
      default:
        return null;
    }
  }
}
