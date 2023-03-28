import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;
import java.awt.Point;

class Grade implements Comparable<Grade> {
    int a;
    int b;

    Grade(int a, int b) {
        this.a = a;
        this.b = b;
    }

    @Override
    public int compareTo(Grade o) {
        if(this.a > o.a) {
            return 1;
        } else {
            return -1;
        }
    }
}

public class Main {
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());


        StringTokenizer st;
        int x, y;
        while(T-- > 0){
            ArrayList<Grade> arr = new ArrayList<>();
            int N = Integer.parseInt(br.readLine());
            for(int i=0; i<N; i++){
                st = new StringTokenizer(br.readLine());
                x = Integer.parseInt(st.nextToken());
                y = Integer.parseInt(st.nextToken());
                arr.add(new Grade(x, y));
            }
            Collections.sort(arr);

            int sum = 1;
            int min = arr.get(0).b;
            for(int j=1; j<N; j++){
                if(arr.get(j).b < min){
                    sum++;
                    min = arr.get(j).b;
                }
            }
            System.out.println(sum);
        }
    }
}
