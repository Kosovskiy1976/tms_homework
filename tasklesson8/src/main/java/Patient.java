public class Patient {
    private int treatmentPlan;
    private Doctor doc;

    public Patient(int treatmentPlan) {
        this.treatmentPlan = treatmentPlan;
        this.doc = null;
    }

    public int getTreatmentPlan() {
        return treatmentPlan;
    }

    public void setDoc(Doctor doc) {
        this.doc = doc;
    }

}
