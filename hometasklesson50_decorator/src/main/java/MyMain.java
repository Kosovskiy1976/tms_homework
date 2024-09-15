public class MyMain {

    public static void main(String[] args) throws InterruptedException {

        String text = "gfdhglkj";

        int length = text.length();

        Reader reader = new BufferReaderImpl(new ReaderImpl());

        for (int i = 0; i < (length - 1); i++) {
            Thread.sleep(2000);
            System.out.println(reader.read(text, i));

        }
    }
}
