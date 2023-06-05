import java.util.Scanner;

public class PersonnelDirectory {
	private static Personnel per = new Personnel();
	private static PersonnelFactory pf = new PersonnelFactory();
	private static Scanner scan = new Scanner(System.in);
	private static String firstN, lastN, middleN;
	private static int empID;
	private static double salary;

	public static void main(String[] args) {
		int choice = -1;
		do {
			System.out.println("Welcome to the Personnel Directory Management System");
			System.out.println("====================================================");

			System.out.println("\n\n\t 1. Add Personel");
			System.out.println("\n\t 2. Find Personel");
			System.out.println("\n\t 3. Print Names");
			System.out.println("\n\t 4. Number of Entries in the Directory");

			System.out.println("\n\t Select one of the options above (1, 2, 3, 4)");
			choice = scan.nextInt();
			scan.nextLine();

			switch (choice) {
				case 1:
					displayAddPersonnelMenu();
					break;

				case 2:
					System.out.println("Enter firts name : ");
					firstN = scan.nextLine();

					System.out.println("Enter last name : ");
					lastN = scan.nextLine();

					boolean found = false;
					int loc = -1;
					for (int i = 0; i < per.getNumPerson(); i++) {
						if (per.getPersonList().get(i).getFirst().equals(firstN)
								&& per.getPersonList().get(i).getFirst().equals(lastN)) {
							found = true;
							loc = i;
						}
					}

					if (found) {
						System.out.println("Found");
						per.getPersonList().get(loc).printName(0);
					} else {
						System.out.println("not found");
						Person p1 = new Person(lastN, firstN, " ");
						per.addPersonnel(p1); // fixed content coupling violation
					}

					break;

				case 3:
					System.out
							.println("Enter the order 0: first, middle,  last, 1: first, last, middle, 2: last, first , middle ");
					int order = scan.nextInt();
					for (int i = 0; i < per.getNumPerson(); i++) {
						per.getPersonList().get(i).printName(order);
					}

					break;

				case 4:
					System.out.println("Total Entries : " + per.getNumPerson());

					break;
			}
		} while (true);
	}

	private static void displayAddPersonnelMenu() {
		int choice = -1;
		System.out.println("Select type of Personnel to add (1, 2, 3, 4, 5): ");
		System.out.println("\n\n\t 1. Person");
		System.out.println("\n\t 2. Volunteer");
		System.out.println("\n\t 3. Employee");
		System.out.println("\n\t 4. Security");
		System.out.println("\n\t 5. Executive");

		choice = scan.nextInt();
		scan.nextLine();

		String type;
		switch (choice) {
			case 1:
				type = "Person";
				displayAddPersonMenu();
				per.addPersonnel(pf.createPersonnel(type, firstN, lastN, middleN));
				break;

			case 2:
				type = "Volunteer";
				displayAddPersonMenu();
				per.addPersonnel(pf.createPersonnel(type, firstN, lastN, middleN));
				break;

			case 3:
				type = "Employee";
				displayAddEmployeeMenu();
				per.addPersonnel(pf.createPersonnel(type, firstN, lastN, middleN, empID, salary));
				break;

			case 4:
				type = "Security";
				displayAddEmployeeMenu();
				per.addPersonnel(pf.createPersonnel(type, firstN, lastN, middleN, empID, salary));
				break;

			case 5:
				type = "Executive";
				displayAddEmployeeMenu();
				per.addPersonnel(pf.createPersonnel(type, firstN, lastN, middleN, empID, salary));
				break;
		}
	}

	private static void displayAddEmployeeMenu() {
		displayAddPersonMenu();
		System.out.println("Enter empploy id : ");
		empID = scan.nextInt();
		System.out.println("Enter base salaey");
		salary = scan.nextDouble();
	}

	private static void displayAddPersonMenu() {
		System.out.println("Enter first name: ");
		firstN = scan.nextLine();
		System.out.println("Enter last name: ");
		lastN = scan.nextLine();
		System.out.println("Enter middle name: ");
		middleN = scan.nextLine();
	}
}
