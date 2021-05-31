public class p_점프와순간이동 {

    public static void main(String[] args) {
        int n = 50000;
        System.out.println(solution(n));
    }
    public static int solution(int n) {
        int ans =0;
        while(n>0){
            if(n%2==0)
                n=n/2;
            else {
                n = n - 1;
                ans++;
            }
        }
        return ans;
    }
}
