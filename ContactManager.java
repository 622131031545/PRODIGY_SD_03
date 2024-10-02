package task_03;
/*Implement a Simple Contact Management System

Develop a program that allows users to store and manage contact information. 
The program should provide options to add a new contact by entering their name, phone
 number, and email address. It should also allow users to view their contact list, edit
  existing contacts, and delete contacts if needed. The program should store the contacts
   in memory or in a file for persistent storage.
   Filename: C:\Users\Shaibaj\eclipse-workspace\PRODIGY_SD_03\src\task_03\ContactManager.java
 Path: C:\Users\Shaibaj\eclipse-workspace\PRODIGY_SD_03\src\task_03\ContactManager.java
 Created Date: Tuseday, Octomber 01 2024, 11:38:43 am
 Author: Shaibaj
 Copyright (c) 2024 */
import java.util.ArrayList;
import java.util.Scanner;

public class ContactManager {

    
    private static ArrayList<Contact> contacts = new ArrayList<>();

    // Method to add a new contact
    public static void addContact(Scanner sc) {
        System.out.print("Enter name: ");
        String name = sc.nextLine();
        System.out.print("Enter phone number: ");
        String phoneNumber = sc.nextLine();
        System.out.print("Enter email address: ");
        String email = sc.nextLine();
        
        contacts.add(new Contact(name, phoneNumber, email));
        System.out.println("Contact added successfully!");
    }

    
    public static void displayContacts() {
        if (contacts.isEmpty()) {
            System.out.println("No contacts available.");
        } else {
            for (int i = 0; i < contacts.size(); i++) {
                System.out.println("\nContact #" + (i + 1) + ":");
                contacts.get(i).displayContact();
            }
        }
    }

    
    public static void editContact(Scanner sc) {
        System.out.print("Enter the contact number to edit: ");
        int index = sc.nextInt();
        sc.nextLine();  // Consume newline

        if (index <= contacts.size() && index > 0) {
            Contact contact = contacts.get(index - 1);

            System.out.print("Enter new name: ");
            String name = sc.nextLine();
            System.out.print("Enter new phone number: ");
            String phoneNumber = sc.nextLine();
            System.out.print("Enter new email address: ");
            String email = sc.nextLine();

            contact.updateContact(name, phoneNumber, email);
            System.out.println("Contact updated successfully!");
        } else {
            System.out.println("Invalid contact number.");
        }
    }

    // Method to delete a contact
    public static void deleteContact(Scanner sc) {
        System.out.print("Enter the contact number to delete: ");
        int index = sc.nextInt();
        sc.nextLine();  // Consume newline

        if (index <= contacts.size() && index > 0) {
            contacts.remove(index - 1);
            System.out.println("Contact deleted successfully!");
        } else {
            System.out.println("Invalid contact number.");
        }
    }

    // Main method to run the Contact Management System
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\nContact Management System");
            System.out.println("1. Add Contact");
            System.out.println("2. View All Contacts");
            System.out.println("3. Edit Contact");
            System.out.println("4. Delete Contact");
            System.out.println("5. Exit");
            System.out.print("Choose an option: ");
            choice = sc.nextInt();
            sc.nextLine();  
            switch (choice) {
                case 1:
                    addContact(sc);
                    break;
                case 2:
                    displayContacts();
                    break;
                case 3:
                    editContact(sc);
                    break;
                case 4:
                    deleteContact(sc);
                    break;
                case 5:
                    System.out.println("Exiting the program.");
                    break;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        } while (choice != 5);

        sc.close();
    }
}

/*
 
Contact Management System
1. Add Contact
2. View All Contacts
3. Edit Contact
4. Delete Contact
5. Exit
Choose an option: 2
No contacts available.

Contact Management System
1. Add Contact
2. View All Contacts
3. Edit Contact
4. Delete Contact
5. Exit
Choose an option: 1
Enter name: sd
Enter phone number: 56
Enter email address: sd@cc.com
Contact added successfully!

Contact Management System
1. Add Contact
2. View All Contacts
3. Edit Contact
4. Delete Contact
5. Exit
Choose an option: 2

Contact #1:
Name: sd
Phone: 56
Email: sd@cc.com

Contact Management System
1. Add Contact
2. View All Contacts
3. Edit Contact
4. Delete Contact
5. Exit
Choose an option: 3
Enter the contact number to edit: 1
Enter new name: shaibaj
Enter new phone number: 787512382
Enter new email address: Sd@gmail.com
Contact updated successfully!

Contact Management System
1. Add Contact
2. View All Contacts
3. Edit Contact
4. Delete Contact
5. Exit
Choose an option: 2

Contact #1:
Name: shaibaj
Phone: 787512382
Email: Sd@gmail.com

Contact Management System
1. Add Contact
2. View All Contacts
3. Edit Contact
4. Delete Contact
5. Exit
Choose an option: */
