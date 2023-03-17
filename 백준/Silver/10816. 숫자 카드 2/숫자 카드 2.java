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
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        Map<Integer, Integer> take = new HashMap<>();

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++){
            int num = Integer.parseInt(st.nextToken());
            if(take.containsKey(num))
                take.replace(num, take.get(num)+1);
            else
                take.put(num, 1);
        }
        int M = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());

        for(int i=0; i<M; i++){
            int num = Integer.parseInt(st.nextToken());
            if(take.containsKey(num))
                sb.append(take.get(num) + " ");
            else
                sb.append(0 + " ");
        }

        System.out.println(sb);
    }
}
