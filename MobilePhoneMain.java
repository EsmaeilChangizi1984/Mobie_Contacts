package MobileContacts;

import java.util.Scanner;

public class MobilePhoneMain {

	public static Scanner scanner = new Scanner(System.in);
	private static MobilePhone mobilePhone = new MobilePhone("647-774-4936");

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		boolean quit = false;
		startPhone();
		printAction();

		while (!quit) {
			System.out.println("Enter action OR press 6 for available actions.");
			int action = scanner.nextInt();
			scanner.nextLine();

			switch (action) {
			case 0:
				System.out.println("Shutting down....");
				quit = false;
				break;
			case 1:
				mobilePhone.printContacts();
				break;
			case 2:
				addNewContact();
				break;
			case 3:
				updateContact();
				break;
			case 4:
				removeContact();
				break;
			case 5:
				queryContact();
				break;
			case 6:
				printAction();
				break;
			}
		}

	}

	public static void addNewContact() {
		System.out.println("Enter New Name .");
		String name = scanner.nextLine();
		System.out.println("Entter phone number");
		String number = scanner.nextLine();
		Contacts newcontact = new Contacts(name, number);
		newcontact.createContact(name, number);

		if (mobilePhone.addNewContact(newcontact)) {
			System.out.println("New contact added : name = " + name + " number = " + number);
		} else {
			System.out.println("can not add " + name + " already exist.");
		}
	}

	private static void updateContact() {

		System.out.println("Enter existing name.");
		String name = scanner.nextLine();
		Contacts oldContact = mobilePhone.queryContact(name);
		if (name == null) {
			System.out.println("The name dose not exist.");
			return;
		}

		System.out.println("Enter new contact name.");
		String newName = scanner.nextLine();
		System.out.println("Enter new contact number :");
		String number = scanner.nextLine();
		// Contacts newContact = createContact(newName,number);
		Contacts newcontact = new Contacts(name, number);
		newcontact.createContact(name, number);

		if (mobilePhone.updateContacts(oldContact, newcontact)) {
			System.out.println("Contact successfully updated.");
		} else {
			System.out.println("Error occured.");
		}

	}
	
	

	private static void removeContact() {

		System.out.println("Enter existing name.");
		String name = scanner.nextLine();
		Contacts oldContact = mobilePhone.queryContact(name);
		if (name == null) {
			System.out.println("The name dose not exist.");
			return;
		}
		if (mobilePhone.removeContact(oldContact)) {
			System.out.println("Contact successfully deleted.");
		} else {
			System.out.println("Error in deletion.");
		}

	}
	
	
	public static void queryContact() {
		System.out.println("Enter Contact Name.");
		String name = scanner.nextLine();
		Contacts myContact = mobilePhone.queryContact(name);
		if (name == null) {
			System.out.println("The name dose not exist.");
			return;
		}
		System.out.println("Contact name "+myContact.getName()+" Number : "+myContact.getNumber());
		
	}
	
	
	

	public static void startPhone() {
		System.out.println("Starting Phone ....");
	}
	
	
	

	private static void printAction() {
		System.out.println("Available actions :");
		System.out.println("0 -  to shotdown.");
		System.out.println("1 -  to print list of contacts");
		System.out.println("2 -  to add new contact.");
		System.out.println("3 -  to update contact");
		System.out.println("4 -  to remove contact");
		System.out.println("5 -  to search for a contact");
		System.out.println("6 -  to print all available options.\n");
		System.out.println(" choose your action : ");

	}

}
