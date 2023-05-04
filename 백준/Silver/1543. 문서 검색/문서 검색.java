import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String word = br.readLine();
        String s = br.readLine();

        int cnt= 0;
        word = word.replace(s, ".");

        for(int i=0; i<word.length(); i++){
            if(word.charAt(i) == '.')
                cnt++;
        }
        System.out.println(cnt);
    }
}
