package MobileContacts;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MobilePhone {

	private String myNumber;
	private ArrayList<Contacts> myList;

	public MobilePhone(String myNumber) {
		this.myNumber = myNumber;
		this.myList = new ArrayList<Contacts>();
	}


	
	public boolean updateContacts(Contacts oldContact,Contacts newContact) {
		int position = findContact(oldContact);
		if(position < 0) {
			System.out.println(oldContact.getName() + "Wasnot found in the list.");
			return false;
		}
		
		this.myList.set(position, newContact);
		System.out.println(oldContact .getName()+" was replaced with "+newContact.getName());
		return true;
		
	}
	
	
	
	public boolean addNewContact(Contacts contact) {
		if(findContact(contact.getName()) > 0) {
			System.out.println("The contact is already in the list.");
			return false;
		}
		myList.add(contact);
		return true;
	}
	
	
	
	
	private int findContact(Contacts contact) {
		return this.myList.indexOf(contact);
	}
	
	
	
	
	
	private int findContact(String contactName) {
		for(int i=0 ; i< myList.size(); i++) {
			//Contacts contact =  this.myList.get(i);
			//if(contact.getName().equals(contactName)) {
			if(this.myList.get(i).getName().equals(contactName)) {
				return i;
			}
		}
		return -1;
	}
	
	
	
	
	public String queryContact(Contacts contact) {
		if(findContact(contact) > 0) {
			return contact.getName();
		}
		return null;
	}
	
	public Contacts queryContact(String name) {
		int position = findContact(name);
		if(position > 0) {
			return this.myList.get(position);
		}else {
			return null;
		}
		
	}
	
	
	
	public boolean removeContact(Contacts contact) {
		int position = findContact(contact);
		if(position < 0) {
			System.out.println(contact + "Was not found in the list.");
			return false;
		}
		this.myList.remove(position);
		System.out.println("Contact deleted from the list.");
		return true;
	}
	
	public void printContacts() {
		System.out.println("Contact List");
		for(int i=0 ; i<myList.size() ; i++) {
			System.out.println((i+1) + " . "+
		this.myList.get(i).getName()+" -> "+
					myList.get(i).getNumber());
		}
	}

}
