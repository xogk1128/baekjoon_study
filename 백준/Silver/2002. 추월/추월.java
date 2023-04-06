import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        Map<String, Integer> map = new HashMap<>();

        for(int i=0; i<N; i++){
            map.put(br.readLine(), i);
        }
        int[] arr = new int[N];
        int cnt = 0;
        for(int i=0; i<N; i++){
            arr[i] = map.get(br.readLine());
        }

        for(int i=0; i<N-1; i++){
            for(int j=i+1; j<N; j++){
                if(arr[i] > arr[j]){
                    cnt++;
                    break;
                }
            }
        }

        System.out.println(cnt);

    }
}
