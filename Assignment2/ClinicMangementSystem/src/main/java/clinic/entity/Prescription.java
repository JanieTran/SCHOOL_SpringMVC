package clinic.entity;

public class Prescription {
    // ====================================================================
    // PROPERTIES
    // ====================================================================

    private String drugName;
    private int quantity;
    private String dose;
    private String instruction;

    // ====================================================================
    // CONSTRUCTOR
    // ====================================================================

    public Prescription(String drugName, int quantity, String dose, String instruction) {
        this.drugName = drugName;
        this.quantity = quantity;
        this.dose = dose;
        this.instruction = instruction;
    }

    // ====================================================================
    // GETTERS
    // ====================================================================

    public String getDrugName() {
        return drugName;
    }

    public int getQuantity() {
        return quantity;
    }

    public String getDose() {
        return dose;
    }

    public String getInstruction() {
        return instruction;
    }

    // ====================================================================
    // SETTERS
    // ====================================================================

    public void setDrugName(String drugName) {
        this.drugName = drugName;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void setDose(String dose) {
        this.dose = dose;
    }

    public void setInstruction(String instruction) {
        this.instruction = instruction;
    }
}
