import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        ArrayList<Long> arr = new ArrayList<>();
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++){
            arr.add(Long.parseLong(st.nextToken()));
        }

        for(int i=0; i<m; i++){
            long sum = 0;
            Collections.sort(arr);
            sum = arr.get(0) + arr.get(1);
            arr.set(0, sum);
            arr.set(1, sum);
        }

        long total = 0;
        for (Long res : arr) {
            total += res;
        }
        System.out.println(total);
    }
}
