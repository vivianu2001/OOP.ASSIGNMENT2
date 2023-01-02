import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class LinesCounterThread extends Thread {
private  String filename;
private int totalines;

LinesCounterThread(String filename)
    {
     this.filename=filename;
    }

@Override
   public void run()
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

    public int getTotalines()
    {
        return totalines;
    }


}
