import java.io.FileNotFoundException;

public class main {

        public static void main(String[] args) throws FileNotFoundException {

           String []arr= new String[10];
           arr =Ex2_1.createTextFiles(10,2,3);
           for(int i=0;i<10;i++)
           {
               System.out.println(arr[i]);
           }

        }
    }



