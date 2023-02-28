import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Main extends Object {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String str = "123";
        ArrayList<String> arr = new ArrayList<>();
        for(int i=0; i<N; i++){
            String s = br.readLine();
            if(!arr.contains(s))
                arr.add(s);
        }
        Collections.sort(arr, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                if(o1.length() > o2.length())
                    return 1;
                else if (o1.length() == o2.length()){
                    return o1.compareTo(o2);
                }
                else return -1;

            }
        });

        for (String s : arr) {
            System.out.println(s);
        }
    }
}
