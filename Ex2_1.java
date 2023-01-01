import java.io.*;
import  java.util.Random;
public class Ex2_1 {

    public static String[] createTextFiles(int n, int seed, int bound) throws FileNotFoundException {
        String fileNamePrefix = "File_";
        String fileNameSuffix = ".txt";
        String[] arr = new String[n];

        for (int i = 0; i < n; i++) {
            String fileName = fileNamePrefix + i + fileNameSuffix;
            try {
                File file = new File(fileName);

                boolean fileCreate = file.createNewFile();
                if (fileCreate) {
                    arr[i] = fileName;
                    System.out.println("File created: " + fileName);
                } else {
                    System.out.println("File already exists");
                    break;
                }
                PrintWriter writer = new PrintWriter(file);
                int numberOfLines = lines(seed, bound);
                for (int j = 0; j < numberOfLines; j++) {
                    writer.println("Hello line: " + j);
                }
                writer.close();

            } catch (IOException e) {
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


    public static int getNumOfLines(String[] fileNames) throws IOException {
        int lines = 0;
        for (int i = 0; i < fileNames.length; i++) {
            try {
                BufferedReader reader = new BufferedReader(new FileReader(fileNames[i]));
                while (reader.readLine() != null) {
                    lines++;

                }
            } catch (IOException e) {
                e.printStackTrace();
            }


        }
        return lines;

    }


    static public int getNumOfLinesThreads(String[] fileNames) {
        LinesT[] linesthreads = new LinesT[fileNames.length];

        for (int i = 0; i < linesthreads.length; i++) {
            linesthreads[i] = new LinesT(fileNames[i]);
            linesthreads[i].start();

        }
        for (LinesT t : linesthreads) {
            try {
                t.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
        return LinesT.totalines;


    }
}


















