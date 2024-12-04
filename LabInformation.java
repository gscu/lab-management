//name= Gheorghe Georgescu
//id= 301377303

/**
 * Driver class for the Lab Management system.
 * Provides a menu-driven interface for managing labs, technicians, and lab equipment.
 */
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class LabInformation {
    // Instance variables for storing data
    private List<Lab> labs;
    private List<Technician> technicians;
    private List<LabEquipment> labEquipment;

    // Constructor
    public LabInformation() {
        this.labs = new ArrayList<>();
        this.technicians = new ArrayList<>();
        this.labEquipment = new ArrayList<>();
    }

    // Methods to handle different functionalities

    // Create a new Lab
    private void createLab(Scanner scanner) {
        System.out.print("Enter Lab ID: ");
        int labId = scanner.nextInt();
        scanner.nextLine(); // Consume newline
        System.out.print("Enter Lab Name: ");
        String labName = scanner.nextLine();
        System.out.print("Enter Lab Phone Number: ");
        String phoneNumber = scanner.nextLine();

        Lab lab = new Lab(labId, labName, phoneNumber);
        labs.add(lab);
        System.out.println("Lab created successfully!\n");
    }

    // Display information of all Labs
    private void displayLabs() {
        if (labs.isEmpty()) {
            System.out.println("No labs available.\n");
        } else {
            for (Lab lab : labs) {
                System.out.println(lab.getLabInfo());
            }
        }
    }

    // Create a new Technician
    private void createTechnician(Scanner scanner) {
        System.out.print("Enter Technician ID: ");
        int technicianId = scanner.nextInt();
        scanner.nextLine(); // Consume newline
        System.out.print("Enter Technician First Name: ");
        String firstName = scanner.nextLine();
        System.out.print("Enter Technician Last Name: ");
        String lastName = scanner.nextLine();
        System.out.print("Enter Technician Email: ");
        String email = scanner.nextLine();
        System.out.print("Enter Technician Phone Number: ");
        String phoneNumber = scanner.nextLine();
        System.out.print("Enter Technician Specialty: ");
        String specialty = scanner.nextLine();

        Technician technician = new Technician(technicianId, firstName, lastName, email, phoneNumber, specialty);
        technicians.add(technician);
        System.out.println("Technician created successfully!\n");
    }

    // Display information of all Technicians
    private void displayTechnicians() {
        if (technicians.isEmpty()) {
            System.out.println("No technicians available.\n");
        } else {
            for (Technician tech : technicians) {
                System.out.println(tech.getTechnicianInfo());
            }
        }
    }

    // Assign a Technician to a Lab
    private void assignTechnicianToLab(Scanner scanner) {
        System.out.print("Enter Technician ID to assign: ");
        int technicianId = scanner.nextInt();
        System.out.print("Enter Lab ID to assign the technician to: ");
        int labId = scanner.nextInt();

        Technician technician = technicians.stream()
                .filter(t -> t.getTechnicianId() == technicianId)
                .findFirst()
                .orElse(null);
        Lab lab = labs.stream()
                .filter(l -> l.getLabId() == labId)
                .findFirst()
                .orElse(null);

        if (technician != null && lab != null) {
            lab.addTechnician(technician);
            System.out.println("Technician assigned to Lab successfully!\n");
        } else {
            System.out.println("Invalid Technician ID or Lab ID.\n");
        }
    }

    // Create new Lab Equipment
    private void createLabEquipment(Scanner scanner) {
        System.out.print("Enter Equipment ID: ");
        int equipmentId = scanner.nextInt();
        scanner.nextLine(); // Consume newline
        System.out.print("Enter Equipment Name: ");
        String equipmentName = scanner.nextLine();
        System.out.print("Enter Lab ID for the equipment: ");
        int labId = scanner.nextInt();
        System.out.print("Enter Equipment State (1 for Functional, 0 for Non-Functional): ");
        boolean state = scanner.nextInt() == 1;

        LabEquipment equipment = new LabEquipment(equipmentId, equipmentName, labId, state);
        labEquipment.add(equipment);

        Lab lab = labs.stream()
                .filter(l -> l.getLabId() == labId)
                .findFirst()
                .orElse(null);
        if (lab != null) {
            lab.addEquipment(equipment);
        }

        System.out.println("Lab Equipment created successfully!\n");
    }

    // Display information of all Lab Equipment
    private void displayLabEquipment() {
        if (labEquipment.isEmpty()) {
            System.out.println("No lab equipment available.\n");
        } else {
            for (LabEquipment equip : labEquipment) {
                System.out.println(equip.getLabEquipmentInfo());
            }
        }
    }

    // Main menu
    private void showMenu() {
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

    // Driver method
    public void start() {
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            showMenu();
            choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1 -> createLab(scanner);
                case 2 -> displayLabs();
                case 3 -> createTechnician(scanner);
                case 4 -> displayTechnicians();
                case 5 -> assignTechnicianToLab(scanner);
                case 6 -> createLabEquipment(scanner);
                case 7 -> displayLabEquipment();
                case 8 -> System.out.println("Exiting... Thank you!");
                default -> System.out.println("Invalid choice. Please try again.\n");
            }
        } while (choice != 8);

        scanner.close();
    }

    // Main method
    public static void main(String[] args) {
        LabInformation app = new LabInformation();
        app.start();
    }
}
