package graph.theory;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * 1. 플로이드와샬보다는 bfs 풀이
 */
public class boj_11403_sol1 {
    static boolean[] isCheck;
    static int[][] map;
    static int n;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        StringTokenizer st;

        map = new int[n][n];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for(int i=0; i<n; i++){
            isCheck = new boolean[n];
            for(int j=0; j<n; j++){
                if(!isCheck[j] && map[i][j] == 1){
                    bfs(i,j);
                }
            }
        }

        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }
    }

    private static void bfs(int start, int end) {
        Queue<Integer> q = new LinkedList<>();
        isCheck[end] = true;
        q.add(end);

        while(!q.isEmpty()){
            int k = q.poll();
            for(int i=0; i<n; i++) {
                if (!isCheck[i] && map[k][i] == 1) {
                    q.add(i);
                    map[start][i] = 1;
                    isCheck[i] = true;
                }
            }
        }
    }
}
