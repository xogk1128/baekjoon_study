import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] index = new int[8];
        ArrayList<Integer> arr = new ArrayList<>();
        for(int i=0; i<8; i++){
            int num = Integer.parseInt(br.readLine());
            index[i] = num;
            arr.add(num);
        }

        Collections.sort(arr, Collections.reverseOrder());
        int sum = 0;
        for(int i=0; i<5; i++){
            sum += arr.get(i);
        }
        System.out.println(sum);

        StringBuilder sb = new StringBuilder();
        for(int i=0; i<8; i++){
            for(int j=0; j<5; j++){
                if(index[i] == arr.get(j))
                    sb.append((i+1) + " ");
            }
        }
        System.out.println(sb);
    }
}
