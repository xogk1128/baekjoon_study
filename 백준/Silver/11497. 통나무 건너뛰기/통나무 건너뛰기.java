import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());
        ArrayList<Integer> arr;
        while(T-- > 0){
            arr = new ArrayList<>();
            int N = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine());
            for(int i=0; i<N; i++){
                arr.add(Integer.parseInt(st.nextToken()));
            }
            Collections.sort(arr);
            int[] ans = new int[N];
            int left=0;
            int right = N-1;
            for(int i=0; i<N;i++){
                if(i%2==0){
                    ans[left] = arr.get(i);
                    left++;
                }
                else {
                    ans[right] = arr.get(i);
                    right--;
                }
            }
            int max = -1;
            for(int i=0; i<arr.size()-1; i++){
                int res = Math.abs(ans[i]-ans[i+1]);
                if(res > max)
                    max = res;
            }
            System.out.println(max);
        }
    }
}
