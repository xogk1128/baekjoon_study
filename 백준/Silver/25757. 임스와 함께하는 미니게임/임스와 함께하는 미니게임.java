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
        String game = st.nextToken();

        Map<String, Integer> map = new HashMap<>();
        int cnt = 0;
        for(int i=0; i<N; i++){
            String name = br.readLine();
            if(!map.containsKey(name)){
                map.put(name, 0);
                cnt++;
            }
        }

        if(game.equals("Y")){
            System.out.println(cnt);
        }
        else if(game.equals("F")){
            System.out.println(cnt/2);
        }
        else if(game.equals("O")){
            System.out.println(cnt/3);
        }
    }
}
