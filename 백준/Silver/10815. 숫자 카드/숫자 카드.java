import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        Map<Integer, Integer> map = new LinkedHashMap<>();
        int N= Integer.parseInt(br.readLine());
        int[] tmp = new int[N];

        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N;i++){
            tmp[i] = Integer.parseInt(st.nextToken());
        }
        int M = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<M; i++){
            map.put(Integer.parseInt(st.nextToken()), 0);

        }
        for(int i=0; i<N;i++){
            if(map.containsKey(tmp[i]))
                map.replace(tmp[i], 1);
        }

        for (Integer num : map.keySet()) {
            System.out.print(map.get(num) + " ");
        }

    }
}
