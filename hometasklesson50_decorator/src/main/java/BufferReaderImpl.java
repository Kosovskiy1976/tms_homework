
// Читает по 5 букв с места курсора
public class BufferReaderImpl implements Reader {

    private Reader reader;

    public BufferReaderImpl(Reader reader) {
        this.reader = reader;
    }

    @Override
    public String read(String text, int number) {

        String subText = "";

        if ((number + 5) > text.length()) {
            return "null";}

        for (int i = 0; i < 5; i++) {
            String read = reader.read(text, number + i);
            subText = subText + read;
        }

        return subText;
    }
}
