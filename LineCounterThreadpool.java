import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.concurrent.Callable;

public class LineCounterThreadpool implements Callable {

    private String filename;
    private int totalines;


    LineCounterThreadpool(String filename)
    {
        this.filename=filename;
    }



    @Override
    public Integer call()  {

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
        return totalines;
    }
}
