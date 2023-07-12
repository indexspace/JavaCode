import java.io.*;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;
import java.nio.charset.CharsetEncoder;
import java.nio.charset.StandardCharsets;

public class ReaderTest {
    public static void main(String[] args) throws IOException {

        File file1 = new File("C:\\Users\\28388\\OneDrive\\桌面\\Test1.txt");

        FileWriter fileWriter = new FileWriter(file1);
        fileWriter.write("hello");
        fileWriter.append("c");

        Charset charset = StandardCharsets.UTF_8;

        FileReader fileReader = new FileReader(file1, charset);  // TODO: 读不出来
        int i;
        while((i = fileReader.read()) != -1) {
            System.out.println((char) i);
        }

        fileWriter.close();
        fileReader.close();

    }
}

