import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class LinesT extends Thread {
private  String filename;
    volatile static int totalines=0;

    LinesT(String filename)
    {
     this.filename=filename;
    }
    public void run(String filename)
    {

        try {
            BufferedReader reader=new BufferedReader(new FileReader(filename));
            while (reader.readLine()!=null)
            {
                totalines ++;

            }
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }

    }



}
