package graph.theory;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * 미로찾기 bfs
 */
public class boj_2178_so1 {
    static int[][] dir = {{0,1},{0,-1},{1,0},{-1,0}};
    static int[][] map;
    static int[][] isCheck;
    static int n,m;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new int[n][m];
        isCheck = new int[n][m];

        for(int i=0; i<n; i++){
            String[] input = br.readLine().split("");
            for(int j=0; j<m; j++){
                map[i][j] = Integer.parseInt(input[j]);
            }
        }
        bfs(0,0);
        System.out.println(isCheck[n-1][m-1]);
    }

    private static void bfs(int x, int y) {
        Queue<Graph> q = new LinkedList<>();
        q.add(new Graph(x,y));
        isCheck[x][y] = 1;

        while(!q.isEmpty()){
            Graph g = q.poll();
            int dx = g.x;
            int dy = g.y;

            for(int i=0; i<4; i++){
                int mx = dx + dir[i][0];
                int my = dy + dir[i][1];
                if(isRangeCheck(mx,my)) continue;

                if(isCheck[mx][my] == 0 && map[mx][my] == 1){
                    isCheck[mx][my] = isCheck[dx][dy] + 1;
                    q.add(new Graph(mx,my));
                }
            }
        }
    }
    private static boolean isRangeCheck(int mx, int my) {
        if(mx < 0 || mx >= n || my < 0 || my >= m){
            return true;
        }
        return false;
    }
    private static class Graph {
        int x;
        int y;
        public Graph(int x,int y){
            this.x = x;
            this.y = y;
        }

    }
}
