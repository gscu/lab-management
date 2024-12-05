//name= Gheorghe Georgescu
//id= 301377303

/**
 * Class representing a Technician in the Lab Management system.
 * This class encapsulates details about a technician such as ID, name, contact details, and specialty.
 */

public class Technician {
    // Instance variables
    private int technicianId;
    private String firstName;
    private String lastName;
    private String email;
    private String phoneNumber;
    private String specialty;

    public Technician() { // Default constructor
        this.technicianId = 0;
        this.firstName = "";
        this.lastName = "";
        this.email = "";
        this.phoneNumber = "";
        this.specialty = "";
    }

    /**
     * Constructor with parameters
     * technicianId - the technician's unique ID
     * firstName - the technician's first name
     * lastName - the technician's last name
     * email - the technician's email address
     * phoneNumber - the technician's phone number
     * specialty - the technician's area of expertise
     */
    public Technician(int technicianId, String firstName, String lastName, String email, String phoneNumber, String specialty) {
        this.technicianId = technicianId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.specialty = specialty;
    }

    // Getters and setters
    public int getTechnicianId() {
        return technicianId;
    }

    public void setTechnicianId(int technicianId) {
        this.technicianId = technicianId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getSpecialty() {
        return specialty;
    }

    public void setSpecialty(String specialty) {
        this.specialty = specialty;
    }

    public String getTechnicianInfo() { // Method to display technician's information and returns a formatted string containing the technician's information
        return String.format("Technician ID: %d%nName: %s %s%nEmail: %s%nPhone: %s%nSpecialty: %s%n",
                technicianId, firstName, lastName, email, phoneNumber, specialty);
    }

    public static void main(String[] args) { // Main method for testing purposes
        Technician technician = new Technician(101, "John", "Doe", "john.doe@example.com", "123-456-7890", "Networking");
        System.out.println(technician.getTechnicianInfo());
    }
}
