import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        String A = st.nextToken();
        String B = st.nextToken();
        int min = B.length(); // 다 틀린 경우가 최대이므로
        // 두 문자열의 길이의 차 만큼 비교를 하면 됨
        for(int i=0; i<=B.length()-A.length(); i++){
            int cnt = 0; // 틀린 문자 갯수
            // A문자열 기준으로 비교하므로 A 길이만큼
            for(int j=0; j<A.length(); j++){
                if(A.charAt(j) != B.charAt(i+j))
                    cnt++;
            }
            // 최솟값 갱신
            if(cnt < min)
                min = cnt;
        }
        System.out.println(min);
    }
}
