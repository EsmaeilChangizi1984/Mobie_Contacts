package MobileContacts;

public class Contacts {
	private String number;
	private String name;
	
	public Contacts(String name,String number) {
		this.number = number;
		this.name = name;
	}

	public String getNumber() {
		return number;
	}

	public String getName() {
		return name;
	}
	
	public Contacts createContact(String name,String number) {
		return new Contacts(name, number);
	}

}
