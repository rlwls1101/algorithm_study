import java.util.Arrays;

public class p_거스름돈 {
    public static void main(String[] args) {
        int [] money ={1,2,5};
        int n =5;
        System.out.println(solution(n,money));
    }
    public static int solution(int n, int[] money) {
        int answer = 0;
        Arrays.sort(money);

        long[] d = new long[n+1];

        for(int i =0; i<=n ;i++){
            if(i % money[0] == 0)
                d[i]=1;
        }

        for(int i=1; i<money.length ; i++){
            for(int j=money[i]; j<=n; j++){
                d[j] += d[j-money[i]];
            }
        }

        answer = (int)(d[n] % 1000000007);
        return answer;
    }
}
