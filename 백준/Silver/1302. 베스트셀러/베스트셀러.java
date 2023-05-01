import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        Map<String, Integer> map = new HashMap<>();
        for(int i=0; i<N; i++){
            String word = br.readLine();
            if(!map.containsKey(word)){
                map.put(word, 0);
            }
            else {
                map.replace(word, map.get(word)+1);
            }
        }
        int max = 0;
        for (String s : map.keySet()) {
            if(max < map.get(s))
                max = map.get(s);
        }

        ArrayList<String> arr = new ArrayList<>();
        for (String s : map.keySet()) {
            if(map.get(s) == max){
                arr.add(s);
            }
        }

        Collections.sort(arr);
        System.out.println(arr.get(0));

    }
}
