public class Therapist extends Doctor {

    private Patient patient;

    public Therapist(Patient patient) {
        this.patient = patient;
    }

    public void treat() {
        System.out.println(patient.getName() + " лечит терапевт");
    }

    public void getDoctor() {
        int plan = patient.getTreatmentPlan();

        if (plan == 1) {
            Surgeon surgeon = new Surgeon(patient);
            patient.setDoc(surgeon);
            surgeon.treat();
        } else if (plan == 2) {
            Dentist dentist = new Dentist(patient);
            patient.setDoc(dentist);
            dentist.treat();
        } else {
            patient.setDoc(this);
            this.treat();

        }

    }

}
