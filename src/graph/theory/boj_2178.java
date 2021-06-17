package graph.theory;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 미로찾기 dfs : 시간초과
 */
public class boj_2178 {
    static int[][] dir = {{0,1},{0,-1},{1,0},{-1,0}};
    static int[][] map;
    static boolean[][] isCheck;
    static int n,m;
    static int answer = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new int[n][m];
        isCheck = new boolean[n][m];

        for(int i=0; i<n; i++){
            String[] input = br.readLine().split("");
            for(int j=0; j<m; j++){
                map[i][j] = Integer.parseInt(input[j]);
            }
        }
        isCheck[0][0] = true;
        dfs(0,0,1);
        System.out.println(answer);
    }

    private static void dfs(int x, int y, int depth) {

        if(x == n-1 && y == m-1){
            answer = Math.min(answer, depth);
            return;
        }
        for(int i=0; i<4; i++){
            int mx = x + dir[i][0];
            int my = y + dir[i][1];
            if(isRangeCheck(mx,my)) continue;
            if(!isCheck[mx][my] && map[mx][my] == 1){
                isCheck[mx][my] = true;
                dfs(mx,my,depth+1);
                isCheck[mx][my] = false;
            }
        }
    }

    private static boolean isRangeCheck(int mx, int my) {
        if(mx < 0 || mx >= n || my < 0 || my >= m){
            return true;
        }
        return false;
    }
}
