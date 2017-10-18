import java.io.*;
import java.util.Arrays;

public class ServerLogReader {

    public static void readFromFile(String path) {

        BufferedReader br = null;
        try {

            InputStream stream = ServerLogReader.class.getClassLoader().getResourceAsStream(path);

            String currentLine;
            br = new BufferedReader(new InputStreamReader(stream));//file name with path
            while ((currentLine = br.readLine()) != null) {
                String[] strArr = currentLine.split("\\|");
                //Arrays.stream(strArr).filter(s -> );
                System.out.println(strArr[0] + " | " + strArr[1]);
            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (br != null) {
                    br.close();
                }
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }
}
