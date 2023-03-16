import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        Map<String, Integer> tmp = new HashMap<>();
        List<String> res = new ArrayList<>();

        for(int i=0; i<N; i++){
            tmp.put(br.readLine(), 0);
        }

        int cnt = 0;
        for(int i=0; i<M; i++){
            String str = br.readLine();
            if(tmp.containsKey(str)){
                cnt++;
                res.add(str);
            }

        }

        Collections.sort(res);
        
        System.out.println(cnt);
        for (String re : res) {
            System.out.println(re);
        }
    }
}
