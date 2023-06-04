import java.util.ArrayList;

public class Personnel {
	public ArrayList<Person> personList;

	public Personnel() {
		personList = new ArrayList<Person>();
	}

	public void addPersonnel(Person p) {
		personList.add(p);
	}
}
