package graph.theory;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
A → B 분류 Silver I
https://www.acmicpc.net/problem/16953
DFS
 */

/**
 * 1. 거꾸로 생각하거나 dfs로 풀기
 * 2. 10^9로는 모든경우를 체크할 수 없다. 다른방법을 구해야한다.
 * 3. bfs같은경우는 모든 경우를 구하는것은 가까운것만 탐색하므로 bfs로 처리할 수 있다.
 * 4. 범위가 10^9이기때문에 100 int의 범위로는 모두 처리하지 못한다. 따라서 Long으로 처리하니까 틀렸습니다.에서 올바른 답 도출하였음.
 */
public class boj_16953 {
    static long a;
    static long b;
    static long answer;
    static boolean isCheck;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        answer = Long.MAX_VALUE;
        a = Long.parseLong(st.nextToken());
        b = Long.parseLong(st.nextToken());
        isCheck = false;
        dfs(a,1);
        if(!isCheck) System.out.println(-1);
        else System.out.println(answer);
    }

    private static void dfs(long a, int cnt) {
        if(a > b){
            return;
        }
        if(a == b){
            answer = Math.min(answer, cnt);
            isCheck = true;
            return;
        }
        dfs(a * 2,cnt+1);
        dfs(a * 10 + 1, cnt+1);
    }
}
