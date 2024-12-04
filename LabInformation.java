//name= Gheorghe Georgescu
//id= 301377303

/**
 * Driver class for the Lab Management system.
 * Provides a menu-driven interface for managing labs, technicians, and lab equipment.
 */

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class LabInformation {// Start of class LabInformation
	// Instance variables for storing data
    private List<Lab> labs;
    private List<Technician> technicians;
    private List<LabEquipment> labEquipment;

    // Default constructor
    public LabInformation() {
        this.labs = new ArrayList<>();
        this.technicians = new ArrayList<>();
        this.labEquipment = new ArrayList<>();
    }

    private int getValidIntInput(Scanner scanner) {// Checks if user input has only integers
        int input;
        while (true) {
            if (scanner.hasNextInt()) {
                input = scanner.nextInt();
                scanner.nextLine();  // Consume the newline character after reading the integer
                break; // Break the loop if a valid integer is entered
            } else {
                System.out.println("Invalid input. Please enter a valid integer.");
                scanner.nextLine(); // Consume the invalid input
            }
        }
        return input;
    }

    private String getValidPhoneNumber(Scanner scanner) {// Checks if input for phone number is of valid format
        String phoneNumber;
        while (true) {
            phoneNumber = scanner.nextLine();
            if (phoneNumber.matches("\\d{10}")) { // Check if it's 10 digits
                break;
            } else {
                System.out.println("Invalid phone number. Please enter a 10-digit phone number.");
            }
        }
        return phoneNumber;
    }

    // Methods to handle different functionalities
    private void createLab(Scanner scanner) {// Creates a new Lab
        System.out.print("Enter Lab ID: ");
        int labId = getValidIntInput(scanner); // This will now properly handle invalid input and not show the prompt twice
        System.out.print("Enter Lab Name: ");
        String labName = scanner.nextLine();

        System.out.print("Enter Lab Phone Number (10 digits): ");
        String phoneNumber = getValidPhoneNumber(scanner);

        Lab lab = new Lab(labId, labName, phoneNumber);
        labs.add(lab);
        System.out.println("Lab created successfully!\n");
    }


    private void displayLabs() {// Displays information of all Labs
        if (labs.isEmpty()) {
            System.out.println("No labs available.\n");
        } else {
            for (Lab lab : labs) {
                System.out.println(lab.getLabInfo());
            }
        }
    }

    private void createTechnician(Scanner scanner) {// Creates a new Technician
        System.out.print("Enter Technician ID: ");
        int technicianId = getValidIntInput(scanner);
        scanner.nextLine(); // Consume newline

        System.out.print("Enter Technician First Name: ");
        String firstName = scanner.nextLine();

        System.out.print("Enter Technician Last Name: ");
        String lastName = scanner.nextLine();

        System.out.print("Enter Technician Email: ");
        String email = scanner.nextLine();

        System.out.print("Enter Technician Phone Number (10 digits): ");
        String phoneNumber = getValidPhoneNumber(scanner);

        System.out.print("Enter Technician Specialty: ");
        String specialty = scanner.nextLine();

        Technician technician = new Technician(technicianId, firstName, lastName, email, phoneNumber, specialty);
        technicians.add(technician);
        System.out.println("Technician created successfully!\n");
    }

    private void displayTechnicians() {// Displays information of all Technicians
        if (technicians.isEmpty()) {
            System.out.println("No technicians available.\n");
        } else {
            for (Technician tech : technicians) {
                System.out.println(tech.getTechnicianInfo());
            }
        }
    }

    private void assignTechnicianToLab(Scanner scanner) {// Assigns a Technician to a Lab
        System.out.print("Enter Technician ID to assign: ");
        int technicianId = getValidIntInput(scanner);

        System.out.print("Enter Lab ID to assign the technician to: ");
        int labId = getValidIntInput(scanner);

        Technician technician = null;
        for (Technician tech : technicians) {
            if (tech.getTechnicianId() == technicianId) {
                technician = tech;
                break;
            }
        }

        Lab lab = null;
        for (Lab l : labs) {
            if (l.getLabId() == labId) {
                lab = l;
                break;
            }
        }

        if (technician != null && lab != null) {
            lab.addTechnician(technician);
            System.out.println("Technician assigned to Lab successfully!\n");
        } else {
            System.out.println("Invalid Technician ID or Lab ID.\n");
        }
    }

    private void createLabEquipment(Scanner scanner) {// Creates new Lab Equipment
        System.out.print("Enter Equipment ID: ");
        int equipmentId = getValidIntInput(scanner);
        scanner.nextLine(); // Consume newline

        System.out.print("Enter Equipment Name: ");
        String equipmentName = scanner.nextLine();

        System.out.print("Enter Lab ID for the equipment: ");
        int labId = getValidIntInput(scanner);

        System.out.print("Enter Equipment State (1 for Functional, 0 for Non-Functional): ");
        boolean state = scanner.nextInt() == 1;

        LabEquipment equipment = new LabEquipment(equipmentId, equipmentName, labId, state);
        labEquipment.add(equipment);

        Lab lab = null;
        for (Lab l : labs) {
            if (l.getLabId() == labId) {
                lab = l;
                break;
            }
        }

        if (lab != null) {
            lab.addEquipment(equipment);
        }

        System.out.println("Lab Equipment created successfully!\n");
    }

    private void displayLabEquipment() {// Displays information of all Lab Equipment
        if (labEquipment.isEmpty()) {
            System.out.println("No lab equipment available.\n");
        } else {
            for (LabEquipment equip : labEquipment) {
                System.out.println(equip.getLabEquipmentInfo());
            }
        }
    }

    private void showMenu() {// Main menu
        System.out.println("===== Lab Management System =====");
        System.out.println("1. Create Lab");
        System.out.println("2. Display Labs");
        System.out.println("3. Create Technician");
        System.out.println("4. Display Technicians");
        System.out.println("5. Assign Technician to Lab");
        System.out.println("6. Create Lab Equipment");
        System.out.println("7. Display Lab Equipment");
        System.out.println("8. Exit");
        System.out.print("Choose an option: ");
    }

    public void start() {// Driver method
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            showMenu();
            choice = getValidIntInput(scanner);

            switch (choice) {
                case 1 -> createLab(scanner);
                case 2 -> displayLabs();
                case 3 -> createTechnician(scanner);
                case 4 -> displayTechnicians();
                case 5 -> assignTechnicianToLab(scanner);
                case 6 -> createLabEquipment(scanner);
                case 7 -> displayLabEquipment();
                case 8 -> System.out.println("Exiting...");
                default -> System.out.println("Invalid choice. Please try again.\n");
            }
        } while (choice != 8);
        scanner.close();
    }

    public static void main(String[] args) {// Main method
        LabInformation app = new LabInformation();
        app.start();
    }
}// End of class LabInformation