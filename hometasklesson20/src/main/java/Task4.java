public class Task4 {
    public static void main(String[] args) {

        Marker  marker = new Marker();

        TreadPrintNumber thread6 = new TreadPrintNumber(1, marker);
        TreadPrintNumber thread7 = new TreadPrintNumber(2, marker);

        thread6.start();
        thread7.start();

    }
}
