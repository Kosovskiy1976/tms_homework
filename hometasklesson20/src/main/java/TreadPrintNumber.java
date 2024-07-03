public class TreadPrintNumber extends Thread{

    private int n;
    private Marker marker;

    public TreadPrintNumber(int n, Marker marker) {
        this.n = n;
        this.marker = marker;
    }

    @Override
    public void run() {
        Print print = new Print();
        for (;;){
          print.print(n, marker);
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
