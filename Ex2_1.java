import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import  java.util.Random;
public class Ex2_1 {

    public static String[] createTextFiles(int n, int seed, int bound) throws FileNotFoundException {
        String fileNamePrefix = "File_";
        String fileNameSuffix = ".txt";
        String []arr =new String[n];

        for (int i = 0; i < n; i++) {
            String fileName = fileNamePrefix + i + fileNameSuffix;
            try {
            File file = new File(fileName);

                boolean fileCreate = file.createNewFile();
                if (fileCreate) {
                    arr[i]=fileName;
                    System.out.println("File created: " + fileName);
                } else {
                    System.out.println("File already exists");
                    break;
                }

                PrintWriter writer= new PrintWriter(file);
            int numberOfLines= lines(seed,bound);
           for (int j=0;j<numberOfLines;j++) {
                writer.println("Hello line: "+j);
         }
                writer.close();

            }

            catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        return arr;
    }

    static int lines(int seed, int bound) {
        int n = 10;
        Random rand = new Random(2);
            int x = rand.nextInt(bound);
            return x;
        }
    }














