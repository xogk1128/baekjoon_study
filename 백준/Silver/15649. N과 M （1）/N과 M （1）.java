import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {

    static ArrayList<Integer> select = new ArrayList<>();
    static int N;
    static int M;

    static void dfs(){

        if(select.size() == M) {
            for (Integer integer : select) {
                System.out.print(integer + " ");
            }
            System.out.println();
            return;
        }

        for(int i=1; i<=N; i++){
            if(!select.contains(i))
                select.add(i);
            else continue;
            dfs();
            select.remove(select.size()-1);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        dfs();


    }

}
