import java.io.*;

public class MakeText {
    public static void main(String[] args) {

        try (LineNumberReader reader = new LineNumberReader(new FileReader("D:Romeo_Juletta.txt"));
             BufferedWriter fileWriter1 = new BufferedWriter(new FileWriter("D:Romeo.txt"));
             BufferedWriter fileWriter2 = new BufferedWriter(new FileWriter("D:Juletta.txt"))) {

            String str = reader.readLine();

            while (str != null) {

                while ((str != null) && !(str.startsWith("Gulieta"))) {
                    fileWriter1.write(str + "\n");
                    str = reader.readLine();
                }

                while ((str != null) && !(str.startsWith("Romeo"))) {
                    fileWriter2.write(str + "\n");
                    str = reader.readLine();
                }

            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
