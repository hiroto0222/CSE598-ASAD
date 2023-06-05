import java.util.ArrayList;

public class Personnel {
	// changed attribute to private from public
	private ArrayList<Person> personList;

	public Personnel() {
		personList = new ArrayList<Person>();
	}

	public ArrayList<Person> getPersonList() {
		return personList;
	}

	public int getNumPerson() {
		return personList.size();
	}

	public void addPersonnel(Person p) {
		personList.add(p);
	}
}
