package leegijin;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class p_1695팰린드롬만들기 {
    static int[][] dp;
    static int[] arr;
    static int solve(int start, int end) {
        if (dp[start][end] != -1)
            return dp[start][end];
        if(start == end) {
            return 0;
        } else if (start+1 == end) {
            if(arr[start] == arr[end])
                return 0;
            return 1;
        }
        if(arr[start] == arr[end]) {
            return dp[start][end] = solve(start+1, end-1);
        } else {
            return dp[start][end] = Math.min(solve(start, end-1), solve(start+1, end)) + 1;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(in.readLine());
        StringTokenizer st = new StringTokenizer(in.readLine());
        arr = new int[N];
        dp = new int[N][N];
        for(int i = 0; i < N; i++)
            Arrays.fill(dp[i], -1);
        for(int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        System.out.println(solve(0, N-1));
    }
}