import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        ArrayList<String> arr = new ArrayList<>();
        for(int i=0; i<N; i++){
            arr.add(br.readLine());
        }
        ArrayList<String> increase = new ArrayList<>();
        ArrayList<String> decrease = new ArrayList<>();

        increase.addAll(arr);
        decrease.addAll(arr);
        Collections.sort(increase);
        Collections.sort(decrease, Collections.reverseOrder());

        if(arr.equals(increase)){
            System.out.println("INCREASING");
        }
        else if(arr.equals(decrease)){
            System.out.println("DECREASING");
        }
        else {
            System.out.println("NEITHER");
        }

    }
}
