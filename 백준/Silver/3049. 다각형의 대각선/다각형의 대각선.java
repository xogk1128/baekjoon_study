import java.io.*;
import java.util.*;
 
public class Main {
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
 
        int n = Integer.parseInt(br.readLine());
        System.out.println((n * (n-1) * (n-2) * (n-3)) / 24);
    }
}
