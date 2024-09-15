
// читает по одной букве с места курсора
public class ReaderImpl implements Reader {
    @Override
    public String read(String text, int number) {

        int length = text.length();

        if (length < number) {
            return "null"; }

        return text.substring(number, number + 1) ;
    }
}
