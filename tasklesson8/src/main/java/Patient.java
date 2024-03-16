public class Patient {
    private int treatmentPlan;
    private Doctor doctor;
    private String name;

    public Patient(String name, int treatmentPlan) {
        this.name = name;
        this.treatmentPlan = treatmentPlan;
        this.doctor = null;
    }

    public String getName() {
        return name;
    }

    public int getTreatmentPlan() {
        return treatmentPlan;
    }

    public void setDoc(Doctor doc) {
        this.doctor = doc;
    }

}
