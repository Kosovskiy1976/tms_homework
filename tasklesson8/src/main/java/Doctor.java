public enum Doctor {
    Surgeon {
        public void treat() {
            System.out.println("Лечит хирург");
        }

        @Override
        public void getDoctor(Patient patient) {

        }
    },
    Therapist {
        public void treat() {
            System.out.println("Лечит терапевт");
        }

        public void getDoctor(Patient patient) {
            int plan = patient.getTreatmentPlan();

            if (plan == 1) {
                patient.setDoc(Surgeon);
                Doctor.Surgeon.treat();
            } else if (plan == 2) {
                patient.setDoc(Dentist);
                Doctor.Dentist.treat();
            } else {
                patient.setDoc(Therapist);
                Doctor.Therapist.treat();
            }

        }

    },

    Dentist {
        public void treat() {
            System.out.println("Лечит дантист");
        }

        @Override
        public void getDoctor(Patient patient) {

        }
    };

    public abstract void treat();

    public abstract void getDoctor(Patient patient);

}
