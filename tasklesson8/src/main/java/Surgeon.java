public class Surgeon extends Doctor {
    private Patient patient;

    public Surgeon (Patient patient) {
        this.patient = patient;
    }
    public void treat() {
        System.out.println(patient.getName() + " лечит хирург");
    }
}
