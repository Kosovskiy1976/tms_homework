public class Print {

    public  void print(int n, Marker marker) {
        synchronized (marker) {
            System.out.println(n);
            System.out.println(n);
            System.out.println(n);
        }
    }
}
