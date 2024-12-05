package lab.management;
// name= Gheorghe Georgescu
// id= 301377303
//
//

/**
 * Driver class for the Lab Management system.
 * Provides a menu-driven console interface for managing labs, technicians, and lab equipment.
 */

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class LabInformation { // Start of class LabInformation
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

    private int getValidIntInput(Scanner input) { // Checks if user input has only integers
        int intValue;
        while (true) {
            if (input.hasNextInt()) {
                intValue = input.nextInt();
                input.nextLine();  // Consumes the newline character after reading the integer
                break; // Breaks the loop if a valid integer is entered
            } else {
                System.out.println("Invalid input. Please enter a valid integer.");
                input.nextLine(); // Consumes the invalid input value
            }
        }
        return intValue;
    }

    private String getValidPhoneNumber(Scanner input) {// Checks if input for phone number is of valid format
        String phoneNumber;
        while (true) {
            phoneNumber = input.nextLine();
            if (phoneNumber.matches("\\d{10}")) { // Check if it's 10 digits
                break;
            } else {
                System.out.println("Invalid phone number. Please enter a 10-digit phone number.");
            }
        }
        return phoneNumber;
    }

    // Methods to handle different functionalities
    private void createLab(Scanner input) { // Creates a new lab
        System.out.print("Enter Lab ID: ");
        int labId = getValidIntInput(input); // This will now properly handle invalid input (not integer) and not show the prompt twice
        System.out.print("Enter Lab Name: ");
        String labName = input.nextLine();

        System.out.print("Enter Lab Phone Number (10 digits): ");
        String phoneNumber = getValidPhoneNumber(input);

        Lab lab = new Lab(labId, labName, phoneNumber);
        labs.add(lab); // add to labs list
        System.out.println("Lab created successfully!\n");
    }


    private void displayLabs() { // Displays information of all labs
        if (labs.isEmpty()) { // .isEmpty is a java.util.List feature
            System.out.println("No labs available.\n");
        } else {
            for (Lab lab : labs) { // iterates over labs list for lab objects
                System.out.println(lab.getLabInfo());
            }
        }
    }

    private void createTechnician(Scanner input) { // Creates a new Technician
        System.out.print("Enter Technician ID: ");
        int technicianId = getValidIntInput(input);
        //input.nextLine(); // Consumes a newline

        System.out.print("Enter Technician First Name: ");
        String firstName = input.nextLine();

        System.out.print("Enter Technician Last Name: ");
        String lastName = input.nextLine();

        System.out.print("Enter Technician Email: ");
        String email = input.nextLine();

        System.out.print("Enter Technician Phone Number (10 digits): ");
        String phoneNumber = getValidPhoneNumber(input);

        System.out.print("Enter Technician Specialty: ");
        String specialty = input.nextLine();

        Technician technician = new Technician(technicianId, firstName, lastName, email, phoneNumber, specialty);
        technicians.add(technician); // Adds to technicians list
        System.out.println("Technician created successfully!\n");
    }

    private void displayTechnicians() { // Displays information of all technicians
        if (technicians.isEmpty()) {
            System.out.println("No technicians available.\n");
        } else {
            for (Technician it : technicians) {
                System.out.println(it.getTechnicianInfo());
            }
        }
    }

    private void assignTechnicianToLab(Scanner input) { // Assigns a technician to a lab
        System.out.print("Enter Technician ID to assign: ");
        int technicianId = getValidIntInput(input);

        System.out.print("Enter Lab ID to assign the technician to: ");
        int labId = getValidIntInput(input);

        Technician technician = null; // Set to null; no value
        for (Technician it : technicians) { // Loop in list and compare it to input technicianId
            if (it.getTechnicianId() == technicianId) {
                technician = it;
                break;
            }
        }

        Lab lab = null; // Set null
        for (Lab l : labs) { // Loop in list and compare it to input labId
            if (l.getLabId() == labId) {
                lab = l;
                break;
            }
        }

        if (technician != null && lab != null) { // Case for setting none-null values to matching ids
            lab.addTechnician(technician);
            System.out.println("Technician assigned to Lab successfully!\n");
        } else {
            System.out.println("Invalid Technician ID or Lab ID.\n"); // Rare else condition given it passed for loops at this stage
        }
    }

    private void createLabEquipment(Scanner input) { // Creates new Lab Equipment
        System.out.print("Enter Equipment ID: ");
        int equipmentId = getValidIntInput(input);
        //input.nextLine(); // Consumes newline

        System.out.print("Enter Equipment Name: ");
        String equipmentName = input.nextLine();

        System.out.print("Enter Lab ID for the equipment: ");
        int labId = getValidIntInput(input);

        System.out.print("Enter Equipment State (1 for Functional, 0 for Non-Functional): ");
        boolean state = input.nextInt() == 1; // Concise way to say, state holds true if user input is 1

        LabEquipment equipment = new LabEquipment(equipmentId, equipmentName, labId, state);
        labEquipment.add(equipment); // Adds to labEquipment list
        System.out.println("Equipment created successfully!\n");
    }

    private void assignLabEquipmentToLab(Scanner input) {
        System.out.print("Enter Equipment ID to assign: ");
        int labEquipmentId = getValidIntInput(input);

        System.out.print("Enter Lab ID to assign the equipment to: ");
        int labId = getValidIntInput(input);

        LabEquipment equipment = null; // Set to null; no value
        for (LabEquipment equip : labEquipment) { // Loop in list and compare it to input labEquipmentId
            if (equip.getLabEquipmentId() == labEquipmentId) {
                equipment = equip;
                break;
            }
        }

        Lab lab = null; // Set null
        for (Lab l : labs) { // Loop in list and compare it to input labId
            if (l.getLabId() == labId) {
                lab = l;
                break;
            }
        }

        if (equipment != null && lab != null) { // Case for setting none-null values to matching ids
            lab.addEquipment(equipment);
            System.out.println("Equipment assigned to Lab successfully!\n");
        } else {
            System.out.println("Invalid Equipment ID or Lab ID.\n"); // Rare else condition given it passed for loops at this stage
        }
    }

    private void displayLabEquipment() { // Displays information of all laboratory equipment
        if (labEquipment.isEmpty()) {
            System.out.println("No lab equipment available.\n");
        } else {
            for (LabEquipment equip : labEquipment) {
                System.out.println(equip.getLabEquipmentInfo());
            }
        }
    }

    private void showMenu() { // Main menu display
        System.out.println("===== Lab Management System =====");
        System.out.println("1. Create Lab");
        System.out.println("2. Display Labs");
        System.out.println("3. Create Technician");
        System.out.println("4. Display Technicians");
        System.out.println("5. Assign Technician to Lab");
        System.out.println("6. Create Lab Equipment");
        System.out.println("7. Display Lab Equipment");
        System.out.println("8. Assign Equipment to Lab");
        System.out.println("9. Exit");
        System.out.print("Choose an option: ");
    }

    public void start() { // the main system
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
                case 8 -> assignLabEquipmentToLab(scanner);
                case 9 -> System.out.println("Exiting...");
                default -> System.out.println("Invalid choice. Please try again.\n");
            }
        } while (choice != 9);
        scanner.close();
    }

    public static void main(String[] args) { // the main method
        LabInformation app = new LabInformation();
        app.start();
    }
}
