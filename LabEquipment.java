//name=Your Name
//id=Your ID

/**
 * Class representing Lab Equipment in the Lab Management system.
 * This class encapsulates details about lab equipment, including its ID, name, associated lab, and state.
 */
public class LabEquipment {
    // Instance variables
    private int labEquipmentId;
    private String labEquipmentName;
    private int labId;
    private boolean equipmentState; // true for functional, false for non-functional

    // Constructors
    /**
     * Default constructor.
     */
    public LabEquipment() {
        this.labEquipmentId = 0;
        this.labEquipmentName = "";
        this.labId = 0;
        this.equipmentState = false;
    }

    /**
     * Parameterized constructor.
     * @param labEquipmentId the unique ID of the lab equipment
     * @param labEquipmentName the name of the lab equipment
     * @param labId the ID of the lab where the equipment is located
     * @param equipmentState the state of the equipment (true for functional, false for non-functional)
     */
    public LabEquipment(int labEquipmentId, String labEquipmentName, int labId, boolean equipmentState) {
        this.labEquipmentId = labEquipmentId;
        this.labEquipmentName = labEquipmentName;
        this.labId = labId;
        this.equipmentState = equipmentState;
    }

    // Getters and Setters
    public int getLabEquipmentId() {
        return labEquipmentId;
    }

    public void setLabEquipmentId(int labEquipmentId) {
        this.labEquipmentId = labEquipmentId;
    }

    public String getLabEquipmentName() {
        return labEquipmentName;
    }

    public void setLabEquipmentName(String labEquipmentName) {
        this.labEquipmentName = labEquipmentName;
    }

    public int getLabId() {
        return labId;
    }

    public void setLabId(int labId) {
        this.labId = labId;
    }

    public boolean isEquipmentState() {
        return equipmentState;
    }

    public void setEquipmentState(boolean equipmentState) {
        this.equipmentState = equipmentState;
    }

    // Methods
    /**
     * Returns a formatted string containing the lab equipment's information.
     * @return lab equipment details as a string
     */
    public String getLabEquipmentInfo() {
        return String.format("Equipment ID: %d%nName: %s%nLab ID: %d%nState: %s%n",
                labEquipmentId, labEquipmentName, labId, (equipmentState ? "Functional" : "Non-Functional"));
    }

    // Main method for testing purposes
    public static void main(String[] args) {
        LabEquipment equipment = new LabEquipment(101, "Microscope", 1, true);
        System.out.println(equipment.getLabEquipmentInfo());
    }
}
