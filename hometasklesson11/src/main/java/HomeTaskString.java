import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class HomeTaskString {
    public static void main(String[] args) {
        String string = "I like Java!";
        System.out.println(string.length());

        StringBuilder stringBuilder = new StringBuilder("");

        String[] arrayString = string.split(" ");
        for (String st: arrayString){
            System.out.println("length word " + st + " = " + st.length());
            stringBuilder.append(st + " ");
        }
        StringBuilder stringRev = stringBuilder
                .reverse()
                .delete(0, 1);
        System.out.println(stringRev);

        String substring = string.substring(7);
        System.out.println(substring);

        Pattern pattern = Pattern.compile(".{2,}@[a-z.]{2,}");
        Matcher matcher = pattern.matcher("ddda@com");
        while (matcher.find()) {
            System.out.println(matcher.start() + "  " + matcher.group());
        }


    }

}
