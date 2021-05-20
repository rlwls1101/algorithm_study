public class p_2n타일링 {
    public static void main(String[] args) {
        int n =4;
        solution(n);
    }
    public static int solution(int n) {
        int answer = 0;

        long dp[] = new long[n+1];
        dp[1]=1;
        dp[2]=2;
        for(int i =3; i<=n ; i++){
            dp[i]=(dp[i-1]+dp[i-2])%1000000007;
        }
        answer = (int) dp[n];
        return answer;
    }
}
