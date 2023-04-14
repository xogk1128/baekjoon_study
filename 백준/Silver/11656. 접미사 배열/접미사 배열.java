import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String S = br.readLine();

        ArrayList<String> arr = new ArrayList<>();
        for(int i=0; i<S.length(); i++){
            arr.add(S.substring(i));
        }

        Collections.sort(arr);
        StringBuilder sb = new StringBuilder();
        for (String s : arr) {
            sb.append(s + "\n");
        }
        System.out.println(sb);
    }
}
