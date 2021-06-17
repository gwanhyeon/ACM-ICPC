package graph.theory;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_9205 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        StringTokenizer st;

        while(t-- > 0){
            boolean isCheck = false;
            int n = Integer.parseInt(br.readLine());

            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            for(int i=0; i<n; i++){
                st = new StringTokenizer(br.readLine());
                int storeX = Integer.parseInt(st.nextToken());
                int storeY = Integer.parseInt(st.nextToken());
                int answer = Math.abs(storeX - x) + Math.abs(storeY - y);

                if(answer > 1000){
                    isCheck = true;
                }else {
                    x = storeX;
                    y = storeY;
                }
            }
            st = new StringTokenizer(br.readLine());
            int destX = Integer.parseInt(st.nextToken());
            int destY = Integer.parseInt(st.nextToken());

            int answer = Math.abs(destX - x) + Math.abs(destY - y);
            if(answer > 1000){
                isCheck = true;
            }

            if(isCheck){
                System.out.println("Sad");
            }else {
                System.out.println("Happy");
            }
        }
    }
}
