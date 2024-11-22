//name=Your Name
//id=Your ID

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

    // Constructors
    /**
     * Default constructor.
     */
    public Technician() {
        this.technicianId = 0;
        this.firstName = "";
        this.lastName = "";
        this.email = "";
        this.phoneNumber = "";
        this.specialty = "";
    }

    /**
     * Parameterized constructor.
     * @param technicianId the technician's unique ID
     * @param firstName the technician's first name
     * @param lastName the technician's last name
     * @param email the technician's email address
     * @param phoneNumber the technician's phone number
     * @param specialty the technician's area of expertise
     */
    public Technician(int technicianId, String firstName, String lastName, String email, String phoneNumber, String specialty) {
        this.technicianId = technicianId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.specialty = specialty;
    }

    // Getters and Setters
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

    // Method to display technician's information
    /**
     * Returns a formatted string containing the technician's information.
     * @return technician's details as a string
     */
    public String getTechnicianInfo() {
        return String.format("Technician ID: %d%nName: %s %s%nEmail: %s%nPhone: %s%nSpecialty: %s%n",
                technicianId, firstName, lastName, email, phoneNumber, specialty);
    }

    // Main method for testing purposes
    public static void main(String[] args) {
        Technician technician = new Technician(101, "John", "Doe", "john.doe@example.com", "123-456-7890", "Networking");
        System.out.println(technician.getTechnicianInfo());
    }
}
