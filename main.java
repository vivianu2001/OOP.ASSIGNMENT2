import java.io.FileNotFoundException;
import java.io.IOException;

public class main {

        public static void main(String[] args) throws IOException {

           String []arr= new String[10];
           arr =Ex2_1.createTextFiles(10,2,3);
//           for(int i=0;i<10;i++)
//           {
//               System.out.println(arr[i]);
//           }
            System.out.println(Ex2_1.getNumOfLinesThreads(arr));
        }
    }



