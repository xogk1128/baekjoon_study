import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        String[] tmp = new String[N+1];
        Map<String, Integer> dic = new HashMap<>();
        for(int i=1; i<N+1; i++){
            String s = br.readLine();
            dic.put(s, i);
            tmp[i] = s;
        }

        StringBuilder sb = new StringBuilder();
        for(int i=0; i<M; i++){
            String str = br.readLine();

            // 타입이 String일 경우
            if(dic.containsKey(str)) {
                sb.append(dic.get(str));
            }
            else {// 타입이 Integer일 경우
                sb.append(tmp[Integer.parseInt(str)]);
            }
            sb.append("\n");
        }

        System.out.println(sb);
    }
}
