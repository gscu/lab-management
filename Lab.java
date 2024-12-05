//name= Jude Kerwynn Nacario
//id= 301438533

/**
 * Class representing a Lab in the Lab Management system.
 * This class encapsulates details about a lab, including its ID, name, contact information,
 * associated technicians, and equipment.
 */

import java.util.ArrayList;
import java.util.List;

public class Lab  {// Start of class Lab
    // Instance variables
    private int labId;
    private String labName;
    private String phoneNumber;
    private List<LabEquipment> labEquipment;
    private List<Technician> technicians;

    public Lab() {// Default constructor
        this.labId = 0;
        this.labName = "";
        this.phoneNumber = "";
        this.labEquipment = new ArrayList<>();
        this.technicians = new ArrayList<>();
    }

    public Lab(int labId, String labName, String phoneNumber) {// Constructor with parameters
        this.labId = labId;
        this.labName = labName;
        this.phoneNumber = phoneNumber;
        this.labEquipment = new ArrayList<>();
        this.technicians = new ArrayList<>();
    }

    // Getters and Setters
    public int getLabId() {
        return labId;
    }

    public void setLabId(int labId) {
        this.labId = labId;
    }

    public String getLabName() {
        return labName;
    }

    public void setLabName(String labName) {
        this.labName = labName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public List<LabEquipment> getLabEquipment() {
        return labEquipment;
    }

    public List<Technician> getTechnicians() {
        return technicians;
    }

    // Methods
    public void addEquipment(LabEquipment equipment) {// Adds a piece of equipment to the lab.
        labEquipment.add(equipment);
    }

    public void addTechnician(Technician technician) {// Adds a technician to the lab.
        technicians.add(technician);
    }

    public String getLabInfo() {// Returns a formatted string containing the lab's information.
        StringBuilder info = new StringBuilder();
        info.append(String.format("Lab ID: %d%nLab Name: %s%nPhone: %s%n", labId, labName, phoneNumber));
        info.append("Technicians Assigned:\n");
        for (Technician tech : technicians) {
            info.append("  - ").append(tech.getTechnicianInfo()).append("\n");
        }
        info.append("Lab Equipment:\n");
        for (LabEquipment equip : labEquipment) {
            info.append("  - ").append(equip.getLabEquipmentInfo()).append("\n");
        }
        return info.toString();
    }

    public static void main(String[] args) {// Main method for testing purposes
        Lab lab = new Lab(1, "Computer Lab", "555-1234");
        Technician tech = new Technician(101, "Alice", "Smith", "alice.smith@example.com", "123-456-7890", "Hardware");
        LabEquipment equip = new LabEquipment(201, "Printer", 1, true);

        lab.addTechnician(tech);
        lab.addEquipment(equip);

        System.out.println(lab.getLabInfo());
    }
}//End of class Lab
