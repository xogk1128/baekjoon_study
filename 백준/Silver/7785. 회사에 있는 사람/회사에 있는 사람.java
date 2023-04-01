import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        Map<String, String> map = new HashMap<>();
        StringTokenizer st;
        ArrayList<String> arr = new ArrayList<>();
        while(n-- >0){
            st = new StringTokenizer(br.readLine());
            map.put(st.nextToken(),st.nextToken());
        }

        for (String key : map.keySet()) {
            if(map.get(key).equals("enter"))
                arr.add(key);
        }
        Collections.sort(arr);
        for (int i=arr.size()-1; i>=0; i--){
            sb.append(arr.get(i)+"\n");
        }
        System.out.println(sb);
    }
}
