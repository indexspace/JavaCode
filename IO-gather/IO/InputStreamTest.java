import java.io.*;

public class InputStreamTest {
    public static void main(String[] args) throws IOException {
        File file2 = new File("C:\\Users\\28388\\OneDrive\\桌面\\Test2.txt");

        FileOutputStream fileOutputStream = new FileOutputStream(file2);
        fileOutputStream.write("hello world".getBytes());
        fileOutputStream.close();

        FileInputStream fileInputStream = new FileInputStream(file2);
        byte [] buffer = new byte[15];
        int i;
        while ((i = fileInputStream.read(buffer)) != -1) {
            System.out.println((char) i);
        }
        fileInputStream.close();


    }
}
