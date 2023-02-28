import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

class Point implements Comparable<Point>{
    private int x;
    private int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public String toString(){
        return this.x + " " + this.y;
    }

    @Override
    public int compareTo(Point p) {
        if (this.y > p.y)
            return 1;
        else if(this.y == p.y){
            if(this.x > p.x)
                return 1;
            else
                return -1;
        }
        else return -1;
    }
}

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        ArrayList<Point> xy = new ArrayList<>();
        for(int i=0; i<N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            xy.add(new Point(x,y));
        }
        Collections.sort(xy);

        for (Point point : xy) {
            System.out.println(point.toString());
        }
    }
}
