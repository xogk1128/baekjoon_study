import java.io.*;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collections;

public class Main {

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(br.readLine());
        ArrayList<Integer> arr = new ArrayList<Integer>();
        while(num > 0){
            arr.add(num%10);
            num /= 10;
        }
        Collections.sort(arr, Collections.reverseOrder());

        for(int val : arr)
            System.out.print(val);


    }
}
