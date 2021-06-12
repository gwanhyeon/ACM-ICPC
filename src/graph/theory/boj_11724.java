package graph.theory;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * 연결 요소의 개수 성공분류 Silver II
 * connected component
 * https://www.acmicpc.net/problem/11724
 */
public class boj_11724 {
    static List<List<Integer>> graphList;
    static boolean[] isCheck;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        graphList = new ArrayList<>();
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        for(int i=0; i<=n; i++){
            graphList.add(new ArrayList<>());
        }
        isCheck = new boolean[n+1];
        for(int i=0; i<m; i++){
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            graphList.get(x).add(y);
            graphList.get(y).add(x);
        }

        int answer = 0;
        for(int i=1; i<=n; i++){
            if(!isCheck[i]){
                bfs(i);
                //dfs(i);
                answer++;
            }
        }
        System.out.println(answer);
    }

    private static void dfs(int x) {
        isCheck[x] = true;
        for(int i=0; i<graphList.get(x).size(); i++){
            int y = graphList.get(x).get(i);
            if(!isCheck[y]){
                dfs(y);
            }
        }
    }

    private static void bfs(int start){
        Queue<Integer> q = new LinkedList<>();
        isCheck[start] = true;
        q.add(start);

        while(!q.isEmpty()){
            int x = q.poll();
            for(int i=0; i<graphList.get(x).size(); i++){
                int y = graphList.get(x).get(i);
                if(!isCheck[y]){
                    isCheck[y] = true;
                    q.add(y);
                }
            }
        }
    }
}
