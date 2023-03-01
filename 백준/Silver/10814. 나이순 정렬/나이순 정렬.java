import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String[][] arr = new String[N][2];
        ArrayList<String[]> res = new ArrayList<>();
        for(int i=0; i<N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            arr[i][0] = st.nextToken();
            arr[i][1] = st.nextToken();

            res.add(arr[i]);
        }
        Collections.sort(res, new Comparator<String[]>() {
            @Override
            public int compare(String[] o1, String[] o2) {
                int num1 = Integer.parseInt(o1[0]);
                int num2 = Integer.parseInt(o2[0]);
                if(num1 > num2)
                    return 1;
                else if(num1 == num2)
                    return 0;
                else return -1;
            }
        });
        for (String[] re : res) {
            System.out.println(re[0] + " " + re[1]);
        }

    }
}
