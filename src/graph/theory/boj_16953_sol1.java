package graph.theory;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
a -> b과정을 b -> a과정으로 생각한다.
 */

/**
 * 1. a > b보다 크면 종료한다.
 * 2. a == b 같으면 현재 진행된값 + 1 만큼 횟수가 해당되는 최소횟수가 된다.
 * 3. b % 10 == 1 나머지가 1이면 +1을 붙이는것과 같으므로 10으로 나누어준다.
 * 4. b % 2 == 0이면 해당값을 2로 나누어준다.
 *
 * 시간초과 발생 -> 그외 나머지경우는 -1을 출력하면서 종료시켜줘야한다.
 * 2가지 조건만 처리하면 되기때문에 그외는 나올 수가 없다.
 */
public class boj_16953_sol1 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int answer = 0;
        long a = Long.parseLong(st.nextToken());
        long b = Long.parseLong(st.nextToken());
        int cnt = 0;

        while(true){
            if(a > b){
                answer = -1;
                break;
            }else if(a == b){
                answer = cnt + 1;
                break;
            }else {
                if(b % 10 == 1){
                    b--;
                    b /= 10;
                }else if(b % 2 == 0){
                    b /= 2;
                }else {
                    answer = -1;
                    break;
                }
            }
            cnt++;
        }
        System.out.println(answer);

    }
}
