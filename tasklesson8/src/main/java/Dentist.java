public class Dentist extends Doctor{
    private Patient patient;

    public Dentist (Patient patient) {
        this.patient = patient;
    }
    public void treat() {
        System.out.println(patient.getName() + " лечит дантист");
    }
}
