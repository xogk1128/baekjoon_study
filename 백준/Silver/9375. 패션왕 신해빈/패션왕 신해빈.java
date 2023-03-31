import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        Map<String, Integer> map = new HashMap<>();

        StringTokenizer st;
        int num;
        while(T-- >0){
            map.clear();
            num = Integer.parseInt(br.readLine());

            for(int i=0; i<num; i++) {
                st = new StringTokenizer(br.readLine());
                st.nextToken();
                String key = st.nextToken();
                if (!map.containsKey(key))
                    map.put(key, 1);
                else {
                    map.put(key, map.get(key) + 1);
                }
            }
            int mul = 1;
            for (int val : map.values()) {
                mul *=  (val+1);
            }


            System.out.println(mul-1);
        }
    }
}
