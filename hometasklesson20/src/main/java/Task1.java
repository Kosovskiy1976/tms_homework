public class Task1 {
    public static void main(String[] args) {

        MyThread thread1 = new MyThread();
        Thread thread2 = new Thread(() -> System.out.println("run " + Thread.currentThread().getName()));

        thread1.start();
        thread2.start();

        try {
            thread1.join();
        } catch (InterruptedException e){
            System.out.println(e.getMessage());
        }

        try {
            thread2.join();
        } catch (InterruptedException e){
            System.out.println(e.getMessage());
        }
    }
}
