import java.io.*;
import  java.util.Random;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ThreadPoolExecutor;

public class Ex2_1 {

    public static void main(String[] args)  {
        String[] filenames = createTextFiles(2, 2, 100);
        System.out.println(getNumOfLines(filenames));
        System.out.println(getNumOfLinesThreads(filenames));
        System.out.println(getNumOfLinesThreadPool(filenames));

    }

    public static String[] createTextFiles(int n, int seed, int bound) {
        String fileNamePrefix = "File_";
        String fileNameSuffix = ".txt";
        String[] filenames = new String[n];
        Random random = new Random(seed);

        for (int i = 0; i < n; i++) {
            String fileName = fileNamePrefix + i + fileNameSuffix;
            try {
                File file = new File(fileName);
                boolean fileCreate = file.createNewFile();
                if (fileCreate) {
                    filenames[i] = fileName;
                    System.out.println("File created: " + fileName);
                } else {
                    System.out.println("File already exists");
                    //break;
                }
                PrintWriter writer = new PrintWriter(file);
                int numberOfLines = random.nextInt(bound);
                for (int j = 0; j < numberOfLines; j++) {
                    writer.println("Hello line: " + j);
                }
                writer.close();

            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        return filenames;
    }


    public static int getNumOfLines(String[] fileNames) {
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
        LinesCounterThread[] threads = new LinesCounterThread[fileNames.length];
        int totalnumberoflines = 0;
        for (int i = 0; i < threads.length; i++) {
            threads[i] = new LinesCounterThread(fileNames[i]);
            threads[i].start();

        }
        for (LinesCounterThread t : threads) {
            try {
                t.join();
                totalnumberoflines = totalnumberoflines + t.getTotalines();

            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
        return totalnumberoflines;


    }




    public static int getNumOfLinesThreadPool(String[] fileNames)  {
        ThreadPoolExecutor executor=(ThreadPoolExecutor) Executors.newFixedThreadPool(fileNames.length) ;
        LineCounterThreadpool[] tasks=new LineCounterThreadpool[fileNames.length];
        Future<Integer>[] results= new Future[fileNames.length];
        int totalnumberoflines = 0;

        for (int i = 0; i < fileNames.length; i++) {
            tasks[i] = new LineCounterThreadpool(fileNames[i]);

        }

        for (int i = 0; i < fileNames.length; i++) {
            results[i] = executor.submit(tasks[i]);

        }

        executor.shutdown();
        for(Future<Integer> result :results)
        {
            try {
                totalnumberoflines =totalnumberoflines +result.get();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            } catch (ExecutionException e) {
                throw new RuntimeException(e);
            }

        }
       
return totalnumberoflines;
        
    }








}


















