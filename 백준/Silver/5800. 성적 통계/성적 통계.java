import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int K = Integer.parseInt(br.readLine());
        ArrayList<Integer> arr;
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        for(int i=0; i<K; i++){
            arr = new ArrayList<>();
            sb.append("Class " + (i+1)).append("\n");
            st = new StringTokenizer(br.readLine());

            int N = Integer.parseInt(st.nextToken());

            for(int j=0; j<N; j++){
                arr.add(Integer.parseInt(st.nextToken()));
            }
            Collections.sort(arr, Collections.reverseOrder());

            int gap = 0;
            for(int j=0; j<arr.size()-1; j++){
                if(gap < arr.get(j)-arr.get(j+1))
                    gap = arr.get(j)-arr.get(j+1);
            }
            sb.append("Max " + arr.get(0) + ", Min " + arr.get(arr.size()-1) + ", Largest gap " + gap + "\n");
        }
        System.out.println(sb);
    }
}
